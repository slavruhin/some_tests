package clocks.base;

/**
 * 
 * @author S.Lavruhin
 *
 */
public class Point implements Comparable<Point>{
	private final double precession = 0.0001;
	
	public final double x;
	public final double y;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param p
	 */
	public Point(final Point p) {
		this(p.x, p.y);
	}

	/**
     * Wrapper to initialize a Point with double values.
     * 
     * @param x
     * @param y
     * @return
     */
    public static java.awt.Point toUtilPoint(double x, double y) {
    	return new java.awt.Point((int)Math.round(x), (int)Math.round(y));
    }
    
    @Override
    public String toString() {
		return String.format("x=%.2f, y=%.2f", x, y );
    }

	@Override
	public int compareTo(Point p) {
		double deltaX = Math.abs(x - p.x), 
			   deltaY = Math.abs(y - p.y);
		return deltaX > precession ? (x > p.x ? 1 : -1) :  deltaY > precession ? (y > p.y ? 1 : -1) : 0; 
	}
}