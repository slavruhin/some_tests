package enums.cafee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class CashProcessor extends CashDesk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param coins
	 * @param caffee
	 * @return
	 */
	public boolean pay(ArrayList<Coin> coins, Caffee caffee) {
		double payback = getDifference(coins, caffee);
		if(payback < 0) {
			System.out.println("not enough coins : " + payback);
			return false;
		}
		// Try to get payback
		System.out.println("return payback. " + payback);
		return true;
	}

	/**
	 * 
	 * @param payback
	 * @return
	 */
	ArrayList<Coin> getPayback(double payback) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		for(Map.Entry<Coin, Integer> entry : entrySet()) {
			int count = (int)(payback / entry.getKey().value);
			if(count > 0) {
				int number = entry.getValue().intValue();
				count = count < number ? count : number;
				for(int i = 0 ; i < count ; ++i)
					coins.add(entry.getKey());
				remove(entry.getKey(), count);
				payback -= count * entry.getKey().value;
			}
		}
		return coins;
	}

	/**
	 * To calculate difference between incoming coins and price
	 */
	static Comparator<Double> Diff = (x,y) -> (int)Math.round((x - y) * 100);

	/**
	 * 
	 * @param coins
	 * @param caffee
	 * @return
	 */
	public static double getDifference(ArrayList<Coin> coins, Caffee caffee) {
		return Diff.compare(summe(coins), caffee.preis) / 100.;
	}

	/**
	 * 
	 * @param coins
	 * @return
	 */
	public static double summe(ArrayList<Coin> coins) {
		double ret = .0;
		for(Coin c : coins) ret += c.value;
		return ret;
	}
}
