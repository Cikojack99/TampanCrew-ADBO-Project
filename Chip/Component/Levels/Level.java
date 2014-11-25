package Chip.Component.Levels;

import Chip.Component.*;
import Chip.Component.Obstacles.*;
import java.awt.Point;

/**
 * Class ini berfungsi sebagai template untuk menginisialisasi time, playerStartingPosition, dan petaLevel
 * yang berisi koordinat, fungsi Maps bisa diliat di javadocs Maps. Kelas ini akan memiliki banyak 
 * inheritance yang berupa level 1,2,3 dan seterusnya.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public abstract class Level {

    /**
     * Array 2 dimensi yang mensimulisasikan sebuah Maps dengan koordinat x dan y, more information in Maps
     * javadocs.
     */
    protected Maps petaLevel[][];
    
    /**
     * Batasan waktu dalam sebuah level, more information in time javadocs in Status class.
     */
    protected int time;
    
    /**
     * Posisi awal player dalam sebuah level, akan dipakai didalam constructor player.
     */
    protected Point playerStartingPosition;

    /**
     * Seluruh array dari Obstacles yang ada di level yang terdiri dari semua turunan kelas Obstacle.
     */
    protected Obstacle obstacles[];
    
    /**
     * Jumlah level yang ada di game pada saat ini.
     */
    public static final int levelCount=2;
    
    /**
     * Constructor ini berfungsi untuk membuat point baru untuk playerstartingposition, constructor ini akan
     * diperpanjang di kelas inheritancenya.
     */
    public Level()
    {
        this.playerStartingPosition=new Point();
    }
    
    /**
     * Menjalankan seluruh initialize yang ada di level.
     */
    public void initializeLevel()
    {
        this.initializeWalls();
        this.initializeObstacles();
        this.initializeItems();
    }
    
    /**
     * Menginisialisi semua walls yang ada di level, memasuk semua id wall kedalam petaLevel.
     */
    protected abstract void initializeWalls();
    
    /**
     * Menginisialisi semua obstacles yang ada di level, memasuk semua id obstacles kedalam petaLevel, dan
     * juga menginsialisasi array obstacle yang isinya jenis-jenis obstacles.
     */
    protected abstract void initializeObstacles();
    
    /**
     * Menginisialisi semua items yang ada di level, memasuk semua id items kedalam petaLevel.
     */
    protected abstract void initializeItems();
    
    /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return batasan waktu dari level.
     */
    public int getTime()
    {
        return this.time;
    }
    
    /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Posisi awal seorang player.
     */
    public Point getStartingPosition()
    {
        return this.playerStartingPosition;
    }
    
    /**
     * Method ini berfungsi untuk memanggil sebuah array Obstacle yang akan
     * digunakan oleh class Board dan Engine.
     * @return Array dari jenis-jenis Obstacles.
     */
    public Obstacle[] getObstacles()
    {
        return this.obstacles;
    }

    /**
     * Method ini berfungsi untuk memanggil petaLevel yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array 2 dimensi semua maps yang mensimulisasikan peta koordinat.
     */
    public Maps[][] getMaps()
    {
        return this.petaLevel;
    }
    
    /**
     * menggambar peta bagian rahasia yang muncul bila Wall tertentu ditembus
     */
    public abstract void drawSecret(int x, int y);
    
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
    
    /**
     * method ini berisikan hint mengenai level.
     * awali string dengan <html> dan akhiri dengan </html>
     * untuk membuat bari baru gunakan tag <br>
     * @return hint level ini dalam bentuk string
     */
    public abstract String getHint();
    
    /**
     * method ini berfungsi untuk mengembalikan jumlah diamond dalam level
     * @return jumlah diamond dalam level
     */
    public abstract int getSumOfDiamond();
}