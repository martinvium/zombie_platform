/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

import com.codefuss.actions.Action;
import java.util.HashMap;
import org.newdawn.slick.Input;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class InputManager {

    Input input;

    HashMap<Integer, Action> keyActions = new HashMap<Integer, Action>();
    
    public InputManager(Input input) {
        this.input = input;
    }

    public void mapToKey(Action action, int keyCode) {
        keyActions.put(keyCode, action);
    }

    public void poll()
	{
        for(int keyCode : keyActions.keySet()) {
            if(keyActions.containsKey(keyCode)) {
                keyActions.get(keyCode).invoke();
            }
        }
	}
}
