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
	
	private enum Action {
		DEPOSIT,
		WITHDRAW,
		LOAN
	};
	
	private enum Account {
		DEPOSIT,
		LOAN,
		OVERDRAFT
	};
	
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
	
	public void updateAccount(Account account, Action method) {
		double amount = Double.parseDouble(amountView.getAmountField().getText());
		try {
			switch(account) {
			case DEPOSIT:
				switch(method) {
					case DEPOSIT:
						customer.getDA().deposit(amount);
						break;
					case WITHDRAW:
						customer.getDA().withdraw(amount);
						break;
					default:
						break;
				}
				break;
			case LOAN:
				switch(method) {
					case DEPOSIT:
						customer.getLA().deposit(amount);
						break;
					case LOAN:
						customer.getLA().loan(amount);
						break;
					default:
						break;
				}
				break;
			case OVERDRAFT:
				switch(method) {
					case DEPOSIT:
						customer.getOA().deposit(amount);
						break;
					case WITHDRAW:
						customer.getOA().withdraw(amount);
						break;
					default:
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
		amountView.getAmountField().setText("");
		
		if(command.equals("Submit")) {
			if(method.equals("dd")) updateAccount(Account.DEPOSIT, Action.DEPOSIT);
			if(method.equals("dw")) updateAccount(Account.DEPOSIT, Action.WITHDRAW);
			if(method.equals("ld")) updateAccount(Account.LOAN, Action.DEPOSIT);
			if(method.equals("ll")) updateAccount(Account.LOAN, Action.LOAN);
			if(method.equals("od")) updateAccount(Account.OVERDRAFT, Action.DEPOSIT);
			if(method.equals("ow")) updateAccount(Account.OVERDRAFT, Action.WITHDRAW);
			amountView.setVisible(false);
		}
		else method = command;
	}
}
