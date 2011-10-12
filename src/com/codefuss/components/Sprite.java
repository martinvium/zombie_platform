package com.codefuss.components;

import com.codefuss.StateAnimation;
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
public class Sprite implements UpdateComponent, RenderComponent {

    Animation leftAnimation;
    Animation rightAnimation;
    Animation attackLeftAnimation;
    Animation attackRightAnimation;
    Animation currentAnimation;
    Vector2f position;
    float maxSpeed = 0.25f;
    float velocityX = 0f;
    State state = State.IDLE;
    long stateTime;
    Direction direction = Direction.RIGHT;

    EnumMap<State, StateAnimation> stateAnimations = new EnumMap<State, StateAnimation>(State.class);

    public enum Direction {
        LEFT, RIGHT
    }

    public enum State {
        IDLE, WALKING, ATTACKING, JUMPING
    }

    public Sprite(Vector2f position) {
        this.position = position;
    }

    public void addStateAnimation(StateAnimation state) {
        stateAnimations.put(state.getState(), state);
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setState(State state) {
        if (this.state != state) {
            this.state = state;
            stateTime = 0;
        }
    }

    public void setVelocityX(float velocity) {
        velocityX = velocity;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public Vector2f getPosition() {
        return position;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return currentAnimation.getImage(0).getWidth();
    }

    public int getHeight() {
        return currentAnimation.getImage(0).getHeight();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if(velocityX < 0) {
            direction = Direction.LEFT;
        } else if(velocityX > 0) {
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
            setState(State.IDLE);
        }

        position.x += velocityX * delta;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g, float offsetX) throws SlickException {
        if(currentAnimation != null) {
            g.drawAnimation(currentAnimation, position.x - offsetX, position.y, Color.white);
        }
    }
}
