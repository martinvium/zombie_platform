package com.codefuss.physics;

import com.codefuss.entities.Entity;
import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseBody implements Body {

    Shape shape;
    float velocityX = 0;
    float velocityY = 0;
    Entity entity;
    float density = DENSITY_NORMAL;
    float friction = 0.001f;
    private boolean removed = false;
    
    CollisionListener collisionListener;
    FrictionListener frictionListener;

    public BaseBody(Shape shape) {
        this.shape = shape;
    }

    @Override
    public float getFriction() {
        return friction;
    }

    @Override
    public void setFriction(float friction) {
        this.friction = friction;
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
        this.collisionListener = listener;
    }

    @Override
    public void collideHorizontal(Body collided) {
        if(collisionListener != null) {
            collisionListener.collideHorizontal(collided);
        }
    }

    @Override
    public void collideVertical(Body collided) {
        if(collisionListener != null) {
            collisionListener.collideVertical(collided);
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

    @Override
    public void setFrictionListener(FrictionListener listener) {
        frictionListener = listener;
    }

    @Override
    public void remove() {
        removed = true;
    }

    @Override
    public boolean isRemoved() {
        return removed;
    }
}
