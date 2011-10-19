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
public class JumpAction implements Action {

    Sprite sprite;

    public JumpAction(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public Collection<Entity> invoke() {
        float velocityY = 0;
        velocityY -= sprite.getMaxSpeed();
        sprite.setVelocityY(velocityY);
        sprite.setState(Sprite.State.NORMAL);
        return new ArrayList<Entity>();
    }
}
