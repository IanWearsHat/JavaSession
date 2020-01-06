/*
 * name: Ian Dai
 * date: 12/14/19
 * description: Simple calculator
 * Takes in one operator and two operands from the user
 * It then displays the answer with the given operator 
 */
package project3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Operation: ");
		String u_operation = input.next();
		
		double op1, op2;
		String format = "#0.000";
		DecimalFormat decimalFormat = new DecimalFormat(format);
		
		switch (u_operation) {
		case("+"):
		case("-"):
		case("*"):
		case("/"):
			double[] ops = getOperand(input);
			op1 = ops[0];
			op2 = ops[1];
			switch (u_operation) {
				case("+"):
					System.out.print(op1 + " + " + op2 + " = " + decimalFormat.format(op1+op2));
					break;
				case("-"):
					System.out.print(op1 + " - " + op2 + " = " + decimalFormat.format(op1-op2));
					break;
				case("*"):
					System.out.print(op1 + " * " + op2 + " = " + decimalFormat.format(op1*op2));
					break;
				case("/"):
					if (op2 == 0) {
						System.out.println("Cannot divide by 0.");
						break;
					}
					else {
						System.out.print( op1 + " / " + op2 + " = " + decimalFormat.format(op1/op2));
						break;
					}
			}
			break;
		default: 
			System.out.println("Invalid Operator.");
		}
	}
	
	public static double[] getOperand(Scanner input) {
		System.out.println("Enter Operand 1: ");
		double op1 = input.nextDouble();
		System.out.println("Enter Operand 2: ");
		double op2 = input.nextDouble();
		
		double values[] = new double[2];
		values[0] = op1;
		values[1] = op2;
		return values;
	}
}
