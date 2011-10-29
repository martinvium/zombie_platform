package com.codefuss.components;

import com.codefuss.Camera;
import com.codefuss.entities.Sprite;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.util.Log;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class HealthBar {

    private final static int WIDTH_FACTOR = 3;
    Image current;
    Image lost;
    int currentWidth;
    int lostWidth;
    private boolean visible = false;
    private Vector2f position = new Vector2f(0, 0);

    public HealthBar(Image current, Image lost) {
        this.current = current;
        this.lost = lost;
    }

    public void update(Sprite entity) {
        if(entity.getHealth() <= 0) {
            visible = false;
            return;
        }

        currentWidth = entity.getHealth() * WIDTH_FACTOR;
        lostWidth = (entity.getMaxHealth() - entity.getHealth()) * WIDTH_FACTOR;
        position.x = entity.getCenterX() - (currentWidth + lostWidth) / 2;
        position.y = entity.getY();
        visible = true; //(entity.getHealth() < entity.getMaxHealth());
    }

    public void render(Camera camera) {
        if(visible) {
            current.draw(position.x - camera.getX(), position.y - camera.getY(), currentWidth, current.getHeight());
            lost.draw(position.x - camera.getX() + currentWidth, position.y - camera.getY(), lostWidth, lost.getHeight());
        }
    }
}
