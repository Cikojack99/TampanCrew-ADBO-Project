package Chip.Component;

import Chip.Engine.Engine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Class untuk menghandle status-status seperti apakah player sudah mati atau belum melalu attribute
 * boolean dead, waktu melalui attribute int time, apakah stage sudah selesai atau belum melalui
 * attribute boolean clear.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class Status implements ActionListener{
    
    /**
     * int banyaknya time yang player butuhkan yang akan berakibat di game over, akan memanggil method
     * playerIsDead yang ada di Engine jika time ini = 0
     * jika waktu ini mencapai angka 0.
     */
    private int time;
    
    /**
     * Timer agar si time bisa berkurang setiap detiknya, mengsimulisasikan sebuah countdown, attribute ini
     * bawaan dari java. For more Information please see the javadocs.
     */
    private Timer timer;
    
    /**
     * Engine dari game, berfungsi untuk mempermudah berkomunikasi antara Status dan Board, untuk update
     * waktu kedisplay dan memberitahu board bahwa player sudah mati karena habis waktu.
     */
    private Engine engine;
    
    /**
     * 
     */
    private final int timeDefault;

    /**
     * Constructor ini berfungsi untuk menginisialisasi status boolean dead dan boolean clear menjadi
     * false, dan waktu awal yang dihandle di engine dan diambil dari level.
     * @param time int banyaknya time yang ada di suatu level.
     * @param engine Engine dari game, berfungsi untuk mempermudah berkomunikasi antara Status dan Board.
     */
    public Status(int time, Engine engine) {
        this.time = time;
        this.timeDefault=time;
        this.engine = engine;
        this.timer=new Timer(1000,this);
        this.timer.start();
    }
    
    /**
     * method ini berfungsi untuk melakukan pengesetan ulang waktu untuk setiap levelnya
     */
    public void statusReset()
    {
        this.timer.stop();
        this.time=this.timeDefault;
        this.timer.start();
    }
    /**
     * method ini berfungsi untuk mematikan timer yang sedang berjalan
     */
    public void statusKill()
    {
        this.timer.stop();
    }

    /**
     * Countdown mechanic dari game, akan dipanggil terus menerus melalui Timer dan jika waktu sudah
     * mencapai angka 0 maka game akan berakhir dalam game over, method ini juga memberitahu engine agar 
     * engine dapat mengupdate time yang ditampilkan didisplay.
     */
    public void countDown()
    {
        if(this.time<=0)
        {
            this.time=0;
            this.timer.stop();
            this.engine.playerIsDead();
        }
        else
        {
            this.time--;
        }
        this.engine.displayTimeLeft(this.time);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.countDown();
    }
}
