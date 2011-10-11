/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.components.Sprite;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class MoveLeft implements Action {

    Sprite sprite;

    public MoveLeft(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void invoke() {
        float velocityX = 0;
        velocityX -= sprite.getMaxSpeed();
        sprite.setVelocityX(velocityX);
        sprite.setState(Sprite.State.NORMAL);
    }
}
