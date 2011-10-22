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
        float actualFriction = getFriction() * delta;

        // do not reverse the body because of friction
        if(actualFriction > Math.abs(getVelocityX())) {
            actualFriction = Math.abs(getVelocityX());
        }

        // negate friction factory if we are moving forward
        if(getVelocityX() > 0) {
            actualFriction = -actualFriction;
        }

        setVelocityX(getVelocityX() + gravity * delta + actualFriction);
        super.updateX(delta, gravity);
    }

    @Override
    public void updateY(int delta, float gravity) {
        setVelocityY(getVelocityY() + gravity * delta);
        super.updateY(delta, gravity);
    }
}
