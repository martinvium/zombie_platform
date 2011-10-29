package com.codefuss.entities;


import com.codefuss.Camera;
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
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class Sprite implements Entity, CollisionListener, FrictionListener {

    private Animation currentAnimation;
    private Vector2f position;
    private float speedX = 0.25f;
    private float speedY;
    private Body body;
    private State state = State.NORMAL;
    private long stateTime;
    private EnumMap<State, StateAnimation> stateAnimations = new EnumMap<State, StateAnimation>(State.class);
    private int maxHealth = 1;
    private int health = 1;

    protected Direction direction = Direction.RIGHT;
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

    public int getHealth() {
        return health;
    }

    public void applyHealth(int health) {
        this.health += health;

        if(this.health > maxHealth) {
            this.health = maxHealth;
        } else if(this.health < 0) {
            this.health = 0;
        }

        Log.debug("applied health: " + health + " => " + this.health);
    }

    public void setMaxHealth(int health) {
        maxHealth = health;
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public Body getBody() {
        return body;
    }

    protected void remove() {
        removed = true;
        getBody().remove();
    }

    @Override
    public boolean isRemoved() {
        return removed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void reverseDirection() {
        if(direction == Direction.LEFT) {
            direction = Direction.RIGHT;
        } else {
            direction = Direction.LEFT;
        }

        Log.debug("reverse direction: " + direction);
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
            Log.debug("state: " + state);
            this.state = state;
            stateTime = 0;
        }
    }

    public State getState() {
        return state;
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

    public float getCenterX() {
        return body.getShape().getCenterX();
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
        if(health <= 0) {
            kill();
        }

        if(body.getVelocityX() < 0) {
            direction = Direction.LEFT;
        } else if(body.getVelocityX() > 0) {
            direction = Direction.RIGHT;
        }

        StateAnimation stateAnimation = stateAnimations.get(state);
        if(state == State.DEAD && stateAnimation == null) {
            removed = true;
            Log.debug("entity died");
            return;
        }

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

        behaviour.update(container, game, delta);
    }

    public Action getNextAction(Creature player) {
        if(state != State.DEAD) {
            return behaviour.nextAction(player);
        }
        
        return null;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g, Camera camera) throws SlickException {
        if(currentAnimation != null) {
            g.drawAnimation(currentAnimation, 
                    body.getShape().getCenterX() - currentAnimation.getWidth() / 2 - camera.getX(),
                    body.getShape().getCenterY() - currentAnimation.getHeight() / 2 - camera.getY(),
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
