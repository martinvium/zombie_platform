package com.codefuss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Game extends StateBasedGame {

    static String title = "Slick RPG";
    static Properties props;

    public Game(String title) {
        super(title);
    }

    public static Properties getProperties() {
        if (props == null) {
            props = loadProperties("config.properties");
        }
        return props;
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new GameState());
    }

    static Properties loadProperties(String path) {
        Properties myProps = new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            myProps.load(stream);
        } catch(FileNotFoundException ex) {
            throw new RuntimeException("config file missing at: " + path, ex);
        } catch(IOException ex) {
            throw new RuntimeException("failed to load config: " + path, ex);
        }
        return myProps;
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game(title));
        app.setDisplayMode(Integer.parseInt(getProperties().getProperty("SCREEN_X")),
                Integer.parseInt(getProperties().getProperty("SCREEN_Y")),
                Boolean.parseBoolean(getProperties().getProperty("SCREEN_FULL")));
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(Integer.parseInt(getProperties().getProperty("FPS_LIMIT")));
        app.setShowFPS(Boolean.parseBoolean(getProperties().getProperty("FPS_SHOW")));
        app.start();
    }
}