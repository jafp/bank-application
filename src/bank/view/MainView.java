package bank.view;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7775858109106280751L;
	private JPanel bankButtonContainer;
	private JButton bankViewButton;
	private JLabel creditsLabel;
	private JPanel footerContainer;
	private JLabel welcomeLabel;
	private JPanel headerContainer;
	private JButton customerViewButton;
	private JPanel customerButtonContainer;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainView inst = new MainView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				headerContainer = new JPanel();
				getContentPane().add(headerContainer);
				{
					welcomeLabel = new JLabel();
					headerContainer.add(welcomeLabel);
					welcomeLabel.setText("Welcome to the Bank Application.");
				}
			}
			{
				bankButtonContainer = new JPanel();
				getContentPane().add(bankButtonContainer);
				BorderLayout bankButtonContainerLayout = new BorderLayout();
				bankButtonContainer.setLayout(bankButtonContainerLayout);
				{
					bankViewButton = new JButton();
					bankButtonContainer.add(bankViewButton, BorderLayout.CENTER);
					bankViewButton.setText("Bank View");
				}
			}
			{
				customerButtonContainer = new JPanel();
				getContentPane().add(customerButtonContainer);
				BorderLayout customerButtonContainerLayout = new BorderLayout();
				customerButtonContainer.setLayout(customerButtonContainerLayout);
				{
					customerViewButton = new JButton();
					customerButtonContainer.add(customerViewButton, BorderLayout.CENTER);
					customerViewButton.setText("Customer View");
				}
			}
			{
				footerContainer = new JPanel();
				getContentPane().add(footerContainer);
				{
					creditsLabel = new JLabel();
					footerContainer.add(creditsLabel);
					creditsLabel.setText("IHK Java App - Jacob Pedersen & Pierre Zabell");
				}
			}
			pack();
			this.setSize(384, 181);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
