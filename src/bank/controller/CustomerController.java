package bank.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bank.model.BankException;
import bank.model.Customer;
import bank.view.AmountView;
import bank.view.CustomerView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class CustomerController implements ActionListener {
	
	private Customer customer;
	private CustomerView customerView;
	private AmountView amountView;
	
	private String method;
	
	public CustomerController(Customer c, MainController mc) {
		customer = c;
		customerView = new CustomerView(this,mc);
		amountView = new AmountView(this);
		customerView.setVisible(true);
		updateFields();
	}
	
	public void updateAccount(int account, int method) {
		double amount = Double.parseDouble(amountView.amountField.getText());
		try {
			switch(account) {
			case 1:
				switch(method) {
				case 1:
					customer.getDA().deposit(amount);
					break;
				case 2:
					customer.getDA().withdraw(amount);
					break;
				}
				break;
			case 2:
				switch(method) {
				case 1:
					customer.getLA().deposit(amount);
					break;
				case 2:
					customer.getLA().loan(amount);
					break;
				}
				break;
			case 3:
				switch(method) {
				case 1:
					customer.getOA().deposit(amount);
					break;
				case 2:
					customer.getOA().withdraw(amount);
					break;
				}
				break;
			}
		}
		catch(BankException e) {
			new ErrorController(e);
		}
		finally {
			updateFields();
		}
	}
	
	public void updateFields() {
		customerView.getNameLabel().setText(customer.getName());
		customerView.getDepositBalance().setText(Double.toString(customer.getDA().getBalance()));
		customerView.getLoanBalance().setText(Double.toString(customer.getLA().getBalance()));
		customerView.getOverdraftBalance().setText(Double.toString(customer.getOA().getBalance()));
		customerView.getOverdraftLimit().setText(Double.toString(customer.getOA().getOverdraftLimit()));
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		
		String command = ((JButton) e.getSource()).getName();
		
		amountView.setVisible(true);
		
		if(command.equals("Submit")) {
			if(method.equals("dd")) updateAccount(1,1);
			if(method.equals("dw")) updateAccount(1,2);
			if(method.equals("ld")) updateAccount(2,1);
			if(method.equals("ll")) updateAccount(2,2);
			if(method.equals("od")) updateAccount(3,1);
			if(method.equals("ow")) updateAccount(3,2);
			amountView.setVisible(false);
		}
		else method = command;
	}
}
