package com.codefuss.physics;

import com.codefuss.entities.Entity;
import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Body extends CollisionListener {

    static public final float DENSITY_NONE = 0f;
    static public final float DENSITY_NORMAL = 0.5f;
    static public final float DENSITY_MASSIVE = 1f;

    public void setVelocityX(float x);

    public void setVelocityY(float y);

    public float getVelocityX();

    public float getVelocityY();

    public float getX();

    public float getY();

    public void setX(float x);

    public void setY(float y);

    public Shape getShape();

    public void updateX(int delta, float gravity);

    public void updateY(int delta, float gravity);

    public void setCollisionListener(CollisionListener listener);

    public void setEntity(Entity entity);

    public Entity getEntity();

    /**
     * Value of 1.0f always collides, otherwise density must be larger than or equal to collide.
     */
    public void setDensity(float density);

    public float getDensity();
}
