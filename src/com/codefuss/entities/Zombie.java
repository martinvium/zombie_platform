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
public class Zombie extends Creature {

    public Zombie(EntityFactory entityFactory, Vector2f position, Body body) {
        super(entityFactory, position, body);
    }

    @Override
    public void init() {
        
    }

    @Override
    public Entity getMainAttack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
