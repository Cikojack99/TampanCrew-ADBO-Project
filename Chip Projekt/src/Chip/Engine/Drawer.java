package Chip.Engine;

import Chip.Component.Levels.Level;
import Chip.Component.Maps;
import Chip.Component.Player;
import Chip.Gui.Board;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class ini berfungsi untuk mengatur semua keperluan penggambaran terhadap GUI.
 * penggambaran dilakukan dengan ukuran (20pixel x 20pixel) per kotaknya
 * @author TampanCrew arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class Drawer extends JPanel{
    /**
     * atribut untuk menyimpan Graphics2D
     */
    private Graphics2D gd;
    
    /**
     * atribut untuk menyimpan alamat gambar
     */
    private URL imgUrl;
    
    /**
     * atribut untuk menampung gambar item dan obstacle yang akan digambar
     */
    private Image itemInMap;
    
    /**
     * atribut untuk menampung gambar karakter yang akan digambar
     */
    private Image character;
    
    /**
     * atribut untuk menampung peta level yang akan digambar
     */
    private Maps[][] map;
    
    /**
     * atribut untuk menyimpan player
     */
    private Player player;
    
    /**
     * atribut untuk menyimpan nama gambar yang akan digunakan
     */
    private String picName="tegel.jpg";
    
    /**
     * atribut untuk menyimpan typeKind yang akan dicari dari isi Maps[][]
     */
    private String typeKind="wall";
    
    /**
     * atribut untuk menyimpan level yang akan digambar
     */
    private Level level;
    
    /**
     * atribut untuk menyimpan arah yang dihadapi oleh character
     * up adalah posisi atas layar
     */
    private String orientation="right";
    
    /**
     * constractor dari Drawer
     * method ini berfungsi untuk menginisialisasi level, board dan player
     * @param stage adalah level yang akan digambar
     * @param board adalah GUI yang akan dimasukan kelas ini kedalam salah satu frame nya
     * @param player adalah player yang akan digambar
     */
    public Drawer(Level stage, Board board, Player player) {
        level = stage;
        level.initializeLevel();
        map = level.getMaps();
        this.player = player;
        repaint();
        JFrame f = new JFrame("Maling Challenge By Tampan Crew Member (Harseto & Alvin)");
        f.getContentPane().add(this);
        f.pack();
        f.setSize(620,483);
        f.setVisible(true);
        board.setGameFrame(this);
        f.setVisible(false);
    }
    
    /**
     * method ini berfungsi untuk mengupdate isi dari level, dan player
     * @param stage adalah level baru yang akan digambar
     * @param player adalah player baru yang akan digambar
     */
    public void updateDrawer(Level stage, Player player)
    {
        this.level=stage;
        level.initializeLevel();
        map=level.getMaps();
        this.player=player;
        orientation="right";
        repaint();
    }
    
    @Override
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
        drawDeleteItem();
        rotateCharacther(orientation);
    }

    /**
     * menggambar isi dari level ini
     * @param picName nama file gambar yang akan digunakan
     * @param type jenis tipe apa yang akan digambar
     */    
    private void drawItem(String picName, String type)
    {
        imgUrl = getClass().getClassLoader().getResource(picName);
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(type))
                {
                    gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                }
            }
        } 
    }

    /**
     * method yang dipanggil untuk menggambar level bila ada item yang menghilang
     * method ini akan memanggil method drawItem(String picName, String typeKind) dan drawObstacle(String picName, String typeKind)
     */
    private void drawDeleteItem() {
        drawItem("brick.jpg", "wall");
        drawItem("diamond.png", "diamond");
        drawObstacle("white", "silverDoor");
        drawObstacle("green", "greenDoor");
        drawObstacle("brown", "brownDoor");
        drawObstacle("exit", "FinishLineDoor");
        drawItem("guard.png", "guardian");
        drawItem("white key.jpg", "silverKey");
        drawItem("green key.jpg", "greenKey");
        drawItem("brown key.png", "brownKey");
        drawItem("armor.jpg", "mirrorArmor");
        drawItem("boot.jpg", "silentBoots");
        drawObstacle("laser", "laser");
    }
    
    /**
     * method yang dipanggil untuk menggambar level bila ada item yang menghilang
     * method ini akan memanggil method drawDeletedItem()
     * @param i koordinat x dalam Maps[][] yang akan dihapus
     * @param j koordinat y dalam Maps[][] yang akan dihapus
     */
    public void drawDeletedItem(int i, int j) {
        map[i][j]=null;
        drawDeleteItem();
    }
    
    /**
     * menggambar ulang character dengan character yang sudah berubah arah
     * @param direction arah yang dihadap oleh character
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
    
    /**
     * method untuk menggambar obstacle yang ada di level
     * gambar harus dalam format .jpg
     * gambar pintu harus : <warna> door wide.jpg,, dan <warna> door long.jpg 
     * @param picName nama file gambar. untuk pintu tulis warna nya saja
     * @param typeKind jenis dari obstacle yang akan digambar
     */
    private void drawObstacle(String picName, String typeKind) {
        String pic="";
        if(typeKind.contains("Door"))
        {
            pic = picName+" door wide.jpg";
        } else {
            pic = picName+".jpg";
        }
        imgUrl = getClass().getClassLoader().getResource(pic);
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(typeKind))
                {
                    int size=0;
                    if(map[i][j+1]!=null && map[i][j+1].getTypeKind().contains(typeKind))
                    {
                        for (int k = j+1; k < 22; k++) {
                            if(map[i][k]!=null && map[i][k].getTypeKind().contains(typeKind))
                            {
                                size++;
                            } else {
                                j=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, i*20, (j-(size+1))*20, 20, (size+1)*20, null);
                    }
                    else if((map[i][j+1]!=null && !map[i][j+1].getTypeKind().contains(typeKind)) || (map[i+1][j]==null))
                    {
                        gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                    }
                }
            }
        }
        
        if(typeKind.contains("Door"))
        {
            pic = picName+" door long.jpg";
        } else {
            pic = picName+"Datar.jpg";
        }
        imgUrl = getClass().getClassLoader().getResource(pic);
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(typeKind))
                {
                    int size=0;
                    if((i+1) < 30 && map[i+1][j]!=null && map[i+1][j].getTypeKind().contains(typeKind))
                    {
                        for (int k = i+1; k < 22; k++) {
                            if(map[k][j]!=null && map[k][j].getTypeKind().contains(typeKind))
                            {
                                size++;
                            } else {
                                i=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, (i-(size+1))*20, j*20, (size+1)*20, 20, null);
                    } else if((map[i][j+1]==null) && (map[i+1][j]!=null && !map[i+1][j].getType().contains(typeKind)))
                    {
                        gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                    }
                }
            }
        }
    }
    
    /**
     * method ini berfungsi untuk menggambar character agar menghadap arah yang diinginkan
     * @param direction arah yang diinginkan
     */
    public void rotateChar(String direction)
    {
        this.orientation=direction;
        repaint();
    }
    
    /**
     * method untuk menggambar jalur jalur rahasia dalam level
     */
    public void drawSecret()
    {
        repaint();
    }
}
