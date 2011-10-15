/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.Entity;
import com.codefuss.EntityFactory;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class Creature extends Sprite {

    EntityFactory entityFactory;

    public Creature(Vector2f position, EntityFactory entityFactory) {
        super(position);
        this.entityFactory = entityFactory;
    }

    abstract public Entity getMainAttack();
}
