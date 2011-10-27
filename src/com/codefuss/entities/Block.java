/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.Camera;
import com.codefuss.physics.Body;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Block implements Entity {

    Body body;

    public Block(Body body) {
        this.body = body;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g, Camera camera) throws SlickException {
        
    }

    @Override
    public void setState(State state) {

    }

    @Override
    public boolean isRemoved() {
        return false;
    }
}
