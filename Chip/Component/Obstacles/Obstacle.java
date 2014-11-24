/*
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah inheritance dari Obstacle
 * berakibat dengan kematian dengan resInDeath.
 */

package Chip.Component.Obstacles;

/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.5 BETA
 */
public abstract class Obstacle {
    /**
     * Sebuah String yang menyimpan id item yang bisa membuat obstacle bisa dilewatin.
     */
    protected String antiObstacle;
    /**
     * Sebuah boolean apakah sebuah obstacle berakibat di kematian player atau tidak, true jika iya, dan 
     * false jika tidak.
     */
    protected boolean resInDeath;
    
    /**
     * Mengembalikan String antiObstacle yang ada di obstacle ini.
     * @return antiObstacle
     */
    public String getAntiObstacle()
    {
        return antiObstacle;
    }
    
    /**
     * 
     * Mengembalikan boolean resInDeath yang ada di obstacle ini.
     * @return resInDeath
     */
    public boolean getResInDeath()
    {
        return resInDeath;
    }
}