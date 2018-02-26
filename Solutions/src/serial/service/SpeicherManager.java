package serial.service;

import java.io.Serializable;

public class SpeicherManager extends Dienst implements Serializable {
	int size;
	Defragmentierung defrag;
	
	public SpeicherManager(String name) {
		super(name);
	}

	public SpeicherManager(String name, int size, Defragmentierung defrag) {
		super(name);
		this.size = size;
		this.defrag = defrag;
	}

	public SpeicherManager(int size, Defragmentierung defrag) {
		this("", size, defrag);
	}
			
	public String toString() {
		// Manager. Size: 2000. Defrag-Dienst: Zeitabstand(3000), LW(C:\) 
	    return "Manager. Size: " + size + ". Defrag-Dienst: " + defrag;
	}
}
