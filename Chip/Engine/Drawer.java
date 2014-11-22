/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Engine;

import Chip.Component.Levels.Level;
import Chip.Component.Maps;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

/**
 *
 * @author Caustri Kennel
 */
public class Drawer extends JPanel{
    Level stage;
    JPanel panel;

    public Drawer(Level stage, JPanel panel) {
        this.stage = stage;
        this.panel = panel;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D gd = (Graphics2D)g;
        Stroke s = new BasicStroke(20);
        gd.setStroke(s);
        Line2D line;
        gd.setColor(Color.GRAY);
        stage.initializeWalls();
        Maps[][] map = stage.getMaps();
        for (int i = 0; i < stage.getWidth(); i++) {
            for (int j = 0; j < stage.getHeight(); j++) {
                if(map[i][j]!=null && map[i][j].getType().contentEquals("Wall"))
                {
                    g.drawLine(i*20, j*20, i*20, j*20);
                }
                
                if(i==21 && j==29) {i=Integer.MAX_VALUE;}
            }
        }
    }
}
