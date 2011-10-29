/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.factories.AmmoFactory;
import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Zombie extends Creature {

    public Zombie(AmmoFactory entityFactory, Vector2f position, Body body) {
        super(entityFactory, position, body);
    }
}
