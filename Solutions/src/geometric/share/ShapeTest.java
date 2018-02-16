package geometric.share;

import geometric.share.base.*;

class ShapeTest {
	
	private final Shape[] shapes;

	{
		int size = 100;
		shapes = new Shape[100];
		for(int i = 0 ; i < size ; i++) {
			int type = (int) (Math.random() * 3);
			int length = 10 + (int) (Math.random() * 20);
			if(type == 0) 
				shapes[i] = new Circle(length);
			else if(type == 1) 
				shapes[i] = new Square(length);
			else {
				shapes[i] = new Rectangle(length, length / 2);
			}
		}
	}

	void testInterfaceGeometrie() {
		for(Shape p : shapes) 
			System.out.println(p);
		System.out.println();
	}

	
	

	public static void main(String[] args) {
		new ShapeTest().testInterfaceGeometrie();
	}
}
