/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Component;

import java.awt.Point;

/**
 *
 * @author Seto
 */
public abstract class Level {
    protected Wall[] walls;
    protected Obstacle[] obstacles;
    protected Item[] items;
    protected int time;
    protected Point playerStartingPosition;
    
    public Level(int time,Point playerStartingPosition)
    {
        this.time=time;
        this.playerStartingPosition=playerStartingPosition;
    }
    
    public abstract void initializeWalls();
    
    public abstract void initializeObstacles();
    
    public abstract void initializeItems();
    
    public int getTime()
    {
        return time;
    }
    
    public Point getStartingPosition()
    {
        return playerStartingPosition;
    }
    
    public Obstacle[] getObstacles()
    {
        return obstacles;
    }
    
    public Wall[] getWalls()
    {
        return walls;
    }
    
    public Item[] getItems()
    {
        return items;
    }
}
