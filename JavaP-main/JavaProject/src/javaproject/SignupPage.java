package javaproject;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Maninder Kaur c0802040
           Pavan Kumar Guddeti c0805086
           Sai Venkata Someshwara Sarma Varahabatla c0806021
           Vamshi Ramagiri c0789785
 *
 */
//Creating a class for signup
public class SignupPage {
	//Method to get the user details
	public static UserDetails getUserDetails()
	{
		InputData name = InputHandler.showDialog("Enter your name");
		//Reads the details of all user to check if a username exists
		ArrayList<UserDetails> allUsers = new FileOperations().readFromFile();
        
		if(name.data != null && UserDetails.checkIfUserExists(name.data, allUsers))
		{
			return null;
		}
        //Taking the values of password and balance(for educational purposes)
		InputData password = InputHandler.showDialog("Enter your password");
		InputData balance = InputHandler.showDialog("Enter your balance");

		UserDetails user = new UserDetails(name.data, password.data, balance.data);
		return user;

	}


}
