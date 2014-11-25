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
public class SleepingGuard extends Obstacle {
 
     /**
     * Constructor untuk menginisialisasi antiObstacle dan resInDeath
     */
    public SleepingGuard()
    {
        antiObstacle="none";
        resInDeath=true;
        obstacleName="guardian";
    }
}
