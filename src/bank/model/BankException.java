package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class BankException extends Exception {
	
	private static final long serialVersionUID = 8870762123671535195L;
	
	/*
	 * Custom exception class.
	 */
	public BankException(String msg) {
		super(msg);
	}
}
