package com.codefuss.factories;

import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class AnimationFactory {

    String spritesPath = "assets/sprites/";
    private HashMap<String, Image> imageMap = new HashMap<String, Image>();
    private HashMap<String, Image> flippedImageMap = new HashMap<String, Image>();

    public Animation getBoxAnimation() {
        Animation ani = getAnimation(new Image[] {
            loadImage("env/box")
        }, 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getBoxAnimationBroken() {
        Animation ani = getAnimation(new Image[] {
            loadImage("env/box_broken")
        }, 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getShotgunFireAnimation() {
        Animation ani = getAnimation(new Image[] {
            loadImage("ammo/ball_red")
        }, 50);
        ani.setLooping(false);
        return ani;
    }

    public Animation getPlayerIdleAnimationRight() {
        Animation ani = getAnimation(getPlayerIdleImages(), 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getPlayerIdleAnimationLeft() {
        Animation ani = getAnimation(getFlippedCopies(getPlayerIdleImages()), 70);
        ani.setLooping(false);
        return ani;
    }

    public Image[] getPlayerIdleImages() {
        return new Image[] {
            loadImage("hero/attack/jared0200")
        };
    }

    public Animation getPlayerShootAnimationRight() {
        Animation ani = getAnimation(getPlayerShootImages(), 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getPlayerShootAnimationLeft() {
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

    public Animation getZombieIdleAnimationLeft() {
        Animation ani = getAnimation(getZombieIdleImages(), 200);
        return ani;
    }

    public Animation getZombieIdleAnimationRight() {
        Animation ani = getAnimation(getFlippedCopies(getZombieIdleImages()), 200);
        return ani;
    }

    public Image[] getZombieIdleImages() {
        return new Image[] {
            loadImage("zombie/attack/jared0174"),
            loadImage("zombie/attack/jared0175"),
            loadImage("zombie/attack/jared0176"),
            loadImage("zombie/attack/jared0177"),
            loadImage("zombie/attack/jared0178"),
            loadImage("zombie/attack/jared0177"),
            loadImage("zombie/attack/jared0176"),
            loadImage("zombie/attack/jared0175")
        };
    }

    public Animation getZombieAttackAnimationLeft() {
        Animation ani = getAnimation(getZombieAttackImages(), 70);
        ani.setLooping(false);
        return ani;
    }

    public Animation getZombieAttackAnimationRight() {
        Animation ani = getAnimation(getFlippedCopies(getZombieAttackImages()), 70);
        ani.setLooping(false);
        return ani;
    }

    public Image[] getZombieAttackImages() {
        return new Image[] {
            loadImage("zombie/attack/jared0174"),
            loadImage("zombie/attack/jared0175"),
            loadImage("zombie/attack/jared0176"),
            loadImage("zombie/attack/jared0177"),
            loadImage("zombie/attack/jared0178"),
            loadImage("zombie/attack/jared0179"),
            loadImage("zombie/attack/jared0180"),
            loadImage("zombie/attack/jared0181"),
            loadImage("zombie/attack/jared0182"),
            loadImage("zombie/attack/jared0183"),
            loadImage("zombie/attack/jared0184"),
            loadImage("zombie/attack/jared0185"),
            loadImage("zombie/attack/jared0186"),
            loadImage("zombie/attack/jared0187"),
            loadImage("zombie/attack/jared0188"),
            loadImage("zombie/attack/jared0189"),
            loadImage("zombie/attack/jared0190"),
            loadImage("zombie/attack/jared0191"),
            loadImage("zombie/attack/jared0192"),
            loadImage("zombie/attack/jared0193"),
            loadImage("zombie/attack/jared0194"),
            loadImage("zombie/attack/jared0195"),
            loadImage("zombie/attack/jared0196"),
            loadImage("zombie/attack/jared0197"),
            loadImage("zombie/attack/jared0198")
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
        Animation ani = getAnimation(getPlayerImages(), 70);
        return ani;
    }

    public Animation getPlayerWalkAnimationLeft() {
        Animation ani = getAnimation(getFlippedCopies(getPlayerImages()), 70);
        return ani;
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
            Image flippedImage;
            boolean isCachable = images[i].getResourceReference() != null;
            if(isCachable && flippedImageMap.containsKey(images[i].getResourceReference())) {
                flippedImage = flippedImageMap.get(images[i].getResourceReference());
            } else {
                flippedImage = images[i].getFlippedCopy(true, false);
                if(isCachable) {
                    flippedImageMap.put(images[i].getResourceReference(), flippedImage);
                }
            }

            flippedImages[i] = flippedImage;
        }
        return flippedImages;
    }

    Image loadImage(String name) {
        String path = spritesPath + name + ".png";
        if(imageMap.containsKey(path)) {
            return imageMap.get(path);
        }

        Image image;
        try {
            image = new Image(path);
            imageMap.put(path, image);
            return image;
        } catch(SlickException ex) {
            Log.error("failed to load image: " + path);
            return loadErrorFallbackImage();
        }
    }

    private Image loadErrorFallbackImage() {
        try {
            return new Image(0, 0);
        } catch(SlickException ex) {
            return null;
        }
    }
}
