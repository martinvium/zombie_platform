package com.codefuss.actions;

import com.codefuss.entities.Creature;
import org.newdawn.slick.Input;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseAction implements Action {

    protected Creature creature;

    public BaseAction(Creature creature) {
        this.creature = creature;
    }

    @Override
    public boolean test(Input input, int keyCode, int delta) {
        return input.isKeyDown(keyCode);
    }
}
