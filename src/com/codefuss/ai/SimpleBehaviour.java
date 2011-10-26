/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.ai;

import com.codefuss.GameState;
import com.codefuss.actions.Action;
import com.codefuss.actions.Attack;
import com.codefuss.actions.MoveLeft;
import com.codefuss.actions.MoveRight;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Player;
import com.codefuss.entities.Sprite.Direction;
import com.codefuss.physics.Body;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class SimpleBehaviour implements Behaviour {

    MoveLeft left;
    MoveRight right;
    Attack attack;

    Creature entity;

    Action nextMove;
    Action lastAction;

    ArrayList<Action> actions = new ArrayList<Action>();

    State state = State.NORMAL_IDLE;

    float timeSinceDecision = 0;
    float timeInState = 0;
    float timeSinceLastAttack = 0;
    float decisionTime = 500;
    float normalStateTimeout = 500;
    float attackTimeout = 3000;
    int viewingDistance = 400;

    public enum State {
        DECISION_READY,
        NORMAL_IDLE,
        NORMAL_PATROL,
        NORMAL_CHASE,
        BATTLE_ATTACK
    };

    public SimpleBehaviour(Creature entity) {
        this.entity = entity;
    }

    public void setState(State state) {
        if(state != this.state) {
            this.state = state;
            timeInState = 0;
        }
    }

    @Override
    public void init() {
        left = new MoveLeft(entity);
        right = new MoveRight(entity);
        attack = new Attack(entity);
        nextMove = left;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        timeSinceDecision += delta;
        timeInState += delta;
        timeSinceLastAttack += delta;

        GameState gameState = (GameState) game.getCurrentState();

        boolean isNormal = (state == State.NORMAL_IDLE || state == State.NORMAL_PATROL);
        if(isNormal && timeInState >= normalStateTimeout) {
            setState(State.DECISION_READY);
        } else if(timeSinceDecision >= decisionTime) {
            setState(State.DECISION_READY);
        } else if(entity.getVelocityX() == 0) {
            setState(State.DECISION_READY);
        }

        if(state == State.BATTLE_ATTACK) {
            timeSinceLastAttack -= attackTimeout;
            throw new RuntimeException("bla");
            
        } else if(state == State.DECISION_READY) {
            timeSinceDecision = 0;
            if(canSee(gameState.getPlayer())) {
                setState(State.NORMAL_CHASE);
            } else {
                setState(State.NORMAL_IDLE); // todo randomly patrol
            }
        }
    }

    private boolean canSee(Creature player) {
        return (Math.abs(entity.getX() - player.getX()) < viewingDistance);
    }

    @Override
    public Action nextAction(Creature player) {
        if(state == State.BATTLE_ATTACK) {
            if(timeSinceLastAttack > attackTimeout) {
                timeSinceLastAttack = 0;
                return attack;
            } else {
                return null;
            }
        } else if(state == State.NORMAL_CHASE) {
            nextMove = (entity.getX() > player.getX() ? left : right);
            return nextMove;
        }
        
        if(state == State.NORMAL_PATROL) {
            return nextMove;
        } else if(state == State.NORMAL_IDLE) {
            return null;
        }

        throw new RuntimeException("unhandled state: " + state);
    }

    @Override
    public void collideHorizontal(Body collided) {
        if(state == State.NORMAL_PATROL) {
            if(entity.getDirection() == Direction.LEFT) {
                nextMove = right;
            } else {
                nextMove = left;
            }
        }

        if(collided.getEntity() instanceof Player) {
            setState(State.BATTLE_ATTACK);
        }
    }

    @Override
    public void collideVertical(Body collided) {
        
    }
}
