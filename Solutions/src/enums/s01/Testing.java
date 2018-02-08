package enums.s01;

enum Hunderasse {
	DACKEL("Dackel", 0.5), COLLIE("Collie",1.0), DOGGE("Dogge", 1.5);
	
	private String alias;
	final private double maxGroesse;
	
	private Hunderasse(String name, double maxGroesse) {
		this.alias = name;
		this.maxGroesse = maxGroesse;
	}
	
	@Override
	public String toString() {
		return String.format("%-6s, max. Größe: %.1f", alias, maxGroesse);
		//return String.format("ordinal=%d : %-6s (%s), max. Größe: %.1f", ordinal(), alias, name(), maxGroesse);
	}
}


public class Testing {
	public static void main(String[] args) {
		for(Hunderasse h : Hunderasse.values())
			System.out.println(h);
	}
}
