/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.Entity;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Action {
    public Collection<Entity> invoke();
}
