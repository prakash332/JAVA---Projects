package BankSystem;

public class BankOperations {

	public static void depositMoney(BankAccount account, double amount) {
		account.deposit(amount);
		AccountFileManager.saveAccount(account);
		System.out.println("DEposited: " + amount);
	}
	
	
	public static void withdrawMoney(BankAccount account, double amount) {
	    if(account.withdraw(amount)) {
	    	AccountFileManager.saveAccount(account);
	    	System.out.println("Withdrawn: " + amount);
	    }else {
	    	System.out.println("Insufficient Balance!");
	    }
	}
	
	public static void showBalance(BankAccount account) {
		System.out.println("\nAccount Number: " + account.getAccountNumber());
		System.out.println("Account Holder: " + account.getAccountHolderName());
		System.out.println("Current Balance: " + account.getBalance());
	}
}
