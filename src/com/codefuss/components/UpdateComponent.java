/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface UpdateComponent {
    public void update(GameContainer container, StateBasedGame game, int delta);
}
