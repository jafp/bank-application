package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class Account {
	private double balance;
	
	public Account() {
		balance = 0;
	}
	
	public Account(double setBalance) {
		balance = setBalance;
	}
	
	public void setBalance(double amount) {
		balance = balance + amount;
	}
	
	public double getBalance() {
		return balance;
	}
}
