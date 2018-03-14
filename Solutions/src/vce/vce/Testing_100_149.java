package vce.vce;

import java.io.*;
import java.util.*;

//--------------------------------------------------------
//test 102
// And the command-line invocations:
// javac Pass2.java    (
// java Pass2 5
// What is the result?  // Exception, no STATIC main function
class Test102 {
	public static void test() {
		int x = 6;
		Test102 p = new Test102();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}
	void doStuff(int x) {
		System.out.print(" doStuff x = " + x++);
	}
}

//--------------------------------------------------------
//test 103
class Test103 {
	public enum Dogs {collie, harrier};

	public static void test() {
		Dogs myDog = Dogs.collie;
		switch (myDog) {
			case collie:
				System.out.print("collie ");
			case harrier:
				System.out.print("harrier ");
		}
	}
}

//--------------------------------------------------------
//test 104
class Test104 {
	public static void test() {
		boolean assertsOn = false;
		assert (assertsOn) : assertsOn = true;
		if(assertsOn) {
			System.out.println("assert is on");
		}
	}
}

//--------------------------------------------------------
//test 105
class Test105 {
	public static void test105() {
		try {
			String x = null;
			System.out.print(x.toString() + " ");
		}
		finally { 
			System.out.print("finally ");
		}
	}
	public static void test() {
		try { 
			test105();
		}
		catch (Exception ex) { 
			System.out.print("exception ");
		}
	}
}

//--------------------------------------------------------
//test 106
class Test106 {
	public static void test106()  throws Error {
		if (true) 
			throw new AssertionError();
		System.out.print("test ");
	}
	public static void test() {
		try { test106(); }
		catch (Exception ex) { System.out.print("exception "); }
		System.out.print("end ");
	}
}

//--------------------------------------------------------
//test 107
class Test107 {
	static class TestException extends Exception { }
	static class A {
		public String sayHello(String name) throws TestException {
			if(name == null) throw new TestException();
			return "Hello " + name;
		}
	}
	public static void test() {
		try {
			new A().sayHello("Aiko");
		} catch (TestException e) {
			e.printStackTrace();
		}
	}
}
//--------------------------------------------------------
//test 108
class Test108 {
	public static Collection get() {
		Collection sorted = new LinkedList();
		sorted.add("B"); sorted.add("C"); sorted.add("A");
		return sorted;
	}
	public static void test() {
		for (Object obj: get()) {
			System.out.print(obj + ", ");
		}
	}
}

//--------------------------------------------------------
//test 109
class Test109 {
	static class A {
		void process() throws Exception { throw new Exception(); }
	}
	static class B extends A {
		void process() { System.out.println("B"); }
	}
	public static void test() {
		new B().process();
	}
}

//--------------------------------------------------------
//test 110
class Test110 {
	static int[] a;
	static { a[0]=2; }
	
	public static void test() {
	}
}

//--------------------------------------------------------
//test 111
class Test111 {
	public static void test() {
		Integer i = new Integer(1) + new Integer(2);
		switch(i) {
			case 3: System.out.println("three"); break;
			default: System.out.println("other"); break;
		}
	}
}

//--------------------------------------------------------
//test 112
class Test112 {
	public static Iterator reverse(List list) {
		Collections.reverse(list);
		return list.iterator();
	}

	public static void test() {
		List list = new ArrayList();
		list.add("1"); list.add("2"); list.add("3");
//		for (Object obj: reverse(list))
//			System.out.print(obj + ", ");
	}
}

//--------------------------------------------------------
//test 113
class Test113 {
	public static void test() {
		// insert code here
//		String s = "123456789"; s = (s-"123").replace(1,3,"24") - "89";
		StringBuffer  s1 = new StringBuffer("123456789");  s1.delete(0,3).replace(1,3,"24").delete(4,6);
//		StringBuffer  s1 = new StringBuffer("123456789");  
//		s1.delete (0,3);        // 456789
//		s1.replace(1,3,"24");   // 424789789
//		s1.delete (4,6);        // 4247
		System.out.println("s1 = " + s1);
//		StringBuffer  s2 = new StringBuffer("123456789");  s2.substring(3,6).delete(1,3).insert(1, "24");
//		System.out.println("s2 = " + s2);
//		StringBuilder s3 = new StringBuilder("123456789"); s3.substring(3,6).delete(1,2).insert(1, "24");
//		System.out.println("s3 = " + s3);
		StringBuilder s4 = new StringBuilder("123456789"); s4.delete(0,3).delete(1,3).delete(2,5).insert(1, "24");
		System.out.println("s4 = " + s4);
	}
}

//--------------------------------------------------------
//test 116
class Test116 {
	int go(Boolean b, int i) {
		if(b) 
			return (i/7);
		return (i/49);
	}
	public static void test() {
		Boolean test = new Boolean(true);
		Integer x = 343;
		Integer y = new Test116().go(test, x);
		System.out.println(y);
	}
}


//--------------------------------------------------------
//test 117
class Test117 {
	static class Tree { }

	public static void test() {
		Test117 f = new Test117();
		try {
			FileOutputStream fs = new FileOutputStream("Forest.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(f); os.close();
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}

class Test118 {
	public static void test() {
	}
}


//--------------------------------------------------------
//test 119
class Test119 {
	public static void test() {
//		Console c = new Console();
//		String pw;
//		System.out.print("password: ");
//		pw = c.readLine();
//		System.out.println("got " + pw);
	}
}

//--------------------------------------------------------
//test 120
class Test120 {
	public static void test() {
		double d = 12.345;
		// insert code here
		System.out.printf("|%7d| \n", d);
		System.out.printf("|%7f| \n", d);
		System.out.printf("|%3.7d| \n", d);
		System.out.printf("|%3.7f| \n", d);
		System.out.printf("|%7.3d| \n", d);
		System.out.printf("|%7.3f| \n", d);
	}
}

//--------------------------------------------------------
//test 121
class Test121 {
	public static void test() {
		String test = "Test A. Test B. Test C.";
		//Which regular expression, inserted here, correctly splits test into "Test A", "Test B", and "Test C"?
		//insert code here
//		String regex = "";
//		String regex = " ";
//		String regex = ".*";
//		String regex = "\\s";
//		String regex = "\\.\\s*";
//		String regex = "\\w[ \.] +";
//		String[] result = test.split(regex);
	}
}


//--------------------------------------------------------
//test 122
class Test122 {
	interface A {
		public void aMethod();
	}

	interface B {
		public void bMethod();
	}

	interface C extends A, B {
		public void cMethod();
	}
	static class D implements B {
		public void bMethod() {
		}
	} 
	static class E extends D implements C {
		public void aMethod() {
		}
		public void bMethod() {
		}
		public void cMethod() {
		}
	}
	public static void test() {
	}
}

//--------------------------------------------------------
//test 123
class Test123 {
	public static final String FOO = "foo";
	public static void test() {
		Test123 b = new Test123();
		SubTest123 s = new SubTest123();
		System.out.print(Test123.FOO);
		System.out.print(SubTest123.FOO);
		System.out.print(b.FOO);
		System.out.print(s.FOO);
		System.out.print(((Test123)s).FOO);
	}
}
class SubTest123 extends Test123 {
	public static final String FOO = "bar";
} 

//--------------------------------------------------------
//test 124
class Test124 {
	static class Mammal {
	}
	static class Raccoon extends Mammal {
		Mammal m = new Mammal();
	}
	static class BabyRaccoon extends Mammal {
	}

	public static void test() {
	}
}

//--------------------------------------------------------
//What is the result?
//test 125
class Test125 {
	interface A {
		void x();
	}
	static class B implements A {
		public void x() {
		}
		public void y() {
		}
	}
	static class C extends B {
		public void x() {
		}
	}
	public static void test() {
		java.util.List<A> list = new java.util.ArrayList<A>();
		list.add(new B());
		list.add(new C());
		for (A a : list) {
			a.x();
			//a.y();
		}
	}
}

//--------------------------------------------------------
//test 126
class Test126 {
	static class Hi {
		void m1() { }
		protected void m2() { }
	}
	static class Lois extends Hi {
		//Which four code fragments, inserted independently here, will compile? (Choose four.)
		//public void m1() { }
		//protected void m1() { }
		//private void m1() { }
		//void m2() { }
		//public void m2() { }
		//protected void m2() { }
		//private void m2() { }
	}
	public static void test() {
	}
}

class Test127 {
	public static void test() {
	}
}

//128
//--------------------------------------------------------
//test 128
//What is the result?
class Test128 {
	static class Hello {
		String title;
		int value;
		public Hello() {
			title += " World";
		}
		public Hello(int value) {
			this.value = value;
			title = "Hello";
//			Hello();
		}
	}
	public static void test() {
		Hello c = new Hello(5);
		System.out.println(c.title);
	}
}

//--------------------------------------------------------
//test 129
class Test129 {
	static class Hypotenuse {
		public InnerTriangle it = new InnerTriangle();

		static class InnerTriangle {
			public int base;
			public int height;
		}
	}
	public static void test() {
	}
}

//130
//--------------------------------------------------------
//test 130
class Test130 {
	interface Data { public void load(); }
	abstract class Info { public abstract void load(); }
	
	//Which class correctly uses the Data interface and Info class?
	//static class Employee extends Info implements Data { public void load() { /*do something*/ }}
	//static class Employee implements Info extends Data { public void load() { /*do something*/ }}
	//static class Employee extends Info implements Data { public void load() { /*do something*/ } public void Info.load(){ /*do something*/ } }
	//static class Employee implements Info extends Data { public void Data.load(){ /*do something*/ } public void load(){ /*do something*/ } }
	//static class Employee implements Info extends Data { public void load(){ /*do something*/ } public void Info.load(){ /*do something*/ } }
	//static class Employee extends Info implements Data{ public void Data.load() { /*do something*/ } public void Info.load() { /*do something*/ } }
	
	public static void test() {
	}
}

// --------------------------------------------------------
// test 131
// What is the result?
class Test131 {
	public static void test() {
		int []x[] = {{1,2}, {3,4,5}, {6,7,8,9}};
		int [][]y = x;
		System.out.println(y[2][1]);
	}
}

//--------------------------------------------------------
//test 132
//What is the result?
class Test132 {
	static abstract class C1 {
		public C1() {
			System.out.print(1);
		}
	}
	static class C2 extends C1 {
		public C2() {
			System.out.print(2);
		}
	}
	static class C3 extends C2 {
		public C3() {
			System.out.println(3);
		}
	}
	public static void test() {
		new C3();
	}
}

//--------------------------------------------------------
//test 133
class Test133 {
	class One {
		public One foo() {
			return this;
		}
	}
	class Two extends One {
		public One foo() {
			return this;
		}
	}
	class Three extends Two {
		// Which two methods, inserted individually, correctly complete the Three class? (Choose two.)
		// public void foo() {}
		// public int foo() { return 3; }
		// public Two foo() { return this; }
		//public One foo() { return this; }
		// public Object foo() { return this; }
	}
	public static void test() {
	}
}


//--------------------------------------------------------
//test 134
class Test134 {
	public static void test() {
	}
}

//--------------------------------------------------------
//test 135
// What is the result?
class Test135 {
	public interface A { public void m1(); }
	
	class C implements A { public void m1() { } }
	//class D implements A { public void m1(int x) { } }
	abstract class E implements A { }
	abstract class F implements A { public void m1() { } }
	abstract class G implements A { public void m1(int x) { } } 
	
	public static void test() {
	}
}

//--------------------------------------------------------
//test 135
class Test136 {
	static class Line {
		public class Point {
			public int x, y;
		}
		public Point getPoint() {
			return new Point();
		}
	}
	static class Triangle {
		public Triangle() {
			// Which code, inserted here, correctly retrieves a local instance of a Point object?
			// insert code here
		}
	}
	public static void test() {
	}
}

class Test137 {
	public static void test() {
	}
}

class Test138 {
	public static void test() {
	}
}

class Test139 {
	public static void test() {
	}
}

class Test140 {
	public static void test() {
	}
}

class Test141 {
	public static void test() {
	}
}

class Test142 {
	public static void test() {
	}
}

class Test143 {
	public static void test() {
	}
}

class Test144 {
	public static void test() {
	}
}

class Test145 {
	public static void test() {
	}
}

class Test146 {
	public static void test() {
	}
}

class Test147 {
	public static void test() {
	}
}

class Test148 {
	public static void test() {
	}
}

class Test149 {
	public static void test() {
	}
}

public class Testing_100_149 {
	public static void main(String[] args) {
//		Test100.test();  System.out.println();
//		Test101.test();  System.out.println();
//		Test102.test();  System.out.println();
//		Test103.test();  System.out.println();
//		Test104.test();  System.out.println();
//		Test105.test();  System.out.println();
//		Test106.test();  System.out.println();
//		Test107.test();  System.out.println();
//		Test108.test();  System.out.println();
//		Test109.test();  System.out.println();
//		Test110.test();  System.out.println();
//		Test111.test();  System.out.println();
//		Test112.test();  System.out.println();
//		Test113.test();  System.out.println();
//		Test114.test();  System.out.println();
//		Test115.test();  System.out.println();
//		Test116.test();  System.out.println();
//		Test117.test();  System.out.println();
//		Test118.test();  System.out.println();
//		Test119.test();  System.out.println();
//		Test120.test();  System.out.println();
//		Test121.test();  System.out.println();
//		Test122.test();  System.out.println();
//		Test123.test();  System.out.println();
//		Test124.test();  System.out.println();
//		Test125.test();  System.out.println();
//		Test126.test();  System.out.println();
//		Test127.test();  System.out.println();
//		Test128.test();  System.out.println();
//		Test129.test();  System.out.println();
//		Test130.test();  System.out.println();
//		Test131.test();  System.out.println();
//		Test132.test();  System.out.println();
//		Test133.test();  System.out.println();
//		Test134.test();  System.out.println();
//		Test135.test();  System.out.println();
//		Test136.test();  System.out.println();
//		Test137.test();  System.out.println();
//		Test138.test();  System.out.println();
//		Test139.test();  System.out.println();
//		Test140.test();  System.out.println();
//		Test141.test();  System.out.println();
//		Test142.test();  System.out.println();
//		Test143.test();  System.out.println();
//		Test144.test();  System.out.println();
//		Test145.test();  System.out.println();
//		Test146.test();  System.out.println();
//		Test147.test();  System.out.println();
//		Test148.test();  System.out.println();
//		Test149.test();  System.out.println();
	}
}
