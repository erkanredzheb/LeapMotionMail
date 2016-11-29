import java.util.*;

import javax.mail.*;

public class ReadingEmail {

	private static String inboxHeader = "";
	private static String subjects = "";
	private static String contents = "";
	
    public static String readSubjects(int numberOfEmail)
    {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            
            store.connect("imap.gmail.com", "aiwaras1111@gmail.com", "skateris1");
            System.out.println("IMAP: " + LeapMouse.imap);
            System.out.println("EMAIL: " + LeapMouse.email);
            System.out.println("PASSWORD: " + LeapMouse.password);
            
            
            Folder inbox = store.getFolder("INBOX");
            
            inbox.open(Folder.READ_ONLY);
            //for (int i = inbox.getMessageCount(); i > inbox.getMessageCount() - 1; i--)
            //{
            	//numberOfEmails = inbox.getMessageCount() - numberOfEmails;
            	Message msg = inbox.getMessage(inbox.getMessageCount() - numberOfEmail);
                Address[] in = msg.getFrom();
                
                // GETS SUBJECT.
                String subject = msg.getSubject();
                if (subject == null)
                	subject = "(No subject)";
                subjects = subject;
                
                /*
                char[] charArray = subject.toCharArray();
                ArrayList<Character> stringChars = new ArrayList<Character> ();
                
                for (int id = 0; id < subject.length(); id++)
                {
                	stringChars.add(charArray[id]);
                }
                Multipart mp = (Multipart) msg.getContent();
                BodyPart bp = mp.getBodyPart(0);
                stringChars.add(' ');
                stringChars.add('-');
                stringChars.add(' ');
                
                // GETS CONTENT.
                String content = bp.getContent().toString();
                if (content == null)
                	content = "";
                
                
                
                
                char[] charArray2 = content.toCharArray();
                for (int id2 = 0; id2 < content.length(); id2++)
                {
                	stringChars.add(charArray2[id2]);
                }

                stringChars.remove(stringChars.size() - 1);
                stringChars.remove(stringChars.size() - 1);
                
                if (stringChars.size() > 85)
                	while (stringChars.size() != 85)
                		stringChars.remove(stringChars.size() - 1);
                
                System.out.println("SIZE: " + stringChars.size());
                
                inboxHeader = "";
                for (int d = 0; d < stringChars.size(); d++)
                {
                	inboxHeader += stringChars.get(d);
                }
                
                // SUBJECT MUST BE IN BOLD.
                //System.out.println(inboxHeader);
            */
            //}
            //Message msg = inbox.getMessage(inbox.getMessageCount());
            //Address[] in = msg.getFrom();
            
            //for (Address address : in) {
            //    System.out.println("FROM:" + address.toString());
            //}
            //Multipart mp = (Multipart) msg.getContent();
            //BodyPart bp = mp.getBodyPart(0);
            //System.out.println("SENT DATE:" + msg.getSentDate());
            //System.out.println("SUBJECT:" + msg.getSubject());
            //System.out.println("CONTENT:" + bp.getContent());

        }catch (Exception mex) {
        //  mex.printStackTrace();
        }
		return subjects;
    }// READSUBJECTS
    
    public static String readContents(int numberOfEmail)
    {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            
            store.connect("imap.gmail.com", "aiwaras1111@gmail.com", "skateris1");
            System.out.println("IMAP: " + LeapMouse.imap);
            System.out.println("EMAIL: " + LeapMouse.email);
            System.out.println("PASSWORD: " + LeapMouse.password);
            
            
            Folder inbox = store.getFolder("INBOX");
            
            inbox.open(Folder.READ_ONLY);
            //for (int i = inbox.getMessageCount(); i > inbox.getMessageCount() - 1; i--)
            //{
            	//numberOfEmails = inbox.getMessageCount() - numberOfEmails;
            	Message msg = inbox.getMessage(inbox.getMessageCount() - numberOfEmail);
                Address[] in = msg.getFrom();
                
                // GETS SUBJECT.
                Multipart mp = (Multipart) msg.getContent();
                BodyPart bp = mp.getBodyPart(0);
                String content = (String) bp.getContent();
                if (content == null)
                	content = "(No subject)";
                contents = content;
                
                /*
                char[] charArray = subject.toCharArray();
                ArrayList<Character> stringChars = new ArrayList<Character> ();
                
                for (int id = 0; id < subject.length(); id++)
                {
                	stringChars.add(charArray[id]);
                }
                Multipart mp = (Multipart) msg.getContent();
                BodyPart bp = mp.getBodyPart(0);
                stringChars.add(' ');
                stringChars.add('-');
                stringChars.add(' ');
                
                // GETS CONTENT.
                String content = bp.getContent().toString();
                if (content == null)
                	content = "";
                
                
                
                
                char[] charArray2 = content.toCharArray();
                for (int id2 = 0; id2 < content.length(); id2++)
                {
                	stringChars.add(charArray2[id2]);
                }

                stringChars.remove(stringChars.size() - 1);
                stringChars.remove(stringChars.size() - 1);
                
                if (stringChars.size() > 85)
                	while (stringChars.size() != 85)
                		stringChars.remove(stringChars.size() - 1);
                
                System.out.println("SIZE: " + stringChars.size());
                
                inboxHeader = "";
                for (int d = 0; d < stringChars.size(); d++)
                {
                	inboxHeader += stringChars.get(d);
                }
                
                // SUBJECT MUST BE IN BOLD.
                //System.out.println(inboxHeader);
            */
            //}
            //Message msg = inbox.getMessage(inbox.getMessageCount());
            //Address[] in = msg.getFrom();
            
            //for (Address address : in) {
            //    System.out.println("FROM:" + address.toString());
            //}
            //Multipart mp = (Multipart) msg.getContent();
            //BodyPart bp = mp.getBodyPart(0);
            //System.out.println("SENT DATE:" + msg.getSentDate());
            //System.out.println("SUBJECT:" + msg.getSubject());
            //System.out.println("CONTENT:" + bp.getContent());

        }catch (Exception mex) {
        //  mex.printStackTrace();
        }
		return contents;
    }// READCONTENTS
}// CLASS