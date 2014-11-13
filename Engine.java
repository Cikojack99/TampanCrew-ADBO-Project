/*
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Heist.
 */

package Chip.Engine;

import Chip.Component.*;
import Chip.Gui.Board;
import java.awt.Point;

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
    
    private Board board;
    
    
//    private Wall[] walls;
//    /**
//     * Attribute array of obstacles. 
//     */
//    private Obstacle[] obstacles; 
//   /**
//     * Attribute array of items.
//     */
//    private Item[] items;
    
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
//        walls=level.getWalls();
//        obstacles=level.getObstacles();
//        items=level.getItems();
        this.peta = level.getMaps();
    }
    
    /**
     * (To be writen)
     * @param direction null
     * @return null
     */
    public boolean checkLegalMove(int direction)
    {
        
        //atas
        Wall wallTemplate = new Wall(false, new Point(0, 0));
        int x = Integer.parseInt(Double.toString(player.getCurPosition().getX()));
        int y = Integer.parseInt(Double.toString(player.getCurPosition().getY()));
        
            if(peta[x][y].getClass()== wallTemplate.getClass())  //<-edit yah...
            {
                wallTemplate = (Wall)peta[x][y];
                if(wallTemplate.checkMoveable()==false)
                {
                    status.timePenalty(4);
                } else {
//                    board.drawSecret();
                    peta[x][y].getClass().getSuperclass();
                }
            }
            
            
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
