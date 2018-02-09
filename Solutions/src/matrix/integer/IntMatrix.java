/**
 * 
 */
package matrix.integer;

//import static org.junit.jupiter.api.Assertions.assertEquals;

interface IntOperation {
	int calculate(int a, int b);
}

class DefaultValueSetter {
	public int value(int min, int max) {  return min; };
}

class RandomValueSetter extends DefaultValueSetter {
	public int value(int min, int max) {
		if(min > max) {
			int swap = min; min = max; max = swap;
		}
		return min + (int) (Math.random() * max); 
	}
}



/**
 * @author slavruhin-ronn
 *
 */
public class IntMatrix {
	public final int x, y;
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

		x = xDimension;
		y = yDimension;
		data = new int[xDimension][yDimension];
		initialize(defaultValue, 0, new  DefaultValueSetter());
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

		x = xDimension;
		y = yDimension;
		data = new int[xDimension][yDimension];
		initialize(minRandomValue, maxRandomValue, new  RandomValueSetter());
	}
	
	private void initialize(int min, int max, DefaultValueSetter setter) {
		for(int i = 0 ; i < x ; i++)
			for(int j = 0 ; j < y ; j++)
				data[i][j] = setter.value(min,  max);
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
		return x == m.x && y == m.y ? true : false;
	}

	@Override
	public boolean equals(Object matrix) {
		IntMatrix m = (IntMatrix)matrix;
		if(! dimensionEquals(m))
			return false;
		
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
	public IntMatrix calculate(int value, IntOperation operation) {
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++)
				data[i][j] = operation.calculate(data[i][j], value ) ;
		return this;
	}
	/**
	 * 
	 * @param m
	 * @return
	 */
	public IntMatrix calculate(IntMatrix m, IntOperation operation) {
		if(dimensionEquals(m)) {
			for(int i = 0 ; i < x; i++)
				for(int j = 0 ; j < y ; j++)
					data[i][j] = operation.calculate(data[i][j], m.get()[i][j] ) ;
		}
		return this;
	}

	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public IntMatrix add(int value)   { return calculate(value, (x,y) -> x + y ); }
	public IntMatrix add(IntMatrix m) { return calculate(m,     (x,y) -> x + y ); }

	/**
	 * 
	 * @param value
	 * @return
	 */
	public IntMatrix sub(int value)   { return calculate(value, (x,y) -> x - y ); }
	public IntMatrix sub(IntMatrix m) { return calculate(m,     (x,y) -> x - y ); }

	/**
	 * 
	 * @param value
	 * @return
	 */
	public IntMatrix multiply(int value)   { return calculate(value, (x,y) -> x * y ); }
	public IntMatrix multiply(IntMatrix m) { return calculate(m,     (x,y) -> x * y ); }

	/**
	 * 
	 * @param value
	 * @return
	 */
	public IntMatrix divide(int value)   { return calculate(value, (x,y) -> x / y ); }
	public IntMatrix divide(IntMatrix m) { return calculate(m,     (x,y) -> x / y ); }
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public IntMatrix transpose() {
		int swap = 0;
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y ; j++) {
				swap = data[i][j];
				data[i][j] = data[j][i];
				data[j][i] = swap;
			}
		return this;
	}
	/**
	 * 
	 * @return
	 */
	public int[] toArray() {
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
	int getMaxValue() { 
		int max = Integer.MIN_VALUE;
		for(int[] row : data)
			for(int p : row)
				max = max < p ? p : max;
		return max;
	}
	
	@Override
	public String toString() {
		String format = String.format("%%%dd ", String.format("%d",getMaxValue()).length());
		StringBuffer buffer = new StringBuffer((format.length() * data[0].length + 4) * data.length);
		for(int[] row : data) {
			for(int p : row)
				buffer.append(String.format(format, p));
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
