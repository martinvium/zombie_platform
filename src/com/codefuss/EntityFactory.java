/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.actions.MoveLeft;
import com.codefuss.components.Sprite;
import com.codefuss.entities.Block;
import com.codefuss.entities.Player;
import com.codefuss.entities.Zombie;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntityFactory {

    SpriteFactory spriteFactory;

    public EntityFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public Block getBlocker(Vector2f position) {
        return new Block();
    }

    public Player getPlayer(Vector2f position) {
        Log.debug("add player at: " + position.toString());
        Sprite sprite = new Sprite(
                spriteFactory.getPlayerWalkAnimationLeft(),
                spriteFactory.getPlayerWalkAnimationRight(),
                spriteFactory.getPlayerShootAnimationFlipped(),
                spriteFactory.getPlayerShootAnimation(),
                position);
        Player player = new Player(sprite);
        player.init();
        return player;
    }

    public Entity getEntity(String type, String name, Vector2f position) {
        if (type.equals("zombie")) {
            Log.debug("add zombie at: " + position.toString());
            //Animation left = spriteFactory.getZombieWalkAnimationLeft();
            position.y = 8;
            Sprite sprite = new Sprite(
                    spriteFactory.getZombieWalkAnimationLeft(),
                    spriteFactory.getZombieWalkAnimationRight(),
                    spriteFactory.getPlayerShootAnimationFlipped(),
                    spriteFactory.getPlayerShootAnimation(),
                    position);
            Zombie zombie = new Zombie(sprite);
            zombie.init();
            new MoveLeft(sprite).invoke();
            return zombie;
        }

        Log.debug("invalid entity type: " + type);
        return null;
    }
}
