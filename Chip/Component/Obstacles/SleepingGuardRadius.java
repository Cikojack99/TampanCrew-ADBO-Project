/*
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah obstacle ini berakibat
 * dengan kematian dengan resInDeath.
 */

package Chip.Component.Obstacles;

/**
 *
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 0.5 BETA
 */
public class SleepingGuardRadius extends Obstacle {
     
     /**
     * Constructor untuk menginisialisasi antiObstacle dan resInDeath
     */
    public SleepingGuardRadius()
    {
        antiObstacle="silentBoots";
        resInDeath=true;
        obstacleName="sleepingGuardRadius";
    }
}
