package geometric.share;

import geometric.share.base.*;

public class Square extends Shape {
	private final double length;
	
	/**
	 * 
	 * @param length
	 */
	public Square(double length) {
		super(4 * length, length * length, "Square");
		this.length = length;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLength() { return length; }

	@Override
	public String toString() {
		return super.toString() + String.format(" ;  Width/Hight (%.2f x %.2f)", length, length);
	}
}
