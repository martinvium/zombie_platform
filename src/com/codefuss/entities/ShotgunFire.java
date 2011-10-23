package com.codefuss.entities;

import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ShotgunFire extends Sprite {

    public ShotgunFire(Vector2f position, Body body) {
        super(position, body);
    }

    @Override
    public void collideVertical(Body collided) {
        super.collideHorizontal(collided);
        if(collided.getEntity() instanceof Sprite) {
            removed = true;
            Sprite sprite = (Sprite)collided.getEntity();
            sprite.kill();
        }
    }

    @Override
    public void collideHorizontal(Body collided) {
        super.collideHorizontal(collided);
        if(collided.getEntity() instanceof Sprite) {
            removed = true;
            Sprite sprite = (Sprite)collided.getEntity();
            sprite.kill();
        }
    }
}
