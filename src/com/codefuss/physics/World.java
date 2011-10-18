package com.codefuss.physics;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class World {
    Vector2f gravity;
    ArrayList<Body> bodies = new ArrayList<Body>();

    public World(Vector2f gravity) {
        this.gravity = gravity;
    }

    public void add(Body body) {
        bodies.add(body);
    }

    public void update(int delta) {
        for(Body body : bodies) {
            float oldX = body.getX();
            float oldY = body.getY();

            body.updateX(delta, -gravity.x);
            for(Body body2 : bodies) {
                if(body != body2 && body.getShape().intersects(body2.getShape())) {
                    body.setX(oldX);
                }
            }
            
            body.updateY(delta, -gravity.y);
            for(Body body2 : bodies) {
                if(body != body2 && body.getShape().intersects(body2.getShape())) {
                    body.setY(oldY);
                }
            }
        }
    }

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

    public void render(Graphics g) {
        for(Body body : bodies) {
            Shape shape = body.getShape();
            if(shape instanceof Rectangle) {
                g.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
            } else {
                throw new RuntimeException("unknown shape: " + shape.getClass());
            }
        }
    }
}