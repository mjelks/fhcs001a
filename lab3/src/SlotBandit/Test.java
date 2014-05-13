/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SlotBandit;

/**
 *
 * @author mjelks
 */
public class Test {
  
  public static void main(String[] args) {
	// show initial prompt
	new Test().foo();
    int sum = new Test().returnAddedNumbers(12345, 0);
    System.out.println(sum);
  }
  
  public void foo() {
//    this.balances = new double;
//    System.out.println(this.balances);
//    int x;
//    char c;
//    c = 97;
      double[] balances;
      balances = new double[200];
      System.out.println(balances[199]);
  }
  
  public static int returnAddedNumbers(int number, int sum) {
    while (number > 0) {
      sum += number % 10;
      number -= (number % 10);
      number /= 10;
      new Test().returnAddedNumbers(number, sum);
    }
    
    return sum;
  }
  
}

