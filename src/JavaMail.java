

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class JavaMail {    
    String d_email = "aiwaras1111@gmail.com",
            d_password = "skateris1", //your email password
            d_host = "smtp.gmail.com",
            d_port = "465",
            m_to = "aiwaras1111@gmail.com", // Target email address
            m_subject = "Labas",
            m_text = "Aivaras just hacked you.";
    
    public JavaMail() {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");   ///////
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            Authenticator auth = new smtpAuthenticator();
            Session session = Session.getInstance(props, auth);     
            MimeMessage msg = new MimeMessage(session);
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        JavaMail blah = new JavaMail();
    	//LeapMouse.run();
    }
  
    private class smtpAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}