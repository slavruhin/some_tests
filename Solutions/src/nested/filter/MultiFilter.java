package nested.filter;

import java.util.ArrayList;

/**
 * 
 * @author S.Lavruhin
 *
 */
class MultiFilter implements Filter {
	ArrayList<Filter> filters = new ArrayList<Filter>();

	MultiFilter(Filter ... filters) {
		for(Filter f : filters)
			this.filters.add(f);
	}

	@Override
	public boolean accept(Person person) {
		for(Filter f : filters)
			if(!f.accept(person))
				return false;
		return true;
	}
}
