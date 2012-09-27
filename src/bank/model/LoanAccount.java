package bank.model;

import java.io.Serializable;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class LoanAccount extends Account implements Serializable, Depositable {
	
	private static final long serialVersionUID = -7111104689969231658L;
	private Account account;
	private DepositAccount targetAccount;
	
	/*
	 * When a loan account is created, the constructor needs to parameters.
	 * A amount that will be the initial loan, and a reference to a deposit account. 
	 */
	public LoanAccount(double amount, DepositAccount target) {
		account = new Account(-amount);
		targetAccount = target;
		targetAccount.deposit(amount);
	}

	/*
	 * This deposit method checks if you are depositing more money than you owe.
	 * If you are good to go, i withdraw money from the reference account,
	 * and deposit them into the loan account.
	 */
	@Override
	public void deposit(double amount) throws BankException {
			if(account.getBalance() > -amount) {
				throw new BankException("Deposit is larger than the loan!");
			}
			else {
				targetAccount.withdraw(amount);
				account.addAmount(amount);
			}
	}
	
	/*
	 * When the customer loans money they are taken from the loan account,
	 * and put into the reference account, the loan account would be negative.
	 */
	public void loan(double amount) {
		account.addAmount(-amount);
		targetAccount.deposit(amount);
	}
	
	/*
	 * Method for getting the account balance.
	 */
	public double getBalance() {
		return account.getBalance();
	}
	
	public void setBalance(double amount) {
		targetAccount.deposit(getBalance()+amount);
		account.setBalance(-amount);
	}
}
