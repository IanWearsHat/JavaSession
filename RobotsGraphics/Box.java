import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Box {
    int x;
    int y;
    int gridX;
    int gridY;
    private Location loc;
    
    Color fillColor;
    Color outlineColor;
    int size;
    
    boolean clicked = false;
    
    /**
     * Initialize a new box with its center located at (startX, startY), filled
     * with startColor.
     */
    public Box(int gridX, int gridY, int startX, int startY, int size, Color fillColor, Color outLineColor) {
        x = startX;
        y = startY;
        this.gridX = gridX;
        this.gridY = gridY;
        this.fillColor = fillColor;
        this.outlineColor = outLineColor;
        this.size = size;
        
        loc = new Location(gridX, gridY);
    }
    
    /**
     * 
     * @param mouseX
     * @param mouseY
     * @return true if coordinates are in box, otherwise return false
     */
    public boolean checkCoords(int mouseX, int mouseY) {
    	if (this.x <= mouseX && this.x + size >= mouseX && this.y <= mouseY && this.y + size >= mouseY) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public Location getLoc() {
    	return loc;
    }
    /** Draws the box at its current position on to surface. */
    public void draw(Graphics surface) {
    	if (this.clicked == true) {
    		outlineColor = Color.MAGENTA;
    	}
    	else {
    		outlineColor = Color.BLACK;
    	}
// Draw the object
        surface.setColor(fillColor);
        surface.fillRect(x, y, size, size);
        surface.setColor(outlineColor);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawRect(x, y, size, size);

    }

}