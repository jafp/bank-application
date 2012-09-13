package bank.view;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class CustomerView extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -88705056175278247L;
	private JPanel headerContainer;
	private JLabel depositLabel;
	private JLabel depositBalanceLabel;
	private JButton loanLoan;
	private JButton loanDeposit;
	private JLabel loanBalance;
	private JLabel loanBalanceLabel;
	private JPanel loanFunctionContainer;
	private JLabel loanLabel;
	private JPanel loanContainer;
	private JPanel loanBalanceContainer;
	private JPanel overdraftBalanceContainer;
	private JPanel depositBalanceContainer;
	private JPanel depositButtomContainer;
	private JPanel loanButtomContainer;
	private JButton overdraftWithdraw;
	private JButton overdraftDeposit;
	private JLabel overdraftBalance;
	private JLabel overdraftLimit;
	private JLabel overdraftLimitLabel;
	private JPanel overdraftLimitContainer;
	private JLabel overdraftBalanceLabel;
	private JLabel overdraftLabel;
	private JPanel overdraftFunctionContainer;
	private JPanel overdraftLabelContainer;
	private JPanel overdraftContainer;
	private JPanel loanLabelContainer;
	private JPanel overdraftButtomContainer;
	private JButton depositWithdraw;
	private JButton depositDeposit;
	private JLabel depositBalance;
	private JPanel depositFunctionContainer;
	private JPanel depositLabelContainer;
	private JPanel depositContainer;
	private JLabel nameLabel;
	private JLabel welcomeLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CustomerView inst = new CustomerView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public CustomerView() {
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
					welcomeLabel.setText("Welcome");
				}
				{
					nameLabel = new JLabel();
					headerContainer.add(nameLabel);
					nameLabel.setText("<name>");
				}
			}
			{
				depositContainer = new JPanel();
				getContentPane().add(depositContainer);
				BoxLayout jPanel2Layout = new BoxLayout(depositContainer, javax.swing.BoxLayout.Y_AXIS);
				depositContainer.setLayout(jPanel2Layout);
				{
					depositLabelContainer = new JPanel();
					depositContainer.add(depositLabelContainer);
					FlowLayout jPanel3Layout = new FlowLayout();
					jPanel3Layout.setAlignment(FlowLayout.LEFT);
					depositLabelContainer.setLayout(jPanel3Layout);
					{
						depositLabel = new JLabel();
						depositLabelContainer.add(depositLabel);
						depositLabel.setText("Deposit Account");
					}
				}
				{
					depositFunctionContainer = new JPanel();
					depositContainer.add(depositFunctionContainer);
					BoxLayout jPanel4Layout = new BoxLayout(depositFunctionContainer, javax.swing.BoxLayout.X_AXIS);
					depositFunctionContainer.setLayout(jPanel4Layout);
					{
						depositBalanceContainer = new JPanel();
						depositFunctionContainer.add(depositBalanceContainer);
						FlowLayout depositBalanceContainerLayout = new FlowLayout();
						depositBalanceContainerLayout.setAlignment(FlowLayout.LEFT);
						depositBalanceContainer.setLayout(depositBalanceContainerLayout);
						{
							depositBalanceLabel = new JLabel();
							depositBalanceContainer.add(depositBalanceLabel);
							depositBalanceLabel.setText("Balance:");
						}
						{
							depositBalance = new JLabel();
							depositBalanceContainer.add(depositBalance);
							depositBalance.setText("<balance>");
						}
					}
					{
						depositButtomContainer = new JPanel();
						FlowLayout jPanel1Layout = new FlowLayout();
						jPanel1Layout.setAlignment(FlowLayout.RIGHT);
						depositFunctionContainer.add(depositButtomContainer);
						depositButtomContainer.setLayout(jPanel1Layout);
						{
							depositDeposit = new JButton();
							depositButtomContainer.add(depositDeposit);
							depositDeposit.setText("Deposit");
						}
						{
							depositWithdraw = new JButton();
							depositButtomContainer.add(depositWithdraw);
							depositWithdraw.setText("Withdraw");
							depositWithdraw.setSize(75, 25);
						}
					}
				}
			}
			{
				loanContainer = new JPanel();
				BoxLayout loanContainerLayout = new BoxLayout(loanContainer, javax.swing.BoxLayout.Y_AXIS);
				loanContainer.setLayout(loanContainerLayout);
				getContentPane().add(loanContainer);
				{
					loanLabelContainer = new JPanel();
					loanContainer.add(loanLabelContainer);
					FlowLayout loanLabelContainerLayout = new FlowLayout();
					loanLabelContainerLayout.setAlignment(FlowLayout.LEFT);
					loanLabelContainer.setLayout(loanLabelContainerLayout);
					{
						loanLabel = new JLabel();
						loanLabelContainer.add(loanLabel);
						loanLabel.setText("Loan Account");
					}
				}
				{
					loanFunctionContainer = new JPanel();
					loanContainer.add(loanFunctionContainer);
					BoxLayout loanFunctionContainerLayout = new BoxLayout(loanFunctionContainer, javax.swing.BoxLayout.X_AXIS);
					loanFunctionContainer.setLayout(loanFunctionContainerLayout);
					{
						loanBalanceContainer = new JPanel();
						loanFunctionContainer.add(loanBalanceContainer);
						FlowLayout loanBalanceContainerLayout = new FlowLayout();
						loanBalanceContainerLayout.setAlignment(FlowLayout.LEFT);
						loanBalanceContainer.setLayout(loanBalanceContainerLayout);
						{
							loanBalanceLabel = new JLabel();
							loanBalanceContainer.add(loanBalanceLabel);
							loanBalanceLabel.setText("Balance:");
						}
						{
							loanBalance = new JLabel();
							loanBalanceContainer.add(loanBalance);
							loanBalance.setText("<balance>");
						}
					}
					{
						loanButtomContainer = new JPanel();
						FlowLayout jPanel2Layout = new FlowLayout();
						jPanel2Layout.setAlignment(FlowLayout.RIGHT);
						loanFunctionContainer.add(loanButtomContainer);
						loanButtomContainer.setLayout(jPanel2Layout);
						{
							loanDeposit = new JButton();
							loanButtomContainer.add(loanDeposit);
							loanDeposit.setText("Deposit");
						}
						{
							loanLoan = new JButton();
							loanButtomContainer.add(loanLoan);
							loanLoan.setText("Loan");
						}
					}
				}
			}
			{
				overdraftContainer = new JPanel();
				BoxLayout overdraftContainerLayout = new BoxLayout(overdraftContainer, javax.swing.BoxLayout.Y_AXIS);
				overdraftContainer.setLayout(overdraftContainerLayout);
				getContentPane().add(overdraftContainer);
				{
					overdraftLabelContainer = new JPanel();
					overdraftContainer.add(overdraftLabelContainer);
					FlowLayout overdraftLabelContainerLayout = new FlowLayout();
					overdraftLabelContainerLayout.setAlignment(FlowLayout.LEFT);
					overdraftLabelContainer.setLayout(overdraftLabelContainerLayout);
					{
						overdraftLabel = new JLabel();
						overdraftLabelContainer.add(overdraftLabel);
						overdraftLabel.setText("Overdraft Account");
					}
				}
				{
					overdraftLimitContainer = new JPanel();
					overdraftContainer.add(overdraftLimitContainer);
					FlowLayout overdraftLimitContainerLayout = new FlowLayout();
					overdraftLimitContainerLayout.setAlignment(FlowLayout.LEFT);
					overdraftLimitContainer.setLayout(overdraftLimitContainerLayout);
					{
						overdraftLimitLabel = new JLabel();
						overdraftLimitContainer.add(overdraftLimitLabel);
						overdraftLimitLabel.setText("Overdraft Limit:");
					}
					{
						overdraftLimit = new JLabel();
						overdraftLimitContainer.add(overdraftLimit);
						overdraftLimit.setText("<limit>");
					}
				}
				{
					overdraftFunctionContainer = new JPanel();
					overdraftContainer.add(overdraftFunctionContainer);
					BoxLayout overdraftFunctionContainerLayout = new BoxLayout(overdraftFunctionContainer, javax.swing.BoxLayout.X_AXIS);
					overdraftFunctionContainer.setLayout(overdraftFunctionContainerLayout);
					{
						overdraftBalanceContainer = new JPanel();
						overdraftFunctionContainer.add(overdraftBalanceContainer);
						FlowLayout overdraftBalanceContainerLayout = new FlowLayout();
						overdraftBalanceContainerLayout.setAlignment(FlowLayout.LEFT);
						overdraftBalanceContainer.setLayout(overdraftBalanceContainerLayout);
						{
							overdraftBalanceLabel = new JLabel();
							overdraftBalanceContainer.add(overdraftBalanceLabel);
							overdraftBalanceLabel.setText("Balance:");
						}
						{
							overdraftBalance = new JLabel();
							overdraftBalanceContainer.add(overdraftBalance);
							overdraftBalance.setText("<balance>");
						}
					}
					{
						overdraftButtomContainer = new JPanel();
						FlowLayout jPanel3Layout = new FlowLayout();
						jPanel3Layout.setAlignment(FlowLayout.RIGHT);
						overdraftFunctionContainer.add(overdraftButtomContainer);
						overdraftButtomContainer.setLayout(jPanel3Layout);
						{
							overdraftDeposit = new JButton();
							overdraftButtomContainer.add(overdraftDeposit);
							overdraftDeposit.setText("Deposit");
						}
						{
							overdraftWithdraw = new JButton();
							overdraftButtomContainer.add(overdraftWithdraw);
							overdraftWithdraw.setText("Withdraw");
						}
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
