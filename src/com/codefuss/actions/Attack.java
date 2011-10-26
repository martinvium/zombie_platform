package com.codefuss.actions;

import com.codefuss.entities.Entity;
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

    int timeKeyPressed = 0;

    public Attack(Creature creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        Log.debug("invoke attack");
        creature.setState(Sprite.State.ATTACKING);
        ArrayList<Entity> ret = new ArrayList<Entity>();
        ret.add(creature.getMainAttack(timeKeyPressed));
        timeKeyPressed = 0;
        return ret;
    }

    @Override
    public boolean test(Input input, int keyCode, int delta) {
        if(input.isKeyDown(keyCode)) {
            timeKeyPressed += delta;
            return false;
        } else if(timeKeyPressed > 0) {
            return true;
        } else {
            timeKeyPressed = 0;
            return false;
        }
    }
}
