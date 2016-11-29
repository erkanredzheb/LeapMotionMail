import com.sendgrid.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home  extends JFrame implements ActionListener {

	public static final JButton inboxButton = new JButton("Inbox");
	public static final JButton sendButton = new JButton("Send");
	public static boolean pressedInbox = false;
	public static boolean pressedSend = false;
	public Home()
	{
        setTitle("Home");
        
		Container contents = getContentPane();
		contents.setLayout(new GridLayout(5, 2));
		
		contents.add(new JLabel("Hello!"));
		
	    contents.add(inboxButton);
		inboxButton.addActionListener(this);

		 contents.add(sendButton);
	        sendButton.setSize(500, 500);
		 sendButton.addActionListener(this);
		
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    	try
	    	{
				Thread.sleep(500);
			}
	    	catch (Exception exception)
	    	{}
	    	
			if (e.getSource() == inboxButton)
			{	
				pressedSend = false;
				pressedInbox = true;
				LeapMouse.onInbox = true;
			}   
			
			else if (e.getSource() == sendButton)
			{	
				pressedSend = true;
				pressedInbox = false;
				LeapMouse.onSend = true;
			} // else
			Login.pressedLogin = false;
			Inbox.pressedRefresh = false;
			LeapMouse.onLogin = false;
			LeapMouse.onHome = false;
	} // actionListener
	

} // class