package bank.model;

public class Customer {
	private String name;
	private String password;
	
	private DepositAccount depositAccount;
	private LoanAccount loanAccount;
	private OverdraftAccount overdraftAccount;
	
	public Customer(String newName,String newPassword,double loanAmount, double overdraftLimit) {
		name = newName;
		password = newPassword;
		depositAccount = new DepositAccount();
		loanAccount = new LoanAccount(loanAmount,depositAccount);
		overdraftAccount = new OverdraftAccount(overdraftLimit);
	}
	
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
