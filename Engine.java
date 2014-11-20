/*
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Heist.
 */

package Chip.Engine;

import Chip.Component.Items.Item;
import Chip.Component.Items.*;
import Chip.Component.Levels.Level;
import Chip.Component.*;
import Chip.Component.Obstacles.*;
import Chip.Gui.Board;
import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 VinS_Alpha_Run
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
    
    private Board board;
    
    
    private Wall[] walls;
    /**
     * Attribute array of obstacles. 
     */
    private Obstacle[] obstacles; 
    /**
     * Attribute array of items.
     */
    private Item[] items;
    
    private Maps peta[][];
    
    /**
     * Constructor ini berfungsi untuk menginisialisasi semua attribute dalam
     * sebuah engine yang diambil dari class level.
     * @param level Level yang sekarang akan dijalankan engine.
     */
    public Engine(Level level, Board board)
    {
        this.board=board;
        player=new Player(level.getStartingPosition());
        status=new Status(false,false,level.getTime());
        walls=level.getWalls();
        obstacles=level.getObstacles();
        items=level.getItems();
        this.peta = level.getMaps();
    }
    
    /**
     * (To be writen)
     * @param direction null
     * @return null
     */
    public void runMovingCondition(int direction)
    {   
        int x=0;
        int y=0;
        if(direction==0)
        {
            x=(int)(player.getCurPosition().getX()+1);
            y=(int)(player.getCurPosition().getY());
        }
        else if(direction==1)
        {
            x=(int)(player.getCurPosition().getX()-1);
            y=(int)(player.getCurPosition().getY());
        }
        else if(direction==2)
        {
            x=(int)(player.getCurPosition().getX());
            y=(int)(player.getCurPosition().getY()-1);
        }
        else if(direction==3)
        {
            x=(int)(player.getCurPosition().getX());
            y=(int)(player.getCurPosition().getY()+1);
        }
        if(peta[x][y]!=null) //keatas
        {
            if(peta[x][y].getType().compareToIgnoreCase("wall")==1)
            {
                for(int i=0;i<walls.length;i++)
                {
                    if((walls[i].getPosition().x==x)&&(walls[i].getPosition().y==y))
                    {
                        if(walls[i].checkMoveable()==false)
                        {
                            status.timePenalty(4);
                        }
                        else
                        {
                            player.move(direction);
                            //board do some secret stuff
                        }
                        i=walls.length;
                    }
                }
            }
            else if(peta[x][y].getType().compareToIgnoreCase("item")==1)
            {
                for(int i=0;i<items.length;i++)
                {
                    if((items[i].getPosition().x==x)&&(items[i].getPosition().y==y))
                    {
                        if(items[i].isTaken()==false)
                        {
                            items[i].effect();
                            player.takeItem(items[i].getType());
                        }
                        i=walls.length;
                    }
                }
            }
            else if(peta[x][y].getType().compareToIgnoreCase("obstacle")==1)
            {
                for(int i=0;i<obstacles.length;i++)
                {
                    if((obstacles[i].getPosition().x==x)&&(obstacles[i].getPosition().y==y))
                    {
                        if(player.checkInventory(obstacles[i].getAntiObstacle())==true)
                        {
                            player.move(direction);
                        }
                        else
                        {
                            player.move(direction);
                            status.playerIsDead();
                            //do some board things here
                        }
                    }
                }
            }
        }
    }
}