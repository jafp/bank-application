package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class OverdraftAccount extends Account implements Depositable,Withdrawable {
	
	private Account account = new Account();
	private double overdraftLimit;
	
	public OverdraftAccount(double overdraft) {
		overdraftLimit = -overdraft;
	}

	@Override
	public void deposit(double amount) {
		account.setBalance(amount);
	}
	
	@Override
	public void withdraw(double amount) throws BankException {
			if(account.getBalance() - amount < overdraftLimit) {
				throw new BankException("Overdraft limit reached!");
			}
			else {
				account.setBalance(-amount);
			}
	}
	public double getBalance() {
		return account.getBalance();
	}
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
}
