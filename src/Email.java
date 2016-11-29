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

  public class Email extends JFrame implements ActionListener {

	
	public Email(int idOfEmail)
	{
         setTitle("Email message");
		
		Container contents = getContentPane();
		contents.setLayout(new GridLayout(0,1));

		contents.add(new JLabel("Email message."));
		
			String subject = ReadingEmail.readSubjects(idOfEmail);
			String content = ReadingEmail.readContents(idOfEmail);

			JTextArea textArea1 = new JTextArea(3, 3);
			JTextArea textArea2 = new JTextArea(3, 3);
			JScrollPane scrollPane1 = new JScrollPane(textArea1); 
			JScrollPane scrollPane2 = new JScrollPane(textArea2); 
			textArea1.setEditable(false);
			textArea2.setEditable(false);
			textArea1.setText("CONTENT: \n");
			textArea2.setText("SUBJECT: \n");
			textArea1.setText(textArea1.getText() + subject);
			textArea2.setText(textArea2.getText() + content);
			contents.add(textArea1);
			contents.add(textArea2);
	
			
	    //contents.add(area);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LeapMouse.onEmail = false;
		LeapMouse.onSend = true;
	}

}