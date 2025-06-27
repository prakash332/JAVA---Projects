package BankSystem;

public class BankAccount {

	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	//constructor
	public BankAccount(String accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	
	//getter & setter
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	
	//method
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public boolean withdraw(double amount) {
		if(amount <= balance) {
			balance = balance - amount;
			return true;
		}
		return false;
	}
}
