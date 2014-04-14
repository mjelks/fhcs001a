/*
  @author mjelks

  Need to output two types of business cards:
  - A business card for a corporate CEO
  - A business card for a furniture store

  Sample output:

*****************************************************************

*                         Home Decor & Design                   *

*          Tel: 650-xxx-xxxx             123  San Miguel Ave    *

*          Fax: 650-xxx-xxxx             San Jose, CA 95121     *

*															    *

*                         info@homedecordesign.com              *

*                         www.homedecordesign.com               *

*****************************************************************
 */

package BusinessCard;

public class BusinessCardPrint {

  public static void main (String args []) {
	cardOne();
	System.out.println();
	cardTwo();
  }
  
  public static void cardOne() {
	String  title = "Corporate CEO Card";
	long telephone = 5555555555L;
	long fax = 5554445554L;
	String  address_1 = "123 Oak Park Way";
	String  city = "New York";
	String  state = "NY";
	String postal_code = "10075";
	String  email = "info@corporateexec.com";
	String  website_url = "www.corporateexec.com";
	printCard(title, telephone, fax, address_1, city, state, 
			postal_code, email, website_url);
  }
  
  public static void cardTwo() {
	String  title = "Furniture Store Card";
	long telephone = 2014448975L;
	long fax = 9785457812L;
	String  address_1 = "125485 Paterson Falls Way";
	String  city = "Paterson";
	String  state = "NJ";
	String postal_code = "07474";
	String  email = "info@furniturestoreway.com";
	String  website_url = "www.furniturestoreway.com";
	printCard(title, telephone, fax, address_1, city, state, 
			postal_code, email, website_url);
  }
  
  public static void printCard(
		String title, long telephone, long fax, String address_1, 
		String city, String state, String postal_code, String email, 
		String website_url
  ) {
	printBorder();
	System.out.println();
	formatSimple(title);
	System.out.println();
	formatTelephoneAddress1(telephone, address_1);
	System.out.println();
	formatFaxAddress2(fax, city, state, postal_code);
	System.out.println();
	formatSimple(email);
	System.out.println();
	formatSimple(website_url);
	System.out.println();
	printBorder();
  }
  
  // print the border with the 
  public static void printBorder() {
	Integer width = 65;
	char border_char = '*';
	for (int i = 0; i < width; i++) {
	  System.out.print(border_char);
	}
	System.out.print("\n");
  }
  
  public static void formatSimple(String line_item) {
	System.out.print("*");
	printPadding(65, line_item, false, false);
	System.out.print(line_item);
	printPadding(65, line_item, false, true);
	System.out.print("*\n");
  }
  
  public static void formatTelephoneAddress1(long telephone, String address_1) {
	String phone = String.valueOf(telephone);
	String phone_portion = "       Tel: " + 
	  phone.replaceAll
	  ("([0-9][0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9])", "$1-$2-$3");
	String line = phone_portion + "             " + address_1;
	System.out.print("*");
	System.out.print(line);
	printPadding(65, line, true, false);
	System.out.print("*\n");
  }
  
  public static void formatFaxAddress2(long fax, String city, String state, String postal_code) {
	String fax_number = String.valueOf(fax);
	String fax_portion = 
	  "       Fax: " + 
	  fax_number.replaceAll
		("([0-9][0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9])", "$1-$2-$3");
	String line = 
	  fax_portion + "             " + city + "," + state + " " + postal_code;
	System.out.print("*");
	System.out.print(line);
	printPadding(65, line, true, false);
	System.out.print("*\n");
  }
  
  public static void printPadding(int width, String text, boolean right_only, boolean right_fix) {
	// width will be 65 for now
	// centering will be done via algo
	// subtract by 2 for the *
	int padding_amount = (width - 2 - text.length());
	if (right_only == false) {
	  padding_amount /= 2;
	}
	for (int i = 0; i < padding_amount; i++) {
	  System.out.print(" ");
	}
	
	// add one more space for even text 
	// fixes issue with dangling asterisk
	if (right_fix && text.length() % 2 == 0) {
	  System.out.print(" ");  
	}
	
  }
  
}
