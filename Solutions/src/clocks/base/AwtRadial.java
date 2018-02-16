package clocks.base;

import java.awt.Point;

public class AwtRadial {
	public final java.awt.Point point1;
	public final java.awt.Point point2;
	
	public AwtRadial(final java.awt.Point p1, final java.awt.Point p2) {
		point1 = p1;
		point2 = p2;
	}

	public AwtRadial(Radial r) {
		point1 = new Point( (int)Math.round(r.point1.x), (int)Math.round(r.point1.y));
		point2 = new Point( (int)Math.round(r.point2.x), (int)Math.round(r.point2.y));
	}

	@Override
	public String toString() {
		return String.format("[x=%d, y=%d] -> [x=%d, y=%d]", point1.x, point1.y, point2.x, point2.y );
	}
}
