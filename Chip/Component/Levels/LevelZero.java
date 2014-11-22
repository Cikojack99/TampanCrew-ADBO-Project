/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Component.Levels;

import Chip.Component.*;
import Chip.Component.Items.*;
import Chip.Component.Obstacles.*;
import java.awt.Point;

/**
 *
 * @author Seto
 */
public class LevelZero extends Level {

    public LevelZero() {
        playerStartingPosition.setLocation(5, 7);
        petaLevel=new Maps[30][22];
        obstacles= new Obstacle[6];
    }

@Override
    public void initializeWalls() {
        Maps wall = new Maps("Wall");
        
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
        Maps invisWall = new Maps("invisible wall");
        petaLevel[4][19]=invisWall;
        petaLevel[4][20]=invisWall;
        petaLevel[22][7]=invisWall;
    }

    @Override
    public void initializeObstacles() {
        obstacles[0]=new BrownLockedDoor();
        obstacles[1]=new SilverLockedDoor();
        obstacles[2]=new GreenLockedDoor();
        obstacles[3]=new Laser();
        obstacles[4]=new SleepingGuardRadius();
        obstacles[5]=new FinishLineDoor();
        Maps laser=new Maps("obstacle","laser");
        Maps sleepingGuardRadius=new Maps("obstacle","sleepingGuardRadius");
        petaLevel[6][13]=new Maps("obstacle","silverDoor");
        petaLevel[11][14]=laser;
        petaLevel[11][15]=laser;
        petaLevel[11][16]=laser;
        petaLevel[11][17]=laser;
        petaLevel[21][15]=new Maps("obstacle","greenDoor");
        petaLevel[13][13]=new Maps("obstacle","brownDoor");
        petaLevel[12][17]=laser;
        petaLevel[13][17]=laser;
        petaLevel[14][17]=laser;
        petaLevel[15][17]=laser;
        petaLevel[22][10]=laser;
        petaLevel[22][11]=laser;
        petaLevel[22][12]=laser;
        petaLevel[18][6]=sleepingGuardRadius;
        petaLevel[18][7]=sleepingGuardRadius;
        petaLevel[18][8]=sleepingGuardRadius;
        petaLevel[17][7]=sleepingGuardRadius;
        petaLevel[17][8]=sleepingGuardRadius;
        petaLevel[16][6]=sleepingGuardRadius;
        petaLevel[16][7]=sleepingGuardRadius;
        petaLevel[16][8]=sleepingGuardRadius;
        petaLevel[17][6]=new Maps("prop","sleepingGuardRadius");
        petaLevel[25][3]=laser;
        petaLevel[29][11]=new Maps("obstacle","FinishLineDoor");
    }
        

    @Override
    public void initializeItems() {
        Maps diamond=new Maps("item","diamond");
        petaLevel[10][6]=new Maps("item","silverKey");
        petaLevel[10][9]=diamond;
        petaLevel[10][14]=new Maps("item","greenKey");
        petaLevel[7][18]=diamond;
        petaLevel[2][19]=new Maps("item","mirrorArmor");
        petaLevel[17][17]=new Maps("item","brownKey");
        petaLevel[14][17]=diamond;
        petaLevel[12][12]=new Maps("item","silentBoots");
        petaLevel[13][7]=diamond;
        petaLevel[26][9]=diamond;
    }

    @Override
    public void drawSecret() {
        Maps wall = new Maps("Wall");
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
