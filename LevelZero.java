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
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 30; j++) {
                if(i==0 && j>22 && j<28)
                {
                    petaLevel[i][j] = wall;
                } else if(i==1 && ((j>16 && j<22) || j==23 || j==23))
                {
                    petaLevel[i][j] = wall;
                } else if(i==2 && ((j>11 && j<18) || (j>20 && j<24) || j==25 || j==27))
                {
                    petaLevel[i][j] = wall;
                } else if(i==3 && (j==12 || j==19 || j==27))
                {
                    petaLevel[i][j] = wall;
                } else if(i==4 && (j==12 || (j>14 && j<26) || j==27))
                {
                    petaLevel[i][j] = wall;
                } else if(i==5 && ((j>3 && j<13) || (j>14 && j<26) || j==27 || j==29))
                {
                    petaLevel[i][j] = wall;
                } else if(i==6 && (j==4 || j==9 || j==11 || j==22 || j==23 || j==29))
                {
                    petaLevel[i][j] = wall;
                } else if(i==7 && (j==4 || j==9 || j==11 || j==29))
                {
                    petaLevel[i][j] = wall;
                } else if(i==8 && (j==4 || j==11 || j==22 || j==23 || j==29))
                {
                    petaLevel[i][j] = wall;
                } else if(i==9 && (j==4 || j==11 || (j>15&&j<20) || j==22 || j==29))
                {
                    petaLevel[i][j] = wall;
                } else if(i==10 && (j==4 || j==11))
                {
                    petaLevel[i][j] = wall;
                } else if(i==11 && (j==4 || j==9 || j==11))
                {
                    petaLevel[i][j] = wall;
                } else if(i==12 && (j==4 || j==9 || j==11 || j==29))
                {
                    petaLevel[i][j] = wall;
                } else if(i==13 && (j==4 || j==5 || (j>7 && j<13) || (j>14 && j<30)))
                {
                    petaLevel[i][j] = wall;
                } else if(i==14 && (j==4 || j==19 || j==24))
                {
                    petaLevel[i][j] = wall;
                } else if((i==15 || i==16) && (j==4 || j==19 || j==22 || j==24))
                {
                    petaLevel[i][j] = wall;
                } else if(i==17 && (j==4 || j==22 || j==24))
                {
                    petaLevel[i][j] = wall;
                } else if(i==18 && ((j>=0 && j<6) || (j>8 && j<23) || j==24))
                {
                    petaLevel[i][j] = wall;
                } else if((i==19 || i==20) && (j==0 || j==4 || j==24))
                {
                    petaLevel[i][j] = wall;
                } else if(i==21 && (j>=0 && j<25))
                {
                    petaLevel[i][j] = wall;
                }
            }
        }
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
