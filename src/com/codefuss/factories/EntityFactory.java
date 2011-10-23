/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.factories;

import com.codefuss.StateAnimation;
import com.codefuss.entities.Entity;
import com.codefuss.actions.MoveLeft;
import com.codefuss.entities.Sprite;
import com.codefuss.entities.Block;
import com.codefuss.entities.Box;
import com.codefuss.entities.Player;
import com.codefuss.entities.ShotgunFire;
import com.codefuss.entities.Zombie;
import com.codefuss.physics.Body;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntityFactory {

    final static float DEFAULT_JUMP_SPEED = 0.8f;

    AnimationFactory spriteFactory;
    PhysicsFactory physicsFactory;
    BehaviourFactory behaviourFactory;

    public EntityFactory(AnimationFactory spriteFactory, PhysicsFactory physicsFactory, BehaviourFactory behaviourFactory) {
        this.spriteFactory = spriteFactory;
        this.physicsFactory = physicsFactory;
        this.behaviourFactory = behaviourFactory;
    }

    public Block getBlocker(Vector2f position, int width, int height) {
        Body body = physicsFactory.getStaticBox(position.x, position.y, width, height);
        body.setDensity(Body.DENSITY_MASSIVE);
        return new Block(body);
    }

    public Box getBox(Vector2f position) {
        Animation ani = spriteFactory.getBoxAnimation();
        Body body = physicsFactory.getDynamicBox(position.x, position.y, ani.getWidth(), ani.getHeight());
        Box box = new Box(this, position, body);
        box.addStateAnimation(new StateAnimation(ani, ani, Entity.State.NORMAL, 0));
        box.addStateAnimation(new StateAnimation(spriteFactory.getBoxAnimationBroken(), spriteFactory.getBoxAnimationBroken(), Entity.State.DEAD, 0));
        return box;
    }

    public Player getPlayer(Vector2f position) {
        position.y = -20;
        Animation aniLeft = spriteFactory.getPlayerWalkAnimationLeft();
        Body body = physicsFactory.getDynamicBox(position.x, position.y, aniLeft.getWidth() / 2, aniLeft.getHeight());
        Log.debug("add player at: " + position.toString());
        Player player = new Player(this, position, body);
        player.setSpeedX(0.35f);
        player.setSpeedY(DEFAULT_JUMP_SPEED);
        player.addStateAnimation(new StateAnimation(spriteFactory.getPlayerIdleAnimationLeft(),
                spriteFactory.getPlayerIdleAnimationRight(), Sprite.State.NORMAL, 0));
        player.addStateAnimation(new StateAnimation(aniLeft,
                spriteFactory.getPlayerWalkAnimationRight(), Sprite.State.WALKING, 0));
        player.addStateAnimation(new StateAnimation(spriteFactory.getPlayerShootAnimationLeft(),
                spriteFactory.getPlayerShootAnimationRight(), Sprite.State.ATTACKING, 600));
        return player;
    }

    public Entity getEntity(String type, String name, Vector2f position) {
        if (type.equals("zombie")) {
            return getZombie(position);
        } else if(type.equals("box")) {
            return getBox(position);
        }

        Log.debug("invalid entity type: " + type);
        return null;
    }

    public Entity getZombie(Vector2f position) {
        position.y = -20;
        Animation aniLeft = spriteFactory.getZombieWalkAnimationLeft();
        Body body = physicsFactory.getDynamicBox(position.x, position.y, aniLeft.getWidth() / 2, aniLeft.getHeight());
        
        Zombie zombie = new Zombie(this, position, body);
        zombie.setSpeedX(0.08f);
        zombie.setSpeedY(DEFAULT_JUMP_SPEED);
        zombie.setBehaviour(behaviourFactory.getZombieBehavour(zombie));

        zombie.addStateAnimation(new StateAnimation(aniLeft,
                spriteFactory.getZombieWalkAnimationRight(), Sprite.State.NORMAL, 0));
        zombie.addStateAnimation(new StateAnimation(spriteFactory.getZombieWalkAnimationLeft(),
                spriteFactory.getZombieWalkAnimationRight(), Sprite.State.WALKING, 0));
        zombie.addStateAnimation(new StateAnimation(spriteFactory.getZombieDeadAnimationLeft(),
                spriteFactory.getZombieDeadAnimationRight(), Entity.State.DEAD, 0));
        
        return zombie;
    }

    public Entity getShotgunFire(float x, float y, Sprite.Direction dir) {
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
}
