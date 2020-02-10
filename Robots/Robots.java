import java.util.Scanner;
import java.util.Random;

/**
 * CS 180 Project 5 Solution
 * This is a reference implementation of the first part of the Robots project (Project 5).
 * You can use it as a basis for project 6; however, you are strongly encouraged to use your own.
 * The best approach would be to examine this solution, and apply some of its concepts and organization to your own implementation (if needed).

 *
 */


public class Robots {
	/**
	 * Starting point for the Robots game.
     * 
	 * @param args The command line arguments
	 */
	public static void main(String[] args) {
		Game testo = new Game();
		View test = new View(testo);

		System.out.println(test.game);
		//test.print();
	}
}
