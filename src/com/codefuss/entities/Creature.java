/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.factories.EntityFactory;
import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class Creature extends Sprite {

    EntityFactory entityFactory;

    public Creature(EntityFactory entityFactory, Vector2f position, Body body) {
        super(position, body);
        this.entityFactory = entityFactory;
    }

    abstract public Entity getMainAttack();
}
