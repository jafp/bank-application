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
	
	/*
	 * A new LoginView is created, the ActionListener(this) is parsed into the LoginView.
	 * Also the MainListener is parsed into LoginView, and saved for reference
	 * so it also later in the code can be parsed into the CustomerController.
	 */
	public LoginController(MainController mc) {
		mainController = mc;
		loginView = new LoginView(this,mc);
	}
	
	/*
	 * This method is used by the MainController, so it can set the LoginView visible.
	 * Because of the LoginView being private, and only accessible from the LoginController class.
	 */
	public void setVisible() {
		loginView.setVisible(true);
	}
	
	/*
	 * Method for logging a customer into the system.
	 * First its checked if the Bank has any customers saved in the Customer ArrayList.
	 * If so, we run through the customer list, checking for a customer with the
	 * same name and password as specified by the user.
	 */
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

	/*
	 * The actionPerformed is a method contained in the ActionListener interface.
	 * We must have this method to receive our ActionEvent, when we perform an action on a object,
	 * that has this listener added to it.
	 * In this case we only listen to one button and perform the login method when pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Login")) login();
	}

}
