/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.factories;

import com.codefuss.StateAnimation;
import com.codefuss.entities.Ammo;
import com.codefuss.entities.ShotgunFire;
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

    public Ammo getShotgunAmmo(float x, float y, Sprite.Direction dir) {
        Animation ani = spriteFactory.getShotgunFireAnimation();
        Body body = physicsFactory.getDynamicBox(x, y, 16, 16);
        body.setFriction(0.0015f);
        ShotgunFire fire = new ShotgunFire(new Vector2f(x, y), body);
        fire.addStateAnimation(new StateAnimation(ani, ani, Sprite.State.NORMAL, 250));

        if(dir == Sprite.Direction.LEFT) {
            fire.setVelocityX(-1.0f);
        } else {
            fire.setVelocityX(1.0f);
        }
        return fire;
    }

    public Ammo getClaw(float x, float y, Sprite.Direction dir) {
        Animation ani = new Animation();
        Body body = physicsFactory.getDynamicBox(x, y, 16, 16);
        body.setFriction(0.0015f);
        Ammo fire = new Ammo(new Vector2f(x, y), body);
        fire.addStateAnimation(new StateAnimation(ani, ani, Sprite.State.NORMAL, 250));
        return fire;
    }
}
