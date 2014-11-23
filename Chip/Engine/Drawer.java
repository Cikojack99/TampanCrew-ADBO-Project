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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Caustri Kennel
 */
public class Drawer extends JPanel{
    private Graphics2D gd;
    private URL imgUrl;
    private Image itemInMap;
    private Image character;
    private Maps[][] map;
    private AffineTransform at;
    private Player player;
    private String picName="tegel.jpg";
    private String type="wall";
    int delX=0;
    int delY=0;
    String orientation="right";
    
    public Drawer(Level stage, JPanel panel, Player player) {
        panel.add(this);
        Level level = stage;
        level.initializeLevel();
        map = level.getMaps();
        at = new AffineTransform();
        this.player = player;
        repaint();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setSize(750,600);
        frame.setVisible(true);
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
        drawDeletedItem(delX, delY);
        rotateCharacther(orientation);
    }

    /**
     * menggambar isi dari level ini
     * @param picName nama file gambar yang akan digunakan
     * @param type jenis tipe apa yang akan digambar
     */    
    private void drawLevel(String picName, String type)
    {
        imgUrl = getClass().getClassLoader().getResource(picName);
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        String xxx="";
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]==null)
                {
                    xxx="null, "+i+" , "+j;
                } else {
                    xxx= map[i][j].getType();
                }
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(type))
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
        drawLevel("brick.jpg", "wall");
        drawLevel("diamond.png", "diamond");
//        drawLevel(".png", "silverDoor");
//        drawLevel(".png", "greenDoor");
//        drawLevel(".png", "brownDoor");
//        drawLevel(".png", "FinishLineDoor");
//        drawLevel(".png", "guardian");
//        drawLevel(".png", "silverKey");
//        drawLevel(".png", "greenKey");
//        drawLevel(".png", "brownKey");
//        drawLevel(".png", "mirrorArmor");
//        drawLevel(".png", "silentBoots");
        drawLaser();
    }
    
    /**
     * menggambar ulang level dengan character yang sudah berubah arah
     * @param direction 
     */
    public void rotateCharacther(String direction)
    {
        String pic = "char "+direction+".png";
        imgUrl = getClass().getClassLoader().getResource(pic);
        try {
            character = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        gd.drawImage(character, (int)player.getCurPosition().getX()*20, (int)player.getCurPosition().getY()*20, 20, 20, null);
    }
    
    public void hover(String direction, int xAksen1, int yAksen1)
    {
        int x = (int)player.getCurPosition().getX()*20;
        int y = (int)player.getCurPosition().getY()*20;
        int xAksen = xAksen1*20;
        int yAksen = yAksen1*20;
        String pic = "hover "+direction+".png";
        imgUrl = getClass().getClassLoader().getResource(pic);
        try {
            character = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Thread thread = new Thread();
        thread.start();
        if(direction.equalsIgnoreCase("left"))
        {
            for (int i = x; i >= xAksen; i--) {
                try {
                    thread.sleep(100);
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            rotateChar(direction);
        } else if(direction.equalsIgnoreCase("right"))
        {
            for (int i = x; i <= xAksen; i++) {
                try {
                    thread.sleep(100);
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            rotateChar(direction);
        } else if(direction.equalsIgnoreCase("up"))
        {
            for (int i = y; i >= yAksen; i--) {
                try {
                    thread.sleep(100);
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            rotateChar(direction);
        } else if(direction.equalsIgnoreCase("down"))
        {
            for (int i = y; i <= yAksen; i++) {
                try {
                    thread.sleep(100);
                    drawDeletedItem(0, 0);
                    gd.drawImage(character, x, y, 20, 20, null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            rotateChar(direction);
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
                if(map[i][j]!=null && map[i][j].getTypeKind().contains("laser"))
                {
                    int size=0;
                    if(map[i][j+1]!=null && map[i][j+1].getTypeKind().contains("laser"))
                    {
                        for (int k = j+1; k < 22; k++) {
                            if(map[i][k]!=null && map[i][k].getTypeKind().contains("laser"))
                            {
                                size++;
                            } else {
                                j=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, i*20, (j-(size+1))*20, 20, (size+1)*20, null);
                    }
                    else if((map[i][j+1]!=null && !map[i][j+1].getTypeKind().contains("laser")) && (map[i+1][j]==null))
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
                if(map[i][j]!=null && map[i][j].getTypeKind().contains("laser"))
                {
                    int size=0;
                    if(map[i+1][j]!=null && map[i+1][j].getTypeKind().contains("laser"))
                    {
                        for (int k = i+1; k < 22; k++) {
                            if(map[k][j]!=null && map[k][j].getTypeKind().contains("laser"))
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
    
    public void rotateChar(String direction)
    {
        this.orientation=direction;
        repaint();
    }
}
