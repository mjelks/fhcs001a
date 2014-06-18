/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Authentication;

/**
 *
 * @author mjelks
 */
public class Account {
  private String username;
  private String password;
  private boolean keepSignedIn;
  
  public Account() {
	this.keepSignedIn = false;
  }
  
  public Account(String username, String password, boolean keepSignedIn) {
	this.username = username;
	this.password = password;
	this.keepSignedIn = keepSignedIn;
  }
  
  public String getUsername() {
	return username;
  }
  
  public void setUsername(String text) {
	this.username = text;
  }
  
  public String getPassword() {
	return this.password;
  }
  
  public void setPassword(String text) {
	this.password = text;
  }
  
  public boolean getKeepSignedIn() {
	return this.keepSignedIn;
  }
  
  public final void setKeepSignedIn(boolean keepSignedIn) {
	this.keepSignedIn = keepSignedIn;
  }
}
