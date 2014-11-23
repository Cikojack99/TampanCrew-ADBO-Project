/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Engine;

import Chip.Component.Levels.Level;
import Chip.Component.Maps;
import Chip.Component.Player;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
    JPanel panel;
    Graphics2D gd;
    URL imgUrl;
    Image itemInMap;
    Image character;
    Maps[][] map;
    AffineTransform at;
    Player player;
    
    public Drawer(Level stage, JPanel panel, Player player) {
        Level level = stage;
        this.panel = panel;
        level.initializeLevel();
        map = level.getMaps();
        at = new AffineTransform();
        this.player = player;
        
        for (int i = 0; i < 601; i+=100) {
            for (int j = 0; j < 440; j+=100) {
                if(map[i][j]==null)
                {
                    drawDeletedItem(i, j);
                    i=Integer.MAX_VALUE;
                    j=i;
                }
            }
        }
        panel.add(this);
    }
    
    @Override
    /**
     * menggambar background
     */
    public void paintComponent(Graphics g)
    {
        gd = (Graphics2D)g;
        imgUrl = getClass().getClassLoader().getResource("tegel.jpg");
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 601; i+=100) {
            for (int j = 0; j < 440; j+=100) {
                gd.drawImage(itemInMap, i, j, 100, 100, null);
            }
        }
        
        imgUrl = getClass().getClassLoader().getResource("char kanan.jpg");
        character = null;
        try {
            character = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * menggambar isi dari level ini
     * @param picName nama file gambar yang akan digunakan
     * @param type jenis tipe apa yang akan digambar
     */
    private void drawLevel(String picName, String type) {
        imgUrl = getClass().getClassLoader().getResource(picName);
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getType().contains(type))
                {
                    gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                }
            }
        }    
    }

    /**
     * method yang dipanggil untuk menggambar level bila ada item yang menghilang
     * method ini akan memanggil method drawLevel()
     * @param i koordinat x yang akan dihapus 
     * @param j koordinat y yang akan dihapus
     */
    public void drawDeletedItem(int i, int j) {
        map[i][j]=null;
        drawLevel("brick.jpg", "Wall");
        drawLevel("diamond.png", "diamond");
        drawLevel(".png", "silverDoor");
        drawLevel(".png", "greenDoor");
        drawLevel(".png", "brownDoor");
        drawLevel(".png", "FinishLineDoor");
        drawLevel(".png", "guardian");
        drawLevel(".png", "silverKey");
        drawLevel(".png", "greenKey");
        drawLevel(".png", "brownKey");
        drawLevel(".png", "mirrorArmor");
        drawLevel(".png", "silentBoots");
        drawLaser();
    }
    
    public void rotateChar(String direction)
    {
        String pic = "char "+direction+".jpg";
        imgUrl = getClass().getClassLoader().getResource(pic);
        try {
            character = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void hover(int xAksen, int yAksen)
    {
        int x = (int)player.getCurPosition().getX();
        int y = (int)player.getCurPosition().getY();
        if(x==xAksen)
        {
            if(y>yAksen)
            {
                for (int i = y; i >= yAksen; i--) {
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                }
            } else {
                for (int i = y; i <= yAksen; i++) {
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                }
            }
        } else {
            if(x>xAksen)
            {
                for (int i = x; i >= xAksen; i--) {
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                }
            } else {
                for (int i = x; i <= xAksen; i++) {
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                }
            }
        }
    }

    private void drawLaser() {
        imgUrl = getClass().getClassLoader().getResource("laser.jpg");
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getType().contains("laser"))
                {
                    int size=0;
                    if(map[i][j+1]!=null && map[i][j+1].getType().contains("laser"))
                    {
                        for (int k = j+1; k < 22; k++) {
                            if(map[i][k]!=null && map[i][k].getType().contains("laser"))
                            {
                                size++;
                            } else {
                                j=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, i*20, (j-(size+1))*20, 20, (size+1)*20, null);
                    }
                    else if((map[i][j+1]!=null && !map[i][j+1].getType().contains("laser")) && (map[i+1][j]==null))
                    {
                        gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                    }
                }
            }
        }
        
        imgUrl = getClass().getClassLoader().getResource("laserDatar.jpg");
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getType().contains("laser"))
                {
                    int size=0;
                    if(map[i+1][j]!=null && map[i+1][j].getType().contains("laser"))
                    {
                        for (int k = i+1; k < 22; k++) {
                            if(map[k][j]!=null && map[k][j].getType().contains("laser"))
                            {
                                size++;
                            } else {
                                i=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, (i-(size+1))*20, j*20, (size+1)*20, 20, null);
                    } else if((map[i][j+1]==null) && (map[i+1][j]!=null && !map[i+1][j].getType().contains("laser")))
                    {
                        gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                    }
                }
            }
        }
    }
}
