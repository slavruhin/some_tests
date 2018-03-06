package aufgaben.collection.automat.base;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ChangeCollectionHelper {
	
	public static Collection<Coin> change(int sum, CoinCounter coins) {
		Collection<Coin> result = new ArrayList<Coin>();
		if(coins.sum() >= sum) {
			for(Coin coin : Coin.values()) {
				int count = getCount(coin, sum, coins);
				if(count == 0)
					continue;

				for(int i = 0; i < count ; ++i)
					result.add(coin);
				sum -= coin.value * count;

				if(sum == 0)
					break;
			}
		}
		if(sum == 0 && result.size() > 0) {
			coins.subtract(result);
			return result;
		}
		return new ArrayList<Coin>();
	}
	
	public static int getCount(Coin coin, int sum, CoinCounter coins) {
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

	public static int getCount(int sum, int coinValue, int coinCount) {
		int i = sum / coinValue;
		return i <= coinCount ? i : coinCount;
	}
}
