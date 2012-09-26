package bank.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import bank.model.BankException;
import bank.model.Customer;
import bank.model.MasterAccount;
import bank.view.AmountView;
import bank.view.CustomerView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class CustomerController implements ActionListener,PopupMenuListener {
	
	/*
	 * Constants for the different actions that can be performed on an account.
	 */
	private enum Action {
		DEPOSIT,
		WITHDRAW,
		LOAN
	};
	
	/*
	 * Constants for the different accounts that the customer holds.
	 */
	private enum Account {
		DEPOSIT,
		LOAN,
		OVERDRAFT
	};
	
	private Customer customer;
	private CustomerView customerView;
	private AmountView amountView;
	
	private String method;
	
	/*
	 * A new CustomerView is created, the ActionListener(this) and the WindowListener(mc),
	 * is parsed into the CustomerView, also we save the Customer(c) from the LoginController
	 * so we know what data to load.
	 * A AmountView is also created, so its there when its needed.
	 * Then we set the CustomerView visible and update the fields with the customers data.
	 */
	public CustomerController(Customer c, MainController mc) {
		customer = c;
		customerView = new CustomerView(this,mc);
		amountView = new AmountView(this);
		customerView.setVisible(true);
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) customerView.getAccountList().getModel();
		model.removeAllElements();
		for(MasterAccount ma : c.getAccounts()) {
			model.addElement(ma.getName());
		}
		customer.setActiveAccount(0);
		updateFields();
	}
	
	/*
	 * This method updates the customers account when a Action is performed on an Account.
	 * It happens when the customer submit a Action in the AmountView, then the amount is fetched.
	 * And two switches selects the Account, and then the Action to be performed.
	 * The a method is then called in the customer object, and the amount is parsed as an parameter.
	 */
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
	
	/*
	 * This method updates the GUI label fields, with new data from the customer object.
	 */
	public void updateFields() {
		customerView.getNameLabel().setText(customer.getName());
		customerView.getDepositBalance().setText(Double.toString(customer.getDA().getBalance()));
		customerView.getLoanBalance().setText(Double.toString(customer.getLA().getBalance()));
		customerView.getOverdraftBalance().setText(Double.toString(customer.getOA().getBalance()));
		customerView.getOverdraftLimit().setText(Double.toString(customer.getOA().getOverdraftLimit()));
	}

	/*
	 * The actionPerformed is a method contained in the ActionListener interface.
	 * We must have this method to receive our ActionEvent, when we perform an action on a object,
	 * that has this listener added to it.
	 * In this case we first get an action from the CustomerView, and depending on what button is pressed
	 * a specific command is parsed into the method string, also the AmountView is set visible.
	 * When the customer then submit an amount, the updateAccount parameters is different depending
	 * on what the method is.
	 */
	@Override
	public void actionPerformed(ActionEvent e)  {
		
		String command = ((JButton) e.getSource()).getName();
		
		amountView.setVisible(true);
		
		if(command.equals("Submit")) {
			if(method.equals("dd")) updateAccount(Account.DEPOSIT, Action.DEPOSIT);
			if(method.equals("dw")) updateAccount(Account.DEPOSIT, Action.WITHDRAW);
			if(method.equals("ld")) updateAccount(Account.LOAN, Action.DEPOSIT);
			if(method.equals("ll")) updateAccount(Account.LOAN, Action.LOAN);
			if(method.equals("od")) updateAccount(Account.OVERDRAFT, Action.DEPOSIT);
			if(method.equals("ow")) updateAccount(Account.OVERDRAFT, Action.WITHDRAW);
			amountView.getAmountField().setText("");
			amountView.setVisible(false);
		}
		else method = command;
	}

	/*
	 * Listener on the JComboBox list, that knows when we have selected an account.
	 */
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
		customer.setActiveAccount(customerView.getAccountList().getSelectedIndex());
		updateFields();
		
	}

	public void popupMenuCanceled(PopupMenuEvent arg0) {}
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {}
}
