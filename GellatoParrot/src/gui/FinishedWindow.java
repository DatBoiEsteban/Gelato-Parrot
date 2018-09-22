package gui;

import javax.swing.JOptionPane;

public class FinishedWindow {

    public static void infoBox(String infoMessage, String titleBar)
    {  
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
