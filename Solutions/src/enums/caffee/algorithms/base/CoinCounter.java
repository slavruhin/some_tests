package enums.caffee.algorithms.base;

import java.util.*;
import enums.caffee.Coin;


/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
class CoinCounterCompareSum implements Comparator<CoinCounter> {

	@Override
	public int compare(CoinCounter o1, CoinCounter o2) {
		return o1.sum - o2.sum;
	}
}

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
class CoinCounterCompareCount implements Comparator<CoinCounter> {

	@Override
	public int compare(CoinCounter o1, CoinCounter o2) {
		return o1.count() - o2.count();
	}
}

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
class CoinCounterCompareCoins implements Comparator<CoinCounter> {

	@Override
	public int compare(CoinCounter o1, CoinCounter o2) {
		int difference = (int)(o1.twoEuros - o2.twoEuros * Coin.TWO_EUROS.value * 100);
		if(difference != 0)
			return difference;

		difference = (int)(o1.oneEuros - o2.oneEuros * Coin.ONE_EURO.value * 100);
		if(difference != 0)
			return difference;

		difference = (int)(o1.fivtyCents - o2.fivtyCents * Coin.FIFTY_CENTS.value * 100);
		if(difference != 0)
			return difference;
		
		difference = (int)(o1.twentyCents - o2.twentyCents * Coin.TWENTY_CENTS.value * 100);
		if(difference != 0)
			return difference;
		
		difference = (int)(o1.tenCents - o2.tenCents * Coin.TEN_CENTS.value * 100);
		if(difference != 0)
			return difference;
		
		difference = (int)(o1.fiveCents - o2.fiveCents * Coin.FIVE_CENTS.value * 100);
		if(difference != 0)
			return difference;
		
		difference = (int)(o1.twoCents - o2.twoCents * Coin.TWO_CENTS.value * 100);
		if(difference != 0)
			return difference;
		
		return (int)(o1.oneCent - o2.oneCent * Coin.ONE_CENT.value * 100);
	}
}

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class CoinCounter implements Comparable<CoinCounter>{

	int twoEuros    = 0;
	int oneEuros    = 0;
	int fivtyCents  = 0;
	int twentyCents = 0;
	int tenCents    = 0;
	int fiveCents   = 0;
	int twoCents    = 0;
	int oneCent     = 0;
	int sum         = 0;

	// set default comparator to use in set or map
	public Comparator<CoinCounter> comparator = new CoinCounterCompareCoins();

	/**
	 * 
	 */
	public CoinCounter() {
	}

	/**
	 * 
	 * @param number
	 */
	public CoinCounter(int number) {
		this.twoEuros    = number;
		this.oneEuros    = number;
		this.fivtyCents  = number;
		this.twentyCents = number;
		this.tenCents    = number;
		this.fiveCents   = number;
		this.twoCents    = number;
		this.oneCent     = number;

		sum += twoEuros    * Coin.TWO_EUROS.value    * 100;
		sum += oneEuros    * Coin.ONE_EURO.value     * 100;
		sum += fivtyCents  * Coin.FIFTY_CENTS.value  * 100;
		sum += twentyCents * Coin.TWENTY_CENTS.value * 100;
		sum += tenCents    * Coin.TEN_CENTS.value    * 100;
		sum += fiveCents   * Coin.ONE_EURO.value     * 100;
		sum += twoCents    * Coin.TWO_CENTS.value    * 100;
		sum += oneCent     * Coin.ONE_CENT.value     * 100;
	}

	/**
	 * 
	 * @param obj
	 */
	public CoinCounter(CoinCounter obj) {
		this.twoEuros    = obj.twoEuros   ;
		this.oneEuros    = obj.oneEuros   ;
		this.fivtyCents  = obj.fivtyCents ;
		this.twentyCents = obj.twentyCents;
		this.tenCents    = obj.tenCents   ;
		this.fiveCents   = obj.fiveCents  ;
		this.twoCents    = obj.twoCents   ;
		this.oneCent     = obj.oneCent    ;
		this.sum         = obj.sum        ;
	}

	/**
	 * 
	 * @param coins
	 */
	public CoinCounter(Collection<Coin> coins) {
		for(Coin c : coins) {
			switch (c) {
				case TWO_EUROS:
					twoEuros++;
					sum += Coin.TWO_EUROS.value * 100;
					break;
				case ONE_EURO:
					oneEuros++;
					sum += Coin.ONE_EURO.value * 100;
					break;
				case FIFTY_CENTS:
					fivtyCents++;
					sum += Coin.FIFTY_CENTS.value * 100;
					break;
				case TWENTY_CENTS:
					twentyCents++;
					sum += Coin.TWENTY_CENTS.value * 100;
					break;
				case TEN_CENTS:
					tenCents++;
					sum += Coin.TEN_CENTS.value * 100;
					break;
				case FIVE_CENTS:
					fiveCents++;
					sum += Coin.FIVE_CENTS.value * 100;
					break;
				case TWO_CENTS:
					twoCents++;
					sum += Coin.TWO_CENTS.value * 100;
					break;
				case ONE_CENT:
					oneCent++;
					sum += Coin.ONE_CENT.value * 100;
					break;
				default:
					break;
			}
		}
	}

	/**
	 * 
	 * @param container
	 */
	public CoinCounter(Map<Coin, Integer> container) {
		twoEuros    = container.get(Coin.TWO_EUROS).intValue();
		oneEuros    = container.get(Coin.ONE_EURO).intValue();
		fivtyCents  = container.get(Coin.FIFTY_CENTS).intValue();
		twentyCents = container.get(Coin.TWENTY_CENTS).intValue();
		tenCents    = container.get(Coin.TEN_CENTS).intValue();
		fiveCents   = container.get(Coin.FIVE_CENTS).intValue();
		twoCents    = container.get(Coin.TWO_CENTS).intValue();
		oneCent     = container.get(Coin.ONE_CENT).intValue();

		sum += twoEuros    * Coin.TWO_EUROS.value    * 100;
		sum += oneEuros    * Coin.ONE_EURO.value     * 100;
		sum += fivtyCents  * Coin.FIFTY_CENTS.value  * 100;
		sum += twentyCents * Coin.TWENTY_CENTS.value * 100;
		sum += tenCents    * Coin.TEN_CENTS.value    * 100;
		sum += fiveCents   * Coin.ONE_EURO.value     * 100;
		sum += twoCents    * Coin.TWO_CENTS.value    * 100;
		sum += oneCent     * Coin.ONE_CENT.value     * 100;
	}

	/**
	 * 
	 * @return sum of coins in object
	 */
	public int sum() {
		return this.sum;
	}

	/**
	 * 
	 * @return a number of coins in object
	 */
	public int count() {
		return twoEuros + oneEuros + fivtyCents + twentyCents + tenCents + fiveCents + twoCents + oneCent;
	}

	/**
	 * 
	 * @param counter
	 * @return
	 */
	public boolean isContains(CoinCounter counter) {
		return 	this.twoEuros    >= counter.twoEuros    &&
				this.oneEuros    >= counter.oneEuros    &&
				this.fivtyCents  >= counter.fivtyCents  &&
				this.twentyCents >= counter.twentyCents &&
				this.tenCents    >= counter.tenCents    &&
				this.fiveCents   >= counter.fiveCents   &&
				this.twoCents    >= counter.twoCents    &&
				this.oneCent     >= counter.oneCent;
	}

	/**
	 * 
	 * @return a mapping of Coins and its number
	 */
	public Map<Coin, Integer> toMap() {
		Map<Coin, Integer> container = new TreeMap<Coin, Integer>();
		container.put(Coin.TWO_EUROS,    twoEuros   );
		container.put(Coin.ONE_EURO,     oneEuros   );
		container.put(Coin.FIFTY_CENTS,  fivtyCents );
		container.put(Coin.TWENTY_CENTS, twentyCents);
		container.put(Coin.TEN_CENTS,    tenCents   );
		container.put(Coin.FIVE_CENTS,   fiveCents  );
		container.put(Coin.TWO_CENTS,    twoCents   );
		container.put(Coin.ONE_CENT,     oneCent    );
		return container;
	}

	/**
	 * 
	 * @return Coins sequence
	 */
	public Collection<Coin> toCollection() {
		Collection<Coin> container = new ArrayList<Coin>();
		append(container, Coin.TWO_EUROS,    twoEuros   );
		append(container, Coin.ONE_EURO,     oneEuros   );
		append(container, Coin.FIFTY_CENTS,  fivtyCents );
		append(container, Coin.TWENTY_CENTS, twentyCents);
		append(container, Coin.TEN_CENTS,    tenCents   );
		append(container, Coin.FIVE_CENTS,   fiveCents  );
		append(container, Coin.TWO_CENTS,    twoCents   );
		append(container, Coin.ONE_CENT,     oneCent    );
		return container;
	}

	/**
	 * Helper function using in @toCollection function 
	 * @param seq
	 * @param coin
	 * @param number
	 * @return
	 */
	private static Collection<Coin> append(Collection<Coin> seq, Coin coin, int number) {
		for(int i = 0 ; i < number ; ++i)
			seq.add(coin);
		return seq;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof CoinCounter))
			return false;

		CoinCounter c = (CoinCounter)obj;
		return 	twoEuros    == c.twoEuros    &&
				oneEuros    == c.oneEuros    &&
				fivtyCents  == c.fivtyCents  &&
				twentyCents == c.twentyCents &&
				tenCents    == c.tenCents    &&
				fiveCents   == c.fiveCents   &&
				twoCents    == c.twoCents    &&
				oneCent     == c.oneCent;
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(CoinCounter o) {
		return comparator.compare(this, o);
	}

}
