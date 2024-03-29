/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.entities.Entity;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Sprite;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class MoveLeft extends BaseAction {

    public MoveLeft(Creature creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        creature.setState(Sprite.State.WALKING);
        creature.setVelocityX(-creature.getSpeedX());
        return new ArrayList<Entity>();
    }
}
