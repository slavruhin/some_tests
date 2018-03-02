package aufgaben.collection.automat.base;

import java.util.*;

public class DefaultChangeCoinCollection implements ChangeCoinCollection {
	private CoinCounter coins = new CoinCounter();

	public DefaultChangeCoinCollection(CoinCounter coins) {
		this.coins = coins;
	}

	@Override
	public Collection<Coin> generate(int sum) {
		Collection<Coin> coins = new ArrayList<Coin>();
		for(Coin coin : Coin.values()) {
			int count = getCount(coin, sum);
			if(count == 0)
				continue;

			for(int i = 0; i < count ; ++i)
				coins.add(coin);
			sum -= coin.value * count;
			
			if(sum == 0)
				break;
		}
		return sum > 0 ? new ArrayList<Coin>() : coins;
	}

	protected int getCount(Coin coin, int sum) {
		return  coin == Coin.TWO_EUROS    ? getCount(sum, coin.value, coins.twoEuros   ) :
				coin == Coin.ONE_EURO     ? getCount(sum, coin.value, coins.oneEuro    ) : 
				coin == Coin.FIFTY_CENTS  ? getCount(sum, coin.value, coins.fivtyCents ) : 
				coin == Coin.TWENTY_CENTS ? getCount(sum, coin.value, coins.twentyCents) : 
				coin == Coin.TEN_CENTS    ? getCount(sum, coin.value, coins.tenCents   ) : 
				coin == Coin.FIVE_CENTS   ? getCount(sum, coin.value, coins.fiveCents  ) : 
				coin == Coin.TWO_CENTS    ? getCount(sum, coin.value, coins.twoCents   ) : 
				coin == Coin.ONE_CENT     ? getCount(sum, coin.value, coins.oneEuro    ) : 
			    0;
	}

	private int getCount(int sum, int coinValue, int coinCount) {
		int i = sum / coinValue;
		return i <= coinCount ? i : coinCount;
	}
}
