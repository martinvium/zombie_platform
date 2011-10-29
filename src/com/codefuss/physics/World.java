package com.codefuss.physics;

import com.codefuss.Camera;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 * - max gravity fall speed
 * - friction along the x axis
 * - default action is a null action
 */
public class World {
    Vector2f gravity;
    ArrayList<Body> bodies = new ArrayList<Body>();
    boolean debugDraw = false;
    static public final int MAX_GRAVITY_FACTOR = 200;

    public World(Vector2f gravity) {
        this.gravity = gravity;
    }

    public void toggleDebugDraw() {
        if(debugDraw) {
            debugDraw = false;
        } else {
            debugDraw = true;
        }
    }

    public void add(Body body) {
        bodies.add(body);
    }

    public void remove(Body body) {
        bodies.remove(body);
    }

    public void update(int delta) {

        Iterator<Body> it = bodies.iterator();
        while(it.hasNext()) {
            Body body = it.next();
            if(body.isRemoved()) {
                it.remove();
                continue;
            }

            float oldX = body.getX();
            float oldY = body.getY();

            body.updateX(delta, gravity.x);
            for(Body body2 : bodies) {
                if(isCollided(body, body2)) {
                    body.setX(oldX);
                    body.collideHorizontal(body2);
                    body2.collideHorizontal(body);
                }
            }
            
            body.updateY(delta, gravity.y);
            for(Body body2 : bodies) {
                if(isCollided(body, body2)) {
                    body.setY(oldY);
                    body.collideVertical(body2);
                    body2.collideVertical(body);
                }
            }
        }
    }

    /**
     * 1) No collision with self
     * 2) Collision if density of either object is massive (e.g. 1)
     * 3) Collision if density of target is larger or equal to source
     * 4) Collision if source box intersects target box
     */
    boolean isCollided(Body source, Body target) {
        boolean impenetrable = ((source.getDensity() == Body.DENSITY_MASSIVE || target.getDensity() == Body.DENSITY_MASSIVE) ||
                    source.getDensity() == target.getDensity());
        
        return source != target && impenetrable && source.getShape().intersects(target.getShape());
    }

    public void render(Graphics g, Camera camera) {
        if(debugDraw == false) {
            return;
        }

        for(Body body : bodies) {
            Shape shape = body.getShape();
            if(shape instanceof Rectangle) {
                g.drawRect(shape.getX() - camera.getX(), shape.getY() - camera.getY(), shape.getWidth(), shape.getHeight());
            } else {
                throw new RuntimeException("unknown shape: " + shape.getClass());
            }
        }
    }

    @Deprecated
    public void update2(int delta) {
        for(Body body : bodies) {
            Shape shape = body.getShape();

            float offsetX = body.getVelocityX() * delta;
            if(body instanceof DynamicBody) {
                offsetX -= gravity.x * delta;
            }
            body.setX(body.getX() + offsetX);

            for(Body body2 : bodies) {
                Shape shape2 = body2.getShape();
                if(shape.intersects(shape2) &&
                        shape.getMinX() < shape2.getMaxX() &&
                        shape2.getMinX() < shape.getMaxX()) {
                    if(offsetX > 0) {
                        body.setX(shape2.getMinX() - shape.getWidth());
                    } else if(offsetX < 0) {
                        body.setX(shape2.getMaxX());
                    }
                }
            }

            float offsetY = body.getVelocityY() * delta;
            if(body instanceof DynamicBody) {
                offsetY -= gravity.y * delta;
            }
            body.setY(body.getY() + offsetY);

            for(Body body2 : bodies) {
                Shape shape2 = body2.getShape();
                if(shape.intersects(shape2) &&
                        shape.getMinY() < shape2.getMaxY() &&
                        shape2.getMinY() < shape.getMaxY()) {
                    if(offsetY > 0) {
                        body.setY(shape2.getMinY() - shape.getHeight());
                    } else if(offsetY < 0) {
                        body.setY(shape2.getMaxY());
                    }
                }
            }
        }
    }
}
