/*
 * Class ini berfungsi sebagai template untuk menginisialisasi sebuah level, class
 * ini akan memiliki banyak inheritance yang berupa level 1,2,3 dan seterusnya.
 */

package Chip.Component.Levels;

import Chip.Component.*;
import Chip.Component.Items.*;
import Chip.Component.Obstacles.*;
import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.02 ALPHA
 */
public abstract class Level {

    /**
     * Seluruh kordinat dari object di level.
     */
    protected Maps petaLevel[][];
    
    /**
     * Batasan waktu dalam sebuah level.
     */
    protected int time;
    
    /**
     * Posisi awal player dalam sebuah level.
     */
    protected Point playerStartingPosition;
    
    /**
     * Seluruh array dari Items yang ada di level.
     */
    protected Item items[];
    
    /**
     * Seluruh array dari Obstacles yang ada di level.
     */
    protected Obstacle obstacles[];
    
    /**
     * Seluruh array dari Walls yang ada di level.
     */
    //protected Wall walls[];
            
    /**
     * Constructor ini berfungsi untuk menginisialisasi batasan waktu dan posisi 
     * player dalam sebuah level.
     * @param time Batasan waktu sebuah level.
     * @param playerStartingPosition Posisi awal player pada sebuah level.
     */
    public Level()
    {
        this.time=time;
        this.playerStartingPosition=playerStartingPosition;
    }

    /**
     * 
     */
    public abstract void initializeWalls();
    
    public abstract void initializeObstacles();
    
    public abstract void initializeItems();
    
    /**
     * Method abstract ini berfungsi untuk menginisialisasi semua hal yang ada
     * di sebuah level yang akan diisi oleh inheritance dari class level ini.
     */
    public abstract void initializeMaps();
    
    /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return batasan waktu dari level.
     */
    public int getTime()
    {
        return time;
    }
    
    /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Posisi awal seorang player.
     */
    public Point getStartingPosition()
    {
        return playerStartingPosition;
    }
    
    /**
     * Method ini berfungsi untuk memanggil sebuah array Obstacle yang akan
     * digunakan oleh class Board dan Engine.
     * @return Array Obstacles.
     */
    public Obstacle[] getObstacles()
    {
        return obstacles;
    }
    
    /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array Walls.
     */
    public Wall[] getWalls()
    {
        return walls;
    }
    
    /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array Items.
     */
    public Item[] getItems()
    {
        return items;
    }
    
    /**
     * Method ini berfungsi untuk memanggil petaLevel yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array Items.
     */
    public Maps[][] getMaps()
    {
        return petaLevel;
    }
    
    public abstract void drawSecret();
}