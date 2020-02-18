


import java.util.Random;
import java.util.Arrays;

/**
 * The data of the Game, with methods for updating this data and applying game logic.
 * 
 * This is the Model in a Model-View-Controller architecture.
 */
public class Game
{
    private final int rowCount = 10;
    private final int colCount = 10;
    private final int debrisCount = 15;
    boolean[][] grid;
    public Location playerLoc, robotLoc;


    /**
     * Constructor for the game
     */
	public Game()
	{

	    // Initialize the grid
        grid = new boolean[10][10];

	}
	
    /**
     * Queries a location for debris
     * @param loc The location to query
     * @return Returns true if there is debris at location loc.
     */
    public boolean getDebris(Location loc) { 
    	
    	return grid[loc.getRow()][loc.getCol()];
    }
    
    /**
     * Accessor for number of rows
     * @return number of rows
     */
    public int getNumRows() {
        return rowCount;
    }
    
    /**
     * Accessor for number of columns
     * @return number of columns
     */
    public int getNumCols() {
        return colCount;
    }
    
    /**
     * Accessor for the player location
     * @return the player location
     */
    public Location getPlayerLoc() {
        return playerLoc;
    }
    
    /**
     * Accessor for the robot location
     * @return the robot location
     */
    public Location getRobotLoc() {
        return robotLoc;
    }
    
    /**
     * Tests if the game is currently won (this is unimportant if the game is also lost)
     * @return true if the game is won
     */
    public boolean isWin() {
        return robotLoc == null;
    }
    
    /**
     * Test if the game is currently lost
     * @return true if the game is lost
     */
    public boolean isLose() {
        return playerLoc.equals(robotLoc) || getDebris(playerLoc);
    }
    
    
    /**
     * Given a movement code, update the board.
     * This method will cause the player and robot to make the appropriate moves.
     * @param moveCode
     */
    public void update(int moveCode)
    {
    	//direction may be inverted based on the grid layout
    	int vertDir = 0;
    	int horDir = 0;
    	
    	switch(moveCode) {
    	case(0):
    		playerLoc = randomEmptyLocation();
    		break;
    	case(1):
    		vertDir = 1;
    		horDir = -1;
    		break;
    	case(2):
    		vertDir = 1;
    		horDir = 0;
    		break;
    	case(3):
    		vertDir = 1;
    		horDir = 1;
    		break;
    	case(4):
    		vertDir = 0;
    		horDir = -1;
    		break;
    	case(5):
    		vertDir = 0;
	    	horDir = 0;
	    	break;
    	case(6):
	    	vertDir = 0;
	    	horDir = 1;
	    	break;
    	case(7):
    		vertDir = -1;
	    	horDir = -1;
	    	break;
    	case(8):
    		vertDir = -1;
	    	horDir = 0;
	    	break;
    	case(9):
    		vertDir = -1;
	    	horDir = 1;
	    	break;
    	default:
    		vertDir = 0;
   			horDir = 0;
   			break;
    	}
    	
    	Location newLoc = new Location(
    			playerLoc.getRow() - vertDir,
    			playerLoc.getCol() + horDir
    			);
    	
    	playerLoc = boundCheck(newLoc);
    	
    	robotLoc = Robot.getNewLocation(robotLoc, playerLoc);
    	
    	if (getDebris(robotLoc)) {
    		robotLoc = null;
    	}

    }
    
    /**
     * This method sets up the board for a new game.
     */
    public void newGame()
    {
        // Clean off the board
        clear();
    	// Fill the board with debris, player, robot
        populateBoard();
        }
    
    
    
    
    /**
     * This sets whether or not a grid cell contains debris
     * @param loc The grid cell to change
     * @param debris The new debris value for the grid cell
     */
    private void setDebris(Location loc, boolean debris)
    {
    	grid[loc.getRow()][loc.getCol()] = debris;
    }
    
    
    /**
     * Clear the board.
     */
    private void clear()
    {
    	playerLoc = null;
    	robotLoc = null;
    	
    	for (int row = 0; row < rowCount; row++) {
    		Arrays.fill(grid[row], false);
    	}
    	
    }
    
    /**
     * Add debris, player, robot to the board.
     */
    private void populateBoard()
    {
    	for (int i = 0; i < debrisCount; i++) {
    		setDebris(randomEmptyLocation(), true);
    	}
    	
        playerLoc = randomEmptyLocation();
        robotLoc = randomEmptyLocation();
    }
    
    
    // Utility functions
    
    /**
     * Ensure that a location is within the board
     * @param loc The location to check
     * @return The location, constrained to be within the board
     */
    private Location boundCheck(Location loc)
    {
        return new Location(
        		Math.max(0, Math.min(loc.getRow(), rowCount - 1)),
        		Math.max(0, Math.min(loc.getCol(), colCount - 1))
        		);
    }

    /**
     * Obtain a random location within the board
     * @return The random location
     */
    private Location randomLocation()
    {
        Random coordinate = new Random();
        Location temp;
        
        int x = coordinate.nextInt(rowCount);
        int y = coordinate.nextInt(colCount);
        
        temp = new Location(x, y);
        
        return temp;
    }

    /**
     * Obtain a random empty location within the board
     * @return The random empty location
     */
    public Location randomEmptyLocation()
    {
        Location temp;
        
        do {
            temp = randomLocation();
        } while (getDebris(temp) || temp.equals(robotLoc) || temp.equals(playerLoc));

        return temp;
    }
    
    public void setLocation(String location, Location newLocation) {
    	if (location == "player") {
    		playerLoc = newLocation;
    	}
    	else if (location == "robot") {
    		robotLoc = newLocation;
    	}
    }
    
}

