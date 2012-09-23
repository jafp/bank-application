package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class Account {
	private double balance;
	
	/*
	 * The account is the base class for all account types.
	 * It has the basic methods that is common for every account type.
	 */
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
