package com.codefuss;


import com.codefuss.actions.Action;
import com.codefuss.factories.GameFactory;
import com.codefuss.entities.Entity;
import com.codefuss.actions.Attack;
import com.codefuss.actions.Jump;
import com.codefuss.actions.MoveLeft;
import com.codefuss.actions.MoveRight;
import com.codefuss.actions.ShowPhysicShapes;
import com.codefuss.entities.Creature;
import com.codefuss.entities.Player;
import com.codefuss.entities.Sprite;
import com.codefuss.physics.Body;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;

import java.util.ArrayList;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class GameState extends BasicGameState {

    static public final int ID = 1;
    static final int PLAYER_WIDTH = 128;
    
    GameFactory gameFactory;
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Player player;
    float offsetX = 0;
    Body ground;

    @Override
    public int getID() {
        return ID;
    }

    public Creature getPlayer() {
        return player;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        gameFactory = new GameFactory(Game.getProperties(), container.getInput());

        gameFactory.getMap().initBlockEntities(entities);
        gameFactory.getMap().initCreatureEntities(entities);

        initPlayer();

        gameFactory.getInputManager().mapToKey(new ShowPhysicShapes(gameFactory.getPhysicsFactory().getWorld()), Input.KEY_P);

        container.setMaximumLogicUpdateInterval(100);
        container.setDefaultFont(gameFactory.getLabelFont());
    }

    void initPlayer() {
        player = gameFactory.getEntityFactory().getPlayer(new Vector2f(0, 0));
        gameFactory.getInputManager().mapToKey(new Attack(player), Input.KEY_SPACE);
        gameFactory.getInputManager().mapToKey(new MoveLeft(player), Input.KEY_LEFT);
        gameFactory.getInputManager().mapToKey(new MoveRight(player), Input.KEY_RIGHT);
        gameFactory.getInputManager().mapToKey(new Jump(player), Input.KEY_UP);
        entities.add(player);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        // run action and apply any resulting entities to stack
        for(Action action : gameFactory.getInputManager().getActions(delta)) {
            entities.addAll(action.invoke());
        }

        // update all entities
        ArrayList<Entity> newEntities = new ArrayList<Entity>();
        ArrayList<Entity> toBeRemoved = new ArrayList<Entity>();
        for(Entity e : entities) {
            e.update(container, game, delta);

            if(e instanceof Sprite) {
                Sprite sprite = (Sprite) e;
                Action nextAction = sprite.getNextAction(player);
                if(nextAction != null) {
                    newEntities.addAll(nextAction.invoke());
                }
            }


            if(e.isRemoved()) {
                toBeRemoved.add(e);
            }
        }

        entities.addAll(newEntities);

        for(Entity e : toBeRemoved) {
            entities.remove(e);
            if(e instanceof Sprite) {
                Sprite sprite = (Sprite) e;
                gameFactory.getPhysicsFactory().getWorld().remove(sprite.getBody());
            }
        }

        gameFactory.getPhysicsFactory().getWorld().update(delta);

        // calculate screen offset
        offsetX = player.getX() - (container.getWidth() / 2) + (player.getWidth() / 2);
        offsetX = getNormalizedOffset(container, offsetX);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        gameFactory.getMap().render(-offsetX, 0);
        for(Entity e : entities) {
            e.render(container, game, g, offsetX);
        }

        gameFactory.getPhysicsFactory().getWorld().render(g, offsetX);
    }

    float getNormalizedOffset(GameContainer container, float offset) {
        if(offset < 0) {
            offset = 0;
        }

        if(offset > gameFactory.getMap().getWidth() - gameFactory.getMap().getTiledMap().getTileWidth() - container.getWidth()) {
            offset = gameFactory.getMap().getWidth() - gameFactory.getMap().getTiledMap().getTileWidth() - container.getWidth();
        }

        return offset;
    }
}