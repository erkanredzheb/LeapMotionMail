import java.io.IOException;
import java.lang.Runtime;

public class Open {

	public static void main(String[] args)
	{
		Process p;
		try {
			p = Runtime.getRuntime().exec("cmd /c start notepad");
			System.out.println("OPENED");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}