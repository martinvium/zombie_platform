package com.codefuss.entities;

import com.codefuss.Entity;
import com.codefuss.EntityFactory;
import com.codefuss.components.Sprite;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
final public class Player extends Creature {

    public Player(EntityFactory entityFactory, Sprite sprite) {
        super(entityFactory, sprite);
    }

    @Override
    public void init() {
        this.sprite.setMaxSpeed(0.25f);
    }

    @Override
    public Entity getMainAttack() {
        return entityFactory.getShotgunFire();
    }
}
