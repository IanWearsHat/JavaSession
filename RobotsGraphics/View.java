
/**
 * This class represents a "view" of the game board.
 * It contains methods to handle displaying the board.
 */
public class View {
	Game game;
	
    /**
     * Constructor
     * @param game The game to display
     */
	public View(Game game)
	{
		this.game = game;
	}
	
    /**
     * Display the game on the system console
     */
    public void print()
    {
    	int rowCount = game.getNumRows();
    	int colCount = game.getNumCols();
    	Location playerLoc = game.getPlayerLoc();
    	Location robotLoc = game.getRobotLoc();
    	
    	
        printHead();

        for (int rows = 0; rows < rowCount; rows++) {

            System.out.print("|");
            for (int col = 0; col < colCount; col++) {
            	Location loc = new Location(rows, col);
            	
            	String str;
            	
            	if (loc.equals(playerLoc)) {
            		str = "@";
            	}
            	else if (loc.equals(robotLoc)) {
            		str = "+";
            	}
            	else if (game.getDebris(loc)) {
            		str = "*";
            	}
            	else {
            		str = " ";
            	}
                System.out.print(str);
            }
            System.out.println("|");

        }

        printHead();
    }
	
    /**
     * Print out the "header" (i.e., the top and bottom borders)
     */
    private void printHead()
    {
    	int colCount = game.getNumCols();
    	
    	System.out.print("+");
        for (int i = 0; i < colCount; i++) {
        	System.out.print("-");
        }
        System.out.println("+");
    }
    
}

