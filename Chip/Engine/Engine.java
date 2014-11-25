/*
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Heist.
 */

package Chip.Engine;

import Chip.Component.*;
import Chip.Component.Levels.Level;
import Chip.Component.Obstacles.*;
import Chip.Component.Status;
import Chip.Gui.Board;

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
     * Attribute board.
     */
    private Board board;
    /**
     * Attribute array of obstacles. 
     */
    private Obstacle[] obstacles; 
    
    /**
     * Attribute 2 array dari Maps.
     */
    private Maps peta[][];
    
    /**
     * Attribute drawer.
     */
    private Drawer drawer;
    
    Level stage;
    /**
     * Constructor ini berfungsi untuk menginisialisasi semua attribute dalam
     * sebuah engine yang diambil dari class level.
     * @param level Level yang sekarang akan dijalankan engine.
     */
     public Engine(Level level, Board board)
    {
        stage=level;
        player=new Player(level.getStartingPosition(), level.getSumOfDiamond());
        drawer = new Drawer(level, board, player);
        this.board=board;
        status=new Status(level.getTime(),this);
        obstacles=level.getObstacles();
        this.peta = level.getMaps();
    }
     
    public void updateEngine(Level level)
    {
        player.setPosition(level.getStartingPosition());
        status.statusReset();
        obstacles=level.getObstacles();
        drawer.updateDrawer(level, player);
        this.peta = level.getMaps();
    }
    
    /**
     * Memberitahu board bahwa player sudah mati, agar board bisa menampilkan kolom gameOver.
     */
    public void playerIsDead()
    {
        board.gameOver();
    }
    
    /**
     * Memberitahu board berapa time yang status punya pada saat ini, agar board bisa menupdate timenya.
     * @param time 
     */
    public void displayTimeLeft(int time)
    {
        board.updateTime(time);
    }

    /**
     * Menentukan kondisi yang dialamin player pada saat dia bergerak, tergantung apa yang ada diarah
     * gerakannya.
     * @param direction direction yang diambil player yang sudah di translate menjadi String yang simpel,
     * 0=Up, 1=left, 2=down, 3=right.
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
            if(peta[x][y].getTypeKind().contains("wallDoang"))
            {
                wallCondition(x,y);
            } 
            else if(peta[x][y].getTypeKind().contains("invisible"))
            {
                stage.drawSecret(x, y);
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
        } 
        else 
        {
            player.move(x, y);
        }
    }
    
    /**
     * Method yang dijalankan oleh runMovingCondition dan tidak bisa dijalankan oleh method lain, berfungsi
     * untuk memanggil suara ketika menabrak tembok. (To be implemented)
     * @param x Koordinat x posisi potensi player.
     * @param y Koordinat y posisi potensi player.
     */
    public void wallCondition(int x, int y)
    {
       //suara kalau sempet.
    }
    
    /**
     * Method yang dijalankan oleh runMovingCondition dan tidak bisa dijalankan oleh method lain, berfungsi
     * untuk memanggil suara(To be implemented), pergerakan player dan pengambilan item, dan pendeletetan item.
     * @param x Koordinat x posisi potensi player.
     * @param y Koordinat y posisi potensi player.
     */
    public void itemCondition(int x, int y)
    {
        player.move(x,y);
        player.takeItem(peta[x][y].getTypeKind());
        peta[x][y]=null;
        drawer.drawDeletedItem(x, y);
    }
    
    /**
     * Method yang dijalankan oleh runMovingCondition dan tidak bisa dijalankan oleh method lain, berfungsi
     * untuk memanggil suara ketika menabrak obstacles, pergerakan player jika punya item yang merupakan
     * antiObstaclesnya, dan pemanggil playerIsDead jika player menabrak obstacle yang resInDeath=true.
     * @param x Koordinat x posisi potensi player.
     * @param y Koordinat y posisi potensi player.
     */
    public void obstaclesCondition(int x,int y)
    {
        int typeKind=0;
        if(peta[x][y].getTypeKind().contains("brownDoor"))
        {
            typeKind=0;
        }
        else if(peta[x][y].getTypeKind().contains("silverDoor"))
        {
            typeKind=1;
        }
        else if(peta[x][y].getTypeKind().contains("greenDoor"))
        {
            typeKind=2;
        }
        else if(peta[x][y].getTypeKind().contains("laser"))
        {
            typeKind=3;
        }
        else if(peta[x][y].getTypeKind().contains("sleepingGuardRadius"))
        {
            typeKind=4;
        }
        else if(peta[x][y].getTypeKind().contains("FinishLineDoor"))
        {
            if(player.diamondReqChecker()==true)
                    {
                        board.setGameFrameVisible(false);
                        board.setVictoryFieldVisible(true);
                        player.move(x,y);
                        //display v sign
                    }
        }
        
        
        if(player.checkInventory(obstacles[typeKind].getAntiObstacle())==true)
        {
            player.move(x,y);
        }
        else
        {
            if(obstacles[typeKind].getResInDeath()==true) {
                player.move(x,y);
                playerIsDead();
            }
        }
    }
}