package StudentGradeManagementSystem;



public class Student {

	String name;
	int rollNo;
	double marks;
	String grade;
	
	//constructor
	Student(String name, int rollNo, double marks){
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
		this.grade = calculateGrade();
	}
	
	//method to calculate grade based on marks
	String calculateGrade() {
		if (marks >= 90) {
			return "A";
		}else if(marks >= 75) {
			return "B";
		}else if(marks >= 60) {
			return "C";
		}else if(marks >= 40) {
			return "D";
		}else {
			return "F";
		}
	}
	
	//to display student detials 
	void display() {
		System.out.println("Name: " + name + ", Roll: " + rollNo + ", marks: " + marks + ", Grade: " + grade);
		}
	}
