package enums.caffee;

public enum Caffee {
    KAFFEE     (1.00),
    CAPPUCCINO (1.20),
    ESPRESSO   (1.13);
    
    
    public final double price;
    
    private Caffee(double preis) { 
    	this.price = preis;
    }
	
    @Override
    public String toString() {
		return String.format("%s - price %.2f \u20AC", name().charAt(0) + name().substring(1).toLowerCase(), price);
    }
}

