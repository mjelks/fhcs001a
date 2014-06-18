/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Authentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mjelks
 */
public class SignInSystem {
  public int numberOfAccts = 0;
  // each array element will be a login and password separated by a space
  public String[] accountList;			
  // each element will be a string of the login only
  public String[] loginsOnly;				
  // each element will be a string of the password only
  public String[] pwordsOnly;				
  public Account account = null;
  
  public static void main(String[] args) {
    // show initial prompt
    new SignInSystem().startApp();
  }
  
  public SignInSystem() {
	this.account = new Account();
  }
  
  public void startApp() {
	System.out.println("INVOKED!");
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new AuthenticationFrame();
      }
    });
  }
  
  public static void quitApp() {
	System.exit(0);
  }
  
  public boolean authenticate(String user, String pword, boolean keepLoggedIn) 
		  throws IOException {
//	boolean approved = false;
	
	getLoginList();
	sortLoginList();
	
	

	findAccount(user, pword, keepLoggedIn);
	System.out.println("sjafka");
	System.out.println(account);
//	System.out.println(account2.getUsername());
    boolean approved = (account.getUsername() == null) ? false : true;
	System.out.println(account.getUsername());
	
	// set it if we have a match
	if (approved) {
	  System.out.println("HHSDF HERE!");
	  System.out.println(keepLoggedIn);
	  account.setKeepSignedIn(keepLoggedIn);
	}
	
	return approved;
  }

  public void findAccount(String user1, String pword1, boolean keepLoggedIn) 
  {
	System.out.println("BEGIN");
	System.out.println(account.getUsername());
	System.out.println(user1);
	// don't need to check password if account is already set
	if (user1.equals(account.getUsername()) && keepLoggedIn) 
	{
	  for (int y = 0; y < numberOfAccts; y++) {
		if ((loginsOnly[y].equals(user1))) {
		  JOptionPane.showMessageDialog(
			  null,
			  "You are authenticated, and you DON't NEED a password. ",
			  "Success", JOptionPane.PLAIN_MESSAGE
			);
		}
	  }
	} 
	else {
	  for (int y = 0; y < numberOfAccts; y++) {
		if ((loginsOnly[y].equals(user1)) && (pwordsOnly[y].equals(pword1))) {
		  account = new Account(user1, pword1, keepLoggedIn);
		}
	  }
	}

//	return tmp;
  }

  // this method adds each line from the accts.txt login list to an array
  public void getLoginList() throws IOException {				
	BufferedReader br = null;
	String delimeter = "[ $]";		//
    
    // method call to find out how many accounts are in the txt file
	numberOfAccts = lineNumbers();							
	accountList = new String[numberOfAccts];
	loginsOnly = new String[numberOfAccts];
	pwordsOnly = new String[numberOfAccts];

	try {
      InputStreamReader reader = new InputStreamReader(
              SignInSystem.class.getResourceAsStream("accts.txt"), "UTF-8");
	  br = new BufferedReader(reader);
	  String line = "";

	  int i = 0;
	  int n = 0;
	  
	  while ((line = br.readLine()) != null) {
        // adding account/password pair (in single strings) to array
		accountList[i] = line;							

        // this splits each file line as it's downloaded
		String[] fields = line.split(delimeter);		
		for (String field : fields) {
		  //System.out.print(field + " ");
		  if (n % 2 == 0) {
            // adding only logins to array
			loginsOnly[i] = field;					
			//System.out.println("login: "+ field);
		  } else {
            // adding only passwords to array
			pwordsOnly[i] = field;					
		
		  }
		  n++;
		}
		i++;
	  }
	  br.close();

	} catch (IOException e) {
	  e.printStackTrace();
	  if (br != null) {
		br.close();
		System.exit(0);
	  }
	}
  }
  
  public void sortLoginList() {
	String tmpLogin;
	String tmpPword;

	for (int p = 0; p < (numberOfAccts - 1); p++) {
	  tmpLogin = loginsOnly[p];
	  int r;
	  for (r = (p + 1); r < numberOfAccts; r++) {

		int compareValue = (loginsOnly[p].compareTo(loginsOnly[r]));
		if (compareValue > 0) {
		  tmpLogin = loginsOnly[p];
		  loginsOnly[p] = loginsOnly[r];
		  loginsOnly[r] = tmpLogin;
		  tmpPword = pwordsOnly[p];								
		  pwordsOnly[p] = pwordsOnly[r];
		  pwordsOnly[r] = tmpPword;
		}
	  }
	}
  }
  
  // figures out how many accounts are in the txt file
  public int lineNumbers() throws IOException {				
	BufferedReader br = null;
	try {
	  InputStreamReader reader = new InputStreamReader(
              SignInSystem.class.getResourceAsStream("accts.txt"), "UTF-8");
	  br = new BufferedReader(reader);
			//String line = "";

	  while ((br.readLine()) != null) {
		numberOfAccts++;
	  }
	  br.close();

	} catch (IOException e) {
	  e.printStackTrace();
	  if (br != null) {
		br.close();
		System.exit(0);
	  }
	}
	return numberOfAccts;
  }
  
  
}
