package com.codefuss.physics;

import com.codefuss.Entity;
import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Body extends CollisionListener {

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
}
