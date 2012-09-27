package bank.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import bank.model.Bank;
import bank.model.Customer;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class SaveController {
	
	private File file;
	private ObjectInputStream input = null;
	private ObjectOutputStream output = null;
	
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
	 * We use the ObjectInputStream to read objects from our bankdata file.
	 * As long as the file has more information, we will continue to read.
	 * The data is saved in the Bank Model ArrayList of customers.
	 */
	public void loadFile() {
		try {
			input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			while(true) {
				Object obj = input.readObject();
				if (obj != null) {
					customer = (Customer) obj;
					bankModel.addCustomer(customer);
				} else {
					break;
				}
			}
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
		}
		finally {
			try {
				if(input != null) {
					input.close();
				}
			}
			catch (IOException exc) {
				System.out.println(exc.getMessage());
			}
		}
	}
	
	/*
	 * When our program is closed, we will delete our previous bankdata file.
	 * We will then create a new one, and use our ObjectOutputStream to 
	 * write all new objects to the file.
	 */
	public void writeFile() {
		try{
			file.delete();
			file.createNewFile();
			output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			for(Customer c : bankModel.getCustomers()) {
				output.writeObject(c);
			}
		}
		catch (IOException exc) {
			System.out.println(exc.getMessage());
		}
		finally {
			try {
				if(output != null) {
					output.close();
				}
			}
			catch (IOException exc) {
				new ErrorController(exc);
			}	
		}
	}
}
