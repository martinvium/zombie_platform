/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.components.Sprite;
import com.codefuss.entities.Block;
import com.codefuss.entities.Player;
import com.codefuss.entities.Zombie;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntityFactory {

    public EntityFactory() {
    }

    public Block getBlocker(Vector2f position) {
        return new Block();
    }

    public Player getPlayer(Vector2f position) {
        Sprite sprite = new Sprite(loadAnimation("assets/sprites/zombie/walk/jared0134.png"), position);
        return new Player(sprite);
    }

    public Entity getEntity(String type, String name, Vector2f position) {
        if (type.equals("zombie")) {
            Log.debug("created zombie");
            Sprite sprite = new Sprite(loadAnimation("assets/sprites/hero/run/jared0076.png"), position);
            return new Zombie(sprite);
        }

        Log.debug("invalid entity type: " + type);
        return null;
    }

    Animation loadAnimation(String ref) {
        Image image;
        try {
			image = new Image(ref);
		} catch(SlickException ex) {
            return null;
		}

        Animation ani = new Animation();
        ani.addFrame(image, 200);

        return ani;
    }
}
