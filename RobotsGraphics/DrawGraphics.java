import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class DrawGraphics {
    BouncingBox box1, box2, box3, box4;
    ArrayList<BouncingBox> boxList = new ArrayList<BouncingBox>();
    ArrayList<BouncingCircle> circleList = new ArrayList<BouncingCircle>();
    Random random;
    int[] xCoords = new int[]{100, 150, 200};
    int[] yCoords = new int[]{100, 250, 200};

    private final int rowCount = 10;
    private final int colCount = 10;
    private final int debrisCount = 10;
    boolean[][] grid;
    private Location playerLoc, robotLoc;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        random = new Random();
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                //boxList.add(new BouncingBox(random.nextInt(250), random.nextInt(250), Color.ORANGE));
//                circleList.add(new BouncingCircle(random.nextInt(250), random.nextInt(250), Color.ORANGE));
//            }
//            else {
//               // boxList.add(new BouncingBox(random.nextInt(250), random.nextInt(250), Color.CYAN));
//                circleList.add(new BouncingCircle(random.nextInt(250), random.nextInt(250), Color.CYAN));
//            }
//
//            //boxList.get(i).setMovementVector(random.nextInt(10), random.nextInt(10));
//            circleList.get(i).setMovementVector(random.nextInt(10), random.nextInt(10));
//        }

    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface, int mouseX, int mouseY) {
        if (mouseX > 50) {
            System.out.println("YAY");
        }

        surface.drawLine(50, 50, 250, 250);
        for (int i = 0; i < circleList.size(); i++) {
            //boxList.get(i).draw(surface);
            //circleList.get(i).draw(surface);
        }

//        surface.setColor(Color.CYAN);
//        surface.fillOval(50, 50, 20, 30);
//        surface.setColor(Color.BLACK);
//        surface.drawOval(50, 50, 20, 30);
//        surface.drawPolygon(xCoords, yCoords, 3);
    }
}