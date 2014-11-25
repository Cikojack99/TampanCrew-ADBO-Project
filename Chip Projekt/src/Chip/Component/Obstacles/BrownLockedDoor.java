package Chip.Component.Obstacles;

/**
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah obstacle ini berakibat
 * dengan kematian dengan resInDeath.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class BrownLockedDoor extends Obstacle {
    
    /**
     * Constructor untuk menginisialisasi antiObstacle dan resInDeath
     */
    public BrownLockedDoor()
    {
        this.antiObstacle="brownKey";
        this.resInDeath=false;
        obstacleName="brownDoor";
    }
}
