/**
 * 
 */
package enums.s01;


enum Hunderasse_v01 {
	DACKEL(0.5), COLLIE(1.0), DOGGE(1.5);
	
	final private double maxGroesse;
	
	private Hunderasse_v01(double maxGroesse) {
		this.maxGroesse = maxGroesse;
	}
	
	@Override
	public String toString() {
		String n = name().charAt(0) + name().substring(1).toLowerCase();
		return String.format("%-6s, max. Größe: %.1f", n, maxGroesse);
		//return String.format("ordinal=%d : %s (%s), max. Größe: %.1f", ordinal(), n, name(), maxGroesse);
	}
}

enum Hunderasse_v02 {
	DACKEL("Dackel", 0.5), COLLIE("Collie",1.0), DOGGE("Dogge", 1.5);
	
	private String alias;
	final private double maxGroesse;
	
	private Hunderasse_v02(String name, double maxGroesse) {
		this.alias = name;
		this.maxGroesse = maxGroesse;
	}
	
	@Override
	public String toString() {
		return String.format("%-6s, max. Größe: %.1f", alias, maxGroesse);
		//return String.format("ordinal=%d : %s (%s), max. Größe: %.1f", ordinal(), n, name(), maxGroesse);
	}
}

enum Hunderasse_v03 {
	DACKEL, COLLIE, DOGGE;
	
	@Override
	public String toString() {
		String n = name().charAt(0) + name().substring(1).toLowerCase();
		return String.format("%-6s, max. Große: %.1f", n, (ordinal() + 1) * .5);
	}
}

public class EnumAccess {
	public static void main(String[] args) {
		for(Hunderasse_v01 h : Hunderasse_v01.values())
			System.out.println(h);
		System.out.println();
		
		for(Hunderasse_v02 h : Hunderasse_v02.values())
			System.out.println(h);
		System.out.println();
		
		for(Hunderasse_v03 h : Hunderasse_v03.values())
			System.out.println(h);
	}
}

