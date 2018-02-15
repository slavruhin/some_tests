package geometric;

import java.util.*;

import geometric.share.Circle;
import geometric.share.Rectangle;
import geometric.share.Square;
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

	void testShapeSortFlaecheUp() {
		Comparator<Shape> comparator = (x,y) -> (int)(x.getFlaeche() - y.getFlaeche());
		Arrays.sort(shapes, comparator);
		for(Shape p : shapes) 
			System.out.println(p);
		System.out.println();
	}

	void testShapeSortFlaecheDown() {
		Comparator<Shape> comparator = (x,y) -> (int)(y.getFlaeche() - x.getFlaeche());
		Arrays.sort(shapes, comparator);
		for(Shape p : shapes) 
			System.out.println(p);
		System.out.println();
	}

	void testShapeBinarySearchFlaeche() {
		Comparator<Shape> comparatorUp = (x,y) -> (int)(y.getFlaeche() - x.getFlaeche());

		Arrays.sort(shapes, comparatorUp);
		for(Shape p : shapes) 
			System.out.println(p);
		System.out.println();
		
		Shape searched = new Shape(144, 0, null);
		int beg = Arrays.binarySearch(shapes, searched, comparatorUp);
		if(beg >= 0) {
			int end = beg;
			for( ; end < shapes.length ; end++) {
				int eq = (int)(shapes[end].getFlaeche() - searched.getFlaeche());
				if(eq != 0)
					break;
			}
			for(int i = beg ; i < end ; ++i)
				System.out.println(shapes[i]);
		}
			
		
		System.out.println();
	}

	public static void main(String[] args) {
		//new ShapeTest().testInterfaceGeometrie();
		//new ShapeTest().testShapeSortFlaecheUp();
		//new ShapeTest().testShapeSortFlaecheDown();
		new ShapeTest().testShapeBinarySearchFlaeche();
	}
}
