package Chip.Component.Obstacles;

/**
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah obstacle ini berakibat
 * dengan kematian dengan resInDeath.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class SleepingGuardRadius extends Obstacle {
     
     /**
     * Constructor untuk menginisialisasi antiObstacle dan resInDeath
     */
    public SleepingGuardRadius()
    {
        this.antiObstacle="silentBoots";
        this.resInDeath=true;
        obstacleName="sleepingGuardRadius";
    }
}
