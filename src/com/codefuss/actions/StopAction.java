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
public class StopAction implements Action {

    Sprite sprite;

    public StopAction(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void invoke() {
        sprite.setVelocityX(0);
    }
}
