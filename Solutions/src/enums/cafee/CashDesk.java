package enums.cafee;

import java.util.*;

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class CashDesk extends TreeMap<Coin, Integer>
{
	{ for(Coin coin : Coin.values())    put(coin, 0); }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param array
	 */
	public void add(ArrayList<Coin> coins) {
		for(Coin c : coins)
			add(c, 1);
	}

	/**
	 * 
	 * @param c
	 * @param number
	 */
	public void add(Coin coin, int number) {
		number += get(coin).intValue();
		put(coin, number);
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean remove(ArrayList<Coin> array) {
		ArrayList<Coin> removed = new ArrayList<Coin>();
		for(Coin coin : array) {
			if(remove(coin, 1) == false) {
				add(removed);
				return false;
			}
			removed.add(coin);
		}
		return true;
	}

	/**
	 * 
	 * @param c
	 * @param number
	 * @return
	 */
	public boolean remove(Coin c, int number) {
		number = get(c).intValue() - number;
		if(number < 0)
			return false;
		put(c, number);
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public double revenue() {
		double ret = .0;
		for(Map.Entry<Coin, Integer> entry : entrySet())
			ret += entry.getKey().value * entry.getValue();
		return ret;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer sbuf = new StringBuffer(256);
		sbuf.append(String.format("Cash desk contains %n"));
		sbuf.append(String.format("----------------------%n", revenue()));
		for(Map.Entry<Coin, Integer> entry : entrySet())
			sbuf.append(String.format("\t%-7s : %d %n", entry.getKey(), entry.getValue()));
		sbuf.append(String.format("----------------------%n"));
		sbuf.append(String.format("Revenue %.2f \u20AC %n", revenue()));
		return sbuf.toString();
	}
}
