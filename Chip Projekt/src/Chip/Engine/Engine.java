package Chip.Engine;

import Chip.Component.*;
import Chip.Component.Levels.Level;
import Chip.Component.Obstacles.*;
import Chip.Component.Status;
import Chip.Gui.Board;

/**
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Maling Challenge.
 * @author TampanCrew arts (Harseto and Alvin)
 * @version 1.0 Early Access
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
    
    /**
     * Attribute level yang akan dipakai dalam permainan ini
     */
    private Level stage;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasi semua attribute dalam
     * sebuah engine yang diambil dari class level.
     * @param level Level yang sekarang akan dijalankan engine.
     * @param board gui yang digunakan
     */
    public Engine(Level level, Board board)
    {
        stage=level;
        player=new Player(level.getStartingPosition(), level.getSumOfDiamond(),this);
        drawer = new Drawer(level, board, player);
        this.board=board;
        status=new Status(level.getTime(),this);
        obstacles=level.getObstacles();
        this.peta = level.getMaps();
        updateTotalDiamond(level.getSumOfDiamond());
    }
    
    /**
     * method ini adalah semi-constructor
     * dipisahkan dari constructor untuk menghindari terjadinya double engine
     * bila dibuat new Drawer9)
     * @param level level baru yang akan dijalankan
     */
    public void updateNewEngine(Level level)
    {
        this.stage = level;
        this.peta = level.getMaps();
        this.player.updatePlayer(level.getStartingPosition().x, level.getStartingPosition().y, level.getSumOfDiamond());
        this.drawer.repaint();
        this.status.statusReset();
        this.obstacles=level.getObstacles();
        this.drawer.updateDrawer(stage, player);
        updateTotalDiamond(level.getSumOfDiamond());
    }
    /**
     * Memberitahu board bahwa player sudah mati, agar board bisa menampilkan kolom gameOver.
     */
    public void playerIsDead()
    {
        this.board.gameOver();
    }
    
    /**
     * Memberitahu board berapa time yang status punya pada saat ini, agar board bisa menupdate timenya.
     * @param time sisa waktu
     */
    public void displayTimeLeft(int time)
    {
        this.board.updateTime(time);
    }
    
    /**
     * Memberitahu board berapa diamond yang perlu diambil player pada saat ini, agar board bisa menupdatenya
     * @param diamonds Jumlah diamond yang dibutuhkan.
     */
    public void updateTotalDiamond(int diamonds)
    {
        board.updateDiamondLeft(diamonds);
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
            this.drawer.rotateChar("up");
            x=(int)(this.player.getCurPosition().getX());
            y=(int)(this.player.getCurPosition().getY()-1);
        }
        else if(direction==1)
        {
            this.drawer.rotateChar("left");
            x=(int)(this.player.getCurPosition().getX()-1);
            y=(int)(this.player.getCurPosition().getY());
        }
        else if(direction==2)
        {
            this.drawer.rotateChar("down");
            x=(int)(this.player.getCurPosition().getX());
            y=(int)(this.player.getCurPosition().getY()+1);
        }
        else if(direction==3)
        {
            this.drawer.rotateChar("right");
            x=(int)(this.player.getCurPosition().getX()+1);
            y=(int)(this.player.getCurPosition().getY());
        }
        if(this.peta[x][y]!=null)
        {
            if(this.peta[x][y].getTypeKind().contains("invisible"))
            {
                this.stage.drawSecret(x, y);
                this.drawer.drawSecret();
            }
            else if(this.peta[x][y].getType().contains("item"))
            {
                this.itemCondition(x,y);
                
            }
            else if(this.peta[x][y].getType().contains("obstacle"))
            {
                this.obstaclesCondition(x,y);
            }
        } 
        else 
        {
            this.player.move(x, y);
        }
    }
    
    /**
     * Method yang dijalankan oleh runMovingCondition dan tidak bisa dijalankan oleh method lain, berfungsi
     * untuk memanggil suara(To be implemented), pergerakan player dan pengambilan item, dan pendeletetan item.
     * @param x Koordinat x posisi potensi player.
     * @param y Koordinat y posisi potensi player.
     */
    public void itemCondition(int x, int y)
    {
        this.player.move(x,y);
        this.player.takeItem(this.peta[x][y].getTypeKind());
        this.peta[x][y]=null;
        this.drawer.drawDeletedItem(x, y);
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
        for(int i=0;i<obstacles.length;i++)
        {
            if(obstacles[i].getObstacleName().contains(peta[x][y].getTypeKind()))
            {
                typeKind=i;
            }
        }
        if(peta[x][y].getTypeKind().contains("FinishLineDoor"))
        {
            if(player.diamondReqChecker()==true)
            {
                board.setGameFrameVisible(false);
                board.setVictoryFieldVisible(true);
                player.move(x,y);
            }
        }      
        else if(player.checkInventory(obstacles[typeKind].getAntiObstacle())==true)
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