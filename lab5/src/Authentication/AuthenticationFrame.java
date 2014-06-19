/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

//Java Core Package  
import javax.swing.*;
//Java Extension Package  
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 *
 * @author mjelks
 */
public class AuthenticationFrame extends JFrame {

  private final int textFieldWidth = 20;
  private String title = "Sign in to Foothill CS";
  
  private JTextField userTextField;
  private JPasswordField passTextField;
  private JCheckBox keepLoggedIn;
  

  //Setting up GUI  
  public AuthenticationFrame() {
	//Exit Property of the Window  
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setTitle(this.title);

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int screenWidth = 700;//dim.width;
	int screenHeight = 350;//dim.height;

	  //Set Size of the Window (WIDTH, HEIGHT)  
	//setSize(500,740);  
	setSize(screenWidth / 2, screenHeight / 2);
	setLocationRelativeTo(null);

	  // need a grid layout of 3 rows , 1 column
	JPanel containerPanel = new JPanel();
	containerPanel.setLayout(new BorderLayout());

	containerPanel.add(userPass(), BorderLayout.CENTER);

	Container pane = getContentPane();
	setContentPane(pane);

	//Adding the main JPanel to the container  
	pane.add(containerPanel);

	/**
	 * Set all the Components Visible. If it is set to "false", the components
	 * in the container will not be visible.
	 */
	setVisible(true);
	setResizable(false);
  }

  // user panel + labael	
  public JPanel userPass() {

	JPanel userPanel = new JPanel();
	userPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	// username row
	JLabel userLabel = new JLabel("Username: ");
	userLabel.setDisplayedMnemonic(KeyEvent.VK_U);
	userTextField = new JTextField(textFieldWidth);
	userLabel.setLabelFor(userTextField);
	// attach
	userPanel.add(userLabel);
	userPanel.add(userTextField);

	// password row
	JLabel passLabel = new JLabel("Password: ");
	passLabel.setDisplayedMnemonic(KeyEvent.VK_P);
	passTextField = new JPasswordField(textFieldWidth);
	passTextField.setEchoChar('$');
	passLabel.setLabelFor(passTextField);
	// attach
	userPanel.add(passLabel);
	userPanel.add(passTextField);

	// loggedin row
	userPanel.add(keepLoggedIn());

	// button row
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	buttonPanel.add(signInButton());
	buttonPanel.add(clearAllButton());
	buttonPanel.add(cancelButton());

	userPanel.add(buttonPanel);

	return userPanel;
  }

  public JPanel keepLoggedIn() {
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.CENTER));

	keepLoggedIn = new JCheckBox("Keep me signed in");
	panel.add(keepLoggedIn);

	return panel;
  }

  public JButton signInButton() {
	JButton signInButton = new JButton("Sign In");
	
	signInButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		char[] password = passTextField.getPassword();
		String passy = new String(password);
		SignInSystem sis = new SignInSystem();
		try {
		  boolean result = sis.authenticate(
				  userTextField.getText(), passy, keepLoggedIn.isSelected()
		  );
		  if (result) {
			JOptionPane.showMessageDialog(
			  null,
			  "You are authenticated. ",
			  "Success", JOptionPane.PLAIN_MESSAGE
			);
		  } else {
			JOptionPane.showMessageDialog(
			  null,
			  "You are NOT authenticated. Check username or pass",
			  "Failure", JOptionPane.PLAIN_MESSAGE
			);
		  }
		} catch (IOException ef) {
          ef.printStackTrace();
        }
	  }
	});

	return signInButton;
  }

  public JButton clearAllButton() {
	JButton clearAllButton = new JButton("Clear All");
	
	clearAllButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		userTextField.setText("");
		passTextField.setText("");
		keepLoggedIn.setSelected(false);
	  }
	});

	return clearAllButton;
  }

  public JButton cancelButton() {
	JButton cancelButton = new JButton("Cancel");

	cancelButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		new SignInSystem().quitApp();
	  }
	});

	return cancelButton;
  }

}
