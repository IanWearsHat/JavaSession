
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
        printHead();

        for (int rows = 0; rows < game.grid.length; rows++) {

            System.out.print("|");
            for (int col = 0; col < game.grid[rows].length; col++) {
                System.out.print(game.grid[rows][col]);
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
        System.out.println("+----------+");
    }
    
}
