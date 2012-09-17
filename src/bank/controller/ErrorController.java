package bank.controller;

import java.io.IOException;

import bank.model.BankException;
import bank.view.ErrorView;

public class ErrorController {
	
	private ErrorView errorView;
	
	public ErrorController(BankException e) {
		errorView = new ErrorView();
		errorView.errorMessage.setText(e.getMessage());
		errorView.setVisible(true);
	}
	
	public ErrorController(IOException e) {
		errorView = new ErrorView();
		errorView.errorMessage.setText(e.getMessage());
		errorView.setVisible(true);
	}
}
