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
        
        for (int i = 5; i <= 18; i++) {
            this.petaLevel[4][i]=wall;
        }
        for (int i = 5; i <= 12; i++) {
            this.petaLevel[i][5]=wall;
        }
        for (int i = 12; i <= 17; i++) {
            this.petaLevel[i][2]=wall;
        }
        for (int i = 17; i <= 21; i++) {
            this.petaLevel[i][1]=wall;
        }
        for (int i = 21; i <= 23; i++) {
            this.petaLevel[i][2]=wall;
        }
        for (int i = 23; i <= 27; i++) {
            this.petaLevel[i][0]=wall;
        }
        for (int i = 1; i <= 5; i++) {
            this.petaLevel[27][i]=wall;
        }
        for (int i = 5; i <= 9; i++) {
            this.petaLevel[29][i]=wall;
        }
        for (int i = 15; i <= 25; i++) {
            this.petaLevel[i][4]=wall;
            this.petaLevel[i][5]=wall;
        }
        for (int i = 16; i <= 19; i++) {
            this.petaLevel[i][9]=wall;
        }
        for (int i = 6; i <= 9; i++) {
            this.petaLevel[22][i]=wall;
        }
        for (int i = 6; i <= 12; i++) {
            this.petaLevel[11][i]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            this.petaLevel[i][13]=wall;
        }
        for (int i = 15; i <= 29; i++) {
            this.petaLevel[i][13]=wall;
        }
        for (int i = 9; i <= 22; i++) {
            this.petaLevel[i][18]=wall;
        }
        for (int i = 5; i <= 24; i++) {
            this.petaLevel[i][21]=wall;
        }
        for (int i = 14; i <= 20; i++) {
            this.petaLevel[24][i]=wall;
        }
        this.petaLevel[23][1]=wall;
        this.petaLevel[25][2]=wall;
        this.petaLevel[19][3]=wall;
        this.petaLevel[12][3]=wall;
        this.petaLevel[12][4]=wall;
        this.petaLevel[28][5]=wall;
        this.petaLevel[23][6]=wall;
        this.petaLevel[9][6]=wall;
        this.petaLevel[23][8]=wall;
        this.petaLevel[9][11]=wall;
        this.petaLevel[9][12]=wall;
        this.petaLevel[29][12]=wall;
        this.petaLevel[5][13]=wall;
        this.petaLevel[19][14]=wall;
        this.petaLevel[19][15]=wall;
        this.petaLevel[19][16]=wall;
        this.petaLevel[22][15]=wall;
        this.petaLevel[22][16]=wall;
        this.petaLevel[22][17]=wall;
        this.petaLevel[5][18]=wall;
        this.petaLevel[4][21]=wall;
        Maps invisWall = new Maps("wall", "invisible wall");
        this.petaLevel[4][19]=invisWall;
        this.petaLevel[4][20]=invisWall;
        this.petaLevel[22][7]=invisWall;
    }

    @Override
    public void initializeObstacles() {
        Maps laser=new Maps("obstacle","laser");
        Maps sleepingGuardRadius=new Maps("obstacle","sleepingGuardRadius");
        
        this.obstacles[0]=new BrownLockedDoor();
        this.obstacles[1]=new SilverLockedDoor();
        this.obstacles[2]=new GreenLockedDoor();
        this.obstacles[3]=new Laser();
        this.obstacles[4]=new SleepingGuardRadius();
        this.obstacles[5]=new FinishLineDoor();
        
        this.petaLevel[6][13]=new Maps("obstacle","silverDoor");
        this.petaLevel[7][13] = this.petaLevel[6][13];
        this.petaLevel[21][15]=new Maps("obstacle","greenDoor");
        this.petaLevel[22][15] = this.petaLevel[21][15];
        this.petaLevel[13][13]=new Maps("obstacle","brownDoor");
        this.petaLevel[14][13] = this.petaLevel[13][13];
        this.petaLevel[17][6]=new Maps("this.obstacles","guardian");
        this.petaLevel[8][7]=this.petaLevel[17][6];
        this.petaLevel[29][11]=new Maps("obstacle","FinishLineDoor");
        this.petaLevel[29][10] = this.petaLevel[29][11];
        
        for (int i = 5; i <= 8; i++) {
            this.petaLevel[i][6]=laser;
        }
        for (int i = 5; i <= 10; i++) {
            this.petaLevel[i][8]=laser;
        }
        for (int i = 5; i <= 10; i++) {
            this.petaLevel[i][9]=laser;
        }
        for (int i = 5; i <= 10; i++) {
            this.petaLevel[i][10]=laser;
        }
        for (int i = 5; i <= 8; i++) {
            this.petaLevel[i][11]=laser;
        }
        for (int i = 5; i <= 8; i++) {
            this.petaLevel[i][12]=laser;
        }
        
        
        for (int i = 14; i <= 17; i++) {
            this.petaLevel[11][i]=laser;
        }
        for (int i = 12; i <= 15; i++) {
            this.petaLevel[i][9]=laser;
        }
        for (int i = 10; i <= 12; i++) {
            this.petaLevel[22][i]=laser;
        }
        for (int i = 6; i <= 8; i++) {
            this.petaLevel[18][i]=sleepingGuardRadius;
        }
        for (int i = 6; i <= 8; i++) {
            this.petaLevel[16][i]=sleepingGuardRadius;
        }
        this.petaLevel[17][7]=sleepingGuardRadius;
        this.petaLevel[17][8]=sleepingGuardRadius;
        this.petaLevel[6][7]=sleepingGuardRadius;
        this.petaLevel[7][7]=sleepingGuardRadius;
        this.petaLevel[25][3]=laser;
    }
        

    @Override
    public void initializeItems() {
        Maps diamond=new Maps("item","diamond");
        this.petaLevel[10][6]=new Maps("item","silverKey");
        this.petaLevel[10][14]=new Maps("item","greenKey");
        this.petaLevel[17][17]=new Maps("item","brownKey");
        this.petaLevel[12][12]=new Maps("item","silentBoots");
        this.petaLevel[10][7]=new Maps("item","mirrorArmor");
        this.petaLevel[7][18]=diamond;
        this.petaLevel[14][17]=diamond;
        this.petaLevel[13][7]=diamond;
        this.petaLevel[26][9]=diamond;
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
        return 4;
    }

}
