package com.codefuss.physics;

import org.newdawn.slick.geom.Shape;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class DynamicBody extends StaticBody {

    public DynamicBody(Shape shape) {
        super(shape);
    }

    @Override
    public void updateX(int delta, float gravity) {
        setVelocityX(getVelocityX() + gravity * delta);
        //setX(getX() + gravity * delta);
        super.updateX(delta, gravity);
    }

    @Override
    public void updateY(int delta, float gravity) {
        setVelocityY(getVelocityY() + gravity * delta);
        //setY(getY() + gravity * delta);
        super.updateY(delta, gravity);
    }
}
