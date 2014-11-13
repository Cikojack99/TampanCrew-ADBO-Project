/*
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Heist.
 */

package Chip.Engine;

import Chip.Component.*;
import Chip.Component.Items.EMP;
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
    public void checkLegalMove(int direction)
    {
        
        //ATAS BAWAH KIRI KANANNYA ATUR NDIRI SET HAHAHAHHA
        Wall wallTemplate = new Wall(false, new Point(0, 0));
        Obstacle obs = new Laser();
        Item item = new EMP(null, null);
        
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
                    this.player.move(0);
                }
            } else if(peta[x][y].getClass().getSuperclass()== obs.getClass().getSuperclass()) //ini obstacle
            {
                //cek moveable(inventori player)
                //buat cek ada item buat matiin ato ga
            } else if(peta[x][y].getClass().getSuperclass()== item.getClass().getSuperclass()) //ini item
            {
                //ambil item
                //delete kordinat
            }
            
            
//        return false;
    }
}
