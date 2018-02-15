package geometric.share.base;

//import java.text.DecimalFormat;
//import java.text.DecimalFormatSymbols;

/**
 * 
 * @author Sergej
 *
 */
public class Shape implements Movable<Double> {

	private final double flache;
	private final double perimeter;
	private final String type;
	private double X = 0, Y = 0;

	/**
	 * 
	 * @param flache
	 * @param perimeter
	 * @param type
	 */
	public Shape(double flache, double perimeter, String type) {
		this.flache    = flache;
		this.perimeter = perimeter;
		this.type      = type;
	}

	/**
	 * 
	 */
	//@Override
	public double getFlaeche() {
		return flache;
	}
	//@Override
	public String Flaeche() {
		return String.format("Flaeche %.2f", flache);
	}

	/**
	 * 
	 * @return
	 */
	//@Override
	public double getPerimeter() {
		return perimeter;
	}
	//@Override
	public String Perimeter() {
		return String.format("Perimeter %.2f", perimeter);
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getType() {
		return type;
	}
	


	/**
	 * 
	 */
	@Override
	public Double getPositionX() {
		return X;
	}

	/**
	 * 
	 */
	@Override
	public Double getPositionY() {
		return Y;
	}
	
	/**
	 * 
	 */
	@Override
	public void bewegen(Double x, Double y) {
		X = x;
		Y = y;
	}

	@Override
	public String Position() {
		return String.format("Position (%.2f, %.2f)", X, Y);
	}
	
	@Override
	public String toString() {
		return String.format("%-12s : %-25s ; %-20s ; %-20s", type, Position(), Flaeche(), Perimeter());
	}
	
//	public String DoubleFormatter(double d) {
//		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
//		decimalFormatSymbols.setDecimalSeparator('.');
//		decimalFormatSymbols.setGroupingSeparator(',');
//		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
//		return decimalFormat.format(d);
//	}
}
