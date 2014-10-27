/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Status {
    private boolean dead;
    private boolean clear;
    private int time;

    public Status(boolean dead, boolean clear, int time) {
        this.dead = dead;
        this.clear = clear;
        this.time = time;
    }
    
    public boolean isDead()
    {
        return dead;
    }
    
    public boolean isLevelClear()
    {
        return clear;
    }
    
    public int countDown()
    {
        time--;
        return time;
    }
    
    public void levelNowClear()
    {
        clear=!clear;
    }
    
    public void playerIsDead()
    {
        dead=!dead;
    }
}
