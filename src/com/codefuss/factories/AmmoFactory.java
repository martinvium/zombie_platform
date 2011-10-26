/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.factories;

import com.codefuss.StateAnimation;
import com.codefuss.entities.Ammo;
import com.codefuss.entities.Sprite;
import com.codefuss.physics.Body;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class AmmoFactory {

    AnimationFactory spriteFactory;
    PhysicsFactory physicsFactory;

    public AmmoFactory(AnimationFactory spriteFactory, PhysicsFactory physicsFactory) {
        this.spriteFactory = spriteFactory;
        this.physicsFactory = physicsFactory;
    }

    public Ammo getClaw(float x, float y, Sprite.Direction dir) {
        Animation ani = new Animation();
        Body body = physicsFactory.getDynamicBox(x, y, 16, 16);
        body.setFriction(0.0015f);
        Ammo fire = new Ammo(new Vector2f(x, y), body);
        fire.addStateAnimation(new StateAnimation(ani, ani, Sprite.State.NORMAL, 250));
        return fire;
    }

    public Ammo getRedBall(float x, float y, Sprite.Direction dir, int timeKeyPressed) {
        return getBaseBall(x, y, dir, timeKeyPressed);
    }

    public Ammo getBlueBall(float x, float y, Sprite.Direction dir, int timeKeyPressed) {
        return getBaseBall(x, y, dir, timeKeyPressed);
    }

    Ammo getBaseBall(float x, float y, Sprite.Direction dir, int timeKeyPressed) {
        Animation ani = spriteFactory.getShotgunFireAnimation();
        Body body = physicsFactory.getDynamicBox(x, y, 16, 16);
        body.setFriction(0.0015f);
        Ammo fire = new Ammo(new Vector2f(x, y), body);
        fire.addStateAnimation(new StateAnimation(ani, ani, Sprite.State.NORMAL, 250));

        float velocity = timeKeyPressed * 0.005f;
        velocity = Math.max(velocity, 0.7f);
        if(dir == Sprite.Direction.LEFT) {
            fire.setVelocityX(-velocity);
        } else {
            fire.setVelocityX(velocity);
        }
        return fire;
    }
}
