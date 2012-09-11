package bank.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();
	
	public long getNextCustomerNumber() {
		long next = 0;
		// TODO: We can maybe use a tree map instead, which is sorted
		for (long n : customers.keySet()) {
			if (n > next) {
				next = n;
			}
		}
		return next + 1;
	}
}
