package com.codefuss;

import com.codefuss.factories.EntityFactory;
import com.codefuss.entities.Entity;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public final class GameMap implements TileBasedMap {

    TiledMap tiledMap;
    EntityFactory entityFactory;

    public GameMap(EntityFactory entityFactory, String ref) throws SlickException {
        tiledMap = new TiledMap(ref);
        this.entityFactory = entityFactory;
    }

    /**
     * Remove two from each axis of collision entity to avoid border collisions
     * @param entityFactory
     */
    public void initBlockEntities(ArrayList<Entity> entities) {
        int layerIndex = tiledMap.getLayerIndex("collision");
        for (int x = 0; x < tiledMap.getWidth(); x++) {
            for (int y = 0; y < tiledMap.getHeight(); y++) {
                int tileId = tiledMap.getTileId(x, y, layerIndex);
                if (tileId > 0) {
                    Vector2f position = new Vector2f(x * tiledMap.getTileWidth(), y * tiledMap.getTileHeight());
                    Entity entity = entityFactory.getBlocker(position, tiledMap.getTileWidth(), tiledMap.getTileHeight());
                    entities.add(entity);
                }
            }
        }
    }

    public void initCreatureEntities(ArrayList<Entity> entities) {
        for (int gid = 0; gid < tiledMap.getObjectGroupCount(); gid++) {
            for (int oid = 0; oid < tiledMap.getObjectCount(gid); oid++) {
                String type = tiledMap.getObjectType(gid, oid);
                Vector2f position = new Vector2f(tiledMap.getObjectX(gid, oid), tiledMap.getObjectY(gid, oid));
                Entity entity = entityFactory.getEntity(type,
                        tiledMap.getObjectName(gid, oid),
                        position);
                entities.add(entity);
            }
        }
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public void render(float x, float y) {
        tiledMap.render((int) x, (int) y);
    }

    @Override
    public int getWidthInTiles() {
        return tiledMap.getWidth();
    }

    @Override
    public int getHeightInTiles() {
        return tiledMap.getHeight();
    }

    public int getWidth() {
        return getWidthInTiles() * tiledMap.getTileWidth();
    }

    public int getHeight() {
        return getHeightInTiles() * tiledMap.getTileHeight();
    }

    @Override
    public void pathFinderVisited(int x, int y) {
    }

    @Override
    public boolean blocked(PathFindingContext context, int tx, int ty) {
        return true;
    }

    @Override
    public float getCost(PathFindingContext context, int tx, int ty) {
        return 1;
    }
}
