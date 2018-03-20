package vce.vce;

import static vce.ext.ExtTest045.testExtTest045;
import java.io.*;
import java.text.*;
import java.util.*;

//--------------------------------------------------------
//test 001
class Test001 implements Runnable {

	public void run() {
		System.out.println("run.");
		throw new RuntimeException("Problem");
	}

	public static void test() {
		System.out.println("Test 001.");
		Thread t = new Thread(new Test001());
		t.start();
		System.out.println("End of method.");
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// --------------------------------------------------------
// test 003
class Test003 {

	void waitForSignal() {
		Object obj = new Object();
		synchronized (Thread.currentThread()) {
			// obj.wait(); // need try/catch : This code can throw an
			// IllegalMonitorStateException.
			obj.notify();
		}
	}
}

// --------------------------------------------------------
// test 004
class Test004 implements Runnable {
	static class PingPong2 {
		synchronized void hit(long n) {
			for (int i = 1; i < 3; i++)
				System.out.print(n + "-" + i + " ");
		}
	}

	static PingPong2 pp2 = new PingPong2();

	@Override
	public void run() {
		pp2.hit(Thread.currentThread().getId());
	}

	public static void test() {
		new Thread(new Test004()).start();
		new Thread(new Test004()).start();
	}
}

// --------------------------------------------------------
// test 005
// What is the result?
class Test005 {
	public static void test() {
		new Test005().go();
	}

	public void go() {
		Runnable r = new Runnable() {
			public void run() {
				System.out.print("foo");
			}
		};
		Thread t = new Thread(r);
		t.start();
		t.start();
	}
}

// --------------------------------------------------------
// test 006
class Test006 {
	static abstract class Shape {
		private int x;
		private int y;

		public abstract void draw();

		public void setAnchor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	// Which two classes use the Shape class correctly? (Choose two.) :

	// class Circle implements Shape { private int radius; }
	// abstract class Circle extends Shape { private int radius; }
	// class Circle extends Shape { private int radius; public void draw(); }
	// abstract class Circle implements Shape { private int radius; public void
	// draw();}
	// class Circle extends Shape { private int radius; public void draw() {/* code
	// here */}}
	// abstract class Circle implements Shape { private int radius; public void
	// draw() { /* code here */ } }

	public static void test() {
	}
}

// --------------------------------------------------------
// test 007
class Test007 {
	public static void test() {
		// new Test007().go("hi", 1);
		// new Test007().go("hi", "world", 2);
	}

	// public void go(String... y, int x) {
	// System.out.print(y[y.length - 1] + " ");
	// }
}

// --------------------------------------------------------
// test 008
class Test008 {
	static enum Direction {
		NORTH, SOUTH, EAST, WEST
	};

	static class Sprite {
		// Direction d = NORTH;
		// Nav.Direction d = NORTH;
		Direction d = Direction.NORTH;
		// Nav.Direction d = Nav.Direction.NORTH;
	}

	public static void test() {
	}
}

// --------------------------------------------------------
// test 009
class Test009 {
	static enum MyColor {
		RED(0xff0000), GREEN(0x00ff00), BLUE(0x0000ff);

		private final int rgb;

		MyColor(int rgb) {
			this.rgb = rgb;
		}

		public int getRGB() {
			return rgb;
		}
	};

	public static void test() {
		// Which code fragment, allows the Rainbow class to compile?
		// MyColor skyColor = BLUE;
		// MyColor treeColor = MyColor.GREEN;
		// if(RED.getRGB() < BLUE.getRGB()) { }
		// Compilation fails due to other error(s) in the code.
		// MyColor purple = new MyColor(0xff00ff);
		// MyColor purple = MyColor.BLUE + MyColor.RED;
	}
}

// --------------------------------------------------------
// test 011
class Test011 {
	static class Atom {
		Atom() {
			System.out.print("atom ");
		}
	}

	static class Rock extends Atom {
		Rock(String type) {
			System.out.print(type);
		}
	}

	static class Mountain extends Rock {
		Mountain() {
			super("granite ");
			new Rock("granite ");
		}

		public static void test() {
			new Mountain();
		}
	}
}

// --------------------------------------------------------
// test 012
// What is the result?
class Test012 {
	interface TestA {
		String toString();
	}

	public static void test() {
		System.out.println(new TestA() {
			public String toString() {
				return "test";
			}
		});
	}
}

// --------------------------------------------------------
// test 013
// What is the result?
class Test013 {
//	public static void parse(String str) {
//		try {
//			float f = Float.parseFloat(str);
//		} catch (NumberFormatException nfe) {
//			f = 0;                 // compilation problem : f is not availible
//		} finally {
//			System.out.println(f); // compilation problem : f is not availible
//		}
//	}
	public static void parse(String str) {
		float f = 0f;
		try {
			f = Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			f = 0;
		} finally {
			System.out.println(f);   // if error resolved that 0.0 
		}
	}
	public static void test() {
		parse("invalid");
	}
}

// --------------------------------------------------------
// test 014
class Test014 {
	static class Blip {
		protected int blipvert(int x) {
			return 0;
		}
	}

	static class Vert extends Blip {
		// Which five methods, inserted independently at line 5, will compile? (Choose
		// five.)
		// public int blipvert(int x) { return 0; }
		// private int blipvert(int x) { return 0; }
		// private int blipvert(long x) { return 0; }
		// protected long blipvert(int x) { return 0; }
		// protected int blipvert(long x) { return 0; }
		// protected long blipvert(long x) { return 0; }
		// protected long blipvert(int x, int y) { return 0; }
	}

	public static void test() {
	}
}

// --------------------------------------------------------
// test 016
class Test016 {
	static class Super {
		private int a;

		protected Super(int a) {
			this.a = a;
		}
	}

	static class Sub extends Super {
		public Sub(int a) {
			super(a);
		}
		// public Sub() {
		// this.a = 5;
		// }
	}

	public static void test() {
	}
}
// Which two, independently, will allow Sub to compile? (Choose two.)

// --------------------------------------------------------
// test 018
// What is the result?
class Test018 {
	static abstract class Vehicle {
		public int speed() {
			return 0;
		}
	}

	static class Car extends Vehicle {
		public int speed() {
			return 60;
		}
	}

	static class RaceCar extends Car {
		public int speed() {
			return 150;
		}
	}

	public static void test() {
		RaceCar racer = new RaceCar();
		Car car = new RaceCar();
		Vehicle vehicle = new RaceCar();
		System.out.println(racer.speed() + ", " + car.speed() + ", " + vehicle.speed());
	}
}

// --------------------------------------------------------
// test 019
class Test019 {
	static class Building {
	}

	static class Barn extends Building {
	}

	public static void test() {
		Building build1 = new Building();
		// Which is true?
		Barn barn1 = new Barn();
		Barn barn2 = (Barn) build1;
		Object obj1 = (Object) build1;
//		String str1 = (String) build1;
		Building build2 = (Building) barn1;
	}
}

// --------------------------------------------------------
// test 021
// What is the result?
class Test021 {
	static class Money {
		private String country = "Canada";

		public String getC() {
			return country;
		}
	}
	static class Yen extends Money {
		public String getC() {
			return super.country;
		}
	}
	static class Euro extends Money {
		public String getC(int x) {
			return super.getC();
		}
	}
	public static void test() {
		System.out.print(new Yen().getC() + " " + new Euro().getC());
	}
}

// --------------------------------------------------------
// test 022
// What is the result?
class Test022 {
	static class Food implements Serializable {
		int good = 3;
	}
	static class Fruit extends Food {
		int juice = 5;
	}
	static class Banana extends Fruit {
		int yellow = 4;
		// more Banana methods go here
		public Banana serializeBanana(Banana b) {
			return b;
		}
		public Banana deserializeBanana() {
			return this;
		}
	}

	public static void test() {
		Banana b = new Banana();
		Banana b2 = new Banana();
		b.serializeBanana(b);       // assume correct serialization
		b2 = b.deserializeBanana(); // assume correct
		System.out.println("restore " + b2.yellow + b2.juice + b2.good);
	}
}

// --------------------------------------------------------
// test 023
class Test023 {
	public static void test() {
		// Given a valid DateFormat object named df, and
		DateFormat df = DateFormat.getInstance();
		Date d = new Date(0L);
		String ds = "December 15, 2004";
		// insert code here
		// What updates d's value with the date represented by ds?
		// d = df.parse(ds);
		// d = df.getDate(ds);
		try {
			d = df.parse(ds);
		} catch (ParseException e) {
		}
		;
		// try { d = df.getDate(ds); } catch(ParseException e) { };
	}
}

// --------------------------------------------------------
// test 024
class Test024 {
	public static void test() {
		double input = 314159.26;
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
		String b;
		// Which code, sets the value of b to 314.159,26?
		// b = nf.parse( input );
		// b = nf.parse( input );
		// b = nf.equals( input );
		// b = nf.parseObject( input );
	}
}

// --------------------------------------------------------
// test 025
// What is the output?
class Test025 {
	public static void test() {
		String str = "420";
		str += 42;
		System.out.print(str);
	}
}

// --------------------------------------------------------
// test 027
class Test1XX {
	public static void test() {
		File dir = new File("dir");
		dir.mkdir();
		File f1 = new File(dir, "f1.txt");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			;
		}
		File newDir = new File("newDir");
		dir.renameTo(newDir);
	}
}

// --------------------------------------------------------
// test 028
class Test028 {
	public static void test() {
		StringBuilder sb1 = new StringBuilder("123");
		String s1 = "123";
		// insert code here
		System.out.println(sb1 + " " + s1);
		// Which code fragment, outputs "123abc 123abc"?
		// sb1.append("abc"); s1.append("abc");
		// sb1.append("abc"); s1.concat("abc");
		// sb1.concat("abc"); s1.append("abc");
		// sb1.concat("abc"); s1.concat("abc");
		// sb1.append("abc"); s1 = s1.concat("abc");
		// sb1.concat("abc"); s1 = s1.concat("abc");
		// sb1.append("abc"); s1 = s1 + s1.concat("abc");
		// sb1.concat("abc"); s1 = s1 + s1.concat("abc");
	}
}

// --------------------------------------------------------
// test 030
// What is the result?
class Test030 {
	public static void test() {
		int x = 5;
		boolean b1 = true;
		boolean b2 = false;

		if ((x == 4) && !b2)
			System.out.print("1 ");
		System.out.print("2 ");
		if ((b2 = true) && b1)
			System.out.print("3 ");
	}
}

// --------------------------------------------------------
// test 031
class Test031 {
	static interface Foo {
	}

	static class Alpha implements Foo {
	}

	static class Beta extends Alpha {
	}

	static class Delta extends Beta {
	}

	public static void test() {
		Beta x = new Beta();
		// Which code, will cause a java.lang.ClassCastException?
		// Alpha a = x;
		// Foo f = (Delta)x;
		// Foo f = (Alpha)x;
		// Beta b = (Beta)(Alpha)x;
	}
}

// --------------------------------------------------------
// test 032
class Test032 {
	public void go() {
		String o = "";
		z: for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 2; y++) {
				if (x == 1)
					break;
				if (x == 2 && y == 1)
					break z;
				o = o + x + y;
			}
		}
		System.out.println(o);
	}

	public static void test() {
		new Test032().go();
	}
}

// --------------------------------------------------------
// test 033
// What is the result?
class Test033 {
	static void test033() throws RuntimeException {
		try {
			System.out.print("test ");
			throw new RuntimeException();
		} catch (Exception ex) {
			System.out.print("exception ");
		}
	}

	public static void test() {
		try {
			test033();
		} catch (RuntimeException ex) {
			System.out.print("runtime ");
		}
		System.out.print("end ");
	}
}

// --------------------------------------------------------
// test 034
class Test034 {
	public static void test() {
		// If some sort of exception is thrown, which output is possible?
		try {
			// some code here
		} catch (NullPointerException e1) {
			System.out.print("a");
		} catch (Exception e2) {
			System.out.print("b");
		} finally {
			System.out.print("c");
		}
	}
}

// --------------------------------------------------------
// test 035
class Test035 {
	static class SomeException extends Exception {
	}

	public static void test() {
		// some code here
		try {
			// some code here
			// } catch (SomeException se) {
			// //some code here
		} finally {
			// some code here
		}
	}
}

//--------------------------------------------------------
//test 036
//What is the result?
class Test036 {
	public static void test() {
		int x = 0;
		int y = 10;
		do {
			y--;
			++x;
		} while (x < 5);
		System.out.print(x + "," + y);
	}
}

//--------------------------------------------------------
//test 0368
//What is the result?
class Test038 {
	public static void test() {
		Float pi = new Float(3.14f);
		if (pi > 3) {
			System.out.print("pi is bigger than 3. ");
		} else {
			System.out.print("pi is not bigger than 3. ");
		}
		// finally {
		// System.out.println("Have a nice day.");
		// }
	}
}

// --------------------------------------------------------
// test 039
class Test039 {
	Integer i;
	int x;

	public Test039(int y) {
		x = i + y; // A NullPointerException occurs at runtime. (Integer i = null)
		System.out.println(x);
	}

	public static void test() {
		new Test039(new Integer(4));
	}
}

// --------------------------------------------------------
// test 040
class Test040 {
	private String name;

	public Test040(String name) {
		this.name = name;
	}

	// !!!! overload : will be not used in sort methods
	public boolean equals(Test040 p) {
		return p.name.equals(this.name);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}

// --------------------------------------------------------
// test 042
class Test042 implements Comparable<Test042> {
	private int wins, losses;

	public Test042(int w, int l) {
		wins = w;
		losses = l;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public String toString() {
		return "<" + wins + "," + losses + ">";
	}

	// insert code here : because generic implementation Comparable<Score> -> typ is
	// explicit defined
	public int compareTo(Test042 other) {
		/* more code here */ return 0;
	}
}

// --------------------------------------------------------
// test 043
// test 068
class Test043 {
	// public static int sum(List list) {
	public static int sum(List<Integer> intList) {
		int sum = 0;
		// for ( Iterator iter = list.iterator(); iter.hasNext(); ) {
		for (int i : intList) {
			// int i = ((Integer)iter.next()).intValue();
			sum += i;
		}
		return sum;
	}
	// What three changes allow the class to be used with generics and avoid an
	// unchecked warning? (Choose three.)
	// Replace the method declaration with "sum(List<Integer> intList)"
	// Replace line 13 with "for (int i : intList) {"
	// Remove line 14.
}

// --------------------------------------------------------
// test 044
class Test044 {
	// public static int sum(List list) {
	public static void test() {
		Object[] myObjects = { new Integer(12), new String("foo"), new Integer(5), new Boolean(true) };

		//Arrays.sort(myObjects);
		// Exception in thread "main" java.lang.ClassCastException: java.lang.Integer
		// cannot be cast to java.lang.String
		// at java.lang.String.compareTo(Unknown Source)
		// at java.util.ComparableTimSort.countRunAndMakeAscending(Unknown Source)
		// at java.util.ComparableTimSort.sort(Unknown Source)
		// at java.util.Arrays.sort(Unknown Source) // static void sort(Object[] a)
		// at vce.Test044.test(Testing.java:131)
		// at vce.Testing.main(Testing.java:196)

		// in other case: 12 foo 5 true 
		for (int i = 0; i < myObjects.length; i++) {
			System.out.print(myObjects[i].toString());
			System.out.print(" ");
		}
	}
}

// --------------------------------------------------------
// test 045
class Test045 {
	public static void test() {
		System.out.println(testExtTest045());
	}
}

public class Testing_001_049 {
	public static void main(String... args) {
		// Test001.test(); System.out.println();
		// Test002.test(); System.out.println();
		// Test003.test(); System.out.println();
		// Test004.test(); System.out.println();
		// Test005.test();	System.out.println();
		// Test006.test(); System.out.println();
		// Test007.test(); System.out.println();
		// Test008.test(); System.out.println();
		// Test009.test(); System.out.println();
		// Test010.test(); System.out.println();
		// Test011.test(); System.out.println();
		// Test012.test(); System.out.println();
		// Test013.test(); System.out.println();
		// Test014.test(); System.out.println();
		// Test015.test(); System.out.println();
		// Test016.test(); System.out.println();
		// Test017.test(); System.out.println();
		// Test018.test(); System.out.println();
		// Test019.test(); System.out.println();
		// Test020.test(); System.out.println();
		// Test021.test(); System.out.println();
		// Test022.test(); System.out.println();
		// Test023.test(); System.out.println();
		// Test024.test(); System.out.println();
		// Test025.test(); System.out.println();
		// Test026.test(); System.out.println();
		// Test027.test(); System.out.println();
		// Test028.test(); System.out.println();
		// Test029.test(); System.out.println();
		// Test030.test(); System.out.println();
		// Test031.test(); System.out.println();
		// Test032.test(); System.out.println();
		// Test033.test(); System.out.println();
		// Test034.test(); System.out.println();
		// Test035.test(); System.out.println();
		// Test036.test(); System.out.println();
		// Test037.test(); System.out.println();
		// Test038.test(); System.out.println();
		// Test039.test(); System.out.println();
		// Test040.test(); System.out.println();
		// Test041.test(); System.out.println();
		// Test042.test(); System.out.println();
		// Test043.test(); System.out.println();
		 Test044.test(); System.out.println();
		// Test045.test(); System.out.println();
		// Test046.test(); System.out.println();
		// Test047.test(); System.out.println();
		// Test048.test(); System.out.println();
		// Test049.test(); System.out.println();
	}
}
