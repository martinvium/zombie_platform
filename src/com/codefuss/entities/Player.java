package com.codefuss.entities;

import com.codefuss.Entity;
import com.codefuss.EntityFactory;
import com.codefuss.components.Sprite;
import org.newdawn.slick.geom.Vector2f;

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
        Vector2f barrelPosition = sprite.getPosition();
        barrelPosition.y += sprite.getHeight() / 4;
        barrelPosition.x += sprite.getWidth() - 30;
        return entityFactory.getShotgunFire(barrelPosition);
    }
}
