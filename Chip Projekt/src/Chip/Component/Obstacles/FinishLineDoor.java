package Chip.Component.Obstacles;

/**
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah obstacle ini berakibat
 * dengan kematian dengan resInDeath.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class FinishLineDoor extends Obstacle {
     
    /**
     * Constructor untuk menginisialisasi antiObstacle dan resInDeath
     */
    public FinishLineDoor()
    {
        this.antiObstacle="5 diamond";
        this.resInDeath=false;
        obstacleName="FinishLineDoor";
    }
    
}
