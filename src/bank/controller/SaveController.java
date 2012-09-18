package bank.controller;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import bank.model.Bank;
import bank.model.Customer;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class SaveController implements WindowListener {
	
	private File file;
	private Scanner input;
	private PrintWriter output;
	
	private Customer customer;
	private Bank bankModel = Bank.instance();

	public SaveController() {
		file = new File("bankdata");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			else loadFile();
		}
		catch(IOException exc) {
			new ErrorController(exc);
		}
	}
	
	public void loadFile() {
		try {
			input = new Scanner(file);
			while(input.hasNext()) {
				customer = new Customer(
						input.next(),
						input.next(),
						input.nextDouble(),
						input.nextDouble());
				customer.getDA().deposit(input.nextDouble());
				customer.getOA().deposit(input.nextDouble());
				bankModel.addCustomer(customer);
			}
		}
		catch(IOException exc) {
			new ErrorController(exc);
		}
		finally {
			if(input != null) {
				input.close();
			}
		}
	}
	
	public void writeFile() {
		try{
			file.delete();
			file.createNewFile();
			output = new PrintWriter(file);
			for(Customer c : bankModel.getCustomers()) {
				output.print(c.getName()+" ");
				output.print(c.getPassword()+" ");
				output.print(-c.getLA().getBalance()+" ");
				output.print(-c.getOA().getOverdraftLimit()+" ");
				output.print(c.getDA().getBalance()+c.getLA().getBalance()+" ");
				output.println(c.getOA().getBalance()+" ");
			}
		}
		catch (IOException exc) {
			new ErrorController(exc);
		}
		finally {
			if(output != null) {
				output.close();
			}
		}	
	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		writeFile();
	}
	
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
