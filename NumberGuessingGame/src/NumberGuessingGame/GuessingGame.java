package NumberGuessingGame;


import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int randomNumber = random.nextInt(100)+1;
		int guess = 0;
		int attempts = 0;
		int maxAttempts = 5;
		
		System.out.println("Welcome to the Number Guessing Game!...");
		System.out.println("I'm thinking of a number between 1 and 100.");
		System.out.println("You have " + maxAttempts + " tries to guess it!");
		
		while(attempts < maxAttempts) {
			System.out.println("Enter your guess: ");
			guess = scan.nextInt();
			attempts++;
			
			if(guess == randomNumber) {
				System.out.println("Congragulations! you guessed it in " + attempts + " tries.");
				break;
			}else if(guess < randomNumber){
				System.out.println("Too low! TryAgain.");
			}else {
				System.out.println("Too high! Try Again.");
			}
		}
		
		if(attempts == maxAttempts) {
			System.out.println("Sorry, you've used all your attempts.");
			System.out.println("The correct number was: " + randomNumber);
		}
		
		scan.close();
	}
}

