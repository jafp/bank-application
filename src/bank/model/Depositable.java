package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public interface Depositable {
	void deposit(double amount) throws BankException;
}
