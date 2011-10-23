package com.codefuss.ai;

import com.codefuss.actions.Action;
import com.codefuss.physics.CollisionListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Behaviour extends CollisionListener {

    public void init();

    public void update(GameContainer container, StateBasedGame game, int delta);

    public Action nextAction();
}
