package enums.caffee;

public enum Coin {

	TWO_EUROS    (2.00),
	ONE_EURO     (1.00),
	FIFTY_CENTS  (0.50),
	TWENTY_CENTS (0.20),
	TEN_CENTS    (0.10),
	FIVE_CENTS   (0.05),
	TWO_CENTS    (0.02),
	ONE_CENT     (0.01);

	/**
	 * 
	 */
	public final double value;

	/**
	 * 
	 * @param value
	 */
	private Coin(double value) { 
		this.value = value; 
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%.2f \u20AC", value);
	}
}
