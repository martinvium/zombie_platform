/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.entities;

import com.codefuss.factories.EntityFactory;
import com.codefuss.physics.Body;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Box extends Sprite {

    EntityFactory entityFactory;

    public Box(EntityFactory entityFactory, Vector2f position, Body body) {
        super(position, body);
        this.entityFactory = entityFactory;
    }

    @Override
    public void collideHorizontal(Body collided) {
        super.collideHorizontal(collided);
        if(body.getX() > getX()) {
            setVelocityX(-0.1f);
        } else {
            setVelocityX(0.1f);
        }
    }


}
