package aufgaben.collection.automat.base;

/**
 * 
 * @author S.Lavruhin-Ronn
 *
 */
public enum Coffee {
    KAFFEE     (100),
    CAPPUCCINO (120),
    ESPRESSO   (113);

    public final int price;

    private Coffee(int preis) { 
    	this.price = preis;
    }

    private Coffee(double preis) { 
    	this.price = (int)Math.round(preis * 100);
    }

    @Override
    public String toString() {
		return String.format("%s - price %.2f \u20AC", name().charAt(0) + name().substring(1).toLowerCase(), price / 100.);
    }
}
