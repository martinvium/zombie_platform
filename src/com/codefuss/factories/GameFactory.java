/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.factories;

import com.codefuss.Camera;
import com.codefuss.GameMap;
import com.codefuss.InputManager;
import com.codefuss.actions.NullAction;
import java.awt.Color;
import java.util.Properties;
import org.newdawn.slick.Font;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class GameFactory {
    Properties properties;
    UnicodeFont labelFont;
    EntityFactory entityFactory;
    GameMap gameMap;
    InputManager inputManager;
    AnimationFactory spriteFactory;
    PhysicsFactory physicsFactory;
    BehaviourFactory behaviourFactory;
    AmmoFactory ammoFactory;
    Camera camera;
    ComponentFactory componentFactory;

    Input input;

    public GameFactory(Properties properties, Input input) {
        this.properties = properties;
        this.input = input;
    }

    public PhysicsFactory getPhysicsFactory() {
        if(physicsFactory == null) {
            physicsFactory = new PhysicsFactory(new Vector2f(0.0f, 0.003f));
        }

        return physicsFactory;
    }

    public AnimationFactory getSpriteFactory() {
        if(spriteFactory == null) {
            spriteFactory = new AnimationFactory();
        }
        return spriteFactory;
    }

    public InputManager getInputManager() {
        if(inputManager == null) {
            inputManager = new InputManager(input);
            inputManager.setDefaultAction(new NullAction());
        }
        return inputManager;
    }

    public EntityFactory getEntityFactory() {
        if(entityFactory == null) {
            entityFactory = new EntityFactory(getSpriteFactory(), getPhysicsFactory(), getBehaviourFactory(), getAmmoFactory(), getComponentFactory());
        }
        return entityFactory;
    }

    public AmmoFactory getAmmoFactory() {
        if(ammoFactory == null) {
            ammoFactory = new AmmoFactory(getSpriteFactory(), getPhysicsFactory());
        }
        return ammoFactory;
    }

    public GameMap getMap() {
        if(gameMap == null) {
            String ref = properties.getProperty("MAP_FILE");
            try {
                gameMap = new GameMap(getEntityFactory(), ref);
            } catch(SlickException ex) {
                throw new RuntimeException("failed to load map: " + ref + ", msg: " + ex.getMessage());
            }
        }
        return gameMap;
    }

    public Font getLabelFont() {
        if(labelFont == null) {
            try {
                labelFont = new UnicodeFont(properties.getProperty("LABEL_FONT_FILE"), 10, false, false);
                labelFont.addAsciiGlyphs();
                labelFont.getEffects().add(new ColorEffect(Color.white));
                labelFont.loadGlyphs();
            } catch(SlickException ex) {
                throw new RuntimeException(ex);
            }
        }

        return labelFont;
    }

    public BehaviourFactory getBehaviourFactory() {
        if(behaviourFactory == null) {
            behaviourFactory = new BehaviourFactory();
        }

        return behaviourFactory;
    }

    public Camera getCamera() {
        if(camera == null) {
            camera = new Camera(getMap());
        }

        return camera;
    }

    public ComponentFactory getComponentFactory() {
        if(componentFactory == null) {
            componentFactory = new ComponentFactory();
        }

        return componentFactory;
    }
}
