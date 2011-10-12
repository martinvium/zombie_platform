/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.actions.MoveLeft;
import com.codefuss.components.Sprite;
import com.codefuss.entities.Block;
import com.codefuss.entities.Player;
import com.codefuss.entities.ShotgunFire;
import com.codefuss.entities.Zombie;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntityFactory {

    AnimationFactory spriteFactory;

    public EntityFactory(AnimationFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public Block getBlocker(Vector2f position) {
        return new Block();
    }

    public Player getPlayer(Vector2f position) {
        Log.debug("add player at: " + position.toString());
        Sprite sprite = new Sprite(position);
        sprite.addStateAnimation(new StateAnimation(spriteFactory.getPlayerWalkAnimationLeft(),
                spriteFactory.getPlayerWalkAnimationRight(), Sprite.State.NORMAL, 0));
        sprite.addStateAnimation(new StateAnimation(spriteFactory.getPlayerWalkAnimationLeft(),
                spriteFactory.getPlayerWalkAnimationRight(), Sprite.State.WALKING, 0));
        sprite.addStateAnimation(new StateAnimation(spriteFactory.getPlayerShootAnimationFlipped(),
                spriteFactory.getPlayerShootAnimation(), Sprite.State.ATTACKING, 600));
        Player player = new Player(this, sprite);
        player.init();
        return player;
    }

    public Entity getEntity(String type, String name, Vector2f position) {
        if (type.equals("zombie")) {
            position.y = 8;
            Sprite sprite = new Sprite(position);
            sprite.addStateAnimation(new StateAnimation(spriteFactory.getZombieWalkAnimationLeft(),
                    spriteFactory.getZombieWalkAnimationRight(), Sprite.State.NORMAL, 0));
            sprite.addStateAnimation(new StateAnimation(spriteFactory.getZombieWalkAnimationLeft(),
                    spriteFactory.getZombieWalkAnimationRight(), Sprite.State.WALKING, 0));
            Zombie zombie = new Zombie(this, sprite);
            zombie.init();
            new MoveLeft(sprite).invoke();
            return zombie;
        }

        Log.debug("invalid entity type: " + type);
        return null;
    }

    public Entity getShotgunFire(Vector2f position) {
        Sprite sprite = new Sprite(position);
        sprite.addStateAnimation(new StateAnimation(spriteFactory.getShotgunFireAnimation(), 
                spriteFactory.getShotgunFireAnimation(), Sprite.State.NORMAL, 300));
        sprite.setVelocityX(0.2f);
        return new ShotgunFire(sprite);
    }
}
