package bank.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.model.Bank;
import bank.model.BankException;
import bank.model.Customer;
import bank.view.LoginView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class LoginController implements ActionListener {
	
	private MainController mainController;
	private Bank bankModel = Bank.instance();
	private LoginView loginView;
	
	public LoginController(MainController mc) {
		mainController = mc;
		loginView = new LoginView(this,mc);
	}
	
	public void setVisible() {
		loginView.setVisible(true);
	}
	
	public void login() {
		try {
			boolean notFound = true;
			if(bankModel.getCustomers().size() != 0) {
				for(Customer c : bankModel.getCustomers()) {
					if(
						loginView.nameField.getText().toLowerCase().equals(c.getName().toLowerCase()) && 
						new String(loginView.passwordField.getPassword()).equals(c.getPassword())) {
						notFound = false;
						new CustomerController(c,mainController);
						loginView.setVisible(false);
					}
				}
				if(notFound == true) {
					throw new BankException("Wrong login information!");
				}
			}
			else {
				throw new BankException("No customers are registered in the system!");
			}
		}
		catch (BankException e) {
			new ErrorController(e);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Login")) login();
	}

}
