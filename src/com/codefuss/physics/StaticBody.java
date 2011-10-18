package com.codefuss.physics;

import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class StaticBody extends BaseBody {

    public StaticBody(Shape shape) {
        super(shape);
    }

    @Override
    public void updateX(int delta, float gravity) {
        shape.setX(getX() + getVelocityX() * delta);
    }

    @Override
    public void updateY(int delta, float gravity) {
        shape.setY(getY() + getVelocityY() * delta);
    }
}
