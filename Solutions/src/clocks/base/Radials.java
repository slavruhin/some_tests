package clocks.base;

import java.util.*;

public class Radials {
	private Point center;
	private double internal_radius, external_radius;
	private ArrayList<Radial> array;

	/**
	 * 
	 * @param center
	 * @param internal_radius
	 * @param external_radius
	 * @param first
	 * @param last
	 * @param step
	 */
	public Radials(Point center, 
			       double internal_radius, 
			       double external_radius,
			       int first,
			       int last,
			       int step) {
		this.center = center;
		this.internal_radius = internal_radius;
		this.external_radius = external_radius;
		initArray(internal_radius, external_radius, first, last, step);
	}
	
	/**
	 * 
	 * @param internal_radius
	 * @param external_radius
	 * @param first
	 * @param last
	 * @param step
	 */
	public void initArray(double internal_radius, 
		                  double external_radius,
					      int first,
					      int last,
					      int step) {

		int number = GeometricBase.getSegmentNumber(first, last, step);
		array = new ArrayList<Radial>();

		for(int i = 0 ; i < number ; i++, first += step)
			array.add(new Radial(GeometricBase.calculateCirclePoint(this.center, internal_radius, first),
				                 GeometricBase.calculateCirclePoint(this.center, external_radius, first)));
		if(first != last)
			array.set(array.size() - 1, new Radial(GeometricBase.calculateCirclePoint(this.center, internal_radius, last),
	                                               GeometricBase.calculateCirclePoint(this.center, external_radius, last)));
	}
	
	public ArrayList<Radial> getArray() {
		return array;
	}

	public Point getCenter() {
		return center;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(1024);
		buffer.append(String.format("Center [%s], internal radius = %.2f, external radius = %.2f %n", center, internal_radius, external_radius));
		for(Radial p : array)
			buffer.append(String.format("\t%s %n", p));
		return buffer.toString();
	}
}
