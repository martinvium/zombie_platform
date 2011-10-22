/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Entity {

    public enum State {
        NORMAL,
        WALKING,
        ATTACKING,
        DEAD
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta);
    
    public void render(GameContainer container, StateBasedGame game, Graphics g, float offsetX) throws SlickException;

    public void setState(State state);

    public boolean isRemoved();
}
