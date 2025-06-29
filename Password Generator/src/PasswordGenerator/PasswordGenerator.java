package PasswordGenerator;
import java.util.Scanner;
import java.util.Random;
public class PasswordGenerator {

	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Enter desired password length: ");
		int length = scan.nextInt();
		
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String symbols = "!@#$%^&*()_+[]{};:,.<>?/";
		
		String allChars = upperCase + lowerCase + digits + symbols;
		
		StringBuilder password = new StringBuilder();
		
		password.append(upperCase.charAt(random.nextInt(upperCase.length())));
		
	    password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
		
	    password.append(digits.charAt(random.nextInt(digits.length())));
	    
	    password.append(symbols.charAt(random.nextInt(symbols.length())));
	    
	    for(int i=4; i < length; i++) {
	    	password.append(allChars.charAt(random.nextInt(allChars.length())));
	    }
	    

	    char[] pwdArray = password.toString().toCharArray();
	    
	    for(int i=0; i<pwdArray.length; i++) {
	    	int randomindex = random.nextInt(pwdArray.length);
	    	
	    	//simple swap logic
	    	char temp = pwdArray[i];
	    	pwdArray[i] = pwdArray[randomindex];
	    	pwdArray[randomindex] = temp;
	    }
	    
	    String finalPassword = new String(pwdArray);
	    
	    System.out.println("Generated Password: " + finalPassword);
	    
	    
	}

}
