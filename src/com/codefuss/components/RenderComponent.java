/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface RenderComponent {
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;
}
