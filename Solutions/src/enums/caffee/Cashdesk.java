package enums.caffee;

import java.util.*;
import enums.caffee.algorithms.*;

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class Cashdesk 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private TreeMap<Coin, Integer> container = new TreeMap<Coin, Integer>();
	{ 
		for(Coin coin : Coin.values())
			container.put(coin, 0);
	}
	
	@SuppressWarnings("unchecked")
	public TreeMap<Coin, Integer> getContainerCopy() {
		return (TreeMap<Coin, Integer>)container.clone();
	}
	
	/**
	 * To compare two double values
	 */
	public static final Comparator<Double> comparator = (x,y) -> (int)Math.round((x - y) * 100);

	/**
	 * using external algorithm to change an incoming summe
	 */
	private CashChangable algorithm = new DefaultCashChangeAlgorithm();
	public void setCashChangeAlgorithm(CashChangable algorithm) {
		this.algorithm = algorithm;
	}
	
	public void clear() {
		for(Coin coin : Coin.values())
			container.put(coin, 0);
	}

	/**
	 * 
	 * @param caffee
	 * @return
	 */
	public ArrayList<Coin> purchase(ArrayList<Coin> coins, Caffee caffee) {
		double diff = comparator.compare(sum(coins), caffee.price) / 100.;
		if(diff >= 0.) {
			add(coins);
			ArrayList<Coin> ret = change(diff);
			if(comparator.compare(sum(ret), diff) == 0) {
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
	public static double sum(Collection<Coin> coins) {
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
		return algorithm.change(summe, container);
	}

	/**
	 * 
	 * @param array
	 */
	public void add(Collection<Coin> coins) {
		for(Coin c : coins)
			add(c, 1);
	}
	/**
	 * 
	 * @param array
	 */
	public void add(Coin ... coins) {
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
	 * @param array
	 * @return
	 */
	public boolean remove(Coin ... coins) {
		ArrayList<Coin> removed = new ArrayList<Coin>();
		for(Coin coin : coins) {
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
	 * @return
	 */
	public ArrayList<Coin> getCoins() {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		for(Map.Entry<Coin, Integer> entry : container.entrySet())
			for(int i = 0 ; i < entry.getValue() ; ++i)
				coins.add(entry.getKey());
		return coins;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer sbuf = new StringBuffer(256);
		sbuf.append(String.format("Cash desk contains: %n"));
		for(Map.Entry<Coin, Integer> entry : container.entrySet())
			sbuf.append(String.format("\t%-7s : %d piece(s)%n", entry.getKey(), entry.getValue()));
		sbuf.append(String.format("tTotal %.2f \u20AC %n", revenue()));
		return sbuf.toString();
	}
}
