package javaproject;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
/**
 * @author Maninder Kaur c0802040
           Pavan Kumar Guddeti c0805086
           Sai Venkata Someshwara Sarma Varahabatla c0806021
           Vamshi Ramagiri c0789785
 *
 */
//Creating a class which will have different methods related to File Operations
public class FileOperations {
    //This value holds details of all the users
    ArrayList<UserDetails> allUsers = new ArrayList<UserDetails>();
    public FileOperations(){

    }
    //This method returns true if we were able to write the user data to file
    public boolean writeToFile(UserDetails newUser)
    {
    	//checking if a user already exists
        ArrayList<UserDetails> allUsers = new FileOperations().readFromFile();
        if(allUsers == null)
        {
            allUsers = new ArrayList<>();
        }
        //if user does not exist we will add the user to the text file
        allUsers.add(newUser);
        try{
            FileOutputStream writeData = new FileOutputStream("users.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(allUsers);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    //this method reads the data from the file
    public ArrayList<UserDetails> readFromFile()
    {
        ArrayList<UserDetails> users = null;
        try{
            FileInputStream readData = new FileInputStream("users.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            users = (ArrayList<UserDetails>) readStream.readObject();
            readStream.close();
            System.out.println(users.toString());
        }catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }
}
