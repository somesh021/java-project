package javaproject;

import javax.swing.*;
/**
 * @author Maninder Kaur c0802040
           Pavan Kumar Guddeti c0805086
           Sai Venkata Someshwara Sarma Varahabatla c0806021
           Vamshi Ramagiri c0789785
 *
 */
public class InputHandler {
   //This method displays inpit dialog box of JOptionPane
    public static InputData showDialog(String message)
    {
        InputData inputData = null;
        String data = JOptionPane.showInputDialog(message);
        inputData = new InputData(data);
        return inputData;
    }
}
