/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.ai;

import com.codefuss.actions.Action;
import com.codefuss.actions.MoveLeft;
import com.codefuss.actions.MoveRight;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Sprite.Direction;
import com.codefuss.physics.Body;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class SimpleBehaviour implements Behaviour {

    MoveLeft left;
    MoveRight right;
    Action nextAction;
    Creature entity;

    public SimpleBehaviour(Creature entity) {
        this.entity = entity;
    }

    @Override
    public void init() {
        left = new MoveLeft(entity);
        right = new MoveRight(entity);
        nextAction = left;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {

    }

    @Override
    public Action nextAction() {
        return nextAction;
    }

    @Override
    public void collideHorizontal(Body collided) {
        if(entity.getDirection() == Direction.LEFT) {
            nextAction = right;
        } else {
            nextAction = left;
        }
    }

    @Override
    public void collideVertical(Body collided) {
        
    }
}
