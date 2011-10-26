/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.ai;

import com.codefuss.actions.Action;
import com.codefuss.entities.Creature;
import com.codefuss.physics.Body;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class NullBehaviour implements Behaviour {

    @Override
    public void init() {
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {

    }

    @Override
    public Action nextAction(Creature player) {
        return null;
    }

    @Override
    public void collideHorizontal(Body collided) {

    }

    @Override
    public void collideVertical(Body collided) {
        
    }
}
