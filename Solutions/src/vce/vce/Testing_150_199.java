package vce.vce;

import java.io.*;
import java.text.*;
import java.util.*;

//--------------------------------------------------------
//test 150
class Test150 {
	public static void test() {
		// Which code, inserted here, guarantees that this program will output [1, 2]?
		Set set = new TreeSet();              // [1, 2]
		//Set set = new HashSet();              // [1, 2]
		//Set set = new SortedSet();            // SortedSet is abstract
		//List set = new SortedList();          // SortedList is not defined
		//Set set = new LinkedHashSet();        // [2, 1]
		set.add(new Integer(2));
		set.add(new Integer(1));
		System.out.println(set);
	}
}

//--------------------------------------------------------
//test 1XX
class Test151 {
	static class A {
		void foo() throws Exception {
			throw new Exception();
		}
	}
	static class SubB2 extends A {
		void foo() {
			System.out.println("B ");
		}
	}
	public static void test() {
		A a = new SubB2();
		try {
			a.foo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//--------------------------------------------------------
//test 1XX
class Test152 {
	public static void test() {
	}
}

class Test153 {
	public static void test() {
	}
}

class Test154 {
	public void go(int x) {
		assert (x > 0);
		switch (x) {
			case 2:
				break;
			default:
				assert false;
		}
	}
	private void go2(int x) {
		assert (x < 0);
	}

	public static void test() {
	}
}

class Test155 {
	public static void test() {
	}
}

class Test156 {
	public static void test() {
	}
}

class Test157 {
	public static void test() {
	}
}

class Test158 {
	public static void test() {
	}
}

class Test159 {
	public static void test() {
	}
}

class Test160 {
	public static void test() {
	}
}

class Test161 {
	public static void test() {
	}
}

class Test162 {
	Test162 t;

	public static void test() {
		Test162 t = new Test162();
		Test162 t2 = t.go(t);
		t2 = null;
		// more code here
	}

	Test162 go(Test162 t) {
		Test162 t1 = new Test162();
		Test162 t2 = new Test162();
		t1.t = t2;
		t2.t = t1;
		t.t = t2;
		return t1;
	}
}

class Test163 {
	public static void test() {
	}
}

class Test164 {
	static class ProppertiesViewer {
		Properties props = System.getProperties();
		public void show() {
			Set<Object> allKeys = props.keySet();
			for(Object k : allKeys) {
				Object value = props.get(k);
				System.out.printf("%s = %s %n", k, value);
			}
		}
	}
	
	
	public static void test() {
		new ProppertiesViewer().show();
		String myProp = /* insert code here */
			//System.load("prop.custom");
			//System.getenv("prop.custom");
			//System.property("prop.custom");
			System.getProperty("prop.custom");
			//System.getProperties().getProperty("prop.custom");
		System.out.println(myProp);
		
	}
}

class Test165 {
	public static void test() {
	}
}

class Test166 {
	public static void test() {
	}
}

class Test167 {
	public static void test() {
	}
}

class Test168 {
	public static void test() {
	}
}

class Test169 {
	interface Fish { }
	static class Perch implements Fish { }
	static class Walleye extends Perch { }
	static class Bluegill { }

	public static void test() {
		Fish f = new Walleye();
		Walleye w = new Walleye();
		Bluegill b = new Bluegill();
		if(f instanceof Perch) System.out.print("f-p ");
		if(w instanceof Fish)  System.out.print("w-f ");
		if(b instanceof Fish)  System.out.print("b-f ");
	}
}

class Test170 {
	public static void test() {
	}
}

class Test171 {
	public static void test() {
	}
}

class Test172 {
	public static void test() {
	}
}

class Test173 {
	public static void test() {
	}
}

class Test174 {
	public static void test() {
		String csv = "Sue,5,true,3";
		Scanner scanner = new Scanner( csv );
		scanner.useDelimiter(",");
		int age = scanner.nextInt();    // throws java.util.InputMismatchException
	}
}

class Test175 {
	public static void test() {
		// create console
		Console c = System.console();
		// Available functions : readLine(), readLine(String, String), readPassword(), readPassword(String, String)
		//String s = c.readLine();
		//char[] c = c.readLine();
		//String s = c.readConsole();
		//char[] c = c.readConsole();
		//String s = c.readLine("%s", "name ");
		//char[] c = c.readLine("%s", "name ")
		//char[] ch = c.readLine("%s", "name ").toCharArray();
	}
}

class Test176 {
	public static void test() {
		String test = "a1b2c3";
		String[] tokens = test.split("\\d");
		for(String s: tokens) 
			System.out.print(s + " "); 
	}
}

/**
 * 
 * DateFormat.getDateInstance()
 * DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
 * 
 *   SHORT is completely numeric, such as 12.13.52 or 3:30pm
 *   MEDIUM is longer, such as Jan 12, 1952
 *   LONG is longer, such as January 12, 1952 or 3:30:32pm
 *   FULL is pretty completely specified, such as Tuesday, April 12, 1952 AD or 3:30:42pm PST. 
 */
class Test177 {
	public static void test() {
		Date d = new Date(0);
		String ds = "December 15, 2004";
		// insert code here
//		DateFormat df = DateFormat.getDateFormat();
		DateFormat df = DateFormat.getDateInstance();
//		DateFormat df = DateFormat.getDateFormat();
//		DateFormat df = DateFormat.getDateInstance();
		try {
			d = df.parse(ds);
		} catch (ParseException e) {
			System.out.println("Unable to parse " + ds);
		}
		// insert code here too
//		d.setTime((60 * 60 * 24) + d.getTime());
		d.setTime((1000 * 60 * 60 * 24) + d.getTime());
//		d.setLocalTime((1000 * 60 * 60 * 24) + d.getLocalTime());
//		d.setLocalTime((60 * 60 * 24) + d.getLocalTime());
	}
}

class Test178 {
	public static void test() {
		Integer x = 400;
		Integer y = x;
		x++;
		
		StringBuilder sb1 = new StringBuilder("123");
		StringBuilder sb2 = sb1;
		sb1.append("5");
		
		String s1 = "ab";
		String s2 = s1;
		s2 += "c";
		System.out.println((x==y) + " " + (sb1==sb2) + " " + (s1==s2));
	}
}

class Test179 {
	public static void test() {
		// java.lang.NumberFormatException or
		//Integer i = Integer.valueOf("12?");
		// Compiler error
		//Integer i = new String("12");
		// java.lang.NullPointerException at vce.vce.Test179.test(Testing_150_199.java:309)
		Integer i = Integer.getInteger("12?");
		int j = 12;
		System.out.println("It is " + (j==i) + " that j==i.");
	}
}

class Test180 {
	public static void test() {
	}
}

class Test181 {
	static final int[] a = { 100,200 };

	static final int[] b; static { b=new int[2]; b[0]=100; b[1]=200; }
	
	//static final int[] c = new int[2]{ 100,200 };
	static final int[] c1 = new int[2];
	static final int[] c2 = new int[]{ 100,200 };
	
	//static final int[] d;  static void init() { d = new int[2]; d[0]=100; d[1]=200; }

	public static void test() {
	}
}

class Test182 {
	public static void test() {
	}
}

class Test183 {
	public static void test() {
	}
}

class Test184 {
	public static void test() {
	}
}

class Test185 {
	public static void test() {
	}
}

class Test186 {
	public static void test() {
	}
}

class Test187 {
	interface Foo { int bar(); }
	
	class A implements Foo {
		@Override
		public int bar() {
			return 1;
		}
	}

	public int fubar(Foo foo) { 
		return foo.bar();
	}

	public void testFoo() {
		class A implements Foo {
			@Override
			public int bar() {
				return 2;
			}
		}
		System.out.println(fubar(new A()));
	}

	public static void test() {
		new Test187().testFoo();
	}
}

class Test188 {
	public static void test() {
	}
}

class Test189 {
	public void go() {
		Runnable r = new Runnable() {
			public void run() {
				System.out.print("foo");
			}
		};
		Thread t = new Thread(r);
		t.start();
		t.start();    // java.lang.IllegalThreadStateException
	}
	public static void test() {
		new Test189().go();
	}
}

class Test190 {
	public static void test() {
	}
}

class Test191 {
	static class Threads3 implements Runnable {
		public void run() {
			System.out.print("running");
		}
	}

	public static void test() {
		Thread t = new Thread(new Threads3());
		t.run();
		t.run();
		t.start();
	}
}

class Test192 {
	public static void test() {
	}
}

class Test193 implements Runnable {

	void go() throws Exception {
		Thread t = new Thread(new Test193());
		t.start();
		for (int x = 1; x < 100000; x++) {
			// insert code here
//			Thread.wait();
//			Thread.join();
//			Thread.yield();
//			Thread.sleep(1);
//			Thread.notify();
			if (x % 100 == 0)
				System.out.print("g");
		}
	}
	public void run() {
		try {
			for (int x = 1; x < 100000; x++) {
				// insert the same code here
//				Thread.wait();
//				Thread.join(); //Thread.currentThread().join();
//				Thread.yield();
//				Thread.sleep(1);
//				Thread.notify();
				if (x % 100 == 0)
					System.out.print("t");
			}
		} catch (Exception e) {
		}
	}
	public static void test() {
		try {
			new Test193().go();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Test194 {
	public static void test() {
	}
}

class Test195 {
	public static void test() {
	}
}

class Test196 {
	public static void test() {
	}
}

class Test197 {
	public static void test() {
	}
}

class Test198 {
	public static void test() {
	}
}

class Test199 {
	public static void test() {
	}
}

public class Testing_150_199 {
	public static void main(String[] args) {
//		Test150.test();  System.out.println();
//		Test151.test();  System.out.println();
//		Test152.test();  System.out.println();
//		Test153.test();  System.out.println();
//		Test154.test();  System.out.println();
//		Test155.test();  System.out.println();
//		Test156.test();  System.out.println();
//		Test157.test();  System.out.println();
//		Test158.test();  System.out.println();
//		Test159.test();  System.out.println();
//		Test160.test();  System.out.println();
//		Test161.test();  System.out.println();
//		Test162.test();  System.out.println();
//		Test163.test();  System.out.println();
//		Test164.test();  System.out.println();
//		Test165.test();  System.out.println();
//		Test166.test();  System.out.println();
//		Test167.test();  System.out.println();
//		Test168.test();  System.out.println();
//		Test169.test();  System.out.println();
//		Test170.test();  System.out.println();
//		Test171.test();  System.out.println();
//		Test172.test();  System.out.println();
//		Test173.test();  System.out.println();
//		Test174.test();  System.out.println();
//		Test175.test();  System.out.println();
//		Test176.test();  System.out.println();
//		Test177.test();  System.out.println();
//		Test178.test();  System.out.println();
//		Test179.test();  System.out.println();
//		Test180.test();  System.out.println();
//		Test181.test();  System.out.println();
//		Test182.test();  System.out.println();
//		Test183.test();  System.out.println();
//		Test184.test();  System.out.println();
//		Test185.test();  System.out.println();
//		Test186.test();  System.out.println();
//		Test187.test();  System.out.println();
//		Test188.test();  System.out.println();
//		Test189.test();  System.out.println();
//		Test190.test();  System.out.println();
//		Test191.test();  System.out.println();
//		Test192.test();  System.out.println();
		Test193.test();  System.out.println();
//		Test194.test();  System.out.println();
//		Test195.test();  System.out.println();
//		Test196.test();  System.out.println();
//		Test197.test();  System.out.println();
//		Test198.test();  System.out.println();
//		Test199.test();  System.out.println();
	}
}
