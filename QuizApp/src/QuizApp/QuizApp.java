package QuizApp;
import java.util.Scanner;
public class QuizApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] questions = {
				"What is the capital of India?", 
				"Which language is used for Android app development?",
				"Who is the founder of Microsoft?"
		};
		
		String[][] options = {
				{"A) Mumbai ", "B) Delhi ", "C) Kolkata ", "D) Chennai "},
				{"A) Java ", "B) Python ", "C) C++ ", "D) Swift "},
				{"A) Bill Gates ", "B) Steve Jobs ", "C) Elon Musk ", "D) Mark Zukerberg "}
		};
		
		char[] answers = {'B', 'A', 'A'};
		
		int score = 0;
		
		for(int i = 0; i < questions.length; i++) {
			System.out.println("\nQuestion " + (i+1) + ":" + questions[i]);
			
			for(String option : options[i]) {
				System.out.println(option);
			}
			
			System.out.println("Enter your answer (A/B/C/D): ");
			char userAnswer = scan.next().toUpperCase().charAt(0);
			
			if(userAnswer == answers[i]) {
				System.out.println("Correcr!");
				score++;
			}else {
				System.out.println("Wrong! Correct Answer: " + answers[i]);
			}
			
		}
		
		System.out.println("\nQuiz Over!");
		System.out.println("Your Score: " + score + " out of " + questions.length );
		scan.close();

	}

}
