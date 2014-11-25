/*
 * Class untuk mengandalikan movement dengan cara memindahkan currentPosition ke posisi yang akan dituju
 * seperti atas, kanan, kiri, bawah dan inventory player dengan cara menyimpan id nama dari item yang bisa 
 * dibandingkan di kelas lain.
 */

package Chip.Component;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.5 BETA
 */
public class Player {
   
    /**
     * Sebuah kordinat posisi player pada saat ini yang bertipe Point.
     */
    private Point currentPosition;
    
    /**
     * Inventory dari player yang bertipe LinkedList .
     */
    private LinkedList inventory;
    
    private int diamondCount;
    
    private int diamondTotal;
    
    /**
     * Constructur ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level dan
     * menginisialisasi LinkedList dari attribute inventory.
     * @param startingPosition Attribute currentPosition.
     */
    public Player(Point startingPosition, int diamondTotal)
    {
        this.diamondTotal = diamondTotal;
        inventory=new LinkedList();
        currentPosition=startingPosition;
        diamondCount=0;
    }
    
    public void setPosition(Point startingPosition)
    {
        currentPosition=startingPosition;
    }
    
    /**
     * Memindahkan kordinat player berdasarkan arah
     * yang user arahkan yang sudah di handle di engine.
     * @param x kordinat x setelah player bergerak yang bertipe int.
     * @param y kordinat y setelah player bergerak yang bertipe int.
     * @return Point posisi player yang sudah bergerak.
     */
    public void move(int x, int y)
    {
        currentPosition.move(x, y);
    }
    
    /**
     * Memanggil posisi Point player pada saat ini
     * untuk digunakan pada class lain.
     * @return Attribute currentPosition.
     */
    public Point getCurPosition()
    {
        return currentPosition;
    }
    
    /**
     * Memasukan item yang diambil oleh player yang di handle di engine kedalam LinkedList inventory untuk
     * dicek sebagai antiObstacles atau jumlah diamond yang diperlukan untuk keluar.
     * @param itemType id nama dari sebuah item agar bisa dimasukan kedalam Linked List .
     */
    public void takeItem(String itemType)
    {
        inventory.addFirst(itemType);
        if(itemType.contains("diamond"))
        {
            diamondCount++;
        }
    }
    
    /**
     * Mencek id item yang ingin di cek dengan id item yang ada di LinkedList inventory apakah idnya sama
     * atau tidak untuk menentukan apakah player punya item yang ingin di cek tersebut.
     * @param itemType id nama dari sebuah item agar bisa dibandingkan atau di cek
     * @return true atau false yang berarti true jika id nama yang ada di inventory match dengan id nama
     * yang ingin di cek dan berarti false jika id nama tidak match dengan yang ingin di cek.
     */
    public boolean checkInventory(String itemType)
    {
        String checker="";
        boolean isInventoryContained=false;
        for(int i=0;i<inventory.size();i++)
        {
            checker=(String)inventory.removeFirst();
            if(checker.contains(itemType))
            {
                isInventoryContained = true;
            }
            inventory.addLast(checker);
        }
        return isInventoryContained;
    }
    
    /**
     * Mencek id item diamond apakah sudah ada 5 buah atau tidak, akan digunakan untuk obstacles
     * finishLineDoor yang di handle di Engine.
     * @return true jika sudah ada 5 dan false jika belum ada 5.
     */
    public boolean diamondReqChecker()
    {
        if(diamondCount<diamondTotal)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}