package serial.service;

import java.io.Serializable;

public class Dienst implements Serializable {
	String name;
	public Dienst(String name) {
	    this.name = name;
	}
}
