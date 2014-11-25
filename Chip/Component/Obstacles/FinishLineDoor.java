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
public class FinishLineDoor extends Obstacle {
     
    /**
     * Constructor untuk menginisialisasi antiObstacle dan resInDeath
     */
    public FinishLineDoor()
    {
        antiObstacle="5 Diamond";
        resInDeath=false;
        obstacleName="FinishLineDoor";
    }
    
}
