/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.entities.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Camera {

    Vector2f position = new Vector2f();
    Sprite lookAt;
    GameMap map;

    public Camera(GameMap map) {
        this.map = map;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void lookAt(Sprite sprite) {
        lookAt = sprite;
    }

    public void update(GameContainer container) {
        position.x = lookAt.getX() - (container.getWidth() / 2) + (lookAt.getWidth() / 2);
        position.x = getNormalized(position.x, container.getWidth(), map.getWidth(), map.getTiledMap().getTileWidth());

        position.y = lookAt.getY() - (container.getHeight() / 2) + (lookAt.getHeight() / 2);
        position.y = getNormalized(position.y, container.getHeight(), map.getHeight(), map.getTiledMap().getTileHeight());
    }

    float getNormalized(float offset, int cameraSize, int mapSize, int tileSize) {
        if(offset < 0) {
            offset = 0;
        }

        if(offset > mapSize - tileSize - cameraSize) {
            offset = mapSize - tileSize - cameraSize;
        }

        return offset;
    }
}
