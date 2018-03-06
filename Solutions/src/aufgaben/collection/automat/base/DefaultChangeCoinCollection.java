package aufgaben.collection.automat.base;

import java.util.*;

public class DefaultChangeCoinCollection extends ChangeCollectionHelper implements ChangeCoinCollection {
	protected CoinCounter coins = new CoinCounter();

	public DefaultChangeCoinCollection(CoinCounter coins) {
		this.coins = coins;
	}

	@Override
	public Collection<Coin> change(int sum) {
		return change(sum, this.coins);
	}
}
