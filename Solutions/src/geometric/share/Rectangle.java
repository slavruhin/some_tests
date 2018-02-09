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
		super(width * hight, 2 * (width + hight));
		this.width = width;
		this.hight = hight;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHight() {
		return hight;
	}
}
