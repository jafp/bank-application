package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class LoanAccount extends Account implements Depositable {
	
	private Account account;
	private DepositAccount targetAccount;
	
	public LoanAccount(double amount, DepositAccount target) {
		account = new Account(-amount);
		targetAccount = target;
		targetAccount.deposit(amount);
	}

	@Override
	public void deposit(double amount) throws BankException {
			if(account.getBalance() > -amount) {
				throw new BankException("Deposit is larger than the loan!");
			}
			else {
				targetAccount.withdraw(amount);
				account.setBalance(amount);
			}
	}
	
	public void loan(double amount) {
		account.setBalance(-amount);
		targetAccount.deposit(amount);
	}
	
	public double getBalance() {
		return account.getBalance();
	}
}
