/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.actions;

import com.codefuss.entities.Entity;
import com.codefuss.entities.Creature;
import com.codefuss.physics.World;
import java.util.ArrayList;
import java.util.Collection;
import org.newdawn.slick.Input;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ShowPhysicShapes implements Action {

    World world;

    public ShowPhysicShapes(World world) {
        this.world = world;
    }

    @Override
    public Collection<Entity> invoke() {
        world.toggleDebugDraw();
        return new ArrayList<Entity>();
    }

    @Override
    public boolean test(Input input, int keyCode, int delta) {
        return input.isKeyPressed(keyCode);
    }
}
