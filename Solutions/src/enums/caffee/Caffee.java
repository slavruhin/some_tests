package enums.caffee;

public enum Caffee {
    KAFFEE     (1.00),
    CAPPUCCINO (1.20),
    ESPRESSO   (1.13);
    
    
    public final double preis;
    
    private Caffee(double preis) { 
    	this.preis = preis;
    }
	
    @Override
    public String toString() {
		return String.format("%-15s : %.2f \u20AC", name().charAt(0) + name().substring(1).toLowerCase(), preis);
    }
}

