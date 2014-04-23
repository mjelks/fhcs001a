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

  HashMap<String, InventoryItem> myMap = new HashMap<String, InventoryItem>();
    //Map<String,String> priceData = new HashMap<String,String>();
  //String  productDescription = "";
  //double  productPrice = 0.0;
  double customerAmount = 0.0;
  int counter = 0;

  int dollars;
  int quarters;
  int dimes;
  int nickels;
  int pennies;

  public static void main(String[] args) {
    HashMap myMap = new CalculateChange().getInput();
    double customerAmount = new CalculateChange().getCustomerAmount();
    double total = new CalculateChange().calculateTotal(myMap);
    new CalculateChange().calculateChange(total, customerAmount);
    new CalculateChange().printOutput(myMap, customerAmount);
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

      myMap.put(new Integer(this.counter).toString(), priceItem);
      this.counter++;

      System.out.print("Scan another item? ");
      buffer = br.readLine();
      //System.out.println("Buffer: " + buffer);
      if (buffer.equals("y") || buffer.equals("yes")) {
        this.getInput();
      }
      
      //System.out.println(this.myMap);
      //System.out.println(foo.productDescription);
    } catch (IOException e) {
      e.printStackTrace();
    }

	// output results without formatting
//	System.out.println ("Product ID: " + this.productID );
//	System.out.println ("Product price: " + this.productPrice );
//	System.out.println ("Product description: " + this.productDescription );
    // output with some formatting
    //System.out.println(this.myMap);
    return myMap;
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

  public double calculateTotal(HashMap myMap) {
    double total = 0.00;
    HashMap<String, InventoryItem> items = myMap;

    for (String key : items.keySet()) {
      //System.out.println("key: " + key + " value: " + items.get(key).productDescription);
      total += items.get(key).productPrice;
    }

    return total;
  }
  
  public void calculateChange(double total, double customerAmount) {
    double change = 0;
    if (total > customerAmount) {
      System.out.println("Please enter an amount that is greater than the total of all items");
    } else {
      this.dollars = (int) customerAmount; // grab the int value (left of decimal)      
      change = this.dollars - customerAmount;
      System.out.println("Change");
      System.out.println();
      System.out.println("Dollars: " + this.dollars);
      System.out.println();
      System.out.println("CHANGE???: " + change);
      System.out.println("Quarters: ");
      System.out.println();
      System.out.println("Dimes: ");
      System.out.println();
      System.out.println("Nickels: ");
      System.out.println();
      System.out.println("Pennies: ");
      System.out.println();
    }
  }

  public void printChangeOutput(HashMap myMap) {

  }

  //public void output
  public void printOutput(HashMap myMap, double customerAmount) {
    // output with some formatting
    System.out.println("HEY!");
    System.out.println("TOTAL: " + this.calculateTotal(myMap));
    System.out.println("Customer amt: " + customerAmount);
    //System.out.println(myMap);
  }
} // end class
