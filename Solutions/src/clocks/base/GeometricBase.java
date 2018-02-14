package clocks.base;

public class GeometricBase {
	/**
	 * Calculate number of segments in circle 
	 * @param gradStart
	 * @param gradEnd
	 * @param gradStep
	 * @return
	 */
	public static int getSegmentNumber(int gradStart, int gradEnd, int gradStep) {
		int x = Math.abs(gradStart - gradEnd);
		return x < gradStep || gradStep == 0? 0 : Math.abs(x / gradStep + (x % gradStep > 0 ? 1 : 0));
	}

	/**
	 * 
	 * @param center
	 * @param radius
	 * @param grad
	 * @return
	 */
	public static Point calculateCirclePoint(Point center, double radius, int grad) {
		return calculateCirclePoint(center.x, center.y, radius, grad);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 * @param grad
	 * @return
	 */
	public static Point calculateCirclePoint(double x, double y, double radius, int grad) {
		 // offset 90 grad
		double offset = Math.PI;
		double rad = Math.PI / 180.0 * grad + offset;

		// mirrors the position X
		x = x - radius * Math.sin(rad);
		y = y + radius * Math.cos(rad);
		return new Point(x, y);
	}

	/**
	 * Check if point is in this circle
	 * 
	 * @param p point position
	 * @return  true if point is in this circle
	 */
    public static boolean includedPoint(Point center, double radius, Point p) {
    	return includedPoint(center.x, center.y, radius, p.x, p.y);
    }

    /**
     * Check if point is in this circle
     * 
     * @param x - point position y
     * @param y - point position y
     * @return true if point is in this circle
     */
    public static boolean includedPoint(double centerX, double centerY, double radius, double x, double y) {
    	return Math.sqrt( Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2)) <= radius ? true : false;
    }
}
