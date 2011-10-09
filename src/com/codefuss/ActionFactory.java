/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.actions.Action;
import com.codefuss.actions.MoveRight;
import com.codefuss.entities.Player;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ActionFactory {
    public Action getMoveRight(Player entity) {
        return new MoveRight(entity.getSprite());
    }
}
