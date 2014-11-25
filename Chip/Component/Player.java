package Chip.Component;
import Chip.Engine.Engine;
import java.awt.Point;
import java.util.LinkedList;

/**
 * Class untuk mengandalikan movement dengan cara memindahkan currentPosition ke posisi yang akan dituju
 * seperti atas, kanan, kiri, bawah dan inventory player dengan cara menyimpan id nama dari item yang bisa 
 * dibandingkan di kelas lain.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
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
    
    /**
     * Jumlah dari diamond yang sudah diambil oleh player
     */
    private int diamondCount;
    
    /**
     * Jumlah dari diamond yang harus diambil oleh player
     */
    private int diamondTotal;
    
    private Engine engine;
    
    /**
     * Constructur ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level dan
     * menginisialisasi LinkedList dari attribute inventory.
     * @param startingPosition Attribute currentPosition.
     * @param diamondTotal menginisialisasi jumlah diamond yang harus diambil
     */
    public Player(Point startingPosition, int diamondTotal,Engine engine)
    {
        this.engine=engine;
        this.diamondTotal = diamondTotal;
        inventory=new LinkedList();
        currentPosition=new Point();
        currentPosition.setLocation(startingPosition.x, startingPosition.y);
        diamondCount=0;
    }
    
    /**
     * method ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level dan
     * menginisialisasi LinkedList dari attribute inventory.
     * @param startingPosition Attribute currentPosition.
     * @param diamondTotal menginisialisasi jumlah diamond yang harus diambil
     */
    public void updatePlayer(int x, int y, int diamondTotal)
    {
        this.diamondTotal = diamondTotal;
        this.inventory=new LinkedList();
        this.currentPosition.setLocation(x, y);
        this.diamondCount=0;
    }
    /**
     * method ini berfungsi untuk mengubah posisi (x,y) player saat ini
     * dengan posisi baru
     * @param newPosition posisi baru untuk player
     */
    public void setPosition(Point newPosition)
    {
        this.currentPosition=newPosition;
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
        this.currentPosition.move(x, y);
    }
    
    /**
     * Memanggil posisi Point player pada saat ini
     * untuk digunakan pada class lain.
     * @return Attribute currentPosition.
     */
    public Point getCurPosition()
    {
        return this.currentPosition;
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
            engine.updateTotalDiamond(diamondTotal-diamondCount);
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
        for(int i=0;i<this.inventory.size();i++)
        {
            checker=(String)this.inventory.removeFirst();
            if(checker.contains(itemType))
            {
                isInventoryContained = true;
            }
            this.inventory.addLast(checker);
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
        if(this.diamondCount<this.diamondTotal)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}