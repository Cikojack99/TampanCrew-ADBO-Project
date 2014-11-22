/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Engine;

import Chip.Component.Levels.Level;
import Chip.Component.Levels.LevelZero;
import Chip.Component.Maps;
import java.awt.*;
import java.awt.geom.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
        stage.initializeLevel();
        Maps[][] map = stage.getMaps();
        URL imgUrl = getClass().getClassLoader().getResource("tegel.jpg");
        Image img = null;
        try {
            img = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 601; i+=100) {
            for (int j = 0; j < 440; j+=100) {
                g.drawImage(img, i, j, 100, 100, null);
            }
        }
        
        
        imgUrl = getClass().getClassLoader().getResource("chip.jpg");
        img = null;
        try {
            img = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getType().equalsIgnoreCase("Wall"))
                {
                    g.drawImage(img, i*20, j*20, 20, 20, null);
                }
                
                if(i==21 && j==29) {i=Integer.MAX_VALUE;}
            }
        }
    }
}
