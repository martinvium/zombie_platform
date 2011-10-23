/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.factories;

import com.codefuss.ai.Behaviour;
import com.codefuss.ai.NullBehaviour;
import com.codefuss.ai.SimpleBehaviour;
import com.codefuss.entities.Creature;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class BehaviourFactory {
    public Behaviour getZombieBehavour(Creature creature) {
        SimpleBehaviour b = new SimpleBehaviour(creature);
        b.init();
        return b;
    }

    public Behaviour getNullBehaviour() {
        return new NullBehaviour();
    }
}
