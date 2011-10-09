package com.codefuss;


import com.codefuss.actions.MoveLeft;
import com.codefuss.actions.MoveRight;
import com.codefuss.entities.Player;
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
    
    GameFactory gameFactory;
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Player player;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        gameFactory = new GameFactory(Game.getProperties(), container.getInput());
        gameFactory.getMap().initBlockEntities(entities);
        gameFactory.getMap().initCreatureEntities(entities);

        initPlayer();

        container.setMaximumLogicUpdateInterval(100);
        container.setDefaultFont(gameFactory.getLabelFont());
    }

    void initPlayer() {
        player = gameFactory.getEntityFactory().getPlayer(new Vector2f(0, 0));
        gameFactory.getInputManager().mapToKey(new MoveLeft(player.getSprite()), Input.KEY_LEFT);
        gameFactory.getInputManager().mapToKey(new MoveRight(player.getSprite()), Input.KEY_RIGHT);
        entities.add(player);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        gameFactory.getInputManager().poll();
        for(Entity e : entities) {
            e.update(container, game, delta);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        gameFactory.getMap().render();
        for(Entity e : entities) {
            e.render(container, game, g);
        }
    }
}