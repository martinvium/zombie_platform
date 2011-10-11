package com.codefuss.entities;

import com.codefuss.components.Sprite;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
final public class Player extends Creature {

    public Player(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void init() {
        this.sprite.setMaxSpeed(0.25f);
    }


}
