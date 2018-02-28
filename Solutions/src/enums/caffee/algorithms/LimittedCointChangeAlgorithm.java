package enums.caffee.algorithms;

import java.util.*;
import enums.caffee.Coin;
import enums.caffee.logger.*;

public class LimittedCointChangeAlgorithm  extends DefaultCashChangeAlgorithm {
	
	public int limit = 16;
	
	@Override
	public ArrayList<Coin> change(double summe, TreeMap<Coin, Integer> container) {
		CoinsCounter desk = new CoinsCounter(container);
		ArrayList<Coin> default_coins = super.change(summe, container);

		if(limit >= default_coins.size()) {
			ArrayList<ArrayList<Coin>> list = new CoinChangeDetails().changeLimitted(default_coins, limit);
			for(ArrayList<Coin> coins : list)
				System.out.println(CashdeskLogger.toString(coins));
			System.out.println();

			
			if(list.size() > 0)
				for(int i = list.size(); i > 0 ; --i)
					if(desk.equals(new CoinsCounter(list.get(i - 1))))
						return list.get(i - 1);
		}
		return default_coins;
	}
}
