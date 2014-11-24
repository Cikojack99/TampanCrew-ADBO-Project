/*
 * Class untuk menghandle status-status seperti apakah player sudah mati atau belum melalu attribute
 * boolean dead, waktu melalui attribute int time, apakah stage sudah selesai atau belum melalui
 * attribute boolean clear.
 */

package Chip.Component;

import Chip.Engine.Engine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.5 BETA
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
     * Constructor ini berfungsi untuk menginisialisasi status boolean dead dan boolean clear menjadi
     * false, dan waktu awal yang dihandle di engine dan diambil dari level.
     * @param time int banyaknya time yang ada di suatu level.
     * @param engine Engine dari game, berfungsi untuk mempermudah berkomunikasi antara Status dan Board.
     */
    public Status(int time, Engine engine) {
        this.time = time;
        this.engine = engine;
        timer=new Timer(1000,this);
        timer.start();
    }

    /**
     * Countdown mechanic dari game, akan dipanggil terus menerus melalui Timer dan jika waktu sudah
     * mencapai angka 0 maka game akan berakhir dalam game over, method ini juga memberitahu engine agar 
     * engine dapat mengupdate time yang ditampilkan didisplay.
     */
    public void countDown()
    {
        if(time<=0)
        {
            time=0;
            timer.stop();
            engine.playerIsDead();
        }
        else
        {
            time--;
        }
        engine.displayTimeLeft(time);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        countDown();
    }
}
