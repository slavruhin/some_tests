package aufgaben.collection.automat.base;

import java.util.*;

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
class CoinCounterCompareCoins implements Comparator<CoinCounter> {

	@Override
	public int compare(CoinCounter o1, CoinCounter o2) {
		int difference = (o1.twoEuros - o2.twoEuros) * Coin.TWO_EUROS.value;
		if(difference != 0)
			return difference;

		difference = (o1.oneEuro - o2.oneEuro) * Coin.ONE_EURO.value;
		if(difference != 0)
			return difference;

		difference = (o1.fivtyCents - o2.fivtyCents) * Coin.FIFTY_CENTS.value;
		if(difference != 0)
			return difference;
		
		difference = (o1.twentyCents - o2.twentyCents) * Coin.TWENTY_CENTS.value;
		if(difference != 0)
			return difference;
		
		difference = (o1.tenCents - o2.tenCents) * Coin.TEN_CENTS.value;
		if(difference != 0)
			return difference;
		
		difference = (o1.fiveCents - o2.fiveCents) * Coin.FIVE_CENTS.value;
		if(difference != 0)
			return difference;
		
		difference = (o1.twoCents - o2.twoCents) * Coin.TWO_CENTS.value;
		if(difference != 0)
			return difference;
		
		return (o1.oneCent - o2.oneCent) * Coin.ONE_CENT.value;
	}
}

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public class CoinCounter implements Comparable<CoinCounter>{

	int twoEuros    = 0;
	int oneEuro     = 0;
	int fivtyCents  = 0;
	int twentyCents = 0;
	int tenCents    = 0;
	int fiveCents   = 0;
	int twoCents    = 0;
	int oneCent     = 0;

	// set default comparator to use in set or map collection
	public Comparator<CoinCounter> comparator = new CoinCounterCompareCoins();

	@Override
	public int compareTo(CoinCounter other) {
		return comparator.compare(this, other);
	}

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
		if(number >= 0) {
			this.twoEuros    = number;
			this.oneEuro     = number;
			this.fivtyCents  = number;
			this.twentyCents = number;
			this.tenCents    = number;
			this.fiveCents   = number;
			this.twoCents    = number;
			this.oneCent     = number;
		}
	}

	/**
	 * 
	 * @param obj
	 */
	public CoinCounter(CoinCounter other) {
		if(other != null) {
			this.twoEuros    = other.twoEuros   ;
			this.oneEuro     = other.oneEuro    ;
			this.fivtyCents  = other.fivtyCents ;
			this.twentyCents = other.twentyCents;
			this.tenCents    = other.tenCents   ;
			this.fiveCents   = other.fiveCents  ;
			this.twoCents    = other.twoCents   ;
			this.oneCent     = other.oneCent    ;
		}
	}

	/**
	 * 
	 * @param coins
	 */
	public CoinCounter(Collection<Coin> coins) {
		if(coins != null) {
			for(Coin c : coins) {
				switch (c) {
					case TWO_EUROS:
						twoEuros++;
						break;
					case ONE_EURO:
						oneEuro++;
						break;
					case FIFTY_CENTS:
						fivtyCents++;
						break;
					case TWENTY_CENTS:
						twentyCents++;
						break;
					case TEN_CENTS:
						tenCents++;
						break;
					case FIVE_CENTS:
						fiveCents++;
						break;
					case TWO_CENTS:
						twoCents++;
						break;
					case ONE_CENT:
						oneCent++;
						break;
					default:
						break;
				}
			}
		}
	}

	public void clear() {
		twoEuros    = 0;
		oneEuro     = 0;
		fivtyCents  = 0;
		twentyCents = 0;
		tenCents    = 0;
		fiveCents   = 0;
		twoCents    = 0;
		oneCent     = 0;
	}

	public void add(Collection<Coin> coins) {
		add(new CoinCounter(coins));
	}

	public void add(CoinCounter other) {
		this.twoEuros    += other.twoEuros   ;
		this.oneEuro     += other.oneEuro    ;
		this.fivtyCents  += other.fivtyCents ;
		this.twentyCents += other.twentyCents;
		this.tenCents    += other.tenCents   ;
		this.fiveCents   += other.fiveCents  ;
		this.twoCents    += other.twoCents   ;
		this.oneCent     += other.oneCent    ;
	}

	public boolean subtract(Collection<Coin> coins) {
		return subtract(new CoinCounter(coins));
	}

	public boolean subtract(CoinCounter other) {
		if(! isContains(other))
			return false;
		this.twoEuros    -= other.twoEuros   ;
		this.oneEuro     -= other.oneEuro    ;
		this.fivtyCents  -= other.fivtyCents ;
		this.twentyCents -= other.twentyCents;
		this.tenCents    -= other.tenCents   ;
		this.fiveCents   -= other.fiveCents  ;
		this.twoCents    -= other.twoCents   ;
		this.oneCent     -= other.oneCent    ;
		return true;
	}

	/**
	 * 
	 * @param container
	 */
	public CoinCounter(Map<Coin, Integer> container) {
		twoEuros    = container.get(Coin.TWO_EUROS).intValue();
		oneEuro     = container.get(Coin.ONE_EURO).intValue();
		fivtyCents  = container.get(Coin.FIFTY_CENTS).intValue();
		twentyCents = container.get(Coin.TWENTY_CENTS).intValue();
		tenCents    = container.get(Coin.TEN_CENTS).intValue();
		fiveCents   = container.get(Coin.FIVE_CENTS).intValue();
		twoCents    = container.get(Coin.TWO_CENTS).intValue();
		oneCent     = container.get(Coin.ONE_CENT).intValue();
	}

	/**
	 * 
	 * @return sum of coins in object
	 */
	public int sum() {
		return  twoEuros    * Coin.TWO_EUROS.value    +
				oneEuro     * Coin.ONE_EURO.value     +
				fivtyCents  * Coin.FIFTY_CENTS.value  +
				twentyCents * Coin.TWENTY_CENTS.value +
				tenCents    * Coin.TEN_CENTS.value    +
				fiveCents   * Coin.ONE_EURO.value     +
				twoCents    * Coin.TWO_CENTS.value    +
				oneCent     * Coin.ONE_CENT.value     ;
	}

	/**
	 * 
	 * @return a number of coins in object
	 */
	public int count() {
		return twoEuros + oneEuro + fivtyCents + twentyCents + tenCents + fiveCents + twoCents + oneCent;
	}

	/**
	 * 
	 * @param counter
	 * @return
	 */
	public boolean isContains(CoinCounter counter) {
		return 	this.twoEuros    >= counter.twoEuros    &&
				this.oneEuro     >= counter.oneEuro     &&
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
		container.put(Coin.ONE_EURO,     oneEuro    );
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
		append(container, Coin.ONE_EURO,     oneEuro   );
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
				oneEuro     == c.oneEuro    &&
				fivtyCents  == c.fivtyCents  &&
				twentyCents == c.twentyCents &&
				tenCents    == c.tenCents    &&
				fiveCents   == c.fiveCents   &&
				twoCents    == c.twoCents    &&
				oneCent     == c.oneCent;
	}
	
	@Override
	public String toString() {
		StringBuffer sbuf = new StringBuffer(256);
		for(Map.Entry<Coin, Integer> entry : toMap().entrySet())
			sbuf.append(String.format("\t%-7s : %3d piece(s) %n", entry.getKey(), entry.getValue()));
		sbuf.append(String.format("\tTotal %.2f \u20AC %n", sum()/100.));
		return sbuf.toString();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new CoinCounter(this);
	}
}
