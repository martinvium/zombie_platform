package com.codefuss.entities;

import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ShotgunFire extends Sprite {

    public ShotgunFire(Vector2f position) {
        super(position);
    }

    @Override
    public void init() {
        setVelocityX(0.5f);
    }
}
