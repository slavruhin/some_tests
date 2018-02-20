package enums.caffee;

import java.util.*;

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class CashDesk 
{
	private TreeMap<Coin, Integer> container = new TreeMap<Coin, Integer>();
	{ 
		for(Coin coin : Coin.values())
			container.put(coin, 0);
	}
	
	public static final Comparator<Double> comparator = (x,y) -> (int)Math.round((x - y) * 100);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param caffee
	 * @return
	 */
	public ArrayList<Coin> pay(ArrayList<Coin> coins, Caffee caffee) {
		double diff = comparator.compare(summe(coins), caffee.preis) / 100.;
		if(diff >= 0.) {
			add(coins);
			ArrayList<Coin> ret = change(diff);
			if(comparator.compare(summe(ret), diff) == 0) {
				remove(ret);
				return ret;
			}
			remove(coins);
		}
		return coins;
	}
	
	/**
	 * 
	 * @param coins
	 * @return
	 */
	public static double summe(ArrayList<Coin> coins) {
		double summe = .0;
		for(Coin c : coins) 
			summe += c.value;
		return summe;
	}

	/**
	 * 
	 * @param summe
	 * @return
	 */
	public ArrayList<Coin> change(double summe) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		for(Map.Entry<Coin, Integer> entry : container.entrySet()) {
			int count = (int)(summe / entry.getKey().value);
			if(count > 0) {
				int number = entry.getValue().intValue();
				count = count < number ? count : number;
				for(int i = 0 ; i < count ; ++i)
					coins.add(entry.getKey());
				summe -= count * entry.getKey().value;
			}
		}
		return coins;
	}

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
		number += container.get(coin).intValue();
		container.put(coin, number);
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
		number = container.get(c).intValue() - number;
		if(number < 0)
			return false;
		container.put(c, number);
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public double revenue() {
		double ret = .0;
		for(Map.Entry<Coin, Integer> entry : container.entrySet())
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
		for(Map.Entry<Coin, Integer> entry : container.entrySet())
			sbuf.append(String.format("\t%-7s : %d %n", entry.getKey(), entry.getValue()));
		sbuf.append(String.format("----------------------%n"));
		sbuf.append(String.format("Revenue %.2f \u20AC %n", revenue()));
		return sbuf.toString();
	}
}
