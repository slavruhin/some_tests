package nested.filter;

import java.util.*;

/**
 * 
 * @author S.Lavruhin
 *
 */
public class Testing {
	
	static class InnerJahrFilter implements Filter {

		int Geburtsjahr;

		InnerJahrFilter(int Geburtsjahr) {
			this.Geburtsjahr = Geburtsjahr;
		}

		@Override
		public boolean accept(Person person) {
			return person.Geburtsjahr == Geburtsjahr;
		}
	} 
	
	/**
	 * 
	 * @param persons
	 * @param filter
	 * @return
	 */
	static Person[] filtern(Person[] persons, Filter filter) {
		
		ArrayList<Person> filtered = new ArrayList<Person>();
		if(persons != null)
			for(Person p : persons)
				if(filter.accept(p))
					filtered.add(p);
		
		Person[] arr = (Person[])filtered.toArray(new Person[0]);
		return arr;
	}

	/**
	 * 
	 * @param persons
	 * @param filter
	 * @return
	 */
	static Person[] filtern(Person[] persons, GenericFilter<Person> filter) {
		
		ArrayList<Person> filtered = new ArrayList<Person>();
		if(persons != null)
			for(Person p : persons)
				if(filter.accept(p))
					filtered.add(p);
		
		Person[] arr = (Person[])filtered.toArray(new Person[0]);
		return arr;
	}
	
	public static void main(String[] args) {
		Person[] persons = new Person[] {
				new Person("Max",    "Groß",      1989),
				new Person("Marsel", "Balthasar", 1971),
				new Person("John",   "Smitt",     1996),
				new Person("Albert", "Winner",    1962)
		};
		
		// Erzeugen Sie mit einer Toplevel-Klasse einen Filter, 
		// der nur die Personen akzeptiert, die nach einem bestimmten Jahr geboren wurden.
		System.out.println("Case 1 : external filter");
		JahrFilter filter = new JahrFilter(1962);
		Person[] filtered = filtern(persons, filter);
		for(Person p : filtered)
			System.out.println(p);
		System.out.println();
		
		// Erzeugen Sie mit einer inneren Klasse einen Filter, 
		// der nur die Personen akzeptiert, die in ihrem Nachnamen mindestens ein 'a' haben
		System.out.println("Case 2: innere filter");
		InnerJahrFilter filter2 = new Testing.InnerJahrFilter(1989);
		filtered = filtern(persons, filter2);
		for(Person p : filtered)
			System.out.println(p);
		System.out.println();
		
		// Erzeugen Sie mit einer lokalen Klasse einen Filter, 
		// der nur die Personen akzeptiert, die in ihrem Nachnamen mindestens 4 Zeichen haben
		System.out.println("Case 3: local filter");
		class LocalNameFilter implements Filter {
			@Override
			public boolean accept(Person person) {
				return person.Nachnamen != null && person.Nachnamen.length() > 3;
			}
		} 
		LocalNameFilter filter3 = new LocalNameFilter();
		filtered = filtern(persons, filter3);
		for(Person p : filtered)
			System.out.println(p);
		System.out.println();
		
		// Erzeugen Sie mit einer anonymen Klasse einen Filter, 
		// der die Eigenschaften zwei anderer Filter (im weiteren A und B genannt) vereint. Akzeptiert werden mit dem neuen Filter nur die Personen, die von Filter A UND Filter B akzeptiert werden. Benutzen Sie zum Testen als Filter A und B die Filter aus den bisherigen Aufgabenpunkten
		System.out.println("Case 4: anonym filter");
		filtered = filtern(persons, new MultiFilter(filter2, filter3));
		for(Person p : filtered)
			System.out.println(p);
		System.out.println();
		
		// Optional: Rufen Sie die Methode filtern mit einer Lambda-Funktion auf, 
		// mit der nur die Personen akzeptiert werden, die in einem Schaltjahr geboren wurden
		System.out.println("Case 5: lambda filter");
		Filter filter5 = x -> 1971 == x.Geburtsjahr;
		filtered = filtern(persons, filter5);
		for(Person p : filtered)
			System.out.println(p);
		System.out.println();
		
	}
}
