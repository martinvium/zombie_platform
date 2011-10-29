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
     * A bodies ability to move through another body.
     *
     * - 1.0f always collide
     * - otherwise density must be larger than or equal to collide.
     */
    public void setDensity(float density);

    public float getDensity();

    /**
     * The rate of which an objects slows down moving through air.
     *
     * - 1.0f instant halt
     * - 0.0f never stop (space) has some implications when combined with gravity :)
     * - initially only affects the X axis?
     */
    public void setFriction(float friction);

    public float getFriction();

    public void setFrictionListener(FrictionListener listener);

    public void remove();

    public boolean isRemoved();
}
