package nested.filter;

/**
 * 
 * @author S.Lavruhin
 *
 */
class JahrFilter implements GenericFilter<Person> {
	
	int Geburtsjahr;
	
	JahrFilter(int Geburtsjahr) {
		this.Geburtsjahr = Geburtsjahr;
	}

	@Override
	public boolean accept(Person person) {
		return person.Geburtsjahr == Geburtsjahr;
	}
}