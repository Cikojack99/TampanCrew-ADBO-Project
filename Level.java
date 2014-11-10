/*
 */*
 * Class ini berfungsi sebagai template untuk menginisialisasi sebuah level, class
 * ini akan memiliki banyak inheritance yang berupa level 1,2,3 dan seterusnya.
 */

package Chip.Component;

import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public abstract class Level {
    /**
     * Wall-wall dalam sebuah level.
     */
    protected Wall[] walls;
    /**
     * Obstacle-obstacle dalam sebuah level.
     */
    protected Obstacle[] obstacles;
    /**
     * Item-item dalam sebuah level.
     */
    protected Item[] items;
    /**
     * Batasan waktu dalam sebuah level.
     */
    protected int time;
    /**
     * Posisi awal player dalam sebuah level.
     */
    protected Point playerStartingPosition;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasi batasan waktu dan posisi 
     * player dalam sebuah level.
     * @param time Batasan waktu sebuah level.
     * @param playerStartingPosition Posisi awal player pada sebuah level.
     */
    public Level(int time,Point playerStartingPosition)
    {
        this.time=time;
        this.playerStartingPosition=playerStartingPosition;
    }
    
    /**
     * Method abstract ini berfungsi untuk menginisialisasi semua wall yang ada 
     * di sebuah level yang akan diisi oleh inheritance dari class level ini.
     */
    public abstract void initializeWalls();
    
    /**
     * Method abstract ini berfungsi untuk menginisialisasi semua obstacles yang
     * ada di sebuah level yang akan diisi oleh inheritance dari class level ini.
     */
    public abstract void initializeObstacles();
    
    /**
     * Method abstract ini berfungsi untuk menginisialisasi semua items yang ada
     * di sebuah level yang akan diisi oleh inheritance dari class level ini.
     */
    public abstract void initializeItems();
    
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
     * Method ini berfungsi untuk memanggil attribute playerStartingPosition yang akan digunakan 
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
     * Method ini berfungsi untuk memanggil sebuah array Wall yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array Walls.
     */
    public Wall[] getWalls()
    {
        return walls;
    }
    
    /**
     * Method ini berfungsi untuk memanggil sebuah array Item yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array Items.
     */
    public Item[] getItems()
    {
        return items;
    }
}
