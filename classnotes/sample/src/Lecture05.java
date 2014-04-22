

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjelks
 */
import javax.swing.JOptionPane;

public class Lecture05 {
    public static void main (String [ ] args) {
        standard();
        combo();
        outputDialog();
        
    } // end main method    
    
    public static void standard() {
        String buffer;
        buffer = (String) JOptionPane.showInputDialog(null, "First Name", "What's your name?",JOptionPane.INFORMATION_MESSAGE,null,null,null);
    }
    
    public static void combo() {
        String[] choices = {"choice1", "choice2", "choice3" };
        String buffer;
        buffer = (String) JOptionPane.showInputDialog(null, "Prompt", "Make a choice",JOptionPane.PLAIN_MESSAGE,null,choices,choices[0]);
    }
    
    public static void outputDialog() {
       JOptionPane.showMessageDialog(null,"HEY!","BOX TITLE", JOptionPane.PLAIN_MESSAGE);
    }
}
