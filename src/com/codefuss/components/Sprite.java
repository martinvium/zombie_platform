package com.codefuss.components;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Sprite implements UpdateComponent, RenderComponent {

    static final int ATTACK_TIME = 1000;

    Animation leftAnimation;
    Animation rightAnimation;
    Animation attackLeftAnimation;
    Animation attackRightAnimation;
    Animation currentAnimation;
    Vector2f position;
    float maxSpeed = 0.25f;
    float velocityX = 0f;
    State state = State.RUNNING;
    long stateTime;

    public enum State {
        RUNNING, ATTACKING
    }

    public Sprite(Animation left, Animation right, Animation attackLeft, Animation attackRight, Vector2f position) {
        this.leftAnimation = left;
        this.rightAnimation = right;
        this.attackLeftAnimation = attackLeft;
        this.attackRightAnimation = attackRight;
        this.currentAnimation = right;
        this.position = position;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setVelocityX(float velocity) {
        velocityX = velocity;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Animation newAnimation = currentAnimation;
        if(velocityX < 0) {
            newAnimation = leftAnimation;
        } else if(velocityX > 0) {
            newAnimation = rightAnimation;
        }

        if(state == State.ATTACKING) {
            if(currentAnimation == leftAnimation) {
                newAnimation = attackLeftAnimation;
            } else if(currentAnimation == rightAnimation) {
                newAnimation = attackRightAnimation;
            }
        }

        if(currentAnimation != newAnimation) {
            currentAnimation = newAnimation;
            currentAnimation.restart();
        } else {
            currentAnimation.update(delta);
        }

        stateTime += delta;
        if (state == State.ATTACKING && stateTime >= ATTACK_TIME) {
            Log.debug("stop attacking");
            setState(State.RUNNING);
        }

        position.x += velocityX * delta;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawAnimation(currentAnimation, position.x, position.y, Color.white);
    }
}
