/*
 * Implement a program to simulate a simple “one-armed” bandit slot machine.
 * Need to always prompt user until they specifically exit.
 * 
 */

package SlotBandit;
import javax.swing.*;

/**
 *
 * @author mjelks
 */
public class SlotMachine {
  Object[] possibilities = {"Play", "Deposit", "Quit (cash out)"};
  String dialog_title = "Fruit Machine"; 

  int deposit = 0;
  int credits = 0;
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
	// show initial prompt
	new SlotMachine().showPrompt();
  }
  
  // this builds the initial prompt that asks user for play/deposit/quit
  public void showPrompt() {
	String selection = "";
	int int_option = 0;
	String final_element = (String)this.possibilities[this.possibilities.length-1];
	
	// ONLY EXIT if you select Quit + OK
	while (selection != final_element) {
	  // NEED TO REBUILD MESSAGE everytime so deposit gets reflected in update
	  // Welcome to FRUIT BUILDER
	  StringBuilder slot_message = new StringBuilder("Welcome to ");
	  slot_message.append(this.dialog_title.toUpperCase()); 
	  // rest of the message above the combo box
	  slot_message.append(String.format("%n%nYour credit: %d%nPlease select your option:%n", this.credits));
	
	  selection = (String)JOptionPane.showInputDialog(
			 null, 
			 slot_message, 
			 this.dialog_title, 
			 JOptionPane.PLAIN_MESSAGE, 
			 null, 
			 this.possibilities, 
			 "Play"
	  );
	  System.out.println(selection);
	  
	  int_option = (selection.equals("Play")) ? 1 : int_option;
	  int_option = (selection.equals("Deposit")) ? 2 : int_option;
	  
	  this.handleSelection(int_option);
	  
	}
	
//String selection = 
	//if (selection == JOptionPane.OK_OPTION)
  }
  
  public void handleSelection(int selection) {
	switch (selection) {
	  case 1:
		break;
	  case 2:
		this.handleDeposit();
		break;
	  default:
		this.handleQuit();
		break;
	}
  }
  
  public void handleDeposit() {
	String user_input;
	
	user_input = JOptionPane.showInputDialog(
	  null,
	  "Enter a deposit in $:", 
	  this.dialog_title, 
	  JOptionPane.PLAIN_MESSAGE
	);
	  
	this.deposit += Integer.valueOf(user_input);
	// four quarters per dollar (1 quarter == 1 play)
	this.credits = this.deposit * 4; 
  }
  
  public void summaryScreen() {
	System.out.println("THIS IS THE SUMMARY SCREEN");
  }
  
  public void handleQuit() {
	this.summaryScreen();
	System.out.println("DONE!");
	System.exit(0);
  }
  
  // method for depositing coins and storing info
  
}