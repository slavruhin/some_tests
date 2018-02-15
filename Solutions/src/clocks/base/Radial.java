package clocks.base;

/**
 * 
 * @author S.Lavruhin
 *
 */
public class Radial {
	public final Point point1;
	public final Point point2;
	
	public Radial(final Point p1, final Point p2) {
		point1 = p1;
		point2 = p2;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] -> [%s]", point1, point2 );
	}
}
