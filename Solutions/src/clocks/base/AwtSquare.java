package clocks.base;

import java.awt.Point;

public class AwtSquare {
	public final java.awt.Point point1;
	public final java.awt.Point point2;
	
	public AwtSquare(final Point center, double length) {
		length /= 2;
		point1 = new java.awt.Point((int)Math.round(center.x - length), (int)Math.round(center.y - length));
		point2 = new java.awt.Point((int)Math.round(center.x - length), (int)Math.round(center.y - length));
	}

	@Override
	public String toString() {
		return String.format("[x=%d, y=%d] -> [x=%d, y=%d]", point1.x, point1.y, point2.x, point2.y );
	}
}
