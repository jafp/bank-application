package bank.model;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class Customer {
	private String name;
	private String password;
	
	private DepositAccount depositAccount;
	private LoanAccount loanAccount;
	private OverdraftAccount overdraftAccount;
	
	/*
	 * When the constructor is called a new customer is created.
	 * It takes all parameters necessary to create all accounts, name & password.
	 */
	public Customer(String newName,String newPassword,double loanAmount, double overdraftLimit) {
		name = newName;
		password = newPassword;
		depositAccount = new DepositAccount();
		loanAccount = new LoanAccount(loanAmount,depositAccount);
		overdraftAccount = new OverdraftAccount(overdraftLimit);
	}
	
	/*
	 * Methods for getting customer information and accounts.
	 */
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public DepositAccount getDA() {
		return depositAccount;
	}
	
	public LoanAccount getLA() {
		return loanAccount;
	}
	
	public OverdraftAccount getOA() {
		return overdraftAccount;
	}
}
