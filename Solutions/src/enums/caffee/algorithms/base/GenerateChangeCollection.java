package enums.caffee.algorithms.base;

import java.util.*;
import enums.caffee.Coin;

public class GenerateChangeCollection {

	private final Set<CoinCounter> collection = new TreeSet<CoinCounter>();
	private CoinCounter filter = new CoinCounter();
	
	/**
	 * 
	 * @param coins
	 */
	public GenerateChangeCollection(Coin coin, CoinCounter filter) {
		this(new ArrayList<Coin>(Arrays.asList(new Coin[] { coin })), filter);
	}

	/**
	 * 
	 * @param coins
	 */
	public GenerateChangeCollection(List<Coin> coins, CoinCounter filter) {
		this.filter = filter;
		CoinCounter cc = new CoinCounter(coins);
		if(filter.isContains(cc)) {
			collection.add(cc);
			MapCoinChanger changer = new MapCoinChanger();
			for(int position = 0 ; position < coins.size() ; ) {
				Collection<Coin> changed = changer.get(coins.get(position));
				if(changed.size() > 1) {
					coins.remove(position);
					coins.addAll(changed);
					cc = new CoinCounter(coins);
					if(filter.isContains(cc))
						collection.add(cc);
				}
				else
					++position;
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public CoinCounter get() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Set<CoinCounter> getCollection() {
		return collection;
	}
}
