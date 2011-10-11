package com.codefuss.actions;

import com.codefuss.Entity;
import com.codefuss.components.Sprite;
import com.codefuss.entities.Creature;
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
        creature.getSprite().setState(Sprite.State.ATTACKING);
        creature.getSprite().setVelocityX(0);

        ArrayList<Entity> ret = new ArrayList<Entity>();
        ret.add(creature.getMainAttack());
        return ret;
    }
}
