package ToDoListApp;
import java.util.*;
import java.io.*;

public class ToDoList {

	static ArrayList<String> tasks = new ArrayList<>();//list to hold tasks
	
	static final String FILE_NAME = "tasks.txt";//file to save tasks
	
	public static void main(String[] args) {
		
		loadTasks();//Load tasks from file at start
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("\n==== TO-DO LIST MENU ====");
			System.out.println("1.Add Task");
			System.out.println("2.Remove Task");
			System.out.println("3.Update Task");
			System.out.println("4.Lisk Tasks");
			System.out.println("5.Exit");
			
			System.out.println("Enter Your Choice: ");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
			
			case 1:
				addTask(scan);
					break;
			case 2:
				removeTask(scan);
				break;
			case 3:
				updateTask(scan);
				break;
			case 4:
				listTasks();
				break;
			case 5:
				saveTasks();
				System.out.println("Tasks Saved.Existing...");
			    break;
			default:
				System.out.println("Invalid Choice! Try again.");
			}
		}while(choice != 5);
	}
		
		//Add a new task
		static void addTask(Scanner scan) {
			System.out.println("Enter task to add: ");
			String task = scan.nextLine();
			tasks.add(task);
			System.out.println("Task added.");
			
		}
		
		//Remove tasks
		static void removeTask(Scanner scan) {
			listTasks();//show tasks
			System.out.println("Enter task Number to remove: ");
			int index = scan.nextInt() - 1;//convert user-friendly 1-based index to 0-based index
			
			if(index >= 0 && index < tasks.size()) {
				tasks.remove(index);
				System.out.println("Task removed.");
				}else {
					System.out.println("Invalid task number.");
				}
			
		}
		
		//update task
		static void updateTask(Scanner scan) {
			listTasks();
			System.out.println("Enter task number to update: ");
			int index = scan.nextInt()-1;
			if(index >= 0 && index < tasks.size()) {
				String newTask = scan.nextLine();
				tasks.set(index, newTask);
				System.out.println("Task updated.");
			}else {
				System.out.println("Invalid task number.");
			}
		}
		
		//list tasks
		static void listTasks() {
			if(tasks.isEmpty()) {
				System.out.println("No tasks found.");
			}else {
				System.out.println("\n Your Tasks..");
				for(int i=0; i<tasks.size();i++) {
					System.out.println((i+1) + "." + tasks.get(i));
				}
			}
		}
		
		
		//save tasks
		static void saveTasks() {
    	   try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
    		   for(String task : tasks) {
    			   writer.write(task);
    			   writer.newLine();
    		   }
    	   }catch(IOException e) {
    		   System.out.println("Error saving tasks: " + e.getMessage());
    	   }
       }
		
	   //load tasks
		static void loadTasks() {
			File file = new File(FILE_NAME);
			if(!file.exists()) return;
			try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
				String line;
				while((line = reader.readLine()) !=null) {
					tasks.add(line);
				}
			}catch(IOException e) {
				System.out.println("Error loading tasks: " + e.getMessage());
			}
		}

}
