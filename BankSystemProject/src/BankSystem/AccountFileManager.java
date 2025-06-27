package BankSystem;
import java.io.*;//for file handling like bufferedWriter, FileWriter, BufferedReader, etc

public class AccountFileManager {

	public static void saveAccount(BankAccount account) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(account.getAccountNumber() + ".txt"))){
			writer.write(account.getAccountNumber() + "\n");
			writer.write(account.getAccountHolderName() + "\n");
			writer.write(account.getBalance() + "\n");
		}catch (IOException e) {
			System.out.println("Error saving account: " + e.getMessage());
		}
	}
	
	
	public static BankAccount loadAccount(String accNumber) {
		try(BufferedReader reader = new BufferedReader(new FileReader(accNumber + ".txt"))){
			String number = reader.readLine();
			String name = reader.readLine();
			double bal = Double.parseDouble(reader.readLine());
			return new BankAccount(number, name, bal);
		}catch(IOException e) {
			System.out.println("Account not found");
			return null;
		}
	}
	
}
