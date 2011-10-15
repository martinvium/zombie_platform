/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.Entity;
import com.codefuss.entities.Sprite;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class MoveRight implements Action {

    Sprite sprite;

    public MoveRight(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public Collection<Entity> invoke() {
        float velocityX = 0;
        velocityX += sprite.getMaxSpeed();
        sprite.setVelocityX(velocityX);
        sprite.setState(Sprite.State.NORMAL);
        return new ArrayList<Entity>();
    }
}
