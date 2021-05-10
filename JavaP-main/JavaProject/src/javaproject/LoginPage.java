package javaproject;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
/**
 * @author Maninder Kaur c0802040
           Pavan Kumar Guddeti c0805086
           Sai Venkata Someshwara Sarma Varahabatla c0806021
           Vamshi Ramagiri c0789785
 *
 */
//Creating a class named LoginPage to handle the Login details of the user
public class LoginPage {
	//Method to take details from a user
	public UserDetails login() {
		JTextField xField = new JTextField(5);
		JTextField yField = new JTextField(5);
      
	    JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Username"));
		myPanel.add(xField);
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		myPanel.add(new JLabel("Password"));
		myPanel.add(yField);

		int result = JOptionPane.showConfirmDialog(null, myPanel,
				"Please Enter Username and Password ", JOptionPane.OK_CANCEL_OPTION);
		//Checking the user details to confirm the name and password
		if (result == JOptionPane.OK_OPTION)
		{
			String name = xField.getText();
			String password = yField.getText();
            //checking if the username exists
			ArrayList<UserDetails> allUsers = new FileOperations().readFromFile();
			if (UserDetails.checkIfUserExists(name, allUsers))
			{
				//Checking if the username and password matches
				UserDetails validUser = UserDetails.checkIfValidUser(name, password, allUsers);
				if (validUser == null)
				{
					JOptionPane.showMessageDialog(null, "Wrong credentials !!");
					return null;
				}
				return validUser;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No user exists! Please sign up");
				return null;
			}
		}
		return null;
	}
	//Method to display Chequing or Savings Account option to the user
	public String select_account(){
		JDialog.setDefaultLookAndFeelDecorated(true);
	    Object[] selectionValues = {  "Chequing Account", "Savings Account" };
	    String initialSelection = "Select";
	    Object selection = JOptionPane.showInputDialog(null, "Please choose the type of account",
	        "Account Selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    System.out.println(selection);
	    return selection.toString();
	}
	
	//method to display utilites after selecting the savings account
	public String select_item_savings(){
		JDialog.setDefaultLookAndFeelDecorated(true);
	    Object[] selectionValues = { "Deposit","Transfer","Check Balance","Withdrawal" };
	    String initialSelection = "Select";
	    Object selection = JOptionPane.showInputDialog(null, "Please choose the next action",
	        "Utilities", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    System.out.println(selection);
	    return selection.toString();
	}
	//Method to display utilities after selecting chequing acc
	public String select_item_chequing(){
		JDialog.setDefaultLookAndFeelDecorated(true);
	    Object[] selectionValues = {"Pay Bills", "Deposit","Transfer","Check Balance","Withdrawal" };
	    String initialSelection = "Select";
	    Object selection = JOptionPane.showInputDialog(null, "Please choose the next action",
	        "Utilities", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    System.out.println(selection);
	    return selection.toString();
	}
	
}



	
