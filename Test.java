/* 
 * Name: Ian Dai
 * Program: Takes in radius and height of 2 cylindrical tanks in centimeters,
 * 			calculates Volume of both tanks and displays the tank with most volume in gallons
 * Date: 12/9/2019
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		JOptionPane window = new JOptionPane();
		String input1 = JOptionPane.showInputDialog("Enter the radius and height of cylindrical tank 1 in centimeters.");
		String input2 = JOptionPane.showInputDialog("Enter the radius and height of cylindrical tank 2 in centimeters.");
		
		double tank1Radius = Double.parseDouble(input1.substring(0, findSpaceIndex(input1)));
		double tank1Height = Double.parseDouble(input1.substring(findSpaceIndex(input1), input1.length()));
		
		double tank2Radius = Double.parseDouble(input2.substring(0, findSpaceIndex(input2)));
		double tank2Height = Double.parseDouble(input2.substring(findSpaceIndex(input2), input2.length()));
		
		double tank1Volume = (Math.PI * tank1Radius * tank1Radius * tank1Height) * 0.000264172052;
		double tank2Volume = (Math.PI * tank2Radius * tank2Radius * tank2Height) * 0.000264172052;
		
		DecimalFormat threeDigits = new DecimalFormat("###,###.000");
		JOptionPane.showMessageDialog(window, "The volume of the largest cylindrical tank is " + threeDigits.format(Math.max(tank1Volume, tank2Volume)));
	}
	
	public static int findSpaceIndex(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				return i;
			}
		}
		return 0;
	}

}
