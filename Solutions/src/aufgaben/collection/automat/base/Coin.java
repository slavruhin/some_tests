package aufgaben.collection.automat.base;

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public enum Coin {

	TWO_EUROS    (200),
	ONE_EURO     (100),
	FIFTY_CENTS  ( 50),
	TWENTY_CENTS ( 20),
	TEN_CENTS    ( 10),
	FIVE_CENTS   (  5),
	TWO_CENTS    (  2),
	ONE_CENT     (  1);

	public final int value;

	private Coin(int value) { 
		this.value = value; 
	}

	private Coin(double value) { 
		this.value = (int)Math.round(value * 100); 
	}

	@Override
	public String toString() {
		return String.format("%.2f \u20AC", value / 100.);
	}
}
