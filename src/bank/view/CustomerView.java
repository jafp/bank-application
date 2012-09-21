package bank.view;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import bank.controller.CustomerController;
import bank.controller.MainController;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class CustomerView extends javax.swing.JFrame {

	/** Auto-generated to avoid warnings */
	private static final long serialVersionUID = -88705056175278247L;
	/** Font size for headers */
	private static final Font HEADER_FONT = new Font("Sans Serif", Font.BOLD, 16);
	/** Font size for "items" */
	private static final Font ITEM_FONT = new Font("Sans Serif", Font.PLAIN, 12);
	
	/** The controller responsible for this view */
	private CustomerController customerController;
	
	private JLabel nameLabel;
	private JLabel depositBalance;
	private JLabel loanBalance;
	private JLabel overdraftBalance;
	private JLabel overdraftLimit;
	private JLabel depositBalanceLabel;
	private JPanel headerContainer;
	private JLabel depositLabel;
	private JButton loanLoan;
	private JButton loanDeposit;
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
	private JPanel depositFunctionContainer;
	private JPanel depositLabelContainer;
	private JPanel depositContainer;
	private JLabel welcomeLabel;
	
	public CustomerView(CustomerController cc, MainController mc) {
		super();
		this.addWindowListener(mc);
		customerController = cc;
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
					setNameLabel(new JLabel());
					headerContainer.add(getNameLabel());
					getNameLabel().setText("<name>");
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
						depositLabel.setFont(HEADER_FONT);
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
							depositBalanceLabel.setFont(ITEM_FONT);
							depositBalanceContainer.add(depositBalanceLabel);
							depositBalanceLabel.setText("Balance:");
						}
						{
							setDepositBalance(new JLabel());
							getDepositBalance().setFont(ITEM_FONT);
							depositBalanceContainer.add(getDepositBalance());
							getDepositBalance().setText("<balance>");
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
							depositDeposit.setName("dd");
							depositDeposit.addActionListener(customerController);
						}
						{
							depositWithdraw = new JButton();
							depositButtomContainer.add(depositWithdraw);
							depositWithdraw.setText("Withdraw");
							depositWithdraw.setName("dw");
							depositWithdraw.setSize(75, 25);
							depositWithdraw.addActionListener(customerController);
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
						loanLabel.setFont(HEADER_FONT);
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
							loanBalanceLabel.setFont(ITEM_FONT);
							loanBalanceContainer.add(loanBalanceLabel);
							loanBalanceLabel.setText("Balance:");
						}
						{
							setLoanBalance(new JLabel());
							getLoanBalance().setFont(ITEM_FONT);
							loanBalanceContainer.add(getLoanBalance());
							getLoanBalance().setText("<balance>");
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
							loanDeposit.setName("ld");
							loanDeposit.addActionListener(customerController);
						}
						{
							loanLoan = new JButton();
							loanButtomContainer.add(loanLoan);
							loanLoan.setText("Loan");
							loanLoan.setName("ll");
							loanLoan.addActionListener(customerController);
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
						overdraftLabel.setFont(HEADER_FONT);
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
						overdraftLimitLabel.setFont(ITEM_FONT);
						overdraftLimitContainer.add(overdraftLimitLabel);
						overdraftLimitLabel.setText("Overdraft Limit:");
					}
					{
						setOverdraftLimit(new JLabel());
						getOverdraftLimit().setFont(ITEM_FONT);
						overdraftLimitContainer.add(getOverdraftLimit());
						getOverdraftLimit().setText("<limit>");
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
							overdraftBalanceLabel.setFont(ITEM_FONT);
							overdraftBalanceContainer.add(overdraftBalanceLabel);
							overdraftBalanceLabel.setText("Balance:");
						}
						{
							setOverdraftBalance(new JLabel());
							getOverdraftBalance().setFont(ITEM_FONT);
							overdraftBalanceContainer.add(getOverdraftBalance());
							getOverdraftBalance().setText("<balance>");
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
							overdraftDeposit.setName("od");
							overdraftDeposit.addActionListener(customerController);
						}
						{
							overdraftWithdraw = new JButton();
							overdraftButtomContainer.add(overdraftWithdraw);
							overdraftWithdraw.setText("Withdraw");
							overdraftWithdraw.setName("ow");
							overdraftWithdraw.addActionListener(customerController);
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

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getDepositBalance() {
		return depositBalance;
	}

	public void setDepositBalance(JLabel depositBalance) {
		this.depositBalance = depositBalance;
	}

	public JLabel getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(JLabel loanBalance) {
		this.loanBalance = loanBalance;
	}

	public JLabel getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(JLabel overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	public JLabel getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(JLabel overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
}
