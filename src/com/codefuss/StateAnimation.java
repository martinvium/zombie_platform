/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.Entity.State;
import com.codefuss.entities.Sprite.Direction;
import org.newdawn.slick.Animation;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class StateAnimation {
    Animation left;
    Animation right;
    State state;
    int timeout;

    public StateAnimation(Animation left, Animation right, State state, int timeout) {
        this.left = left;
        this.right = right;
        this.state = state;
        this.timeout = timeout;
    }

    public Animation getCurrent(Direction direction) {
        if(direction == Direction.LEFT) {
            return left;
        } else if(direction == Direction.RIGHT) {
            return right;
        }

        return null;
    }

    public boolean expired(long stateTime) {
        if(timeout == 0) {
            return false;
        }
        return stateTime >= timeout;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
