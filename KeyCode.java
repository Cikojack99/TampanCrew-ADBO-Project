/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Component.Items;

import java.awt.Point;

/**
 *
 * @author Seto
 */
public class KeyCode extends Item {

    public KeyCode(String type, Point position) {
        super(type, position);
    }

    @Override
    public void effect() {
        take();
    }
    
}
