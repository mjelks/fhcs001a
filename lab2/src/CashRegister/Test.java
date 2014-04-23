/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CashRegister;

/**
 *
 * @author mjelks
 */
public class Test {
  public static void main(String[] args) {
	double amt = 12.22;
	double customerAmount = 12.51;
	int dollars = (int) customerAmount;
	double fractionalPart = (amt % 1) * 100;
	
	double changeAmount = (amt % 1) * 100;
	//int convertedAmount = (int) (Math.round(changeAmount / 0.5) * 0.5);
	
	System.out.println(dollars);
	System.out.println((int) Math.ceil(fractionalPart));
	
	int convertedAmount = 17;
	int quarters = convertedAmount / 25;
	int dimes = ( (convertedAmount - (25 * quarters)) / 10);
	int nickels = ( ( convertedAmount - (25 * quarters) - (10 * dimes)) / 5);
	int pennies = (convertedAmount - (25 * quarters) - (10 * dimes) - (5 * nickels) );
	System.out.println(quarters);
	System.out.println(dimes);
	//System.out.println(convertedAmount);
	
//	int dollarAmount = 282;
	
	//String hundredAmount = String.valueOf(dollarAmount / 100);
	//System.out.println(hundredAmount);
	
//	int hundreds = dollarAmount / 100;
//	int fifties = ( (dollarAmount - (100 * hundreds)) / 50);
//	int twenties = ( (dollarAmount - (100 * hundreds) - (50 * fifties)) / 20);
//	int tens = ( (dollarAmount - (100 * hundreds) - (50 * fifties) - (20 * twenties)) / 10);
//	int ones = ( (dollarAmount - (100 * hundreds) - (50 * fifties) - (20 * twenties) - (10 * tens) ));
//	System.out.println(hundreds);
//	System.out.println(fifties);
//	System.out.println(twenties);
//	System.out.println(tens);
//	System.out.println(ones);
	
  }
}
