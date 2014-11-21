/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Component.Levels;

import Chip.Component.*;
import java.awt.Point;

/**
 *
 * @author VS.BETA
 */
public class LevelZero extends Level {

    public LevelZero(int time, Point playerStartingPosition) {
        super(time, playerStartingPosition);
        petaLevel=new Maps[30][22];
    }

    @Override
    public void initializeWalls() {
        Maps wall = new Maps("Wall");
        
        for (int i = 5; i <= 21; i++) {
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
    }

    @Override
    public void initializeObstacles() {
        
    }

    @Override
    public void initializeItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initializeMaps() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public Maps[][] getMap()
    {
        return petaLevel;
    }
    
    public int getHeight()
    {
        return 22;
    }
    
    public int getWidth()
    {
        return 30;
    }
    
    public Maps getContent(int i, int j)
    {
        return petaLevel[i][j];
    }
}
