/**
 *
 * @author mjelks
 */

package VendingMachine;

public class Coin {
  private int nickels;
  private int dimes;
  private int quarters;
  
  public Coin() {
	this.nickels = 0;
	this.dimes = 0;
	this.quarters = 0;
  }
  
  public Coin(int nickels, int dimes, int quarters) {
	this.nickels = nickels;
	this.dimes = dimes;
	this.quarters = quarters;
  }
  
  public void setNickels(int nickels) {
	this.nickels = nickels;
  }
  
  public int getNickels() {
	return this.nickels;
  }
  
  public void setDimes(int dimes) {
	this.dimes = dimes;
  }
  
  public int getDimes() {
	return this.dimes;
  }
  
  public void setQuarters(int quarters) {
	this.quarters = quarters;
  }
  
  public int getQuarters() {
	return this.quarters;
  }
  
  public double totalValue() {
	return (this.nickels * .05) + (this.dimes * .10) + (this.quarters * .25);
  }
  
  public boolean withdrawCoins(double productAmount) {
	boolean valid = false;
	
	int retval = Double.compare(productAmount, this.totalValue());
	System.out.println(retval);
	// if productAmount less than or == total, we're good
	if (retval < 0 || retval == 0) {
	  valid = true;
	  int quartersAmount = (int) (productAmount / .25);	
	  int dimesAmount = (int) ( (productAmount - (quartersAmount * .25)) / .10);
	  int nickelsAmount = (int) ( (productAmount - (quartersAmount * .25) - (dimesAmount * .10)) / .05);

	  if (quartersAmount > 0) {
		this.quarters -= quartersAmount;
	  }

	  if (dimesAmount > 0) {
		this.dimes -= dimesAmount;
	  }

	  if (nickelsAmount > 0) {
		this.nickels -= nickelsAmount;
	  }
	}
	
	return valid;
  }
  
  // convert amount to coins
  public void insertCoins(double amount) {
	int quartersAmount = (int) (amount / .25);	
	int dimesAmount = (int) ( (amount - (quartersAmount * .25)) / .10);
	int nickelsAmount = (int) ( (amount - (quartersAmount * .25) - (dimesAmount * .10)) / .05);
	
	if (quartersAmount > 0) {
	  this.quarters += quartersAmount;
	}
	
	if (dimesAmount > 0) {
	  this.dimes += dimesAmount;
	}
	
	if (nickelsAmount > 0) {
	  this.nickels += nickelsAmount;
	}
	
  }
  
  public double clear() {
	double total = this.totalValue();
	
	this.nickels = 0;
	this.dimes = 0;
	this.quarters = 0;
	
	return total;
  }
  
}
