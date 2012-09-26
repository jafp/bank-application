package bank.model;

import java.io.Serializable;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		balance = amount;
	}
	
	public void addAmount(double amount) {
		balance = balance + amount;
	}
	
	public double getBalance() {
		return balance;
	}
}
