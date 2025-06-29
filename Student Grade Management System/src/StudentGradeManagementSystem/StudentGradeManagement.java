package StudentGradeManagementSystem;

import java.util.ArrayList;// for storing multiple student objects
import java.util.Collections;// for sorting
import java.util.Scanner;

public class StudentGradeManagement {

	public static void main(String[] args) {
		ArrayList<Student> StudentList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n=== Student Grade Management System ===");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search by Roll Number");
			System.out.println("4. View Top Perfomers");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			
			switch(choice) {
			//Add Student
			case 1:
			System.out.println("Enter Name: ");
			scan.nextLine();//clear buffer
			String name = scan.nextLine();
			
			System.out.println("Enter Roll Number: ");
			int roll = scan.nextInt();
			
			System.out.println("Enter Marks: ");
			double marks = scan.nextDouble();
			
			StudentList.add(new Student(name, roll, marks));
			System.out.println("Student added successfully!");
			break;
			
			
			//view all detials
			case 2:
			System.out.println("\n--- Student List ---");
			for(Student s : StudentList) {
				s.display();
			}
			break;
			
			
			//Search by Roll Number
			case 3:
			System.out.println("Enter Roll Number to search: ");
			int searchRoll = scan.nextInt();
			
			boolean found = false;
			
			for(Student s : StudentList) {
				if(searchRoll == s.rollNo) {
					s.display();
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("Student not found!");
			}
			break;
			
			
			//View Top Perfomers
			case 4:
				//sort by marks in descending order
			Collections.sort(StudentList,(s1,s2) -> Double.compare(s2.marks, s1.marks));
			System.out.println("\n--- Top Performers ---");
			for(Student s : StudentList) {
				s.display();
			}
			break;
				
			
			
			case 5:
			System.out.println("Existing... Thank you!");
			scan.close();
			break;
			
			
			default:
			System.out.println("Invalid choice! Please try again.");
			}
		}
		
	}
}
