package com.codefuss.entities;

import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ShotgunFire extends Ammo {

    public ShotgunFire(Vector2f position, Body body) {
        super(position, body);
    }
}
