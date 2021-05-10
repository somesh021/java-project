package javaproject;

import java.io.Serializable;
/**
 * @author Maninder Kaur c0802040
           Pavan Kumar Guddeti c0805086
           Sai Venkata Someshwara Sarma Varahabatla c0806021
           Vamshi Ramagiri c0789785
 *
 */
import java.util.ArrayList;
//Creating a class name UserDetails which inherits the properties of Serializable
public class UserDetails implements Serializable {
    public String name;
    public String password;
    public String balance;
    //Creating a constructor with user details like name,password and balance
    public UserDetails(String name, String password, String balance)
    {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    //Creating a method to get the username from all the users.
    public static UserDetails getUserByName(String name, ArrayList<UserDetails> allUsers)
    {
        if(checkIfUserExists(name, allUsers))
        {
        	//checking if the file is empty
            if(allUsers != null)
            {
            	//searching for a username in the file
                for (UserDetails user: allUsers) {
                    if(user.name.equals(name))
                    {
                        return user;
                    }
                }
            }
        }
        return null;
    }
    //Creating a method which will return true if a user exists
    public static boolean checkIfUserExists(String name, ArrayList<UserDetails> allUsers)
    {
        if(allUsers != null)
        {
            for (UserDetails user: allUsers) {
                if(user.name.equals(name))
                {
                    return true;
                }
            }
        }
        return false;
    }
    //Creating a method to check if the user enters the right username and password
    public static UserDetails checkIfValidUser(String name, String password, ArrayList<UserDetails> allUsers) {
        UserDetails validUser = null;
        for (UserDetails user: allUsers) {
            if(user.name.equals(name) && user.password.equals(password))
            {
                validUser = user;
                break;
            }
        }
        return validUser;
    }
}