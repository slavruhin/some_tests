/**
 * 
 */
package matrix.integer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author slavruhin-ronn
 *
 */
public class IntMatrix {
	
	private final int [][] data;
	
	/**
	 * 
	 * @param xDimension
	 * @param yDimension
	 */
	public IntMatrix(int xDimension, int yDimension) {
		this(xDimension, yDimension, 0);
	}
	
	/**
	 * 
	 * @param xDimension
	 * @param yDimension
	 * @param defaultValue
	 */
	public IntMatrix(int xDimension, int yDimension, int defaultValue) {
		if(xDimension < 1 || yDimension < 1)
			throw new ExceptionInInitializerError();

		data = new int[xDimension][yDimension];
		for(int x = 0 ; x < xDimension ; x++)
			for(int y = 0 ; y < yDimension ; y++)
				data[x][y] = defaultValue;
	}
	
	/**
	 * 
	 * @param xDimension
	 * @param yDimension
	 * @param defaultValue
	 */
	public IntMatrix(int xDimension, int yDimension, int minRandomValue, int maxRandomValue) {
		if(xDimension < 1 || yDimension < 1)
			throw new ExceptionInInitializerError();

		data = new int[xDimension][yDimension];
		for(int x = 0 ; x < xDimension ; x++)
			for(int y = 0 ; y < yDimension ; y++)
				data[x][y] = minRandomValue + (int) (Math.random() * maxRandomValue); 
	}

	/**
	 * 
	 * @param xDimension
	 * @param yDimension
	 * @param maxRandomValue
	 * @return
	 */
	static IntMatrix getRandomMatrix(int xDimension, int yDimension, int maxRandomValue) {
		return new IntMatrix(xDimension, yDimension, 0, maxRandomValue);
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public boolean dimensionEquals(IntMatrix m) {
		return getXDimension() == m.getXDimension() && getYDimension() == m.getYDimension() ? true : false;
	}

	@Override
	public boolean equals(Object matrix) {
		IntMatrix m = (IntMatrix)matrix;
		if(! dimensionEquals(m))
			return false;
		
		int x = getXDimension(), y = getYDimension();
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++)
				if(get(i, j) != m.get(i, j))
					return false;
		return true;
	}
	

	/**
	 * 
	 * @param value
	 * @return
	 */
	public IntMatrix multiply(int value) {
		int x = getXDimension(), y = getYDimension();
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++)
				data[i][j] *= value;
		return this;
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public IntMatrix multiply(IntMatrix m) {
		if(dimensionEquals(m)) {
			int x = getXDimension(), y = getYDimension();
			for(int i = 0 ; i < x; i++)
				for(int j = 0 ; j < y ; j++)
					get(i)[j] *= m.get(i)[j];
		}
		return this;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public IntMatrix divide(int value) {
		int x = getXDimension(), y = getYDimension();
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++)
				data[i][j] /= value;
		return this;
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public IntMatrix divide(IntMatrix m) {
		if(dimensionEquals(m)) {
			int x = getXDimension(), y = getYDimension();
			for(int i = 0 ; i < x; i++)
				for(int j = 0 ; j < y ; j++)
					get(i)[j] /= m.get(i)[j];
		}
		return this;
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public IntMatrix transpose() {
		return this;
	}
	/**
	 * 
	 * @return
	 */
	public int[] toArray() {
		int x = getXDimension(), y = getYDimension();
		int [] array = new int[x * y];
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++)
				array[i * y + j] = get(i, j);
		return array;
	}

	/**
	 * 
	 * @return
	 */
	int [][] get() { 
		return data;
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	int[] get(int x) {
		return data[x];
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int get(int x, int y) {
		return data[x][y];
	}

	/**
	 * 
	 * @return
	 */
	int getXDimension() { 
		return data.length;
	}
	
	/**
	 * 
	 * @return
	 */
	int getYDimension() { 
		return data[0].length;
	}

	
	/**
	 * 
	 * @return
	 */
	int getMaxValue() { 
		int x = getXDimension();
		int y = getYDimension();
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++)
				if(max < data[i][j])
					max = data[i][j];
		return max;
	}
	
	@Override
	public String toString() {
		int x = getXDimension();
		int y = getYDimension();
		String format = String.format("%%%dd ", String.format("%d",getMaxValue()).length());
		
		StringBuffer buffer = new StringBuffer((format.length() * x + 4) * y);
		for(int i = 0 ; i < x; i++) {
			for(int j = 0 ; j < y ; j++) {
				buffer.append(String.format(format, data[i][j]));
			}
			buffer.append(String.format("%n"));
		}
		return buffer.toString();
	}

	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 2,  y = 3,  value = 100;
		IntMatrix matrix = new IntMatrix(x,  y, value);
		System.out.println(matrix.toString());
		System.out.println();
		
		int[][] xy = matrix.get();
		System.out.println("xy.length : " + xy.length);
		System.out.println();

		int[] x0 = matrix.get(0);
		System.out.println("x0.length : " + x0.length);
		System.out.println();

		int[] x1 = matrix.get(1);
		System.out.println("x1.length : " + x1.length);
		System.out.println();

		int v00 = matrix.get(0, 0);
		System.out.println("v00 : " + v00);
		System.out.println();
		
		x0[0] = 200;
		System.out.println(matrix.toString());
		System.out.println();
	}
}
