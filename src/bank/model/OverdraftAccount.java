package bank.model;

import java.io.Serializable;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class OverdraftAccount extends Account implements Serializable, Depositable,Withdrawable {
	
	private static final long serialVersionUID = -540971148120989388L;
	private Account account = new Account();
	private double overdraftLimit;
	
	/*
	 * When an overdraft account is created, it needs a overdraft parameter.
	 * This is the overdraft limit the customer enters in the BankView.
	 */
	public OverdraftAccount(double overdraft) {
		overdraftLimit = -overdraft;
	}

	/*
	 * Standard deposit method, adds the amount to the account balance.
	 */
	@Override
	public void deposit(double amount) {
		account.addAmount(amount);
	}
	
	/*
	 * Withdraw method checks if your have reached the overdraft limit.
	 * If not it subtracts amount from the total balance.
	 */
	@Override
	public void withdraw(double amount) throws BankException {
			if(account.getBalance() - amount < overdraftLimit) {
				throw new BankException("Overdraft limit reached!");
			}
			else {
				account.addAmount(-amount);
			}
	}
	
	/*
	 * Getters for private data.
	 */
	public double getBalance() {
		return account.getBalance();
	}
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
}
