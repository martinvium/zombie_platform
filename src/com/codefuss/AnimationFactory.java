package com.codefuss;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class AnimationFactory {

    String spritesPath = "assets/sprites/";

    public Animation getShotgunFireAnimation() {
        Image orgImage = loadImage("hero/shotgun_fire");
        Animation ani = getAnimation(new Image[] {
            orgImage.getScaledCopy(.1f),
            orgImage.getScaledCopy(.2f),
            orgImage.getScaledCopy(.3f),
            orgImage.getScaledCopy(.4f),
            orgImage.getScaledCopy(.5f)
        }, 50);
        ani.setLooping(false);
        return ani;
    }

    public Animation getPlayerShootAnimation() {
        Animation ani = getAnimation(getPlayerShootImages(), 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getPlayerShootAnimationFlipped() {
        Animation ani = getAnimation(getFlippedCopies(getPlayerShootImages()), 70);
        ani.setLooping(false);
        return ani;
    }

    public Image[] getPlayerShootImages() {
        return new Image[] {
            loadImage("hero/attack/jared0200"),
            loadImage("hero/attack/jared0201"),
            loadImage("hero/attack/jared0202"),
            loadImage("hero/attack/jared0203"),
            loadImage("hero/attack/jared0204"),
            loadImage("hero/attack/jared0205"),
            loadImage("hero/attack/jared0206"),
            loadImage("hero/attack/jared0207"),
            loadImage("hero/attack/jared0208"),
            loadImage("hero/attack/jared0209"),
            loadImage("hero/attack/jared0210"),
            loadImage("hero/attack/jared0211"),
            loadImage("hero/attack/jared0212"),
            loadImage("hero/attack/jared0213"),
            loadImage("hero/attack/jared0214"),
            loadImage("hero/attack/jared0215")
        };
    }
    
    public Animation getZombieDeadAnimationLeft() {
        Animation ani = getAnimation(getZombieDeadImages(), 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getZombieDeadAnimationRight() {
        Animation ani = getAnimation(getFlippedCopies(getZombieDeadImages()), 70);
        ani.setLooping(false);
        return ani;
    }

    public Image[] getZombieDeadImages() {
        return new Image[] {
            loadImage("zombie/dead/jared0090"),
            loadImage("zombie/dead/jared0091"),
            loadImage("zombie/dead/jared0092"),
            loadImage("zombie/dead/jared0093"),
            loadImage("zombie/dead/jared0094"),
            loadImage("zombie/dead/jared0095"),
            loadImage("zombie/dead/jared0096"),
            loadImage("zombie/dead/jared0097"),
            loadImage("zombie/dead/jared0098"),
            loadImage("zombie/dead/jared0099"),
            loadImage("zombie/dead/jared0100"),
            loadImage("zombie/dead/jared0101"),
            loadImage("zombie/dead/jared0102"),
            loadImage("zombie/dead/jared0103"),
            loadImage("zombie/dead/jared0104"),
            loadImage("zombie/dead/jared0105"),
            loadImage("zombie/dead/jared0106"),
            loadImage("zombie/dead/jared0107"),
            loadImage("zombie/dead/jared0108"),
            loadImage("zombie/dead/jared0109"),
            loadImage("zombie/dead/jared0110"),
            loadImage("zombie/dead/jared0111"),
            loadImage("zombie/dead/jared0112"),
            loadImage("zombie/dead/jared0113"),
            loadImage("zombie/dead/jared0114"),
            loadImage("zombie/dead/jared0115"),
            loadImage("zombie/dead/jared0116"),
            loadImage("zombie/dead/jared0117"),
            loadImage("zombie/dead/jared0118"),
            loadImage("zombie/dead/jared0119"),
            loadImage("zombie/dead/jared0120"),
            loadImage("zombie/dead/jared0121")

        };
    }

    public Animation getPlayerWalkAnimationRight() {
        return getAnimation(getPlayerImages(), 70);
    }

    public Animation getPlayerWalkAnimationLeft() {
        return getAnimation(getFlippedCopies(getPlayerImages()), 70);
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

    public Animation getZombieWalkAnimationLeft() {
        return getAnimation(getZombieWalkImages(), 70);
    }

    public Animation getZombieWalkAnimationRight() {
        return getAnimation(getFlippedCopies(getZombieWalkImages()), 70);
    }

    public Image[] getZombieWalkImages() {
        return new Image[] {
            loadImage("zombie/walk/jared0133"),
            loadImage("zombie/walk/jared0134"),
            loadImage("zombie/walk/jared0135"),
            loadImage("zombie/walk/jared0136"),
            loadImage("zombie/walk/jared0137"),
            loadImage("zombie/walk/jared0138"),
            loadImage("zombie/walk/jared0139"),
            loadImage("zombie/walk/jared0140"),
            loadImage("zombie/walk/jared0141"),
            loadImage("zombie/walk/jared0142"),
            loadImage("zombie/walk/jared0143"),
            loadImage("zombie/walk/jared0144"),
            loadImage("zombie/walk/jared0145"),
            loadImage("zombie/walk/jared0146"),
            loadImage("zombie/walk/jared0147"),
            loadImage("zombie/walk/jared0148"),
            loadImage("zombie/walk/jared0149"),
            loadImage("zombie/walk/jared0150"),
            loadImage("zombie/walk/jared0151"),
            loadImage("zombie/walk/jared0152"),
            loadImage("zombie/walk/jared0153"),
            loadImage("zombie/walk/jared0154"),
            loadImage("zombie/walk/jared0155"),
            loadImage("zombie/walk/jared0156"),
            loadImage("zombie/walk/jared0157"),
            loadImage("zombie/walk/jared0158"),
            loadImage("zombie/walk/jared0159"),
            loadImage("zombie/walk/jared0160"),
            loadImage("zombie/walk/jared0161"),
            loadImage("zombie/walk/jared0162"),
            loadImage("zombie/walk/jared0163"),
            loadImage("zombie/walk/jared0164"),
            loadImage("zombie/walk/jared0165"),
            loadImage("zombie/walk/jared0166"),
            loadImage("zombie/walk/jared0167"),
            loadImage("zombie/walk/jared0168"),
            loadImage("zombie/walk/jared0169"),
            loadImage("zombie/walk/jared0170"),
            loadImage("zombie/walk/jared0171"),
            loadImage("zombie/walk/jared0172"),
            loadImage("zombie/walk/jared0173")
        };
    }

    Animation getAnimation(Image[] images, int defaultDuration) {
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
