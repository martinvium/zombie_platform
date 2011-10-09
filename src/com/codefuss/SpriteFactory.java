/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class SpriteFactory {

    String spritesPath = "assets/sprites/";

    public Animation getPlayerWalkAnimation() {
        return getAnimation(getPlayerImages());
    }

    public Animation getPlayerWalkAnimationFlipped() {
        return getAnimation(getFlippedCopies(getPlayerImages()));
    }

    public Image[] getPlayerImages() {
        return new Image[] {
            loadImage("hero/run/jared0060"),
            loadImage("hero/run/jared0061"),
            loadImage("hero/run/jared0062"),
            loadImage("hero/run/jared0063"),
            loadImage("hero/run/jared0064"),
            loadImage("hero/run/jared0065"),
            loadImage("hero/run/jared0066"),
            loadImage("hero/run/jared0067"),
            loadImage("hero/run/jared0068"),
            loadImage("hero/run/jared0069"),
            loadImage("hero/run/jared0070"),
            loadImage("hero/run/jared0071"),
            loadImage("hero/run/jared0072"),
            loadImage("hero/run/jared0073"),
            loadImage("hero/run/jared0074"),
            loadImage("hero/run/jared0075"),
            loadImage("hero/run/jared0076")
        };
    }

    public Animation getZombieWalkAnimation() {
        return getAnimation(getZombieWalkImages());
    }

    public Animation getZombieWalkAnimationFlipped() {
        return getAnimation(getFlippedCopies(getZombieWalkImages()));
    }

    public Image[] getZombieWalkImages() {
        return new Image[] {
            loadImage("zombie/walk/jared0144"),
            loadImage("zombie/walk/jared0145"),
            loadImage("zombie/walk/jared0146"),
            loadImage("zombie/walk/jared0147"),
            loadImage("zombie/walk/jared0148"),
            loadImage("zombie/walk/jared0149"),
            loadImage("zombie/walk/jared0150")
        };
    }

    Animation getAnimation(Image[] images) {
        int defaultDuration = 70;
        Animation ani = new Animation();

        for(Image image : images) {
            ani.addFrame(image, defaultDuration);
        }

        return ani;
    }

    public Image[] getFlippedCopies(Image[] images) {
        Image[] flippedImages = new Image[images.length];
        for(int i = 0; i < images.length; i++) {
            flippedImages[i] = images[i].getFlippedCopy(true, false);
        }
        return flippedImages;
    }

    Image loadImage(String name) {
        Image image;
        try {
            image = new Image(spritesPath + name + ".png");
            return image;
        } catch(SlickException ex) {
            return null;
        }
    }
}
