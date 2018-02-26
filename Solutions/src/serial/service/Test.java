package serial.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		SpeicherManager sManager = new SpeicherManager(2000, new Defragmentierung (3000, "C:\\"));
		
		String filename = "nienst.bin";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(sManager);
		oos.close();
		
		System.out.println("Serialisiert: " + sManager);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Object obj2 = ois.readObject();
		ois.close();

		System.out.println("Deserialisiert: " + obj2);
	}
}
