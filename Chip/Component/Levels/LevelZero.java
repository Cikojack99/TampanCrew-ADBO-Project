/*
 * Class ini adalah turunan dari kelas Level, semua deskripsi ada di kelas level. More information in Level
 * javadocs.
 */

package Chip.Component.Levels;

import Chip.Component.*;
import Chip.Component.Obstacles.*;
import java.awt.Point;

/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.5 BETA
 */
public class LevelZero extends Level {

    /**
     * Constructor ini menginisialisasi batas waktu dilevel, posisi awal player, banyak 2 array map yang
     * dibutuhkan, dan array jenis-jenis obstacles.
     */
    public LevelZero() {
        time=60;
        playerStartingPosition.setLocation(5, 7);
        petaLevel=new Maps[30][22];
        obstacles= new Obstacle[6];
    }

@Override
    public void initializeWalls() {
        Maps wall = new Maps("wall", "wall");
        
        for (int i = 5; i <= 18; i++) {
            petaLevel[4][i]=wall;
        }
        for (int i = 5; i <= 12; i++) {
            petaLevel[i][5]=wall;
        }
        for (int i = 12; i <= 17; i++) {
            petaLevel[i][2]=wall;
        }
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][1]=wall;
        }
        for (int i = 21; i <= 23; i++) {
            petaLevel[i][2]=wall;
        }
        for (int i = 23; i <= 27; i++) {
            petaLevel[i][0]=wall;
        }
        for (int i = 1; i <= 5; i++) {
            petaLevel[27][i]=wall;
        }
        for (int i = 5; i <= 9; i++) {
            petaLevel[29][i]=wall;
        }
        for (int i = 15; i <= 25; i++) {
            petaLevel[i][4]=wall;
            petaLevel[i][5]=wall;
        }
        for (int i = 16; i <= 19; i++) {
            petaLevel[i][9]=wall;
        }
        for (int i = 6; i <= 9; i++) {
            petaLevel[22][i]=wall;
        }
        for (int i = 6; i <= 12; i++) {
            petaLevel[11][i]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][13]=wall;
        }
        for (int i = 15; i <= 29; i++) {
            petaLevel[i][13]=wall;
        }
        for (int i = 9; i <= 22; i++) {
            petaLevel[i][18]=wall;
        }
        for (int i = 5; i <= 24; i++) {
            petaLevel[i][21]=wall;
        }
        for (int i = 14; i <= 20; i++) {
            petaLevel[24][i]=wall;
        }
        petaLevel[23][1]=wall;
        petaLevel[25][2]=wall;
        petaLevel[19][3]=wall;
        petaLevel[12][3]=wall;
        petaLevel[12][4]=wall;
        petaLevel[28][5]=wall;
        petaLevel[23][6]=wall;
        petaLevel[9][6]=wall;
        petaLevel[9][7]=wall;
        petaLevel[23][8]=wall;
        petaLevel[9][11]=wall;
        petaLevel[9][12]=wall;
        petaLevel[29][12]=wall;
        petaLevel[5][13]=wall;
        petaLevel[19][14]=wall;
        petaLevel[19][15]=wall;
        petaLevel[19][16]=wall;
        petaLevel[22][15]=wall;
        petaLevel[22][16]=wall;
        petaLevel[22][17]=wall;
        petaLevel[5][18]=wall;
        petaLevel[4][21]=wall;
        Maps invisWall = new Maps("wall", "invisible wall");
        petaLevel[4][19]=invisWall;
        petaLevel[4][20]=invisWall;
        petaLevel[22][7]=invisWall;
    }

    @Override
    public void initializeObstacles() {
        Maps laser=new Maps("obstacle","laser");
        Maps sleepingGuardRadius=new Maps("obstacle","sleepingGuardRadius");
        
        obstacles[0]=new BrownLockedDoor();
        obstacles[1]=new SilverLockedDoor();
        obstacles[2]=new GreenLockedDoor();
        obstacles[3]=new Laser();
        obstacles[4]=new SleepingGuardRadius();
        obstacles[5]=new FinishLineDoor();
        
        petaLevel[6][13]=new Maps("obstacle","silverDoor");
        petaLevel[21][15]=new Maps("obstacle","greenDoor");
        petaLevel[13][13]=new Maps("obstacle","brownDoor");
        petaLevel[17][6]=new Maps("obstacles","guardian");
        petaLevel[29][11]=new Maps("obstacle","FinishLineDoor");
        
        for (int i = 14; i <= 17; i++) {
            petaLevel[11][i]=laser;
        }
        for (int i = 12; i <= 15; i++) {
            petaLevel[i][9]=laser;
        }
        for (int i = 10; i <= 12; i++) {
            petaLevel[22][i]=laser;
        }
        for (int i = 6; i <= 8; i++) {
            petaLevel[18][i]=sleepingGuardRadius;
        }
        for (int i = 6; i <= 8; i++) {
            petaLevel[16][i]=sleepingGuardRadius;
        }
        petaLevel[17][7]=sleepingGuardRadius;
        petaLevel[17][8]=sleepingGuardRadius;
        petaLevel[25][3]=laser;
    }
        

    @Override
    public void initializeItems() {
        Maps diamond=new Maps("item","diamond");
        petaLevel[10][6]=new Maps("item","silverKey");
        petaLevel[10][14]=new Maps("item","greenKey");
        petaLevel[2][19]=new Maps("item","mirrorArmor");
        petaLevel[17][17]=new Maps("item","brownKey");
        petaLevel[12][12]=new Maps("item","silentBoots");

        petaLevel[10][9]=diamond;
        petaLevel[7][18]=diamond;
        petaLevel[14][17]=diamond;
        petaLevel[13][7]=diamond;
        petaLevel[26][9]=diamond;
    }

    @Override
    public void drawSecret() {
        Maps wall = new Maps("wall", "wallDoang");
        for (int i = 0; i <= 3; i++) {
            petaLevel[i][18]=wall;
        }
        for (int i = 0; i <= 3; i++) {
            petaLevel[i][21]=wall;
        }
        petaLevel[0][19]=wall;
        petaLevel[0][20]=wall;
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

}
