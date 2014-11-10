/*
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Heist.
 */

package Chip.Engine;

import Chip.Component.*;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public class Engine {
    /**
     * Attribute player.
     */
    private Player player;
    /**
     * Attribute status.
     */
    private Status status;
    /**
     * Attribute array of walls.
     */
    private Wall[] walls;
    /**
     * Attribute array of obstacles. 
     */
    private Obstacle[] obstacles;
    /**
     * Attribute array of items.
     */
    private Item[] items;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasi semua attribute dalam
     * sebuah engine yang diambil dari class level.
     * @param level Level yang sekarang akan dijalankan engine.
     */
    public Engine(Level level)
    {
        player=new Player(level.getStartingPosition());
        status=new Status(false,false,level.getTime());
        walls=level.getWalls();
        obstacles=level.getObstacles();
        items=level.getItems();
    }
    
    /**
     * (To be writen)
     * @param direction null
     * @return null
     */
    public boolean move(int direction)
    {
    /** if(direction==0)
        {
            for(int i=0;i<walls.length;i++)
            {
                player.getCurPosition().getX()+1==walls[0].
            }
        }
        else if(direction==1)
        {
            
        }
        else if(direction==2)
        {
            
        }
        else if(direction==3)
        {
            
        }
    */
        return false;
    }
}
