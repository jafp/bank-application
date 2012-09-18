package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class DepositAccount extends Account implements Depositable,Withdrawable {
	
	private Account account = new Account();
	
	public void deposit(double amount) {
		account.setBalance(amount);
	}
	
	public void withdraw(double amount) throws BankException {
			if(amount > account.getBalance()) {
				throw new BankException("Insufficient Funds!");
			}
			else {
				account.setBalance(-amount);
			}
	}
	public double getBalance() {
		return account.getBalance();
	}
}
