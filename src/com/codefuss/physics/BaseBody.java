package com.codefuss.physics;

import com.codefuss.Entity;
import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseBody implements Body {

    Shape shape;
    float velocityX = 0;
    float velocityY = 0;
    CollisionListener listener;
    Entity entity;
    float density = 1f;

    public BaseBody(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return this.entity;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public float getX() {
        return shape.getX();
    }

    @Override
    public float getY() {
        return shape.getY();
    }

    @Override
    public void setX(float x) {
        shape.setX(x);
    }

    @Override
    public void setY(float y) {
        shape.setY(y);
    }

    @Override
    public float getVelocityX() {
        return velocityX;
    }

    @Override
    public float getVelocityY() {
        return velocityY;
    }

    @Override
    public void setVelocityX(float x) {
        velocityX = x;
    }

    @Override
    public void setVelocityY(float y) {
        velocityY = y;
    }

    @Override
    public void setCollisionListener(CollisionListener listener) {
        this.listener = listener;
    }

    @Override
    public void collideHorizontal(Body collided) {
        if(listener != null) {
            listener.collideHorizontal(collided);
        }
    }

    @Override
    public void collideVertical(Body collided) {
        if(listener != null) {
            listener.collideVertical(collided);
        }
    }

    @Override
    public void setDensity(float density) {
        this.density = density;
    }

    @Override
    public float getDensity() {
        return density;
    }
}
