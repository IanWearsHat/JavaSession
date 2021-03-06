



/**
 * This class represents a coordinate on the Board
 */
public class Location
{
    public int x, y;
    /**
     * Constructor
     * @param row  This Locations's row
     * @param col  This Locations's column
     */
    public Location(int row, int col)
    {
        x = row;
        y = col;
    }

    /**
     * Get this Location's row
     * @return The row
     */
    public int getRow() { return x; }
    
    /**
     * Get this Location's column
     * @return The column
     */
    public int getCol() { return y; }

    /**
     * Return true if this Location is equal to another Location
     * @param loc The Location to which to compare
     * @return Whether the two Locations are equal
     */
    public boolean equals(Location loc)
    {
    	if (loc == null) {
    	    return false;
        }
    	return (loc.getRow() == x && loc.getCol() == y);
    }
}
