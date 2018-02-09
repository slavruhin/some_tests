package geometric.share.base;

/**
 * 
 * @author Sergej
 *
 */
public class Shape implements Geometric {
	private final double flache;
	private final double perimeter;

	/**
	 * 
	 * @param flache
	 * @param perimeter
	 */
	public Shape(double flache, double perimeter) {
		this.flache    = flache;
		this.perimeter = perimeter;
	}

	/**
	 * 
	 */
	@Override
	public double getFlaeche() {
		return flache;
	}

	/**
	 * 
	 * @return
	 */
	public double getPerimeter() {
		return perimeter;
	}
}
