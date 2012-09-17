package bank.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ErrorView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public JLabel errorMessage;
	
	private JPanel messageContainer;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ErrorView inst = new ErrorView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ErrorView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				messageContainer = new JPanel();
				getContentPane().add(messageContainer, BorderLayout.NORTH);
				messageContainer.setPreferredSize(new java.awt.Dimension(413, 70));
				{
					errorMessage = new JLabel();
					messageContainer.add(errorMessage);
					FlowLayout errorMessageLayout = new FlowLayout();
					errorMessage.setLayout(errorMessageLayout);
					errorMessage.setText("<message>");
				}
			}
			pack();
			this.setSize(423, 84);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}