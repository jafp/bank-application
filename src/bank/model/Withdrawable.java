package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public interface Withdrawable {
	void withdraw(double amount) throws BankException;
}
