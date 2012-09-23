package bank.controller;
import bank.view.ErrorView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class ErrorController {
	
	private ErrorView errorView;
	
	/*
	 * This controller makes a new ErrorView, to display our exception messages.
	 */
	public ErrorController(Exception e) {
		errorView = new ErrorView();
		errorView.errorMessage.setText(e.getMessage());
		errorView.setVisible(true);
	}
}
