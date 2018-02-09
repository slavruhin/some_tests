package matrix.integer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntMatrixTest {

	@Test
	void testInitIntInt() {
		int x = 2, 
		    y = 3;
		IntMatrix matrix = new IntMatrix(x,  y);

		assertEquals(x, matrix.get().length);
		assertEquals(y, matrix.get()[0].length);
		assertEquals(0, matrix.get()[0][0]);
	}

	@Test
	void testInitIntIntInt() {
		int x = 2, 
			y = 3, 
			value = 100;
		IntMatrix matrix = new IntMatrix(x,  y, value);

		assertEquals(x, matrix.get().length);
		assertEquals(y, matrix.get()[0].length);
		assertEquals(value, matrix.get()[0][0]);
		assertEquals(value, matrix.get()[x-1][y-1]);
	}

	@Test
	void testToString() {
		int x = 2,  y = 3,  value = 100;
		IntMatrix matrix = new IntMatrix(x,  y, value);
		
		String expected = String.format("100 100 100 %n") + 
				          String.format("100 100 100 %n");
		assertEquals(expected, matrix.toString());
	}
	
	@Test
	void testGet() {
		int x = 2,  y = 3,  value = 100;
		IntMatrix matrix = new IntMatrix(x,  y, value);
		
		int[][] xy = matrix.get();
		assertEquals(2, xy.length);

		int[] x0 = matrix.get(0);
		assertEquals(3, x0.length);

		int[] x1 = matrix.get(1);
		assertEquals(3, x1.length);
		
		int v00 = matrix.get(0, 0);
		assertEquals(value, v00);
		
		x0[0] = 200;
		assertEquals(200, matrix.get(0, 0));
	}
	
	@Test
	void testCreateRandomMatrix() {
		int x = 2,  y = 3,  value = 200;
		//int x = 20,  y = 30,  value = 200;
		IntMatrix matrix = IntMatrix.getRandomMatrix(x,  y, value);
		System.out.println(matrix.toString());
	}
	
	@Test
	void testMatrixEquals() {
		int x = 2,  y = 3,  value = 100;
		//int x = 20,  y = 30,  value = 200;
		IntMatrix m1 = new IntMatrix(x,  y, value),
				  m2 = new IntMatrix(x,  y, value);
		System.out.println(m1.toString());
		System.out.println();
		
		assertTrue(m1.equals(m2));
		m2.get()[1][1] = value*2;
		System.out.println(m2.toString());
		System.out.println();
		
		assertFalse(m1.equals(m2));
	}
	
	@Test
	void testMatrixMath() {
		int x = 2,  y = 3,  value = 100;
		//int x = 20,  y = 30,  value = 200;
		IntMatrix m1 = new IntMatrix(x,  y, value * 1),
				  m2 = new IntMatrix(x,  y, value * 2),
				  m3 = new IntMatrix(x,  y, value * 6);
		System.out.println(m1.toString());
		System.out.println();
		
		assertFalse(m1.equals(m2));
		assertFalse(m1.equals(m3));

		assertTrue(m1.multiply(2).equals(m2));
		System.out.println(m1.toString());
		System.out.println();

		assertTrue(m1.multiply(3).equals(m3));
		System.out.println(m1.toString());
		System.out.println();

		assertTrue(m1.divide(3).equals(m2));
		System.out.println(m1.toString());
		System.out.println();

		assertFalse(m1.divide(2).equals(m2));
		System.out.println(m1.toString());
		System.out.println();
	}
	
	@Test
	void testMatrixTransposing() {
		int x = 10,  y = 10,  value = 200;
		IntMatrix matrix = IntMatrix.getRandomMatrix(x,  y, value);
		System.out.println(matrix);
		System.out.println();
		
		System.out.println(matrix.transpose());
		System.out.println();
	}

}
