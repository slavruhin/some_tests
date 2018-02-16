package enums.cafee;

import java.io.IOException;
import java.util.Scanner;

public class Kaffeeautomat {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		//s.useLocale(Locale.GERMAN);
		//s.useLocale(Locale.US);
		while(s.hasNextLine())
		{
			String string = s.nextLine().toString();
			try {

			}
			catch(NumberFormatException e) {
			}
			finally {
				if(string.equals("exit")) {
					break; // stop looping block and exit
				}
			}
			System.out.println();
		}
		s.close();
		System.out.println("Exit.");
		System.out.println();
	}
}
