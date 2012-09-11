package bank.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();

	public void addCustomer(Customer customer) {
		customer.setNumber(getNextCustomerNumber());
		customers.put(customer.getNumber(), customer);
	}

	public Collection<Customer> getCustomers() {
		return customers.values();
	}
	
	private long getNextCustomerNumber() {
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
