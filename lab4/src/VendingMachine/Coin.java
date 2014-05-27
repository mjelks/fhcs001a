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
  
  public int withdrawCoins(double amount) {
	int totalCoins = 0;
	
	if (amount > .04) {
	  //totalCoins = Integer (amount / .25 ).intValue() + (amount / .10).intValue() + (amount / .05).intValue();
	}
	
	return totalCoins;
  }
  
  // convert coins to 
  public void insertCoins(double amount) {
	
  }
  
  public double clear() {
	double total = this.totalValue();
	
	this.nickels = 0;
	this.dimes = 0;
	this.quarters = 0;
	
	return total;
  }
  
}
