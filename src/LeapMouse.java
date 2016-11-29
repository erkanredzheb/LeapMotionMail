import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Gesture.Type;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

class CustomListener extends Listener
{
	public Robot robot;
	
	public void onConnect(Controller c)
	{
		c.enableGesture(Gesture.Type.TYPE_CIRCLE);
		c.enableGesture(Gesture.Type.TYPE_SWIPE);
		c.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	}
	
	public void onFrame(Controller c)
	{
		try { robot = new Robot(); } catch (Exception e){}
		Frame frame = c.frame();
		InteractionBox box = frame.interactionBox();
		for (Finger f : frame.fingers())
		{
			// IF FINGER TYPE IS INDEX FINGER.
			if (f.type() == Finger.Type.TYPE_INDEX)
			{
				// TIP POSITION VECTOR.
				Vector fingerPOS = f.stabilizedTipPosition(); // f.tipPosition();
				Vector boxFingerPOS = box.normalizePoint(fingerPOS);
				// SCREEN SIZE.
				Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				robot.mouseMove((int) (screen.width * boxFingerPOS.getX()), (int) (screen.height - boxFingerPOS.getY() * screen.height));
				
			}
		}
		
		
		
		
		for (Gesture g : frame.gestures())
		{

			if (g.type() == Type.TYPE_CIRCLE && LeapMouse.onHome)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CircleGesture circle = new CircleGesture(g);
				// Clockwise.
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 4)
				{
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							LeapMouse.onHome = false;
							LeapMouse.onInbox = true;
						}
						else
						{
							LeapMouse.onHome = false;
							LeapMouse.onSend = true;
						}
					}
				}
				// Counter-clockwise.
				else
				{
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							LeapMouse.onHome = false;
							LeapMouse.onLogin = true;
						}
						
					}
				}
			}

			else if (g.type() == Type.TYPE_CIRCLE && LeapMouse.onLogin)
			{
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CircleGesture circle = new CircleGesture(g);
				// Clockwise.
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 4)
				{
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							LeapMouse.onLogin = false;
							LeapMouse.onHome = true;
						}
						else
						{
							Login.acc.setText("aiwaras1111@gmail.com");
							Login.pass.setText("");
						}
					}
				}
				// Counter-clockwise.
				else
				{
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							System.out.println("PROGRAM CLOSED.");
							System.exit(0);
						}
						else
						{
							Login.acc.setText("");
							Login.pass.setText("");
						}
					}
				}
			}

			else if (g.type() == Type.TYPE_CIRCLE && LeapMouse.onInbox)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CircleGesture circle = new CircleGesture(g);
				// Clockwise.
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 4)
				{
					
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					
				}
				// Counter-clockwise.
				else
				{
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							LeapMouse.onInbox = false;
							LeapMouse.onHome = true;
				
						}
					}
				}
			}
			
			else if (g.type() == Type.TYPE_CIRCLE && LeapMouse.onEmail)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CircleGesture circle = new CircleGesture(g);
				// Clockwise.
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 4)
				{
					
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					
				}
				// Counter-clockwise.
				else
				{
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							LeapMouse.onEmail = false;
							LeapMouse.onInbox = true;
							LeapMouse.emails.dispose();
						}
					}
				}
			}
			

			
			
			else if (g.type() == Type.TYPE_CIRCLE && LeapMouse.onSend)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CircleGesture circle = new CircleGesture(g);
				// CLOCKWISE.
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 4)
				{
					System.out.println("CIRCLE CLOCKWISE DETECTED");
					SendPage.setFromWithMyDetails();
				}
				// COUNTER-CLOCKWISE.
				else
				{
					for (Hand hand : frame.hands())
					{
						String handType = hand.isLeft() ? "LEFT HAND" : "RIGHT HAND";
						System.out.println("HANDTYPE: " + handType);
						if (hand.isLeft())
						{
							LeapMouse.onSend = false;
							LeapMouse.onHome = true;
						}
					}
					System.out.println("CIRCLE COUNTER-CLOCKWISE DETECTED");
					SendPage.setFromEmpty();
					//robot.mouseWheel(-1);
					//try{ Thread.sleep(50); } catch (Exception e) {}
				}
			}
			
			
			
			
			
			else if (g.type() == Type.TYPE_SCREEN_TAP)
			{
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			else if (g.type() == Type.TYPE_SWIPE && g.state() == State.STATE_START)
			{
				SendPage.sendMethod();
				try
				{
					Thread.sleep(800);
				}
				catch (Exception e)
				{
					
				}
				//robot.keyPress(KeyEvent.VK_WINDOWS);
				//robot.keyRelease(KeyEvent.VK_WINDOWS);
			}
		}
	}
}





public class LeapMouse
{
	public static String email = "";
	public static String password = "";
	public static String imap = "";
	// STATES.
	public static boolean onLogin = true, onHome = false, onInbox = false, onSend = false, onEmail = false;
	
	static Login login;
	static Home home;
	static Inbox inbox;
	static SendPage sendPage;
	static Email emails;

    public static void main(String[] args)
    {
    	login = new Login();
    	sendPage = new SendPage();
    	home = new Home();
    	inbox = new Inbox();
    	
    	login.setVisible(true);
    	LeapMouse.run();
    }
	
	
	
	
	// WAS MAIN.
	public static void run()
	{
		CustomListener l = new CustomListener();
		Controller c = new Controller();
		c.addListener(l);
		
		try
		{
	    	while (true)
	    	{
		    	try
		    	{
					Thread.sleep(500);
				}
		    	catch (Exception e)
		    	{}
		    	
		    	if (onLogin)
		    	{
		    		//System.out.println("HERE1");
			    	home.setVisible(false);
			    	inbox.setVisible(false);
		    		sendPage.setVisible(false);
		    		login.setVisible(true);
		    	}
		    	else if (onHome)
		    	{
		    		//System.out.println("HERE2");

		    		login.setVisible(false);
			    	inbox.setVisible(false);
		    		sendPage.setVisible(false);
			    	home.setVisible(true);
		    		
		    		if (home.pressedInbox)
		    		{
			    		login.setVisible(false);
				    	home.setVisible(false);
			    		sendPage.setVisible(false);
				    	inbox.setVisible(true);
		    		}
		    		else if (home.pressedSend)
		    		{
			    		home.setVisible(false);
				    	inbox.setVisible(false);
				    	login.setVisible(false);
				    	sendPage.setVisible(true);
		    		}
		    	}
		    	else if (onInbox)
		    	{
		    		home.setVisible(false);
		    		sendPage.setVisible(false);
			    	login.setVisible(false);
			    	inbox.setVisible(true);
			    	
		    		//System.out.println("HERE3");
		    		if (inbox.pressedRefresh)
		    		{
		    			//inbox.setVisible(false);

		    		}
		    	}
		    	
		    	else if (onSend)
		    	{
		    		home.setVisible(false);
			    	login.setVisible(false);
			    	inbox.setVisible(false);
		    		sendPage.setVisible(true);
		    	}

		    	else if (onEmail && emails != null)
		    	{
		    		home.setVisible(false);
			    	login.setVisible(false);
			    	inbox.setVisible(false);
		    		sendPage.setVisible(false);
		    		emails.setVisible(true);
		    	}

				//System.in.read();
	    	}

			
		}
		catch (Exception e)
		{
			
		}
		
		c.removeListener(l);
	}

}
