/*
 * Implement a program to simulate a simple “one-armed” bandit slot machine.
 * Need to always prompt user until they specifically exit.
 * 
 */
package SlotBandit;

import javax.swing.*;
import java.util.Arrays; // used for debugging

/**
 *
 * @author mjelks
 */
public class SlotMachine {

  Object[] possibilities = {"Play", "Deposit", "Quit (cash out)"};
  String dialog_title = "Fruit Machine";

  int deposit = 0;
  int credits = 0;
  int finalScore;
  String winnerText;

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
    String final_element
            = (String) this.possibilities[this.possibilities.length - 1];

    // ONLY EXIT if you select Quit + OK
    while (selection != final_element) {
      int int_option = 0; // default to 0 (quit / default in case statement)
      this.finalScore = 0; // init to 0
      this.winnerText = ""; // init to empty

      // NEED TO REBUILD MESSAGE everytime so deposit gets reflected in update
      // Welcome to FRUIT BUILDER
      StringBuilder slot_message = new StringBuilder("Welcome to ");
      slot_message.append(this.dialog_title.toUpperCase());
      // rest of the message above the combo box
      slot_message.append(String.format(
              "%n%nYour credit: %d%nPlease select your option:%n",
              this.credits)
      );

      selection = (String) JOptionPane.showInputDialog(
              null,
              slot_message,
              this.dialog_title,
              JOptionPane.PLAIN_MESSAGE,
              null,
              this.possibilities,
              "Play"
      );
      System.out.println(selection);

      if (selection != null) {
        int_option = (selection.equals("Play")) ? 1 : int_option;
        int_option = (selection.equals("Deposit")) ? 2 : int_option;
      }
      System.out.println(int_option);
      this.handleSelection(int_option);

    }

  }

  public void handleSelection(int selection) {
    switch (selection) {
      case 1:
        this.handlePlay();
        break;
      case 2:
        this.handleDeposit();
        break;
      default:
        this.handleQuit();
        break;
    }
  }

  public void handlePlay() {
    if (this.credits >= 1) {
      this.crankIt();
    } else {
      JOptionPane.showMessageDialog(
              null,
              "Please deposit some money.",
              this.dialog_title,
              JOptionPane.PLAIN_MESSAGE
      );
      this.handleDeposit();
    }
  }

  public void crankIt() {
    String[] charOptions = {"A", "D", "J", "O", "V"};
    int minimum = 0;
    int maximum = charOptions.length;

    // decrement the credits
    this.credits--;

    // init a 3 char array with the String value
    String[] result = new String[3];
    for (int i = 0; i < 3; i++) {
      // generate 1 of the chars based on this :
      // http://stackoverflow.com/questions/363681/
      // generating-random-numbers-in-a-range-with-java
      int randomNum = minimum + (int) (Math.random() * maximum);
      result[i] = charOptions[randomNum];
    }

    // TESTING SPINS
    //String[] resultTest = {"J", "A", "V"};
    //String spinString = this.parseSpin(resultTest);
    String spinString = this.parseSpin(result);

    JOptionPane.showMessageDialog(
            null,
            "Spinning! --- Results: " + spinString,
            this.dialog_title,
            JOptionPane.PLAIN_MESSAGE
    );

  }

  // perform the rules logic for winning credits and return string
  /*
   Winning combinations
   Coins won
   O O D ==> 10000
   JAV   ==> 5000
   Same 3 symbols  ==> 200
   Any 2 consecChar Os (JOO, OOA, DOO,..) ==> 100
   Any 2 consecChar Js (JJA, OJJ, DJJ, …) ==> 50
   Any 1 A ==> 2
   */
  public String parseSpin(String[] result) {
    String spinnerResult = Arrays.toString(result);

    // just go down the list of conditions. the finalScore is NOT an aggregate, 
    // so it should be overwritten by the higher amount if there is a match
    // Any 1 A ==> 2
    if (spinnerResult.contains("A")) {
      this.finalScore = 2;
      this.winnerText = "There was an 'A' in your spin. You win 2 credits!";
    }

    // Any 2 consecChar Js (JJA, OJJ, DJJ, …) ==> 50
    this.consecChar("J", result, 50);

    //Any 2 consecChar Os (JOO, OOA, DOO,..) ==> 100
    this.consecChar("O", result, 100);

    //Same 3 symbols  ==> 200
    if (result[0].equals(result[1]) && result[1].equals(result[2])) {
      this.finalScore = 200;
      this.winnerText = "All three characters match. "
              + "You win " + this.finalScore + " credits!";
    }

    // JAV   ==> 5000
    if (spinnerResult.equals("[J, A, V]")) {
      this.finalScore = 5000;
      this.winnerText = "You spelled JAV. "
              + "You win " + this.finalScore + " credits!";
    }
    // OOD   ==> 10000
    if (spinnerResult.equals("[O, O, D]")) {
      this.finalScore = 10000;
      this.winnerText = "You spelled OOD. "
              + "You win " + this.finalScore + " credits!";
    }

    // add the winner logic to the prompt box
    if (!this.winnerText.isEmpty()) {
      spinnerResult += "\n" + this.winnerText;
    }

    // finally, deposit the additional credits to their account
    this.credits += this.finalScore;

    // return the string with the spin values and winner result
    return spinnerResult;
  }

  // take the full length of the spin array -1 and test element 0 vs 1, 1 vs 2
  // this will check if consecChar
  public void consecChar(String character, String[] result, int creditValue) {
    for (int i = 0; i < result.length - 1; i++) {
      if (result[i].equals(character) && result[i].equals(result[i + 1])) {
        this.finalScore = creditValue;
        this.winnerText = "There were 2 consecutive \""
                + character + "'s\". You win " + creditValue + " credits!";
      }
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
    JOptionPane.showMessageDialog(
            null,
            "Thank you for playing. "
            + "Your total credits after quitting is: " + this.credits,
            this.dialog_title, JOptionPane.PLAIN_MESSAGE
    );
  }

  public void handleQuit() {
    this.summaryScreen();
    System.exit(0);
  }

}
