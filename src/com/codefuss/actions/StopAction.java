/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.Entity;
import com.codefuss.components.Sprite;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class StopAction implements Action {

    Sprite sprite;

    public StopAction(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public Collection<Entity> invoke() {
        sprite.setVelocityX(0);
        return new ArrayList<Entity>();
    }
}
