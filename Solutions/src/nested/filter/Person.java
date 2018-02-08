package nested.filter;


public class Person {

	String Vornamen, 
	       Nachnamen;
	int Geburtsjahr;
	
	Person(String Vornamen, String Nachnamen, int Geburtsjahr) {
		this.Vornamen = Vornamen;
		this.Nachnamen = Nachnamen;
		this.Geburtsjahr = Geburtsjahr ;
	}
	
	@Override
	public String toString() {
		return String.format("\t%s %s (%d)", Vornamen, Nachnamen, Geburtsjahr);
	}
}
