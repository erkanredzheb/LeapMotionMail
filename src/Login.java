import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Login extends JFrame implements ActionListener {
	private static Login login;
	public static boolean pressedLogin = false;
	public static final JTextField acc = new JTextField(100);
	public static final JPasswordField pass = new JPasswordField(100);
	private final JButton loginButton = new JButton("Login");
	
	public Login()
	  {
		setTitle("Login");
		
		Container contents = getContentPane();
		contents.setLayout(new GridLayout(15,2));
		
		contents.add(new JLabel("Account:"));
	    contents.add(acc);
	  		  
		contents.add(new JLabel("Password:"));
	    contents.add(pass);
	    
	    contents.add(loginButton);
		loginButton.addActionListener(this);
		
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
	  }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		LeapMouse.onLogin = false;
		LeapMouse.onHome = true;
		
		LeapMouse.email = "aiwaras1111@gmail.com";//acc.getText();
		LeapMouse.password = "skateris1";//pass.getText();
		
		char[] emailChars = LeapMouse.email.toCharArray();
		String imapString = "";
		for (int i = 0; i < emailChars.length; i++)
		{
			if (emailChars[i] == '@')
			{
				for (int l = (i + 1); l < emailChars.length; l++)
				{
					imapString += emailChars[l];
				}
			}
		}
		
		LeapMouse.imap = "imap." + imapString;
		System.out.println("IMAP: " + LeapMouse.imap);
		
		pressedLogin = true;
		Home.pressedInbox = false;
		Home.pressedSend = false;
		Inbox.pressedRefresh = false;
	}
}