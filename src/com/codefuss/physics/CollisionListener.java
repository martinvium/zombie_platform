/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss.physics;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface CollisionListener {
    
    public void collideVertical(Body collided);

    public void collideHorizontal(Body collided);
}
