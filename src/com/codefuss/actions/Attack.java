package com.codefuss.actions;

import com.codefuss.Entity;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Sprite;
import java.util.ArrayList;
import java.util.Collection;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

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
        Log.debug("invoke attack");
        creature.setState(Sprite.State.ATTACKING);
        ArrayList<Entity> ret = new ArrayList<Entity>();
        ret.add(creature.getMainAttack());
        return ret;
    }

    @Override
    public boolean test(Input input, int keyCode) {
        return input.isKeyPressed(keyCode);
    }
}
