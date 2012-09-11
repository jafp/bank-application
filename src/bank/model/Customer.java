package bank.model;

import java.util.List;

public class Customer {
	private Long number;
	private String name;
	private List<Account> accounts;
	
	public long getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setNumber(long n) {
		number = n;
	}
}
