/**
 * 
 */
package clocks.base;

import java.util.*;

/**
 * @author slavruhin-ronn
 *
 */
public class Circle {
	private Point center;
	private double radius;
	private ArrayList<Point> array;

	/**
	 * Constructor
	 */
	public Circle(double x, double y, double radius, int first, int last, int step) {
		center = new Point(x, y);
		this.radius = radius;
		initArray(first, last, step);
	}

	/**
	 * Constructor
	 * 
	 * @param center
	 * @param radius
	 */
	public Circle(Point center, double radius, int first, int last, int step) {
		this(center.x, center.y, radius, first, last, step);
	}

	/**
	 * Copy constructor
	 * 
	 * @param obj
	 */
	public Circle(Circle obj) {
		this.center = new Point(obj.center);
		this.radius = obj.radius;
		array = new ArrayList<>(obj.array);
	}

	/**
	 * Get position of center
	 */
	public Point getCenter() { 
		return center;
	}

	/**
	 * Get position of center
	 */
	public double getRadius() {
		return radius;
	}
	
	public ArrayList<Point> getArray() {
		return array;
	}

	/**
	 * Create an array with calculated position of Points on circle
	 *  
	 * @param grad (0 .. )
	 * @return Point object with position on circle
	 * @throws Exception 
	 */
	public void initArray(int first, int last, int step) {
		int number = GeometricBase.getSegmentNumber(first, last, step);

		array = new ArrayList<Point>(); 
		for(int i = 0 ; i < number ; i++, first += step)
			array.add(GeometricBase.calculateCirclePoint(center.x, center.y, radius, first) );

		if(first != last)
			array.set(array.size() - 1, GeometricBase.calculateCirclePoint(center.x, center.y, radius, last));
	}

	/**
	 * @return print a position of current circle
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer(1024);
		buffer.append(String.format("Center [%s], radius : %.2f %n", center, radius));
		for(Point p : array)
			buffer.append(String.format("\t%s %n", p));
		return buffer.toString();
	}
}
