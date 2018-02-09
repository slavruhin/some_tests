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
	public double getLength() {
		return length;
	}

	@Override
	public String info() {
		return String.format("%-12s (%.2f X %.2f)%n", getType(), length, length);
	}
}
