/*
 * Class untuk mengandalikan movement player (Dev ALPHA NOTE: Mungkin inventory juga)
 */

package Chip.Component;
import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public class Player {
   
    /**
     * Sebuah kordinat posisi player pada saat ini.
     */
    private Point currentPosition;
    
    /**
     * (Dev ALPHA NOTE: Inventory mungkin diimplementasikan di class player)
     */
    private Item[] inventory;
    
    /**
     * Constructur ini berfungsi untuk menginisialisasikan posisi kordinat awal 
     * player dalam sebuah level.
     * @param startingPosition Posisi awal player.
     */
    public Player(Point startingPosition)
    {
        currentPosition=startingPosition;
    }
    
    /**
     * Method ini berfungsi untuk memindahkan kordinat player berdasarkan arah
     * yang user arahkan, input arah akan diurus oleh class Board.
     * @param direction arah input player yang sudah dikonversi sebagai int.
     * 0=Up, 1=Down, 2=left, 3=right.
     * @return Point posisi player yang sudah bergerak.
     */
    public Point move(int direction)
    {
        if(direction==0)
        {
            currentPosition.move((int)currentPosition.getX()+1, (int)currentPosition.getY());
        }
        else if(direction==1)
        {
            currentPosition.move((int)currentPosition.getX()-1, (int)currentPosition.getY());
        }
        else if(direction==2)
        {
            currentPosition.move((int)currentPosition.getX(), (int)currentPosition.getY()-1);
        }
        else if(direction==3)
        {
            currentPosition.move((int)currentPosition.getX(), (int)currentPosition.getY()+1);
        }
        return currentPosition;
    }
    
    /**
     * Method ini berfungsi untuk memanggil posisi Point player pada saat ini
     * untuk digunakan pada class lain.
     * @return posisi Point player pada saat ini.
     */
    public Point getCurPosition()
    {
        return currentPosition;
    }
}
