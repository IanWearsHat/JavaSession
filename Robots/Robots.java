package project5;

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
		Game game = new Game();
		View view = new View(game);
		Scanner input = new Scanner(System.in);
		
		game.newGame();
		
		while(true) {
			
			view.print();
			
			if (game.isWin()) {
				System.out.println("You win!");
				break;
			}
			if (game.isLose()) {
				System.out.println("You lose!");
				break;
			}
			
			System.out.print("\nPlease input a number on the number pad: ");
			
			int moveCode = input.nextInt();
			
			if (moveCode < 0) {
				return;
			}
			
			game.update(moveCode);
			
		}
		
	}
}
