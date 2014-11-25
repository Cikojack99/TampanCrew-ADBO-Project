package Chip.Component.Levels;

import Chip.Component.*;
import Chip.Component.Obstacles.*;

/**
 * Class ini adalah turunan dari kelas Level, semua deskripsi ada di kelas level. More information in Level
 * javadocs.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class LevelOne extends Level {

    /**
     * Constructor ini menginisialisasi batas waktu dilevel, posisi awal player, banyak 2 array map yang
     * dibutuhkan, dan array jenis-jenis this.obstacles.
     */
    public LevelOne() {
        this.time=60;
        this.playerStartingPosition.setLocation(5, 7);
        this.petaLevel=new Maps[30][22];
        this.obstacles= new Obstacle[6];
    }

@Override
    public void initializeWalls() {
        Maps wall = new Maps("wall", "wallDoang");
        for (int i = 1; i <= 11; i++) {
            petaLevel[i][1]=wall;
        }
        for (int i = 1; i <= 11; i++) {
            petaLevel[i][4]=wall;
        }
        for (int i = 5; i <= 7; i++) {
            petaLevel[8][i]=wall;
        }
        for (int i = 5; i <= 7; i++) {
            petaLevel[10][i]=wall;
        }
        petaLevel[9][7]=wall;
    }

    @Override
    public void initializeObstacles() {
        Maps laser=new Maps("obstacle","laser");
        Maps sleepingGuardRadius=new Maps("obstacle","sleepingGuardRadius");
        
        obstacles[0]=new Laser();
        obstacles[1]=new SleepingGuardRadius();
        obstacles[2]=new SleepingGuard();
        obstacles[3]=new FinishLineDoor();
        
        petaLevel[1][2]=new Maps("obstacle","FinishLineDoor");
        petaLevel[1][3] = petaLevel[1][2];
        petaLevel[11][2] = petaLevel[1][2];
        petaLevel[11][3]= petaLevel[1][2];
        petaLevel[5][2]= laser;
        petaLevel[5][3]= laser;
        petaLevel[7][2]= laser;
        petaLevel[7][3]= laser;
        petaLevel[9][2]= laser;
        petaLevel[9][3]= laser;
        petaLevel[3][2]= sleepingGuardRadius;
        petaLevel[3][3]= sleepingGuardRadius;
        petaLevel[4][3]= sleepingGuardRadius;
        petaLevel[4][2]= new Maps("obstacle","guardian");
        petaLevel[10][2]= petaLevel[4][2];
    }
        

    @Override
    public void initializeItems() {
        petaLevel[9][6]= new Maps("item","diamond");
    }

    @Override
    public void drawSecret(int x, int y) {
        
    }

    @Override
    public int getHeight()
    {
        return 22;
    }
    
    @Override
    public int getWidth()
    {
        return 30;
    }

    @Override
    public String getHint() {
        String hint = "Jangan Jadi Maling^^";
        return hint;
    }

    @Override
    public int getSumOfDiamond() {
        return 1;
    }

}
