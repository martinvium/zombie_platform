/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class PhysicsFactory {
    private World world;

    public PhysicsFactory(float x, float y) {
        this.world = world = new World(new Vec2(x, y), true);
    }

    public World getWorld() {
        return world;
    }

    public Body getBody(float x, float y) {
        BodyDef def = new BodyDef();
        def.position.set(x, y);
        return world.createBody(def);
    }
}
