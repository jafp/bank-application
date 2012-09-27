package bank.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import bank.model.Bank;
import bank.model.BankException;
import bank.model.Customer;
import bank.model.MasterAccount;
import bank.view.BankView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class BankController implements ActionListener,MouseListener,FocusListener {
	
	private enum ActiveList {
		CUSTOMERLIST,
		ACCOUNTLIST,
		NONE
	}
	
	private BankView bankView;
	private Bank bankModel = Bank.instance();
	private ActiveList activeList;
	private Customer activeCustomer;
	
	/*
	 * A new BankView is created, the ActionListener(this) and the WindowListener(mc),
	 * is parsed into the BankView, and finally we update the customer list,
	 * because we might have a saved file with customer information in store.
	 */
	public BankController(MainController mc) {
		bankView = new BankView(this,mc);
		updateGUI();
	}
	
	/*
	 * This method is used by the MainController, so it can set the BankView visible.
	 * Because of the BankView being private, and only accessible from the BankController class.
	 */
	public void setVisible() {
		bankView.setVisible(true);
		updateGUI();
	}
	
	/*
	 * Helper method, for finding the correct customer object.
	 */
	public Customer findCustomer(String name) {
		for(Customer c : bankModel.getCustomers()) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	/*
	 * This method is for adding new customers to our Bank(Model).
	 * First of all we get the name of the customer, and check if such name already exists.
	 * If we are clear to go, we create a new Customer object, and then add it to our ArrayList
	 * of customers in the BankModel.
	 */
	public void addCustomer() {
		try {
			String name = bankView.getNameField().getText();
			Customer customer = findCustomer(name);
			if(customer != null) {
				String accountName = bankView.getAccountField().getText();
				if(customer.getActiveAccount().getName().toLowerCase().equals(accountName.toLowerCase())) {
					throw new BankException("Customer with that name and account name already exists!");
				}
				else {
					customer.newMasterAccount(
							accountName, 
							Double.parseDouble(bankView.getLoanField().getText()), 
							Double.parseDouble(bankView.getOverdraftField().getText())
							);
				}
			}
			else {
				try {
					Customer newCustomer = new Customer(
							name,
							new String(bankView.getPasswordField().getPassword()),
							new String(bankView.getAccountField().getText()),
							Double.parseDouble(bankView.getLoanField().getText()),
							Double.parseDouble(bankView.getOverdraftField().getText())
							);
					bankModel.addCustomer(newCustomer);
					activeCustomer = null;
				}
				catch (Exception e)  {
					throw new BankException("All fields needs to be filled!");
				}
			}
		}
		catch (BankException e) {
			new ErrorController(e);
		}
		finally {
			updateGUI();
		}
	}
	
	/*
	 * Here we have a small method for deleting a given customer in the ArrayList for BankModel.
	 */
	public void deleteCustomer() {
		if(activeCustomer.getAccounts().size() > 1) {
			activeCustomer.removeActiveAccount();
		}
		else {
			//activeCustomer.removeActiveAccount();
			bankModel.deleteCustomer(activeCustomer);
			activeCustomer = null;
		}
		updateGUI();
	}
	
	/*
	 * Updates information for an active customer and a selected account.
	 */
	public void updateAccount() {
		activeCustomer.setName(bankView.getNameField().getText());
		activeCustomer.setPassword(new String(bankView.getPasswordField().getPassword()));
		activeCustomer.getActiveAccount().setName(bankView.getAccountField().getText());
		activeCustomer.getActiveAccount().getLA().setBalance(
				Double.parseDouble(bankView.getLoanField().getText()));
		updateGUI();
	}
	
	/*
	 * This method is for updating the ListModels used by the List components in the BankView.
	 * When this is called we refresh the list, so proper data will be displayed in the GUI.
	 * Also the fields are cleared or set, according to what customer is selected.
	 */
	public void updateGUI() {
		if(activeCustomer != null) {
			bankView.getNameField().setText(activeCustomer.getName());
			bankView.getPasswordField().setText(activeCustomer.getPassword());
			bankView.getAccountField().setText(activeCustomer.getActiveAccount().getName());
			bankView.getLoanField().setText(Double.toString(-activeCustomer.getLA().getBalance()));
			bankView.getOverdraftField().setText(Double.toString(-activeCustomer.getOA().getOverdraftLimit()));
		}
		else {
			bankView.clearFields();
		}
		if(activeList != ActiveList.CUSTOMERLIST) {
			DefaultListModel<String> customerModel = (DefaultListModel<String>) bankView.getCustomerList().getModel();
			customerModel.clear();
			for(Customer c : bankModel.getCustomers()) {
				customerModel.addElement(c.getName());
			}
		}
		if(activeList != ActiveList.ACCOUNTLIST) {
			DefaultListModel<String> accountModel = (DefaultListModel<String>) bankView.getAccountList().getModel();
			accountModel.clear();
			if(activeCustomer != null) {
				for(MasterAccount ma : activeCustomer.getAccounts()) {
					accountModel.addElement(
							ma.getName()+" - "
							+"Deposit:"+ma.getDA().getBalance()+" "
							+"Loan:"+ma.getLA().getBalance()+" "
							+"Overdraft:"+ma.getOA().getBalance()
							);
				}
			}
		}
	}

	/*
	 * The actionPerformed is a method contained in the ActionListener interface.
	 * We must have this method to receive our ActionEvent, when we perform an action on a object,
	 * that has this listener added to it.
	 * In this case we can either perform the addCustomer or deleteCustomer method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		activeList = ActiveList.NONE;
		if(command.equals("Add")) addCustomer();
		else if(command.equals("Delete")) deleteCustomer();
		else if(command.equals("Update")) updateAccount();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(activeList == ActiveList.CUSTOMERLIST) {
			try {
				if(bankModel.getCustomers().size() == 0) {
					throw new BankException("No customers in system!");
				}
				else {
					activeCustomer = findCustomer(bankView.getCustomerList().getSelectedValue());
					updateGUI();
				}
			}
			catch(BankException e) {
				new ErrorController(e);
			}
		}
		else if(activeList == ActiveList.ACCOUNTLIST) {
			try {
				if(activeCustomer == null) {
					throw new BankException("No Customer Selected!");
				}
				activeCustomer.setActiveAccount(bankView.getAccountList().getSelectedIndex());
				updateGUI();
			}
			catch(BankException e) {
				new ErrorController(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void focusGained(FocusEvent arg0) {
		String name = ((JList<String>) arg0.getSource()).getName();
		if(name.equals("customerList")) {
			activeList = ActiveList.CUSTOMERLIST;
		}
		else if(name.equals("accountList")) {
			activeList = ActiveList.ACCOUNTLIST;
		}
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void focusLost(FocusEvent arg0) {}
}
