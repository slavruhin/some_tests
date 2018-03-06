package aufgaben.collection.automat.base;

import java.util.*;

public class ExtendChangeCoinCollection extends DefaultChangeCoinCollection {
	protected TreeSet<CoinCounter> collection = new TreeSet<CoinCounter>();

	public ExtendChangeCoinCollection(CoinCounter coins) {
		super(coins);
	}

	@Override
	public Collection<Coin> change(int sum) {
		return super.change(sum);
//		CoinCounter cc = new CoinCounter(coins);
//		Collection<Coin> sequence = change(sum, cc);
//		return sequence;
	}
	
	public Collection<Collection<Coin>> changeTraverse(Collection<Coin> array) {
		Collection<Collection<Coin>> out = new ArrayList<Collection<Coin>>();
		for(int i = 0 ; i < array.size() ; ++i) {
			Coin coin = ((ArrayList<Coin>)array).get(i);
			Collection<Coin> changed = MapCoinChanger.get(coin);
			if(changed.size() > 1) {
				ArrayList<Coin> b = (ArrayList<Coin>) ((ArrayList<Coin>) array).clone();
				b.remove(i);
				b.addAll(changed);
				out.add(b);
			}
		}
		return out;
	}
}
