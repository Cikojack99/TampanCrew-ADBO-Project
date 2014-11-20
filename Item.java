/*
 * class untuk objek yang dapat diambil
 * @author 
 */

package Chip.Component.Items;
import java.awt.Point;
import Chip.Component.*;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public abstract class Item{
    /**
     * type adalah penanda dalam bentuk string jenis objek ini.
     * 0=Diamond, 1=SilverKey, 2=MirrorSuit, 3=SilentBoots, 4=KeyCode, 5=FakeKey.
     */
    protected final String type;
    
    /**
     * position adalah koordinat objek ini
     */
    protected Point position;
    
    protected Boolean takenStatus;

    /**
     * konstraktor kelas objek
     * @param type string untuk jenis objek
     * @param position koordinat objek dalam bentuk Point(x, y) 
    */
    public Item(String type, Point position) {
        takenStatus=false;
        this.type = type;
        this.position = position;
    }
    
    /**
     * effect dari objek ini
     */
    public abstract void effect();
    
    /**
     * mengembalikan jenis objek ini
     * @return jenis objek ini
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * mengembalikan koordinat objek
     * @return koordinat objek
     */
    public Point getPosition()
    {
        return position;
    }
    
    /**
     * Mengembalikan apakah sebuah item sudah diambil atau belum.
     */
    public boolean isTaken()
    {
        return takenStatus;
    }
    
    public void take()
    {
        takenStatus=true;
    }
}