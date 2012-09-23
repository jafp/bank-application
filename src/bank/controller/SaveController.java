package bank.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import bank.model.Bank;
import bank.model.Customer;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class SaveController {
	
	private File file;
	private Scanner input;
	private PrintWriter output;
	
	private Customer customer;
	private Bank bankModel = Bank.instance();

	/*
	 * When the SaveController is constructed, we find the path to the directory 
	 * in which the program is located. Then we check for a file named bankdata,
	 * if it dosen't exists we create a new file, but if we already have a bankdata file.
	 * We call the loadFile method which will read data from the file.
	 */
	public SaveController() {
		String rawPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		String path = rawPath.substring(0, rawPath.lastIndexOf("/")+1);
		file = new File(path+"bankdata");
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
	
	/*
	 * Uses the Scanner object to read from out bankdata file.
	 * As long as the file has more information, we will continue to read.
	 * The data is saved in the Bank Model ArrayList of customers.
	 */
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
	
	/*
	 * When our program is closed, we will delete our previous bankdata file.
	 * We will then create a new one, and use our PrintWriter object to 
	 * write all new information to the file.
	 */
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
}
