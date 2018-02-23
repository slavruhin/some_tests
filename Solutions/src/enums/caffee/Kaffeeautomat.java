package enums.caffee;

import java.io.Console;
import java.util.*;

public class Kaffeeautomat {

	String head = "";
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {

		Console console = System.console(); //Nur so auf das Objekt zugreifen
		
		for(boolean exit = false ; !exit && console != null; ) {
			console.format("Bitte eine Zeile eingeben: %n");
			String line = console.readLine();
			if(line.equals("exit"))
				break;
		}
		
//		console.format("Hallo Welt%n");
//		console.format("Hallo %s %n", "Welt");
//		console.printf("Die Methode %s funktioniert genau so wie die Methode %s %n", 
//				"printf", "format");
//		
//		
//		//1. readLine
//		console.format("Bitte eine Zeile eingeben: %n");
//		String line = console.readLine();
//		
//		console.format("Ihre Eingabe war: %s %n", line);
//		
//		//2. readLine
//		line = console.readLine("Bitte noch %s Zeile eingeben: ", 1);
//		console.format("Ihre Eingabe war: %s %n", line);
//		
//		/*
//		 * Exam: auf RÃ¼ckgabetypen in readLine und readPassword achten!
//		 */
//		
//		//1. readPassword
//		console.format("Bitte das Passwort eingeben: %n");
//		char[] pwd = console.readPassword();
//		
//		console.format("Passwort: %s %n", Arrays.toString(pwd));
//		
//		//2. readPassword
//		pwd = console.readPassword("Bitte das Passwort erneut eingeben: %n");
//		
//		console.format("Passwort: %s %n", Arrays.toString(pwd));

		
//		Scanner s = new Scanner(System.in);
//		//s.useLocale(Locale.GERMAN);
//		//s.useLocale(Locale.US);
//		System.out.print(">");
//		while(s.hasNextLine())
//		{
//			String line = s.nextLine().toString();
//			System.out.print(">");
//			try {
//				
//				
//				
//			}
//			catch(NumberFormatException e) {
//			}
//			finally {
//				if(line.equals("exit")) {
//					break; // stop looping block and exit
//				}
//			}
//			System.out.println();
//		}
//		s.close();
//		System.out.println("Exit.");
//		System.out.println();
	}
}
