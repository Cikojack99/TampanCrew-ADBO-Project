
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * class untuk tembok
 * @author User
 */
public class Wall {
    /**
     * boolean apakah tembok dapat ditembus atau tidak
     */
    private boolean moveable;
    
    /**
     * koordinat dari tembok
     */
    private Point position;

    /**
     * konstraktor
     * @param moveable mengisi boolean dapat ditembus atu tidak, true bila dapat ditembus
     * @param position koordinat dari tembok dalam bentuk Point(x,y)
     */
    public Wall(boolean moveable, Point position) {
        this.moveable = moveable;
        this.position = position;
    }
    
    /**
     * mengecek apakah tembok bisa ditembus atau tidak
     * @return true bila dapat,, false bila tidak
     */
    public boolean checkMoveable()
    {
        return moveable;
    }
    
    /**
     * mengembalikan koordinat tembok
     * @return koordinat tembok
     */
    public Point getPosition()
    {
        return position;
    }
}
