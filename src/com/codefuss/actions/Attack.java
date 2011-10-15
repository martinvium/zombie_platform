package com.codefuss.actions;

import com.codefuss.Entity;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Sprite;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Attack extends BaseAction {

    public Attack(Creature creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        creature.setState(Sprite.State.ATTACKING);
        creature.setVelocityX(0);

        ArrayList<Entity> ret = new ArrayList<Entity>();
        ret.add(creature.getMainAttack());
        return ret;
    }
}
