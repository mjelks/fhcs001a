/*
 * @author mjelks
 */
package CashRegister;

import java.util.HashMap;

public class InventoryItem {

  //HashMap <String, String> myMap = new HashMap<String, String>();
  String productDescription = "";
  double productPrice = 0.0;

  InventoryItem(String productDescription, double productPrice) {
	//myMap.put("description", productDescription);
	//myMap.put("price", String.valueOf(productPrice));
	this.productDescription = productDescription;
	this.productPrice = productPrice;
  }
}
