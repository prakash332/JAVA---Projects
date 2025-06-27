package BankSystem;
import java.util.Scanner;

public class BankSystem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BankAccount account = null;
		
		while(true) {
			System.out.println("\n---Bank Menu---");
			System.out.println("1.Create Account");
			System.out.println("2.Load Account");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Show Balance");
			System.out.println("6.Exit");
			
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			scan.nextLine();//consume new line
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter Account Number: ");
				String accNumber = scan.nextLine();
				System.out.println("Enter Account Holder Name: ");
				String name = scan.nextLine();
				System.out.println("Enter Initial Balance: ");
				double initBalance = scan.nextDouble();
				
				account = new BankAccount(accNumber, name, initBalance);
				AccountFileManager.saveAccount(account);
				
				System.out.println("Account created successfully!");
				break;
				
			case 2:
				System.out.println("Enter Account Number to Load: ");
				String accToLoad = scan.nextLine();
				account = AccountFileManager.loadAccount(accToLoad);
				if(account != null) {
					System.out.println("Account Loaded Successfully!");
				}
				break;
				
			case 3:
				if(account != null) {
					System.out.println("Enter amount to deposit: ");
					double depAmt = scan.nextDouble();
					BankOperations.depositMoney(account, depAmt);
				}else {
					System.out.println("Load an account first!");
				}
				break;
				
			case 4:
				if(account != null) {
					System.out.println("Enter amount to withdraw: ");
					double witAmt = scan.nextDouble();
					BankOperations.withdrawMoney(account, witAmt);
					}else {
						System.out.println("Load an account first!");
					}
				break;
				
			case 5:
				if(account != null) {
					BankOperations.showBalance(account);
				}else {
					System.out.println("Load an account first!");
				}
				break;
				
			case 6:
				System.out.println("Existing...Thank you!");
				scan.close();
				return;
			
			default:
				System.out.println("Invalid choice! Try Again.");
				
		}
		}
	}

}
