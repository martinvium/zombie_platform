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
public class Zombie extends Creature {

    public Zombie(Vector2f position, EntityFactory entityFactory) {
        super(position, entityFactory);
    }

    @Override
    public void init() {
        setMaxSpeed(0.08f);
    }

    @Override
    public Entity getMainAttack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
