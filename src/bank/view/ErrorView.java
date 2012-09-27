package bank.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
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
	
	/*
	 * Super is called here, and that initializes JFrame.
	 * The GUI is then being initialized and the window is set visible.
	 */
	public ErrorView() {
		super();
		initGUI();
	}
	
	/*
	 * This method sets up all our windows components, such as containers, buttons, lists etc.
	 * Also here the Controller ActionListener is added to our button components.
	 */
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
