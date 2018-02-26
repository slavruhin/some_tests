package generic.garage;

interface Fahrzeug {}

class PKW implements Fahrzeug {
}
class LKW implements Fahrzeug {
}


public class Garage<T extends Fahrzeug> {
	private T fahrzeug;
	
	public void reinfahren(T fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
}
