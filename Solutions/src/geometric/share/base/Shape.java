package geometric.share.base;

/**
 * 
 * @author Sergej
 *
 */
public abstract class Shape implements Geometric, Movable {

	private final double flache;
	private final double perimeter;
	private final String type;
	
	private int posX = 0, posY = 0;

	/**
	 * 
	 * @param flache
	 * @param perimeter
	 */
	public Shape(double flache, double perimeter, String type) {
		this.flache    = flache;
		this.perimeter = perimeter;
		this.type      = type;
	}

	/**
	 * 
	 */
	@Override
	public double getFlaeche() {
		return flache;
	}

	/**
	 * 
	 * @return
	 */
	public double getPerimeter() {
		return perimeter;
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
	public void bewegen(int x, int y) {
		posX = x;
		posY = y;
	}

	/**
	 * 
	 */
	@Override
	public int getPositionX() {
		return posX;
	}

	/**
	 * 
	 */
	@Override
	public int getPositionY() {
		return posY;
	}
	
	abstract public String info();
}
