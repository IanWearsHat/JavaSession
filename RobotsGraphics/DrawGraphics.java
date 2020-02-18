import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics{
    ArrayList<Box> boxList = new ArrayList<Box>();

    private final int rowCount;
    private final int colCount;
    private final int boxSize = 30;
    private final int spaceBetweenBoxes = 10;
    
    Game game;
    public Location playerLoc, robotLoc;
    public Box clickedBox;

    /** Initializes this class for drawing. */
    public DrawGraphics(Game game) {
    	this.game = game;
    	
    	playerLoc = game.getPlayerLoc();
    	robotLoc = game.getRobotLoc();
    	
    	rowCount = game.getNumRows();
    	colCount = game.getNumCols();
    	
    	//drawing of the grid on the window
        int x = (SimpleDraw.WIDTH/2) - ((5 * boxSize + 5 * spaceBetweenBoxes) - (spaceBetweenBoxes / 2));
        int y = 50;
        for (int i = 0; i < rowCount; i++) {
        	
        	for (int j = 0; j < colCount; j++) {

    			boxList.add(new Box(i, j, x, y, boxSize, Color.ORANGE, Color.BLACK));
        		x += boxSize + spaceBetweenBoxes;
        		
        	}
        	y += boxSize + spaceBetweenBoxes;
        	x = (SimpleDraw.WIDTH/2) - ((5 * boxSize + 5 * spaceBetweenBoxes) - (spaceBetweenBoxes / 2));
        }

    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface, int mouseX, int mouseY) {
    	
    	playerLoc = game.getPlayerLoc();
    	robotLoc = game.getRobotLoc();
    	
        for (int i = 0; i < boxList.size(); i++) {
        	//only changes box color if the box is within one space of the player
        	if (Math.abs(boxList.get(i).gridY - playerLoc.getCol()) <= 1 && 
        		Math.abs(boxList.get(i).gridX - playerLoc.getRow()) <= 1) { 
        		if (boxList.get(i).checkCoords(mouseX, mouseY)) {
            		boxList.get(i).clicked = true;
        		}
        		else {
            		boxList.get(i).clicked = false;
            	}
        	}
        	else {
        		boxList.get(i).clicked = false;
        	}
        	
        	//show which box is player, robot, and debris
        	Location debrisTestLoc = new Location(boxList.get(i).gridX, boxList.get(i).gridY);
        	if (boxList.get(i).getLoc().equals(playerLoc)) {
        		boxList.get(i).fillColor = Color.GREEN;
        	}
        	else if (boxList.get(i).getLoc().equals(robotLoc)) {
        		boxList.get(i).fillColor = Color.RED;
        	}
        	else if (game.getDebris(debrisTestLoc)) {
        		boxList.get(i).fillColor = Color.DARK_GRAY;
        	}
        	else {
        		boxList.get(i).fillColor = Color.ORANGE;
        	}
        	
        	boxList.get(i).draw(surface);
        	
        }

    }
    
    /**
     * 
     * @return Box object if any of them are clicked
     */
    public Box getClickedBox() {
    	for (int i = 0; i < boxList.size(); i++) {
    		if (boxList.get(i).clicked == true) {
    			return boxList.get(i);
    		}
    	}
    	return null;
    }
}