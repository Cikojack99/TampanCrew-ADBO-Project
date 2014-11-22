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
    
    public void initializeLevel()
    {
        initializeWalls();
        initializeObstacles();
        initializeItems();
    }
    
    public abstract void initializeWalls();
    
    public abstract void initializeObstacles();
    
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
     * Method ini berfungsi untuk memanggil petaLevel yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array Items.
     */
    public Maps[][] getMaps()
    {
        return petaLevel;
    }
    
    /**
     * menggambar peta bagian rahasia yang muncul bila Wall tertentu ditembus
     */
    public abstract void drawSecret();
    
    /**
     * mendapatkan tinggi dari map level
     * @return tinggi map level
     */
    public abstract int getHeight();
    
    /**
     * mendapatkan lebar dari map level
     * @return lebar dari level
     */
    public abstract int getWidth();
    
    /**
     * mendapatkan isi dari koordinat peta[i][j]
     * @param i koordinat x dari peta
     * @param j koordinat y dari peta
     * @return isi peta[i][j]
     */
    public Maps getContent(int i, int j)
    {
        return petaLevel[i][j];
    }
}
