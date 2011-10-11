package com.codefuss.actions;

import com.codefuss.entities.Creature;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseAction implements Action {

    protected Creature creature;

    public BaseAction(Creature creature) {
        this.creature = creature;
    }
}
