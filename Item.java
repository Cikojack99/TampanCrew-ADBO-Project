/*
 * class untuk objek yang dapat diambil
 * @author 
 */

package Chip.Component;
import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public abstract class Item extends Maps {
//    /**
//     *type adalah penanda dalam bentuk string jenis objek ini
//     */
//    private final String type;
    
    /**
     * position adalah koordinat objek ini
     */
    private Point position;

    /**
     * konstraktor kelas objek
     * @param type string untuk jenis objek
     * @param position koordinat objek dalam bentuk Point(x, y) 
    */
    public Item(String type, Point position) {
//        this.type = type;
        this.position = position;
    }
    
    /**
     * effect dari objek ini
     */
    public abstract void effect();
    
//    /**
//     * mengembalikan jenis objek ini
//     * @return jenis objek ini
//     */
//    public String getType()
//    {
//        return type;
//    }
    
    /**
     * mengembalikan koordinat objek
     * @return koordinat objek
     */
    public Point getCoordinate()
    {
        return position;
    }
    
    /**
     * memindahkan koordinat objek setelah diambil
     */
    public void deleteCoordinate()
    {
        position= new Point(0, 0);
    }
}
