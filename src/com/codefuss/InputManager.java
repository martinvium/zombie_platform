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
    Action defaultAction;
    
    public InputManager(Input input) {
        this.input = input;
    }

    public void setDefaultAction(Action action) {
        defaultAction = action;
    }

    public void mapToKey(Action action, int keyCode) {
        keyActions.put(keyCode, action);
    }

    public Action getAction()
	{
        for(int keyCode : keyActions.keySet()) {
            if(input.isKeyDown(keyCode)) {
                return keyActions.get(keyCode);
            }
        }

        return defaultAction;
	}
}
