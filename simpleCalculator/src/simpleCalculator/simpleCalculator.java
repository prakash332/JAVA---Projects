package simpleCalculator;

import java.util.Scanner;

public class simpleCalculator {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int num1 = scan.nextInt();
		
		System.out.print("Enter second number: ");
		int num2 = scan.nextInt();
		
		System.out.println("Enter operator (+, -, *, /, %): ");
		char op = scan.next().charAt(0);//Read the operator first character only
		
		//call the calculate method with inputs 
		int result = calculate(num1, num2, op);
		
		System.out.println("Result: " + result);
	}
		
		public static int calculate(int num1, int num2, char op) {
			int result = 0;
			
			switch(op) {
			case '+':
				result = num1 + num2;
				break;
				
			case '-':
				result = num1 - num2;
				break;	
			
			case '*':
				result = num1 + num2;
				break;
				
			case '/':
				if(num2 != 0) {
					result = num1 / num2;
				}else {
					System.out.println("Error cannot divide by zero.");
				}
				break;
				
			case '%':
				if(num2 != 0) {
					result = num1 % num2;
				}else {
					System.out.println("Error cannot mod by zero.");
				}
				break;
				
			default:
				System.out.println("Invalid operator!");
				
			
			}
			return result;
			
	}

	
}

