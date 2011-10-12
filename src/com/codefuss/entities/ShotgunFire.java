/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.Entity;
import com.codefuss.components.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ShotgunFire implements Entity {

    Sprite sprite;

    public ShotgunFire(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void init() {
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        sprite.update(container, game, delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g, float offsetX) throws SlickException {
        sprite.render(container, game, g, offsetX);
    }
}
