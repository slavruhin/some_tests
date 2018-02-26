package serial.service;

import java.io.Serializable;

public class Defragmentierung extends Dienst implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	int zeitabstand;
	String laufwerk;

	public Defragmentierung(String name) {
		super(name);
	}

	public Defragmentierung(int zeitabstand, String laufwerk) {
		super("Defrag-Dienst");
		this.laufwerk = laufwerk;
		this.zeitabstand = zeitabstand;
	}

	public String toString() {
	    return String.format("Zeitabstand(%d), LW(%s)", zeitabstand, laufwerk);
	}
}
