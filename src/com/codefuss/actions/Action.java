/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.entities.Entity;
import java.util.Collection;
import org.newdawn.slick.Input;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Action {
    public Collection<Entity> invoke();

    public boolean test(Input input, int keyCode);
}
