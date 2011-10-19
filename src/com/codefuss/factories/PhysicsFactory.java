package com.codefuss.factories;

import com.codefuss.physics.Body;
import com.codefuss.physics.DynamicBody;
import com.codefuss.physics.StaticBody;
import com.codefuss.physics.World;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class PhysicsFactory {
    private World world;

    public PhysicsFactory(Vector2f gravity) {
        this.world = world = new World(gravity);
    }

    public World getWorld() {
        return world;
    }

    public Body getDynamicBox(float x, float y, float width, float height) {
        Body body = new DynamicBody(new Rectangle(x, y, width, height));
        world.add(body);
        return body;
    }

    public Body getStaticBox(float x, float y, float width, float height) {
        Body body = new StaticBody(new Rectangle(x, y, width, height));
        world.add(body);
        return body;
    }
}
