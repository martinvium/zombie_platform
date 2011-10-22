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
        float actualGravity = gravity * delta;

        // do not reverse the body because of friction
        if(actualFriction > Math.abs(getVelocityX())) {
            actualFriction = Math.abs(getVelocityX());
        }

        // negate friction factory if we are moving forward
        if(getVelocityX() > 0) {
            actualFriction = -actualFriction;
        }

        // gravity does not apply to bodies moving faster than a given factor
        if(gravity * World.MAX_GRAVITY_FACTOR < getVelocityX()) {
            actualGravity = 0;
        }

        setVelocityX(getVelocityX() + actualGravity + actualFriction);
        super.updateX(delta, gravity);
    }

    @Override
    public void updateY(int delta, float gravity) {
        float actualGravity = gravity * delta;

        // gravity does not apply to bodies moving faster than a given factor
        if(gravity * World.MAX_GRAVITY_FACTOR < getVelocityY()) {
            actualGravity = 0;
        }

        setVelocityY(getVelocityY() + actualGravity);
        super.updateY(delta, gravity);
    }
}
