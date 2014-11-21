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
        Point PSP=new Point();
        PSP.setLocation(5, 7);
        super(60, PSP);
        petaLevel=new Maps[30][22];
        obstacles= new Obstacle[6];
    }

    @Override
    public void initializeWalls() {     
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
        items[0]=new BrownKey();
        items[1]=new GreenKey();
        items[2]=new SilverKey();
        items[3]=new MirrorSuit();
        items[4]=new SilentBoots();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
