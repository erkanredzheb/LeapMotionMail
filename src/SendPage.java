

import com.sendgrid.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

import javax.swing.*;

public class SendPage extends JFrame implements ActionListener {

	  
	  private final JTextField acc = new JTextField(20);
	  private final JPasswordField pass = new JPasswordField(10);
	  private final static JTextField to = new JTextField(50);
	  private final static JTextField from = new JTextField(20);
	  private final static JTextField subject = new JTextField(20);
	  private final static JTextArea text = new JTextArea();
	  private final JTextArea text1 = new JTextArea(5, 20);
	 // private final JScrollPane scroll1 = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	  
	  
	  private final JButton sendButton = new JButton("SEND");
	  private final JButton inboxButton = new JButton("INBOX");
	   
	
	  public SendPage()
	  {
	    setTitle("Send e-mail.");
		
		Container contents = getContentPane();
		contents.setLayout(new GridLayout(0,2));
		
		
		contents.add(new JLabel("To:"));
		contents.add(to);
		
		contents.add(new JLabel("From:"));
		contents.add(from);
				
		contents.add(new JLabel("Subject:"));
		contents.add(subject);
		
		contents.add(new JLabel("Text:"));
		contents.add(text);

		contents.add(sendButton);
		sendButton.addActionListener(this);
		
		//contents.add(inboxButton);
		//inboxButton.addActionListener(this);
		
		//contents.add(new JLabel("Inbox: "));
		//contents.add(text1);
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	  }
	
	  public void actionPerformed(ActionEvent event)
	  {

	    
	    sendMethod();
	    
	  }
	



    	
    public static void setFromWithMyDetails()
    {
    	to.setText("aiwaras1111@gmail.com");
    	from.setText("aiwaras1111@gmail.com");
    	subject.setText("My subject !");
    	text.setText("No mouse man !");
    }

    public static void setFromEmpty()
    {
    	to.setText("");
    	from.setText("");
    	subject.setText("");
    	text.setText("");
    }
    
    
    public static void sendMethod()
    {
	    String to1 = to.getText();
	    String from1  = from.getText();
	    String subject1 = subject.getText();
	    String text1 = text.getText();
	    
	    SendGrid sendgrid = new SendGrid("erkanerkan2", "erkanerkan");
	    
	    SendGrid.Email email = new SendGrid.Email();
	    email.addTo(to1); //email.addTo(to1);
	    email.setFrom(from1);
	    email.setSubject(subject1);
	    email.setText(text1);

	    try {
	      SendGrid.Response response = sendgrid.send(email);
	      System.out.println(response.getMessage());
	    }
	    catch (SendGridException e) {
	      System.err.println(e);
	    }
    }
}