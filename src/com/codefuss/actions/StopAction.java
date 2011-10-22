/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.entities.Entity;
import com.codefuss.entities.Creature;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class StopAction extends BaseAction {

    public StopAction(Creature creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        creature.setVelocityX(0);
        creature.setState(Entity.State.NORMAL);
        return new ArrayList<Entity>();
    }
}
