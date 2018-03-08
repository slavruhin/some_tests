package vce.eA.item19;

import java.util.Iterator;
import java.util.List;

class Foo {
	public int a = 3;
	public void addFive() {
		a += 5;
		System.out.print("f ");
	}
}

class Bar extends Foo {
	public int a = 8;
	public void addFive() {
		this.a += 5;
		System.out.print("b ");
	}
}


public class Test {
	static public void go() {
		String o = "";
		z:
		for(int x = 0; x < 3; x++) {
		for(int y = 0; y < 2; y++) {
		if(x==1) break;
		if(x==2 && y==1) break z;
		o = o + x + y;
		}
		}
		System.out.println(o);
	}

	static void test() throws RuntimeException {
		try {
		System.out.print("test ");
		throw new RuntimeException();
		}
		catch (Exception ex) { System.out.print("exception "); }
	}

//	public static int sum(List list) {
//		int sum = 0;
//		for ( Iterator iter = list.iterator(); iter.hasNext(); ) {
//			int i = ((Integer)iter.next()).intValue();
//			sum += i;
//		}
//		return sum;
//	}
	
	public static int sum2(List<Integer> list) {
		int sum = 0;
		//for ( Iterator iter = list.iterator(); iter.hasNext(); ) {
		for ( int i : list) {
			//int i = ((Integer)iter.next()).intValue();
			sum += i;
		}
		return sum;
	}

	
	public static void main(String... args) {
		//-------------------
		go();
		//-------------------
		try { test(); }
		catch (RuntimeException ex) { System.out.print("runtime "); }
		System.out.println("end ");
		//-------------------
		Foo f = new Bar();
		f.addFive();
		System.out.println(f.a);
		//-------------------
		Float pi = new Float(3.14f);
		if (pi > 3) {
			System.out.print("pi is bigger than 3. ");
		}
		else {
			System.out.print("pi is not bigger than 3. ");
		}
		//-------------------
		class Boxer1{
			Integer i;
			int x;
			
			public Boxer1(int y) {
				x = i + y;
				System.out.println(x);
			}
		}
		new Boxer1(new Integer(4));
		//-------------------

	}
}
