package bank.model;

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
