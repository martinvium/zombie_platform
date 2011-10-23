package com.codefuss.entities;


import com.codefuss.StateAnimation;
import com.codefuss.actions.Action;
import com.codefuss.ai.Behaviour;
import com.codefuss.ai.NullBehaviour;
import com.codefuss.physics.Body;
import com.codefuss.physics.CollisionListener;
import com.codefuss.physics.FrictionListener;
import java.util.EnumMap;
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
abstract public class Sprite implements Entity, CollisionListener, FrictionListener {

    Animation currentAnimation;
    Vector2f position;

    float speedX = 0.25f;
    float speedY;
    Body body;

    State state = State.NORMAL;
    long stateTime;
    Direction direction = Direction.RIGHT;

    EnumMap<State, StateAnimation> stateAnimations = new EnumMap<State, StateAnimation>(State.class);

    protected boolean removed = false;

    protected Behaviour behaviour;

    public enum Direction {
        LEFT, RIGHT
    }

    public Sprite(Vector2f position, Body body) {
        this.position = position;
        this.body = body;
        this.body.setCollisionListener(this); // FIXME
        this.body.setFrictionListener(this); // FIXME
        this.body.setEntity(this); // FIXME
        behaviour = new NullBehaviour();
    }

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public Body getBody() {
        return body;
    }

    @Override
    public boolean isRemoved() {
        return removed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void addStateAnimation(StateAnimation stateAni) {
        stateAnimations.put(stateAni.getState(), stateAni);
    }

    public void setSpeedX(float speed) {
        speedX = speed;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedY(float speed) {
        speedY = speed;
    }

    public float getSpeedY() {
        return speedY;
    }

    @Override
    public void setState(State state) {
        if (this.state != state) {
            this.state = state;
            stateTime = 0;
        }
    }

    public void kill() {
        setState(State.DEAD);
        body.setDensity(.1f);
    }

    public void setVelocityX(float velocity) {
        body.setVelocityX(velocity);
    }

    public float getVelocityX() {
        return body.getVelocityX();
    }

    public void setVelocityY(float velocity) {
        body.setVelocityY(velocity);
    }

    public float getVelocityY() {
        return body.getVelocityY();
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

        if(state != State.DEAD) {
            behaviour.update(container, game, delta);
            Action nextAction = behaviour.nextAction();
            if(nextAction != null) {
                nextAction.invoke();
            }
        }
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
        behaviour.collideHorizontal(collided);
    }

    @Override
    public void collideVertical(Body collided) {
        behaviour.collideVertical(collided);
    }

    @Override
    public void frictionStop() {
        if(state != Entity.State.DEAD) {
            setState(Entity.State.NORMAL);
        }
    }
}
