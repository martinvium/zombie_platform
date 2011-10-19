/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.Entity;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Sprite;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Jump extends BaseAction {

    public Jump(Creature creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        float velocityY = 0;
        velocityY -= creature.getMaxSpeed();
        creature.setVelocityY(velocityY);
        creature.setState(Sprite.State.NORMAL);
        return new ArrayList<Entity>();
    }
}
