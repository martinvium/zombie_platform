package com.codefuss.entities;

import com.codefuss.Entity;

import com.codefuss.StateAnimation;
import com.codefuss.physics.Body;
import com.codefuss.physics.CollisionListener;
import java.util.EnumMap;
import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class Sprite implements Entity, CollisionListener {

    Animation currentAnimation;
    Vector2f position;

    float maxSpeed = 0.25f;
    Body body;

    State state = State.NORMAL;
    long stateTime;
    Direction direction = Direction.RIGHT;

    EnumMap<State, StateAnimation> stateAnimations = new EnumMap<State, StateAnimation>(State.class);

    protected boolean removed = false;

    public enum Direction {
        LEFT, RIGHT
    }

    public Sprite(Vector2f position, Body body) {
        this.position = position;
        this.body = body;
        this.body.setCollisionListener(this); // FIXME
        this.body.setEntity(this); // FIXME
    }

    public Body getBody() {
        return body;
    }

    @Override
    public boolean isRemoved() {
        return removed;
    }

    public void addStateAnimation(StateAnimation stateAni) {
        stateAnimations.put(stateAni.getState(), stateAni);
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void setState(State state) {
        if (this.state != state) {
            this.state = state;
            stateTime = 0;
            setVelocityX(0);
            setVelocityY(0);
        }
    }

    public void setVelocityX(float velocity) {
        body.setVelocityX(velocity);
    }

    public void setVelocityY(float velocity) {
        body.setVelocityY(velocity);
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public Vector2f getPosition() {
        return new Vector2f(body.getX(), body.getY());
    }

    public float getX() {
        return body.getX();
    }

    public float getY() {
        return body.getY();
    }

    public float getWidth() {
        return body.getShape().getWidth();
    }

    public float getHeight() {
        return body.getShape().getHeight();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if(body.getVelocityX() < 0) {
            direction = Direction.LEFT;
        } else if(body.getVelocityX() > 0) {
            direction = Direction.RIGHT;
        }

        StateAnimation stateAnimation = stateAnimations.get(state);
        Animation newAnimation = stateAnimation.getCurrent(direction);

        if(currentAnimation != newAnimation) {
            currentAnimation = newAnimation;
            currentAnimation.restart();
        } else {
            currentAnimation.update(delta);
        }

        stateTime += delta;
        if(stateAnimation.expired(stateTime)) {
            setState(State.NORMAL);
        }

        /*position.x += velocityX * delta;
        position.y += velocityY * delta;*/
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g, float offsetX) throws SlickException {
        if(currentAnimation != null) {
            g.drawAnimation(currentAnimation, 
                    body.getShape().getCenterX() - currentAnimation.getWidth() / 2 - offsetX,
                    body.getShape().getCenterY() - currentAnimation.getHeight() / 2,
                    Color.white);
        }
    }

    @Override
    public void collideHorizontal(Body collided) {
        
    }

    @Override
    public void collideVertical(Body collided) {

    }
}
