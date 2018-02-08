package nested.filter;

interface Filter {
	boolean accept(Person person);
}

interface GenericFilter<T> {
	boolean accept(T obj);
}

