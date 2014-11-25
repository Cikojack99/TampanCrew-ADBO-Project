package Chip.Component.Obstacles;

/**
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah inheritance dari Obstacle
 * berakibat dengan kematian dengan resInDeath.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
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
        return this.antiObstacle;
    }
    
    /**
     * 
     * Mengembalikan boolean resInDeath yang ada di obstacle ini.
     * @return resInDeath
     */
    public boolean getResInDeath()
    {
        return this.resInDeath;
    }
}