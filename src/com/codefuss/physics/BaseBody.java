package com.codefuss.physics;

import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseBody implements Body {

    Shape shape;
    float velocityX = 0;
    float velocityY = 0;

    public BaseBody(Shape shape) {
        this.shape = shape;
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
}
