/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.components;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Sprite implements UpdateComponent, RenderComponent {

    Animation leftAnimation;
    Animation rightAnimation;
    Animation currentAnimation;
    Vector2f position;
    float maxSpeed = 0.25f;
    float velocityX = 0f;

    public Sprite(Animation left, Animation right, Vector2f position) {
        this.leftAnimation = left;
        this.rightAnimation = right;
        this.currentAnimation = right;
        this.position = position;
    }

    public void setVelocityX(float velocity) {
        velocityX = velocity;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if(velocityX < 0) {
            currentAnimation = leftAnimation;
        } else if(velocityX > 0) {
            currentAnimation = rightAnimation;
        }

        currentAnimation.update(delta);
        position.x += velocityX * delta;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawAnimation(currentAnimation, position.x, position.y, Color.white);
    }
}
