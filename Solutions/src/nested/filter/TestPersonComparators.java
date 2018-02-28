package nested.filter;

import java.util.*;

/**
 * Top-levels comparators
 * 
 * @author S.Lavruhin-Ronn
 *
 */
// Local filter 1:
class TopLevelFilterNachnameUp implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) { return o1.Nachname.compareTo(o2.Nachname); }
};

// Local filter 2:
class TopLevelFilterVornameUp implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) { return o1.Vorname.compareTo(o2.Vorname); }
};

// Local filter 3:
class TopLevelFilterYearUp implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) { return o1.Geburtsjahr - o2.Geburtsjahr; }
};

// Local filter 4:
class TopLevelFilterMultifilterUp implements Comparator<Person> {
	final Comparator<Person>[] filters;
	
	@SuppressWarnings("unchecked")
	public TopLevelFilterMultifilterUp(Comparator<Person> ... filters) { this.filters = filters; }
	
	@Override
	public int compare(Person o1, Person o2) {
		for(Comparator<Person> filter : filters) {
			int ret = filter.compare(o1, o2);
			if(ret != 0)
				return ret;
		}
		return 0;
	}
};

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class TestPersonComparators {

	Person[] persons = new Person[] {
		new Person("Max",       "Groß",      1989),
		new Person("Albertino", "Winnero",   1961),
		new Person("Marsel",    "Balthasar", 1971),
		new Person("Albert",    "Winner",    1962),
		new Person("John",      "Smitt",     1996),
		new Person("Michel",    "Winner",    1962),
	    new Person("Michael",   "Grabbe",    1973),
        new Person("Jane",      "Peterson",  1994),
        new Person("John",      "Rob",       1985),
        new Person("Peter",     "Peterson",  2003),
        new Person("Lucy",      "Hammer",    2000)
	};

	/**
	 * 
	 */
	public static void useAnonymeFilters() {

		// Anonyme filter 1:
		final Comparator<Person> fNachnameUp = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) { return o1.Nachname.compareTo(o2.Nachname); }
		};

		// Anonyme filter 2:
		final Comparator<Person> fVornameUp = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) { return o1.Vorname.compareTo(o2.Vorname); }
		};

		// Anonyme filter 3:
		final Comparator<Person> fYearUp = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) { return o1.Geburtsjahr - o2.Geburtsjahr; }
		};
		
		// Anonyme filter 4:
		final Comparator<Person> fMultifilterUp = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int ret = fYearUp.compare(o1, o2);
				if(ret != 0)
					return ret;
				ret = fNachnameUp.compare(o1, o2);
				return ret != 0 ? ret : fVornameUp.compare(o1, o2);
			}
		};

		System.out.println("Unsorted list");
		TestPersonComparators test = new TestPersonComparators();
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
		
		System.out.println("Sorted list : lastname:");
		Arrays.sort(test.persons, fNachnameUp);
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
		
		System.out.println("Sorted list : years:");
		Arrays.sort(test.persons, fYearUp);
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();

		System.out.println("Sorted list : years + lastname + firstname:");
		Arrays.sort(test.persons, fMultifilterUp);
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
	}
	

	/**
	 * 
	 */
	public static void useLocaleFilters() {

		// Local filter 1:
		class FilterNachnameUp implements Comparator<Person> {
			@Override
			public int compare(Person o1, Person o2) { return o1.Nachname.compareTo(o2.Nachname); }
		};

		// Local filter 2:
		class FilterVornameUp implements Comparator<Person> {
			@Override
			public int compare(Person o1, Person o2) { return o1.Vorname.compareTo(o2.Vorname); }
		};

		// Local filter 3:
		class FilterYearUp implements Comparator<Person> {
			@Override
			public int compare(Person o1, Person o2) { return o1.Geburtsjahr - o2.Geburtsjahr; }
		};
		
		// Local filter 4:
		@SuppressWarnings("unchecked")
		class FilterMultifilterUp implements Comparator<Person> {
			final Comparator<Person>[] filters;
			
			public FilterMultifilterUp(Comparator<Person> ... filters) { this.filters = filters; }
			
			@Override
			public int compare(Person o1, Person o2) {
				for(Comparator<Person> filter : filters) {
					int ret = filter.compare(o1, o2);
					if(ret != 0)
						return ret;
				}
				return 0;
			}
		};

		System.out.println("Unsorted list");
		TestPersonComparators test = new TestPersonComparators();
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();

		System.out.println("Sorted list : lastname:");
		Arrays.sort(test.persons, new FilterNachnameUp());
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();

		System.out.println("Sorted list : years:");
		Arrays.sort(test.persons, new FilterYearUp());
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();

		System.out.println("Sorted list : years + lastname + firstname:");

		Comparator<Person> f1 = new FilterNachnameUp(), 
				           f2 = new FilterVornameUp(), 
				           f3 = new FilterYearUp();
		FilterMultifilterUp filter = new FilterMultifilterUp(f1, f2, f3);
		Arrays.sort(test.persons, filter);
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
	}

	/**
	 * 
	 */
	public static void useTopLevelsFilters() {

		System.out.println("Unsorted list");
		TestPersonComparators test = new TestPersonComparators();
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
		
		System.out.println("Sorted list : lastname:");
		Arrays.sort(test.persons, new TopLevelFilterNachnameUp());
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
		
		System.out.println("Sorted list : years:");
		Arrays.sort(test.persons, new TopLevelFilterYearUp());
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();

		System.out.println("Sorted list : years + lastname + firstname:");
		Arrays.sort(test.persons, new TopLevelFilterMultifilterUp(new TopLevelFilterYearUp(), new TopLevelFilterNachnameUp(), new TopLevelFilterVornameUp()));
		for(Person p : test.persons)
			System.out.println(p);
		System.out.println();
	}
	
	public static void main(String[] args) {

		//useAnonymeFilters();
		//useLocaleFilters();
		useTopLevelsFilters();
	}
}
