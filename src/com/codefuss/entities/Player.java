package com.codefuss.entities;

import com.codefuss.Entity;
import com.codefuss.EntityFactory;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
final public class Player extends Creature {

    public Player(Vector2f position, EntityFactory entityFactory) {
        super(position, entityFactory);
    }

    @Override
    public void init() {
        setMaxSpeed(0.25f);
    }

    @Override
    public Entity getMainAttack() {
        Vector2f barrelPosition = getPosition();
        barrelPosition.y += getHeight() / 4;
        barrelPosition.x += getWidth() - 30;
        return entityFactory.getShotgunFire(barrelPosition);
    }
}
