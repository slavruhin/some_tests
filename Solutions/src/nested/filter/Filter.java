package nested.filter;


interface GenericFilter<T>      { boolean accept(T obj); }
interface GenericMultiFilter<T> { @SuppressWarnings("unchecked") boolean accept(T obj, GenericFilter<T> ... filters); }

interface Filter extends GenericFilter<Person> {}


//interface MultiComparator {  

