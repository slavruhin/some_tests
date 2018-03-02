package aufgaben.collection.automat.base;

import java.util.*;

public class ExtChangeCoinCollection implements ChangeCoinCollection {
	private CoinCounter coins = new CoinCounter();
	private TreeSet<CoinCounter> collection = new TreeSet<CoinCounter>();

	public ExtChangeCoinCollection(CoinCounter coins) {
		this.coins = coins;
	}

	@Override
	public Collection<Coin> generate(int sum) {
		combinate(sum);
		return collection.size() > 0 ? collection.first().toCollection() : null;
	}
	
	private void combinate(int sum) {
		collection.clear();
		if(coins.sum() >= sum) {
//			// using combinatorics to select sequence with entered sum
//			Collection<Coin> main = coins.toCollection();
//			for(int i = 0 ; i < main.size() ; ++i) {
//				for(int j = i ; j < main.size() ; ++j) {
//					// TODO:
//					Collection<Coin> sequence = coins.toCollection();
//					
//					CoinCounter c = new CoinCounter(sequence);
//					if(c.sum() == sum))
//						collection.add(c);
//				}
//			}
		}
	}
}
