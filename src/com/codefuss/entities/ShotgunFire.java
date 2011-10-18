package com.codefuss.entities;

import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ShotgunFire extends Sprite {

    public ShotgunFire(Vector2f position, Body body) {
        super(position, body);
    }

    @Override
    public void init() {
        setVelocityX(0.5f);
    }
}
