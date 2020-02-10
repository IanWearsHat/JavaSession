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
    String[][] grid;

    Location playerLoc, robotLoc;


    /**
     * Constructor for the game
     */
	public Game()
	{

	    // Initialize the grid
        grid = new String[10][10];

        for (int rows = 0; rows < grid.length; rows++) {
            for (int col = 0; col < grid[rows].length; col++) {
                grid[rows][col] = " ";
            }
        }

        playerLoc = randomEmptyLocation();
        robotLoc = randomEmptyLocation();

	}
	
    /**
     * Queries a location for debris
     * @param loc The location to query
     * @return Returns true if there is debris at location loc.
     */
    public boolean getDebris(Location loc) { 
    	return false;
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
        return null;
    }
    
    /**
     * Accessor for the robot location
     * @return the robot location
     */
    public Location getRobotLoc() {
        return null;
    }
    
    /**
     * Tests if the game is currently won (this is unimportant if the game is also lost)
     * @return true if the game is won
     */
    public boolean isWin() {
        return false;
    }
    
    /**
     * Test if the game is currently lost
     * @return true if the game is lost
     */
    public boolean isLose() {
        return false;
    }
    
    
    /**
     * Given a movement code, update the board.
     * This method will cause the player and robot to make the appropriate moves.
     * @param moveCode
     */
    public void update(int moveCode)
    {
    }
    
    /**
     * This method sets up the board for a new game.
     */
    public void newGame()
    {
        // Clean off the board
        
    	// Fill the board with debris, player, robot
        }
    
    
    
    
    /**
     * This sets whether or not a grid cell contains debris
     * @param loc The grid cell to change
     * @param debris The new debris value for the grid cell
     */
    private void setDebris(Location loc, boolean debris)
    {
    // 10 debris only
    }
    
    
    /**
     * Clear the board.
     */
    private void clear()
    {
    
    }
    
    /**
     * Add debris, player, robot to the board.
     */
    private void populateBoard()
    {
    
    }
    
    
    // Utility functions
    
    /**
     * Ensure that a location is within the board
     * @param loc The location to check
     * @return The location, constrained to be within the board
     */
    private Location boundCheck(Location loc)
    {
        return null;
    }

    /**
     * Obtain a random location within the board
     * @return The random location
     */
    private Location randomLocation()
    {
        return null;
    }

    /**
     * Obtain a random empty location within the board
     * @return The random empty location
     */
    private Location randomEmptyLocation()
    {
        Random coordinate = new Random();
        Location temp;

        int x = coordinate.nextInt(10);
        int y = coordinate.nextInt(10);

        boolean foundFull = false;
        while (!foundFull) {
            for ()

        }

        return temp;
    }
    
}
