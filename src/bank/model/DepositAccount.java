package bank.model;

import java.io.Serializable;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class DepositAccount extends Account implements Serializable, Depositable,Withdrawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account = new Account();
	
	/*
	 * This method parses an amount to the account super class,
	 * then the amount is added to the total sum.
	 */
	public void deposit(double amount) {
		account.addAmount(amount);
	}
	
	/*
	 * This method first checks if the customer have sufficient funds on their account,
	 * to make the requested withdraw.
	 * If they are good to go, the amount is subtracted from the account sum.
	 */
	public void withdraw(double amount) throws BankException {
			if(amount > account.getBalance()) {
				throw new BankException("Insufficient Funds!");
			}
			else {
				account.addAmount(-amount);
			}
	}
	
	/*
	 * Method for getting the balance of the account.
	 */
	public double getBalance() {
		return account.getBalance();
	}
}
