package bank.model;

public interface Depositable {
	void deposit(double amount) throws BankException;
}
