/*
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Heist.
 */

package Chip.Engine;

import Chip.Component.*;
import Chip.Component.Levels.Level;
import Chip.Component.Obstacles.*;
import Chip.Component.Status;
import Chip.Gui.Board;
import javax.swing.JPanel;

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
    
    private Drawer drawer;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasi semua attribute dalam
     * sebuah engine yang diambil dari class level.
     * @param level Level yang sekarang akan dijalankan engine.
     */
    public Engine(Level level, Board board)
    {
        this.board=board;
        player=new Player(level.getStartingPosition());
        status=new Status(level.getTime(),this);
        obstacles=level.getObstacles();
        this.peta = level.getMaps();
        drawer = new Drawer(level, board, player);
    }
    
    public void playerIsDead()
    {
        board.gameOver();
    }
    
    public void displayTimeLeft(int time)
    {
        board.updateTime(time);
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
            drawer.rotateChar("up");
            x=(int)(player.getCurPosition().getX());
            y=(int)(player.getCurPosition().getY()-1);
        }
        else if(direction==1)
        {
            drawer.rotateChar("left");
            x=(int)(player.getCurPosition().getX()-1);
            y=(int)(player.getCurPosition().getY());
        }
        else if(direction==2)
        {
            drawer.rotateChar("down");
            x=(int)(player.getCurPosition().getX());
            y=(int)(player.getCurPosition().getY()+1);
        }
        else if(direction==3)
        {
            drawer.rotateChar("right");
            x=(int)(player.getCurPosition().getX()+1);
            y=(int)(player.getCurPosition().getY());
        }
        if(peta[x][y]!=null)
        {
            if(peta[x][y].getType().contains("wallDoang"))
            {
                wallCondition(x,y);
            } 
            else if(peta[x][y].getType().contains("invisible"))
            {
                drawer.drawSecret();
            }
            else if(peta[x][y].getType().contains("item"))
            {
                itemCondition(x,y);
                
            }
            else if(peta[x][y].getType().contains("obstacle"))
            {
                obstaclesCondition(x,y);
            }
        } else {
            player.move(x, y);
        }
    }
    
    public void wallCondition(int x, int y)
    {
        status.timePenalty(2);
    }
    
    public void itemCondition(int x, int y)
    {
        player.move(x,y);
        //Ini kan si player bergerak, jadi gerakin animasi dan visualnya serta ilangin item yang ada di 
        //x,y.
        player.takeItem(peta[x][y].getTypeKind());
        peta[x][y]=null;
        drawer.drawDeletedItem(x, y);
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
                    //ini kan si player bergerak dan karena dia udah punya anti obstacles, untuk saat ini
                    //ga usah diilangin dulu obstacles nya dehh.
                    player.move(x,y);
                }
                else
                {
                    if(obstacles[typeKind].getResInDeath()==true) {
                        player.move(x,y);
                        playerIsDead();
                    }
                    else if(obstacles[typeKind].getResInDeath()==false)
                    {
                        status.timePenalty(4);
                    }
                }
    }
}