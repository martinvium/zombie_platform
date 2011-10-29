/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.Camera;
import com.codefuss.components.HealthBar;
import com.codefuss.factories.AmmoFactory;
import com.codefuss.physics.Body;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class Creature extends Sprite {

    protected AmmoFactory entityFactory;
    private HealthBar healthBar;

    public Creature(AmmoFactory entityFactory, Vector2f position, Body body) {
        super(position, body);
        this.entityFactory = entityFactory;
    }

    public void setHealthBar(HealthBar bar) {
        healthBar = bar;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta);
        if(healthBar != null) {
            healthBar.update(this);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g, Camera camera) throws SlickException {
        super.render(container, game, g, camera);
        if(healthBar != null) {
            healthBar.render(camera);
        }
    }



    abstract public Entity getMainAttack(int timeKeyPressed);
}
