package aufgaben.collection.automat.base;

import java.util.Collection;

@FunctionalInterface
public interface ChangeCoinCollection {
	public Collection<Coin> generate(int sum);
}
