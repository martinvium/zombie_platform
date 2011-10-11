/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codefuss;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Camera {
    float x;
    float y;

    public void lookAt(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
