package bank.model;

public interface Withdrawable {
	void withdraw(double amount) throws BankException;
}
