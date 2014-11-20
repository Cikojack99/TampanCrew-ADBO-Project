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
 * @author Seto
 */
public class LevelZero extends Level {

    public LevelZero() {
        Point PSP=new Point();
        PSP.setLocation(5, 7);
        super(60, PSP);
        petaLevel=new Maps[30][22];
    }

    @Override
    public void initializeWalls() {
        petaLevel[4][5]=new Maps("wall");
        
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
