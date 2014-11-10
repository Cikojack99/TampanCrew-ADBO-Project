/*
 * Class untuk mengandalikan movement player dan pergerakan player.
 */

package Chip.Component;
import java.awt.Point;

/**
 *
 * @author TampanCrew Arts
 * @version 0.01 ALPHA
 */
public class Player {
    
    private Point currentPosition;
    private Item[] inventory;
    
    public Player(Point startingPosition)
    {
        currentPosition=startingPosition;
    }
    
    public Point move(int direction)
    {
        if(direction==0)
        {
            currentPosition.move((int)currentPosition.getX()+1, (int)currentPosition.getY());
        }
        else if(direction==1)
        {
            currentPosition.move((int)currentPosition.getX()-1, (int)currentPosition.getY());
        }
        else if(direction==2)
        {
            currentPosition.move((int)currentPosition.getX(), (int)currentPosition.getY()-1);
        }
        else if(direction==3)
        {
            currentPosition.move((int)currentPosition.getX(), (int)currentPosition.getY()+1);
        }
        return currentPosition;
    }
    
    public Point getCurPosition()
    {
        return currentPosition;
    }
}
