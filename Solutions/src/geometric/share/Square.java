package geometric.share;

import geometric.share.base.*;

public class Square extends Shape {
	private final double length;
	
	/**
	 * 
	 * @param length
	 */
	public Square(double length) {
		super(4 * length, length * length);
		this.length = length;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLength() {
		return length;
	}
}
