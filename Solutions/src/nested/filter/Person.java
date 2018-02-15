package nested.filter;


public class Person {

	String Vorname, 
	       Nachname;
	int Geburtsjahr;
	
	Person(String Vornamen, String Nachnamen, int Geburtsjahr) {
		this.Vorname = Vornamen;
		this.Nachname = Nachnamen;
		this.Geburtsjahr = Geburtsjahr ;
	}
	
	@Override
	public String toString() {
		return String.format("\t%-12s %-12s (%d)", Nachname, Vorname, Geburtsjahr);
	}
}
