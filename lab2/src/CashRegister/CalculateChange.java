/*
 @author mjelks

 Sample run of the cashier program: (bold-face is user input)

 Scan an item: Chocolate Chip

 Enter price: $3.99

 Scan an item: Sharp Microwave

 Enter price: $75.40

 Scan an item: Logitech Wireless Mouse

 Enter price: $35.99

 Customer pays:  $150

 

 ============================================

 Change

 Dollars:   34

 Quarters:  2

 Dimes:       1

 Nickels:     0

 Pennies:     2    

 *******************************************************************

 PURCHASE RECEIPT

 Chocolate Chip                   $    3.99

 Sharp Microwave                  $   75.40

 Logitech Wireless Mouse          $   35.99

 Total:                           $ 115.38

 Amount paid:                     $ 150.00

 Change:                          $  34.62

 ********************************************************************

 */
package CashRegister;

import java.io.*;    //  include Java I/O library package
import java.util.ArrayList; // want to store value input into array
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CalculateChange {

  HashMap<String, InventoryItem> productMap = new HashMap<String, InventoryItem>();
  
  double customerAmount = 0.0;
  int counter = 0;

  public static void main(String[] args) {
    HashMap productMap = new CalculateChange().getInput();
    double customerAmount = new CalculateChange().getCustomerAmount();
    double total = new CalculateChange().calculateTotal(productMap);
    new CalculateChange().printChange(total, customerAmount);
    new CalculateChange().printReceipt(productMap, customerAmount);
  } // end main method

  public HashMap getInput() {
    try {
      String description;
      double price;

      String buffer;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // read a string
      System.out.print("Scan an item: ");
      buffer = br.readLine();
      description = buffer;

      // read double
      System.out.print("Enter price: $");
      buffer = br.readLine();
      price = Double.parseDouble(buffer);

      InventoryItem priceItem = new InventoryItem(description, price);

      productMap.put(new Integer(this.counter).toString(), priceItem);
      this.counter++;

      System.out.print("Scan another item? ");
      buffer = br.readLine();

	  if (buffer.equals("y") || buffer.equals("yes")) {
        this.getInput();
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    return productMap;
  }
  
  public double getCustomerAmount() {
    try {
      String buffer;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Customer amount: $");
      buffer = br.readLine();
      this.customerAmount = Double.parseDouble(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return this.customerAmount;
  }

  public double calculateTotal(HashMap productMap) {
    double total = 0.00;
    HashMap<String, InventoryItem> items = productMap;

    for (String key : items.keySet()) {
      //System.out.println("key: " + key + " value: " + items.get(key).productDescription);
      total += items.get(key).productPrice;
    }

    return total;
  }
  
  public void printChange(double total, double customerAmount) {
	if (total > customerAmount) {
      System.out.println("Please enter an amount that is greater than the total of all items");
    } 
	else {
      HashMap<String, Integer> changeMap = this.calculateChange(customerAmount - total);
	  
	  System.out.println("============================================");
	  System.out.println();
	  System.out.println("Change");
	  System.out.println();
	  System.out.println("Hundreds: " + changeMap.get("hundreds"));
	  System.out.println();
	  System.out.println("Fifties: " + changeMap.get("fifties"));
	  System.out.println();
	  System.out.println("Twenties: " + changeMap.get("twenties"));
	  System.out.println();	  
	  System.out.println("Tens: " + changeMap.get("tens"));
	  System.out.println();
	  System.out.println("Fives: " + changeMap.get("fives"));
	  System.out.println();
	  System.out.println("Ones: " + changeMap.get("ones"));
	  System.out.println();
	  System.out.println("Quarters: " + changeMap.get("quarters"));
	  System.out.println();
	  System.out.println("Dimes: " + changeMap.get("dimes"));
	  System.out.println();
	  System.out.println("Nickels: " + changeMap.get("nickels"));
	  System.out.println();
	  System.out.println("Pennies: " + changeMap.get("pennies"));
	  System.out.println();
	  System.out.println("============================================");
	  System.out.println();

    }
  }
  
  public HashMap calculateChange(double customerAmount) {
	int dollarAmount = 0;
    double changeAmount = 0;
	int convertedAmount = 0;
	HashMap<String, Integer> changeMap = new HashMap<String, Integer>();
	
	dollarAmount = (int) customerAmount; // grab the int value (left of decimal)
	// get the stuff after the decimal place (WE SHOULD REALLY BE USING BigDecimal)
    changeAmount = (customerAmount % 1) * 100;
	convertedAmount = (int) Math.round(changeAmount);
	
	int hundreds = dollarAmount / 100;
	int fifties = ( (dollarAmount - (100 * hundreds)) / 50);
	int twenties = ( (dollarAmount - (100 * hundreds) - (50 * fifties)) / 20);
	int tens = ( (dollarAmount - (100 * hundreds) - (50 * fifties) - (20 * twenties)) / 10);
	int fives = ( (dollarAmount - (100 * hundreds) - (50 * fifties) - (20 * twenties) - (10 * tens)) / 5);
	int ones = ( (dollarAmount - (100 * hundreds) - (50 * fifties) - (20 * twenties) - (10 * tens) - (5 * fives) ));
	
	int quarters = convertedAmount / 25;
	int dimes = ( (convertedAmount - (25 * quarters)) / 10);
	int nickels = ( ( convertedAmount - (25 * quarters) - (10 * dimes)) / 5);
	int pennies = (convertedAmount - (25 * quarters) - (10 * dimes) - (5 * nickels) );
	
	changeMap.put("hundreds", hundreds);
	changeMap.put("fifties", fifties);
	changeMap.put("twenties", twenties);
	changeMap.put("tens", tens);
	changeMap.put("fives", fives);
	changeMap.put("ones", ones);
	
	changeMap.put("quarters", quarters);
	changeMap.put("dimes", dimes);
	changeMap.put("nickels", nickels);
	changeMap.put("pennies", pennies);
	
	return changeMap;
  }
  
  //public void output
  // output with some formatting -- the receipt
  public void printReceipt(HashMap productMap, double customerAmount) {    
	HashMap<String, InventoryItem> items = productMap;
	double total = this.calculateTotal(productMap);
	
	// print top section
	System.out.println("********************************************");
	System.out.println();
	System.out.println("PURCHASE RECEIPT");
	System.out.println();
	
	// loop through the product hash map and output the description and price
	for (String key : items.keySet()) {
	  System.out.format ("%-16s\t\t$%8.2f%n", items.get(key).productDescription, items.get(key).productPrice );
	  System.out.println();
	}
	
	// formatted print total
	System.out.format ("%-16s\t\t$%8.2f%n", "Total:", total);
	System.out.println();
	
	// formatted print amount paid
	System.out.format ("%-16s\t\t$%8.2f%n", "Amount Paid:", customerAmount);
	System.out.println();

	// formatted print change
	System.out.format ("%-16s\t\t$%8.2f%n", "Change:", customerAmount - total);
	System.out.println();
	
	// print bottom border
	System.out.println("********************************************");
    
  }
} // end class
