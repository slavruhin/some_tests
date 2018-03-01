package enums.caffee.algorithms;

import java.util.*;
import enums.caffee.*;


/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class CoinChangeDetails {
	/**
	 * 
	 * @author S.Lavruhin-Ronn
	 *
	 */
	class CoinChanger {
		public final Coin coin;
		public final ArrayList<Coin> array;
		
		public CoinChanger(Coin coin, Coin ...coins) {
			this.coin = coin;
			array = new ArrayList<Coin>();
			if(coins != null)
				for(Coin c : coins)
					array.add(c);
		}
	}

	/**
	 * 
	 */
	private TreeMap<Coin, CoinChanger> container = new TreeMap<Coin, CoinChanger>();
	{
		container.put(Coin.ONE_CENT,     new CoinChanger(Coin.ONE_CENT));
		container.put(Coin.TWO_CENTS,    new CoinChanger(Coin.TWO_CENTS,     Coin.ONE_CENT,     Coin.ONE_CENT));
		container.put(Coin.FIVE_CENTS,   new CoinChanger(Coin.FIVE_CENTS,    Coin.TWO_CENTS,    Coin.TWO_CENTS,    Coin.ONE_CENT));
		container.put(Coin.TEN_CENTS,    new CoinChanger(Coin.TEN_CENTS,     Coin.FIVE_CENTS,   Coin.FIVE_CENTS));
		container.put(Coin.TWENTY_CENTS, new CoinChanger(Coin.TWENTY_CENTS,  Coin.TEN_CENTS,    Coin.TEN_CENTS));
		container.put(Coin.FIFTY_CENTS,  new CoinChanger(Coin.FIFTY_CENTS,   Coin.TWENTY_CENTS, Coin.TWENTY_CENTS, Coin.TEN_CENTS));
		container.put(Coin.ONE_EURO,     new CoinChanger(Coin.ONE_EURO,      Coin.FIFTY_CENTS,  Coin.FIFTY_CENTS));
		container.put(Coin.TWO_EUROS,    new CoinChanger(Coin.TWO_EUROS,     Coin.ONE_EURO,     Coin.ONE_EURO));
	}

	/**
	 * 
	 * @param coins
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<Coin>> changeLimitted(ArrayList<Coin> coins, int limit) {
		ArrayList<ArrayList<Coin>> result = new ArrayList<ArrayList<Coin>>();
		Collections.sort(coins, (x,y)-> (int)((x.value - y.value) * 100));
		for(int i = 0, pos = 0 ; i < coins.size() ; ++i) {
			if(changeInPosition(coins, pos)) {
				if(coins.size() >= limit)
					return result;
				result.add((ArrayList<Coin>)coins.clone());
			}
			else
				++pos;
		}
		return result;
	}

	/**
	 * Generate a list of coins arrays  
	 * @param coins
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<Coin>> changeCurrentTraverse(ArrayList<Coin> coins) {
		ArrayList<ArrayList<Coin>> result = new ArrayList<ArrayList<Coin>>();
		Collections.sort(coins, (x,y)-> (int)((x.value - y.value) * 100));
		
		for(int i = 0, size = coins.size(), pos = 0 ; i < size ; ++i) {
			if(changeInPosition(coins, pos)) {
				result.add((ArrayList<Coin>)coins.clone());
			}
			else
				++pos;
		}
		return result;
	}
	
	/**
	 * Replace element in position @position with array of sub coins (if possible)
	 * @param coins - is array to modify
	 * @param position 
	 * @return true if array @coins modified
	 */
	public boolean changeInPosition(ArrayList<Coin> coins, int position) {
		if(position < coins.size()) {
			ArrayList<Coin> changed = container.get(coins.get(position)).array;
			if(changed != null && changed.size() > 0) {
				coins.remove(position);
				for(Coin c : changed)
					coins.add(c);
				return true;
			}
		}
		return false;
	}
}
