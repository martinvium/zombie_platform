/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.components.Sprite;
import com.codefuss.entities.Block;
import com.codefuss.entities.Player;
import com.codefuss.entities.Zombie;
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
        Sprite sprite = new Sprite(
                spriteFactory.getPlayerWalkAnimationFlipped(),
                spriteFactory.getPlayerWalkAnimation(),
                spriteFactory.getPlayerShootAnimationFlipped(),
                spriteFactory.getPlayerShootAnimation(),
                position);
        return new Player(sprite);
    }

    public Entity getEntity(String type, String name, Vector2f position) {
        if (type.equals("zombie")) {
            Sprite sprite = new Sprite(
                    spriteFactory.getZombieWalkAnimationFlipped(),
                    spriteFactory.getZombieWalkAnimation(),
                    spriteFactory.getPlayerShootAnimationFlipped(),
                    spriteFactory.getPlayerShootAnimation(),
                    position);
            return new Zombie(sprite);
        }

        Log.debug("invalid entity type: " + type);
        return null;
    }
}
