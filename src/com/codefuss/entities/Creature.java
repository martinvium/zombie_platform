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

    final static int AMMO_OFFSET = 17; // todo, should be supplied by ammo?

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

    public Entity getMainAttack(int timeKeyPressed) {
        float x;
        if(direction == Direction.LEFT) {
            x = getPosition().x - AMMO_OFFSET;
        } else {
            x = getPosition().x + getWidth() + 1;
        }

        float y = getPosition().y + getHeight() / 4;

        return entityFactory.getRedBall(x, y, direction, timeKeyPressed);
    }
}
