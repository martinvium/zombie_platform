package com.codefuss.entities;

import com.codefuss.factories.AmmoFactory;
import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
final public class Player extends Creature {

    public Player(AmmoFactory entityFactory, Vector2f position, Body body) {
        super(entityFactory, position, body);
    }
}
