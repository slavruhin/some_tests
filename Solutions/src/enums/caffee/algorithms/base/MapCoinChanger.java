package enums.caffee.algorithms.base;

import java.util.*;
import enums.caffee.*;

public class MapCoinChanger {
	private Map<Coin, Collection<Coin>> map = new TreeMap<Coin, Collection<Coin>>();
	{
		map.put(Coin.ONE_CENT,     toCollection(new Coin[]{Coin.ONE_CENT                                       }));
		map.put(Coin.TWO_CENTS,    toCollection(new Coin[]{Coin.ONE_CENT,     Coin.ONE_CENT                    }));
		map.put(Coin.FIVE_CENTS,   toCollection(new Coin[]{Coin.TWO_CENTS,    Coin.TWO_CENTS,    Coin.ONE_CENT }));
		map.put(Coin.TEN_CENTS,    toCollection(new Coin[]{Coin.FIVE_CENTS,   Coin.FIVE_CENTS                  }));
		map.put(Coin.TWENTY_CENTS, toCollection(new Coin[]{Coin.TEN_CENTS,    Coin.TEN_CENTS                   }));
		map.put(Coin.FIFTY_CENTS,  toCollection(new Coin[]{Coin.TWENTY_CENTS, Coin.TWENTY_CENTS, Coin.TEN_CENTS}));
		map.put(Coin.ONE_EURO,     toCollection(new Coin[]{Coin.FIFTY_CENTS,  Coin.FIFTY_CENTS                 }));
		map.put(Coin.TWO_EUROS,    toCollection(new Coin[]{Coin.ONE_EURO,     Coin.ONE_EURO                    }));
	}
	
	private Collection<Coin> toCollection(Coin[] array) {
		return (Collection<Coin>)new ArrayList<Coin>(Arrays.asList(array));
	}
	
	public Collection<Coin> get(Coin coin) {
		return map.get(coin);
	}
}
