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
        status=new Status(level.getTime());
        obstacles=level.getObstacles();
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
                wallCondition(x,y);
            }
            else if(peta[x][y].getType().compareToIgnoreCase("item")==1)
            {
                itemCondition(x,y);
            }
            else if(peta[x][y].getType().compareToIgnoreCase("obstacle")==1)
            {
                obstaclesCondition(x,y);
            }
        }
    }
    
    public void wallCondition(int x, int y)
    {
        status.timePenalty(4);
    }
    
    public void itemCondition(int x, int y)
    {
        player.move(x,y);
        player.takeItem(peta[x][y].getTypeKind());
        peta[x][y]=null;
    }
    
    public void obstaclesCondition(int x,int y)
    {
         int typeKind=0;
                if(peta[x][y].getTypeKind().compareToIgnoreCase("brownDoor")==1)
                {
                    typeKind=0;
                }
                else if(peta[x][y].getTypeKind().compareToIgnoreCase("silverDoor")==1)
                {
                    typeKind=1;
                }
                else if(peta[x][y].getTypeKind().compareToIgnoreCase("greenDoor")==1)
                {
                    typeKind=2;
                }
                else if(peta[x][y].getTypeKind().compareToIgnoreCase("laser")==1)
                {
                    typeKind=3;
                }
                else if(peta[x][y].getTypeKind().compareToIgnoreCase("sleepingGuardRadius")==1)
                {
                    typeKind=4;
                }
                else if(peta[x][y].getTypeKind().compareToIgnoreCase("finishLineDoor")==1)
                {
                    typeKind=5;
                }
                if(player.checkInventory(obstacles[typeKind].getAntiObstacle())==true)
                {
                    player.move(x,y);
                }
                else
                {
                    if(obstacles[typeKind].getResInDeath()==true) {
                        player.move(x,y);
                        status.playerIsDead();
                        //do some board things here
                    }
                    else if(obstacles[typeKind].getResInDeath()==false)
                    {
                        status.timePenalty(4);
                    }
                }
    }
        
}