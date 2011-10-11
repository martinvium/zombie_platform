/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.Entity;
import com.codefuss.EntityFactory;
import com.codefuss.components.Sprite;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Zombie extends Creature {

    public Zombie(EntityFactory entityFactory, Sprite sprite) {
        super(entityFactory, sprite);
    }

    @Override
    public void init() {
        this.sprite.setMaxSpeed(0.08f);
    }

    @Override
    public Entity getMainAttack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
