/*
 * Class untuk menghandle status-status seperti apakah player sudah mati atau belum melalu attribute
 * boolean dead, waktu melalui attribute int time, apakah stage sudah selesai atau belum melalui
 * attribute boolean clear.
 */

package Chip.Component;

import Chip.Engine.Engine;
import Chip.Engine.Engine;
import Chip.Gui.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.02 ALPHA
 */
public class Status implements ActionListener{
    
    /**
     * int banyaknya time yang player butuhkan yang akan berakibat di game over, boolean dead=true
     * jika waktu ini mencapai angka 0.
     */
    private int time;
    
    private Timer timer;
    
    private Board board;
    
    private Engine engine;

    /**
     * Constructor ini berfungsi untuk menginisialisasi status boolean dead dan boolean clear menjadi
     * false, dan waktu awal yang dihandle di engine dan diambil dari level.
     * @param time int banyaknya time yang player butuhkan.
     * @param board
     * @param engine
     */
    public Status(int time, Engine engine) {
        this.time = time;
        this.board = board;
        this.engine = engine;
        timer=new Timer(1000,this);
        timer.start();
    }

    /**
     * Countdown mechanic dari game, akan berkurang terus timenya dan jika time=0, maka game akan berhasil
     * dan player dianggap mati.
     * @return int time sisa waktu yang player punya.
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

    /** Mengurangi attribute time dengan penalty yang diberikan dikarenakan suatu hal yang akan di handle 
     *  di engine.
     *  @param penalty Banyaknya pengurangan waktu yang dikurangan ke time.
     */
    public void timePenalty(int penalty)
    {
        time=time-penalty;
        engine.displayTimeLeft(time);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        countDown();
    }
}
