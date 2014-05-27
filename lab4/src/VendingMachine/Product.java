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

public class Product {
  private String position;
  private String description;
  private double price;
  private int quantity;
  
  public Product() {
	this.position = "";
	this.description = "";
	this.price = 0;
	this.quantity = 0;
  }
  
  public void sell() {
	
  }
  
  public void setPosition(String position) {
	this.position = position;
  }
  
  public String getPosition() {
	return position;
  }
  
  public void setDescription(String description) {
	this.description = description;
  }
  
  public String getDescription() {
	return description;
  }
  
  public void setPrice(double Price) {
	this.price = price;
  }
  
  public double getPrice() {
	return price;
  }
  
  public void setQuanity(int quantity) {
	this.quantity = quantity;
  }
  
  public int getQuantity() {
	return quantity;
  }
  
  public boolean isEmpty() {
	return (this.quantity == 0) ? true : false;
  }
  
  public void addProduct(int additional) {
	this.quantity += additional;
  }
  
  public void removeProduct(int additional) {
	this.quantity -= additional;
  }
  
}
