package enums.caffee.algorithms;

import java.util.*;
import enums.caffee.*;

public class CoinDetails {
	
	class CoinChanger {
		public final Coin coin;
		public final Collection<Coin> array;
		
		public CoinChanger(Coin coin, Coin ...coins) {
			this.coin = coin;
			array = new ArrayList<Coin>();
			if(coins != null)
				for(Coin c : coins)
					array.add(c);
		}
	}
	
	private TreeMap<Coin, CoinChanger> container = new TreeMap<Coin, CoinChanger>();
	{
		container.put(Coin.ONE_CENT,     new CoinChanger(Coin.ONE_CENT));
		container.put(Coin.TWO_CENTS,    new CoinChanger(Coin.TWO_CENTS,     Coin.ONE_CENT, Coin.ONE_CENT));
		container.put(Coin.FIVE_CENTS,   new CoinChanger(Coin.FIVE_CENTS,    Coin.TWO_CENTS, Coin.TWO_CENTS, Coin.ONE_CENT));
		container.put(Coin.TEN_CENTS,    new CoinChanger(Coin.TEN_CENTS,     Coin.FIVE_CENTS, Coin.FIVE_CENTS));
		container.put(Coin.TWENTY_CENTS, new CoinChanger(Coin.TWENTY_CENTS,  Coin.TEN_CENTS, Coin.TEN_CENTS));
		container.put(Coin.FIFTY_CENTS,  new CoinChanger(Coin.FIFTY_CENTS,   Coin.TWENTY_CENTS, Coin.TWENTY_CENTS, Coin.TEN_CENTS));
		container.put(Coin.ONE_EURO,     new CoinChanger(Coin.ONE_EURO,      Coin.FIFTY_CENTS, Coin.FIFTY_CENTS));
		container.put(Coin.TWO_EUROS,    new CoinChanger(Coin.TWO_EUROS,     Coin.ONE_EURO, Coin.ONE_EURO));
	}

	/**
	 * 
	 * @param coin
	 * @return
	 */
	public ArrayList<ArrayList<Coin>> change(Coin coin) {
		ArrayList<ArrayList<Coin>> ret = new  ArrayList<ArrayList<Coin>>();

		ArrayList<Coin> sub = new ArrayList<Coin>();
		sub.add(coin);
		ret.add(sub);
		
		// root level
		ArrayList<Coin> coins = (ArrayList<Coin>)container.get(coin).array;
		ret.add(coins);
		
		// resolve sub level
		for(boolean ende = true ; !ende ; ) {
			sub = new ArrayList<Coin>();

//			for(int j = 0 ; j < coins.size() ; ++j) {
//				
//				if(i != j) {
//					sub.add(coins.get(i));
//				}
//				else
//				{
//					ArrayList<Coin> seq = (ArrayList<Coin>)container.get(coins.get(i)).array;
//					if(seq == null)
//						break;
//					sub.addAll(seq);
//					ret.add(sub);
//				}
//			}
		}

//		for(int i = 0 ; i < coins.size() ; ++i) {
//
//			sub = new ArrayList<Coin>();
//			for(int j = 0 ; j < coins.size() ; ++j) {
//				
//				if(i != j) {
//					sub.add(coins.get(i));
//				}
//				else
//				{
//					ArrayList<Coin> seq = (ArrayList<Coin>)container.get(coins.get(i)).array;
//					if(seq == null)
//						break;
//					sub.addAll(seq);
//					ret.add(sub);
//				}
//			}
//			coins = sub;
//		}
		return ret;
	}

//	private ArrayList<Coin> change(ArrayList<Coin> arr) {
//		ArrayList<Coin> ret = new ArrayList<Coin>();
//		for(int i = iStart ; i < arr.size() && i < iEnd; ++i) {
//			
//		}
//		return ret;
//	}
}
