

/**
 * This class represents a regular, slow robot in the game.
 *
 */
public class Robot
{
    /**
     * Performs this robot's "artificial intelligence", producing a new Location.
     * @param oldLoc The previous location of this robot.
     * @param playerLoc The player's current location
     * @return The new location of this robot
     */
    public static Location getNewLocation(Location oldLoc, Location playerLoc)
    {
    	int newRow = oldLoc.getRow();
    	int newCol = oldLoc.getCol();
    	
    	if (playerLoc.getRow() > oldLoc.getRow()) {
    		newRow++;
    	}
    	if (playerLoc.getRow() < oldLoc.getRow()) {
    		newRow--;
    	}
    	
    	
    	if (playerLoc.getCol() > oldLoc.getCol()) {
    		newCol++;
    	}
    	if (playerLoc.getCol() < oldLoc.getCol()) {
    		newCol--;
    	} 
    	
        return new Location(newRow, newCol);
    }
}
