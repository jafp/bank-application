package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class DepositAccount extends Account implements Depositable,Withdrawable {
	
	private Account account = new Account();
	
	/*
	 * This method parses an amount to the account super class,
	 * then the amount is added to the total sum.
	 */
	public void deposit(double amount) {
		account.setBalance(amount);
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
				account.setBalance(-amount);
			}
	}
	
	/*
	 * Method for getting the balance of the account.
	 */
	public double getBalance() {
		return account.getBalance();
	}
}
