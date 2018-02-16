package enums.cafee;

enum Caffee {
    KAFFEE     (1.00),
    CAPPUCCINO (1.20),
    ESPRESSO   (1.13);
    
    
    private double preis;
    Caffee(double preis) {
    	this.preis = preis;
    }
	
    @Override
    public String toString() {
    	return String.format("%s : %.2f", name().charAt(0) + name().substring(1).toLowerCase(), preis);
    }
}

