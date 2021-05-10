/**
 * 
 */
package javaproject;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Maninder Kaur c0802040
           Pavan Kumar Guddeti c0805086
           Sai Venkata Someshwara Sarma Varahabatla c0806021
           Vamshi Ramagiri c0789785
 *
 */
public class HomePage {
    //Creating the enum variables since these 3 options are used many times in the program
	public enum SelectionPageValues
	{
		LOGIN("Login"),
		SIGNUP("Sign Up"),
		EXIT("Exit");

		String message;

		private SelectionPageValues(String message) {
			this.message = message;

		}
	}
  //main method
	public static void main(String[] args) {

		//This method causes the decoration of the panel to be optimum in looks based on the OS. 
		JDialog.setDefaultLookAndFeelDecorated(true);
		//Asking whether the client wants to signup or login.

		String selection = showSelectionPage();
		UserDetails loggedInUser = null;
       //while loop so that menu will always execute and can use break after certain utilities are done
		boolean toContinue = true;
		while(toContinue) {
			//switch case block for Login or SignUp options
			switch (selection) {
				case "Login":
					//creating an object of loginpage class to use its methods
					LoginPage lg = new LoginPage();
					//login() method authenticates the user to access accounts
					loggedInUser = lg.login();
					if(loggedInUser != null)
					{
						//user will be provided option to select savings or current account
						String accountSelected = lg.select_account();
						//this block executes the utilitites available in the savings account
						if(accountSelected.equals("Savings Account"))
						{
							//select_item_savings method displays different functions under savings acc
							String operation = lg.select_item_savings();
							//code to complete the deposit utility
							if(operation.equals("Deposit"))
							{
								InputData amountToDeposit = InputHandler.showDialog("Enter amount to deposit");
								loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance) + Integer.parseInt(amountToDeposit.data));
								JOptionPane.showMessageDialog(null, "New balance: "+loggedInUser.balance);						
                            //code to complete the withdrawal which charges 2 dollars fee per transaction
							}else if(operation.equals("Withdrawal"))
							{
								 InputData amountToWithdraw =   InputHandler.showDialog("Enter amount to withdraw");  
								 loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance)- Integer.parseInt(amountToWithdraw.data)-2);
								 JOptionPane.showMessageDialog(null, "New balance: "+loggedInUser.balance);
								 
							}
							//code to display balance on the menu
							else if(operation.equals("Check Balance"))
							{
								JOptionPane.showMessageDialog(null,loggedInUser.balance);
							}
							//code to transfer amount from one user to other and display thier new balance
							else if(operation.equals("Transfer"))
							{	
							ArrayList<UserDetails> allUsers = new FileOperations().readFromFile();
							InputData toTranferName = InputHandler.showDialog("Enter name of the recipient");
							UserDetails toTransferUser = UserDetails.getUserByName(toTranferName.data, allUsers);

							
							int oldBalance = Integer.parseInt(loggedInUser.balance);

                            InputData amountToTransfer =   InputHandler.showDialog("Enter amount to transfer");
                            Integer amountToTransferI = Integer.parseInt(amountToTransfer.data);
                            
						    if(oldBalance < amountToTransferI)
						    {
							JOptionPane.showMessageDialog(null,"Cannot deduct!! Insufficient Balance!Enter a lower amount");
							
						    }
						    else
							{
								toTransferUser.balance = String.valueOf(Integer.parseInt(toTransferUser.balance) + amountToTransferI);
								loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance) - amountToTransferI);
								JOptionPane.showMessageDialog(null,"new balance of loggedin user:" + loggedInUser.balance);
								JOptionPane.showMessageDialog(null,"new balance of recipient user:" + toTransferUser.balance);
								
							}
							} 
						
						}
						//code to display options under chequing account
						else if(accountSelected.equals("Chequing Account"))
						{
							String operation = lg.select_item_chequing();
							//code to complete the deposit utility
							if(operation.equals("Deposit"))
							{
								InputData amountToDeposit = InputHandler.showDialog("Enter amount to deposit");
								loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance) + Integer.parseInt(amountToDeposit.data));
								JOptionPane.showMessageDialog(null, "New balance: "+loggedInUser.balance);						

							}
							//code to complete the withdrawal which charges 2 dollars fee per transaction
							else if(operation.equals("Withdrawal"))
							{
								 InputData amountToWithdraw =   InputHandler.showDialog("Enter amount to withdraw");  
								 loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance)- Integer.parseInt(amountToWithdraw.data)-2);
								 JOptionPane.showMessageDialog(null, "New balance: "+loggedInUser.balance);
								 
							}
							//code to display balance on the menu
							else if(operation.equals("Check Balance"))
							{
								JOptionPane.showMessageDialog(null,loggedInUser.balance);
							}
							//code to select the name of the bill and pay the amount
							else if(operation.equals("Pay Bills"))
							{
								InputHandler.showDialog("Enter the name of the bill");
								InputData amountToPay =   InputHandler.showDialog("Enter amount to pay");
								if(Integer.parseInt(amountToPay.data)> Integer.parseInt(loggedInUser.balance))
										{
									JOptionPane.showMessageDialog(null, "Insufficient Balance to pay the bill");
									break;
										}
								loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance)- Integer.parseInt(amountToPay.data));
								JOptionPane.showMessageDialog(null, "Bill succesfully paid. New balance: "+loggedInUser.balance);
								
								}
							//Code to transfer amount from  one user to other user
							else if(operation.equals("Transfer"))
							{	
							ArrayList<UserDetails> allUsers = new FileOperations().readFromFile();
							InputData toTranferName = InputHandler.showDialog("Enter name of the recipient");
							UserDetails toTransferUser = UserDetails.getUserByName(toTranferName.data, allUsers);

							
							int oldBalance = Integer.parseInt(loggedInUser.balance);

                            InputData amountToTransfer =   InputHandler.showDialog("Enter amount to transfer");
                            Integer amountToTransferI = Integer.parseInt(amountToTransfer.data);
                            
						    if(oldBalance < amountToTransferI)
						    {
							JOptionPane.showMessageDialog(null,"Cannot deduct!! Insufficient Balance!Enter a lower amount");
							
						    }
						    else
							{
								toTransferUser.balance = String.valueOf(Integer.parseInt(toTransferUser.balance) + amountToTransferI);
								loggedInUser.balance = String.valueOf(Integer.parseInt(loggedInUser.balance) - amountToTransferI);
								JOptionPane.showMessageDialog(null,"new balance of loggedin user:" + loggedInUser.balance);
								JOptionPane.showMessageDialog(null,"new balance of recipient user:" + toTransferUser.balance);
								
							}
							} 
							
						}
					}
				
				
				break;
				//this code executes when user selects SignUp
				case "Sign Up":
					UserDetails newUser = null;
					newUser = SignupPage.getUserDetails();
					while(newUser == null)
					{
						//User already exists
						JOptionPane.showMessageDialog(null, "User already exists");
						newUser = SignupPage.getUserDetails();
					}

					if(newUser.name == null || newUser.password == null)// || newUser.balance == null)
					{
						JOptionPane.showMessageDialog(null, "Invalid values. Possibly empty values");
						selection = showSelectionPage();
						break;
					}


					boolean success = addUser(newUser);
					if(success)
					{
						System.out.print("Done");
						JOptionPane.showMessageDialog(null, "Added to file successfully");
					}
					else
					{
						System.out.print("Failed");
						JOptionPane.showMessageDialog(null, "Failed to add to file!!");
					}
					selection = showSelectionPage();
					break;
				case "Exit":
					toContinue = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Wrong selection");
					break;
			}
			break;
		}
	}

	private static String showSelectionPage() {
		SelectionPageValues[] selectionValues = SelectionPageValues.values();
		//Gave the initial selection on the dropdown menu to be login.
		SelectionPageValues initialSelection = selectionValues[0];
		//Giving enough context on the display
		SelectionPageValues selection = (SelectionPageValues) JOptionPane.showInputDialog(null, "Please choose",
				"Banking System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		return selection.message;
	}

	public static boolean addUser(UserDetails user)
	{
//		user.setStatus(InputData.InputStatus.VALID);
		return new FileOperations().writeToFile(user);
	}
}