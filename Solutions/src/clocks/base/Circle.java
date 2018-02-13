/**
 * 
 */
package clocks.base;

import java.awt.*;

/**
 * @author slavruhin-ronn
 *
 */
public class Circle {
	protected final double x;
	protected final double y;
	protected final double radius;

	
	/**
	 * Constructor
	 * 
	 * @param center
	 * @param radius
	 */
	public Circle(Point center, double radius) {
		this(center.x, center.y, radius);
	}

	/**
	 * Constructor
	 */
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param obj
	 */
	public Circle(Circle obj) {
		this(obj.x, obj.y, obj.radius);
	}
	
	
	/**
	 * Get position of center
	 */
	public Point getCenter() { 
		return toPoint(x, y);
	}

	/**
	 * Get position of center
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Get radius
	 */
	public int getRadiusAsInteger() {
		return (int)Math.round(radius);
	}

	/**
	 * Create an array with calculated position of Points on circle
	 *  
	 * @param grad (0 .. )
	 * @return Point object with position on circle
	 * @throws Exception 
	 */
	public Point[] calculateCirclePoints(int gradStart, int gradEnd, int gradStep) throws Exception {

		if(gradStep <= 0)
			throw new Exception("parameter gradStep (" + gradStep + ") missmatch.");

		int end = gradStart < gradEnd ? gradEnd : gradStart; 
		int beg = gradStart < gradEnd ? gradStart : gradEnd; 
		int length = (end - beg) / gradStep;

		Point[] arr = new Point[length];
		for (int i = 0; i < arr.length; i++, beg += gradStep) {
			arr[i] = calculateCirclePoint(beg);
		}
		return arr;
	}

	/**
	 * Get a position of Point on circle
	 * @param grad (0 .. )
	 * @return Point object with position on circle
	 */
	public Point calculateCirclePoint(int grad) {
		 // offset 90 grad
		double offset = Math.PI;
		double rad = Math.PI / 180.0 * grad + offset;

		// mirrors the position X
		double x = this.x - radius * Math.sin(rad);
		double y = this.y + radius * Math.cos(rad);
		return toPoint(x, y);
	}
	
	/**
	 * @return print a position of current circle
	 */
	public String toString() {
		return String.format("Center : %.2f, %.2f%nRadius : %.2f", x, y, radius );
	}
	
	/**
	 * Check if point is in this circle
	 * 
	 * @param p point position
	 * @return  true if point is in this circle
	 */
    public boolean includedPoint(Point p) {
    	return includedPoint(p.x, p.y);
    }

    /**
     * Check if point is in this circle
     * 
     * @param x - point position y
     * @param y - point position y
     * @return true if point is in this circle
     */
    public boolean includedPoint(double x, double y) {
    	return Math.sqrt( Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) <= this.radius ? true : false;
    }
    
    /**
     * Wrapper to initialize a Point with double values.
     * 
     * @param x
     * @param y
     * @return
     */
    public static Point toPoint(double x, double y) {
    	return new Point((int)Math.round(x), (int)Math.round(y));
    }
}
