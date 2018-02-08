package nested.filter;


interface GenericFilter<T> {
	boolean accept(T obj);
}

interface Filter extends GenericFilter<Person> {}

