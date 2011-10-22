/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.entities.Entity;
import com.codefuss.entities.Creature;
import java.util.ArrayList;
import java.util.Collection;
import org.newdawn.slick.Input;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class NullAction implements Action {

    @Override
    public boolean test(Input input, int keyCode) {
        throw new UnsupportedOperationException("Null action is untestable");
    }

    @Override
    public Collection<Entity> invoke() {
        return new ArrayList<Entity>();
    }
}
