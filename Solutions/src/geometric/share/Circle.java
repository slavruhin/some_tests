package geometric.share;

import geometric.share.base.*;

public class Circle extends Shape {
	private final double radius;
	
	/**
	 * 
	 * @param radius
	 */
	public Circle(double radius) {
		super(2 * Math.PI * radius, Math.PI * radius * radius, "Circle");
		this.radius = radius;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getRadius() { return radius; }

	@Override
	public String toString() {
		return super.toString() + String.format(" ;  Radius: %.2f", radius);
	}
}
