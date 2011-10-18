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
        super.updateX(delta, gravity);
        shape.setX(getX() + gravity * delta);
    }

    @Override
    public void updateY(int delta, float gravity) {
        super.updateY(delta, gravity);
        shape.setY(getY() + gravity * delta);
    }
}
