/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjelks
 */

package VendingMachine;

import javax.swing.JOptionPane;
import java.util.Random;

public class VendingMachine {
  // Class fields
  public static Coin customerCredit = new Coin(0,0,0);
  private static final double machineBalance = 500;
  
  // instance fields
  private String machineId;
  private Product[] products = new Product[9];
  
  private Object[] possibilities = 
    {"Insert Coins", "Select a product", "Return coins"};
  
  private String paneMessage = "Please select an option:";
  private String paneTitle = "Vending Machine";
    
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    new VendingMachine("abc123").operate();
  }
  
  public VendingMachine() {
	//this.machineId = new BigInteger(32, this.random).toString(32);
	this.machineId = this.randomId(6);
	this.initProducts();
  }
  
  public VendingMachine(String machineId) {
	this.machineId = machineId;
	this.initProducts();
  }
  
  public void initProducts() {
	this.products[0] = new Product("A1","Peanut",2.5);
	this.products[1] = new Product("A2","Chocolate",3.5);
	this.products[2] = new Product("A3","Cookies",2.75);
	this.products[3] = new Product("B1","Ice cream",2);
	this.products[4] = new Product("B2","Chips",3.25);
	this.products[5] = new Product("B3","Hotdog",3.25);
	this.products[6] = new Product("C1","Sprite",1.75);
	this.products[7] = new Product("C2","Coke",1.5);
	this.products[8] = new Product("C3","Water",1.25);
	System.out.println(this.products[0].getDescription());
	System.out.println(this.products[0].getQuantity());
  }
  
  // generate a Random String for our vending machine
  private String randomId(int length) {
	String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	Random rnd = new Random();
	StringBuilder sb = new StringBuilder( length );
	
	for (int i=0; i<length; i++) {
	  sb.append(AB.charAt(rnd.nextInt(AB.length())));
	}
	
	return sb.toString();
  }
  
  // this builds the initial prompt that asks user input
  public void operate() {
	String final_element = (String) this.possibilities[this.possibilities.length - 1];
	String selection = "";
	
	// ONLY EXIT if you select Quit + OK
    while (selection != final_element) {
	  int int_option = this.showVendingMachineHeader();    
      System.out.println(int_option);
      this.handleSelection(int_option);
	}
    
	
  }
  
  public void handleSelection(int selection) {
    switch (selection) {
	  case 0:
		this.handleQuit();
      case 1:
        this.showCoinInsert();
        break;
      case 2:
        this.showProduct();
        break;
	  case 3:
        this.summaryScreen();
        break;		
      default:
        this.operate();
        break;
    }
  }
  
  public void summaryScreen() {
	String message = "You should get the following change back : " 
			  + customerCredit.getQuarters() + "quarters, " 
			  + customerCredit.getDimes() + " dimes, " 
			  + customerCredit.getNickels() + " nickels";
	
	JOptionPane.showMessageDialog(
	  null,
	  message,
	  this.paneTitle,
	  JOptionPane.PLAIN_MESSAGE
	);	
  }
  
  public void handleQuit() {
	this.summaryScreen();
	System.exit(0);
  }
  
  public int showVendingMachineHeader() {
	int int_option = 0; // default to 0 (quit / default in case statement)
	String selection = (String) JOptionPane.showInputDialog(
		null,
		this.paneMessage,
		this.paneTitle,
		JOptionPane.PLAIN_MESSAGE,
		null,
		this.possibilities,
		"Insert coins"
	);
    System.out.println(selection);
	
	if (selection != null) {
	  int_option = (selection.equals(this.possibilities[0])) ? 1 : int_option;
	  int_option = (selection.equals(this.possibilities[1])) ? 2 : int_option;
	  int_option = (selection.equals(this.possibilities[2])) ? 3 : int_option;
	}
	
	return int_option;
  }
  
  public StringBuilder listProducts() {
	StringBuilder productString = new StringBuilder();
	
	productString.append("Foothill Vending Machine\n");
	int totalCounter = 0;
	int activeCounter = 0;
	while (totalCounter < this.products.length) {
	  if (this.products[totalCounter] != null) {
		if (this.products[totalCounter].getQuantity() > 0) {
		  activeCounter++;
		  productString.append(
			String.format("%6s %-25s $%3.2f",
					this.products[totalCounter].getPosition(), 
					this.products[totalCounter].getDescription(), 
					this.products[totalCounter].getPrice()
			)
		  );
		}

		if (activeCounter % 3 == 0) {
		  productString.append("\n");
		  activeCounter = 0;
		}
	  }
	  totalCounter++;
	}
	
	productString.append(
	"\nPlease input the leter + number combo to choose an item."
	);
	
	return productString;
  }
  
  public void showCoinInsert() {
	String amount = JOptionPane.showInputDialog(
	  null,
	  "Please deposit some money (must be divisible by 5).",
	  this.paneTitle,
	  JOptionPane.PLAIN_MESSAGE
	);
	System.out.println(amount);
	double converted = Double.valueOf(amount);
	customerCredit.insertCoins(Double.valueOf(amount));
	System.out.println(customerCredit.getQuarters());
	System.out.println(customerCredit.getDimes());
	System.out.println(customerCredit.getNickels());
			
  }
  
  public void needMoreCoin() {
	JOptionPane.showMessageDialog(
	  null,
	  "Not enough money. Please insert more.",
	  this.paneTitle,
	  JOptionPane.PLAIN_MESSAGE
	);
	this.showCoinInsert();
  }
  
  public void showProduct() {
	Product matchProduct = null;
	String position = JOptionPane.showInputDialog(
	  null,
	  this.listProducts(),
	  this.paneTitle,
	  JOptionPane.PLAIN_MESSAGE
	);
	
	if (position != null) {
	  for (Product product : this.products ) {
		if (product.getPosition().equals(position)) {
		  matchProduct = product;
		}
	  }
	  
	  if (matchProduct != null) {
		if (customerCredit.totalValue() < matchProduct.getPrice()) {
		  this.needMoreCoin();
		}
		boolean result = customerCredit.withdrawCoins(matchProduct.getPrice());
		if (result == true) {
		  matchProduct.removeProduct(1);
		  this.summaryScreen();
		}
	  } 
	  else {
		JOptionPane.showMessageDialog(
		  null,
		  "No such selection exists. Please try again.",
		  this.paneTitle,
		  JOptionPane.PLAIN_MESSAGE
		);
		this.showProduct();
	  }

	}
	
  }
  
}
