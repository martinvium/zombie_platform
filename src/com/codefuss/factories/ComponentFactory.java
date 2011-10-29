/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.factories;

import com.codefuss.components.HealthBar;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class ComponentFactory {
    public HealthBar getHealthBar() {
        try {
            return new HealthBar(new Image("assets/other/healthbar/remaining.png"),
                new Image("assets/other/healthbar/lost.png"));
        } catch(SlickException ex) {
            Log.error("failed to load healthbar: " + ex.getMessage());
            return null;
        }
    }
}
