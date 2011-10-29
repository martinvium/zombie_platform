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
import java.util.Iterator;
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
        gameFactory.getCamera().lookAt(player);

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
        // get user input and apply actions accordingly
        for(Action action : gameFactory.getInputManager().getActions(delta)) {
            entities.addAll(action.invoke());
        }

        // update all entities
        ArrayList<Entity> newEntities = new ArrayList<Entity>();
        Iterator<Entity> itr = entities.iterator();
        while(itr.hasNext()) {
            Entity e = itr.next();
            if(e.isRemoved()) {
                itr.remove();
                continue;
            }

            e.update(container, game, delta);

            if(e instanceof Sprite) {
                Sprite sprite = (Sprite) e;
                Action nextAction = sprite.getNextAction(player);
                if(nextAction != null) {
                    newEntities.addAll(nextAction.invoke());
                }
            }
        }
        entities.addAll(newEntities);

        gameFactory.getPhysicsFactory().getWorld().update(delta);
        gameFactory.getCamera().update(container);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Camera camera = gameFactory.getCamera();

        gameFactory.getMap().render(-camera.getX(), -camera.getY());
        for(Entity e : entities) {
            e.render(container, game, g, camera);
        }

        gameFactory.getPhysicsFactory().getWorld().render(g, camera);
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