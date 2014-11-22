/*
 * Class untuk menghandle status-status seperti apakah player sudah mati atau belum melalu attribute
 * boolean dead, waktu melalui attribute int time, apakah stage sudah selesai atau belum melalui
 * attribute boolean clear.
 */

package Chip.Component;
/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.02 ALPHA
 */
public class Status {
    /**
     * boolean apakah player sudah mati atau belum akan berubah jika waktu habis atau player kena
     * obstacles yang bisa berakibat di kematian yang di handle di engine, true jika player mati dan false
     * jika player sudah mati.
     */
    private boolean dead;
    /**
     * boolean apakah stage sudah selesai atau belum.
     */
    private boolean clear;
    /**
     * int banyaknya time yang player butuhkan yang akan berakibat di game over, boolean dead=true
     * jika waktu ini mencapai angka 0.
     */
    private int time;

    /**
     * Constructor ini berfungsi untuk menginisialisasi status boolean dead dan boolean clear menjadi
     * false, dan waktu awal yang dihandle di engine dan diambil dari level.
     * @param time int banyaknya time yang player butuhkan.
     */
    public Status(int time) {
        this.dead = false;
        this.clear = false;
        this.time = time;
    }
    
    /**
     * Mengembalikan boolean dead yang berfungsi untuk mengetahui apakah player sudah mati atau belum, true
     * jika player mati dan false jika player masih hidup.
     * @return boolean apakah player sudah mati atau belum.
     */
    public boolean isDead()
    {
        return dead;
    }
    
    /**
     * Mengembalikan boolean clear yang berfungsi untuk mengetahui apakah level sudah clear atau belum, true
     * jika level sudah clear dan false jika level belum clear.
     * @return boolean apakah stage sudah selesai atau belum.
     */
    public boolean isLevelClear()
    {
        return clear;
    }
    
    /**
     * Countdown mechanic dari game, akan berkurang terus timenya dan jika time=0, maka game akan berhasil
     * dan player dianggap mati.
     * @return int time sisa waktu yang player punya.
     */
    public int countDown()
    {
        time--;
        return time;
    }
    
    /**
     * Mengubah status attribute clear yang asalnya false menjadi true untuk merepresentasikan level yang
     * sudah clear.
     */
    public void levelNowClear()
    {
        clear=!clear;
    }
    
    /**
     * Mengubah status attribute dead yang asalnya false menjadi true untuk merepresentasikan player yang
     * sudah mati.
     */
    public void playerIsDead()
    {
        dead=!dead;
    }
    
    /**
     * Mengurangi attribute time dengan penalty yang diberikan dikarenakan suatu hal yang akan di handle 
     * di engine.
     * @param penalty Banyaknya pengurangan waktu yang dikurangan ke time.
     */
    public void timePenalty(int penalty)
    {
        for(int i=0;i<penalty;i++)
        {
            countDown();
        }
    }
}
