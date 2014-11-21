/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Component.Obstacles;

import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public abstract class Obstacle {
    protected String antiObstacle;
    protected boolean resInDeath;
    
    public String getAntiObstacle()
    {
        return antiObstacle;
    }
    
    public boolean getResInDeath()
    {
        return resInDeath;
    }
}