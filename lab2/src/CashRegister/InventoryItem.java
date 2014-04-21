/*
* @author mjelks
*/

package CashRegister;

public class InventoryItem {
  String  productDescription = "";
  double  productPrice = 0.0;
  
  InventoryItem(String productDescription, double productPrice) {
	this.productDescription = productDescription;
	this.productPrice = productPrice;
  }
}
