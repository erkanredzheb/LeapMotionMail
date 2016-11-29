import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

  public class Inbox extends JFrame implements ActionListener {
	  
	//private final JTextArea area = new JTextArea(20, 25);
	private final JButton refreshButton = new JButton("Refresh");
	public static final JButton sendIButton = new JButton("Send");
	public static boolean pressedRefresh = false;

	ArrayList<Integer> buttonCodes = new ArrayList<Integer>();
	
	public Inbox()
	{
         setTitle("Inbox");
		
		Container contents = getContentPane();
		contents.setLayout(new GridLayout(0,1));

		contents.add(new JLabel("Inbox e-mails."));


		//String content = ReadingEmail.readSubjects(i);

		for (int i = 0; i < 3; i++)
		{
			String subject = ReadingEmail.readSubjects(i);
			
			//System.out.println(ReadingEmail.readEmails(10));
			JButton buttonName = new JButton(subject);
			
			contents.add(buttonName);
			buttonName.addActionListener(this);
			
			

			buttonCodes.add(buttonName.hashCode());
		}
		
	    //contents.add(area);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < buttonCodes.size(); i++)
		{
			if (buttonCodes.get(i).hashCode() == e.getSource().hashCode())
			{
				LeapMouse.emails = new Email(i);
				LeapMouse.onInbox = false;
				LeapMouse.onEmail = true;
			}
		}

		
		System.out.println("CODE: " + e.getSource().hashCode());
		
		Login.pressedLogin = false;
		Home.pressedInbox = false;
		Home.pressedSend = false;
	}

}