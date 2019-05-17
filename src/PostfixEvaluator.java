import java.io.*;
import java.util.Scanner;
/**
* This is the PostfixEvaluator that implements LinkedList
*
* @author Amelia Tran
* @version 3/20/2019
*/

public class PostfixEvaluator {
	// declare global variables
	private static boolean add, substract, multiply, divide;

	/** main method to do the analysis work via an evaluation object
	* @param args -main method argument
	*/
	public static void main (String[] args) throws FileNotFoundException {	
		// declare local variables
		StackLL<Integer> stackData = new StackLL<Integer>();
		String token, expr, operator = "";
		int right, left, res, operand = 0; 
		Scanner parser;
		Integer val = new Integer(0);
		File infile = new File(args[0]);
				
		Scanner dataIn = new Scanner(infile);
		// read the data file
		while (dataIn.hasNext()) {
			expr = dataIn.nextLine();
			parser = new Scanner(expr);
		

		// read the tokens
		while (parser.hasNext()) {
			token = parser.next();
			// if the token is an operator, perform the appropriate math operation
			if (isOperator()) {
				right = stackData.pop();
				left = stackData.pop();

				// evaluate individual computations
				if (add) {
					res = left + right;
					add = false;
				} else if (substract) {
					res = left - right;
					substract = false;
				} else if (multiply) {
					res = left * right;
					multiply = false;
				} else if (divide) {
					res = left / right;
					divide = false;
				}
				stackData.push(res); // push the result into the stack
			} // if the token is an operand, convert into interger  
			
			else {
				val = Integer.parseInt(token);
				operand = val.intValue(); 
				stackData.push(operand); // push the integer into the stack
			}	
		
		// print out the expression and the result
		System.out.println(expr+" results in "+res);
		}
	}

	/** boolean method to check if the token is an operator
	* @return true if it's an operator, false otherwise
	*/
	public static boolean isOperator() {
		// convert the character to string
		char firstChar = token.charAt(0);
		operator = String.valueOf(firstChar);
		
		if (operator.equals("+")) {
			add = true;
			return true;
		} else if (operator.equals("-")) {
			substract = true;
			return true;
		} else if (operator.equals("*")) {
			multiply = true;
			return true;
		} else if (operator.equals("/")) {
			divide = true;
			return true;
		} else {
			return false;
		}
	}
}

