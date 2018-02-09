package geometric.share;

import geometric.share.base.*;

public class Rectangle extends Shape {
	private final double width, hight;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Rectangle(double width, double hight) {
		super(width * hight, 2 * (width + hight), "Rectangle");
		this.width = width;
		this.hight = hight;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHight() {
		return hight;
	}
	
	public String info() {
		return String.format("%-12s (%.2f X %.2f)%n", getType(), width, hight);
	}
}
