package vce.vce;
import java.io.*;
import java.util.*;

//--------------------------------------------------------
//test 1XX
class Test200 {
	public static void test() {
	}
}

class Test201 {
	public static void test() {
	}
}

class Test202 {
	public static void test() {
	}
}

class Test203 {
	public static void test() {
	}
}

class Test204 {
	public static void test() {
	}
}

class Test205 {
	public static void test() {
	}
}

class Test206 {
	public static void test() {
	}
}

class Test207 {
	public static void test() {
	}
}

class Test208 {
	public static void test() {
	}
}

class Test209 {
	public static void test() {
	}
}

class Test210 {
	public static void test() {
	}
}

class Test211 {
	public static void test() {
	}
}

class Test212 {
	public static void test() {
	}
}

class Test213 {
	public static void test() {
	}
}

class Test214 {
	public static void test() {
		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for(int i = 606; i < 613; i++)
		if(i%2 == 0) s.add(i);
		subs = (TreeSet)s.subSet(608, true, 611, true);
		//subs.add(611); 
		subs.add(629);          // java.lang.IllegalArgumentException: key out of range
		System.out.println(s + " " + subs);
	}
}

class Test215 {
	public static void test() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("aAaA");
		strings.add("AaA");
		strings.add("aAa");
		strings.add("AAaa");
		Collections.sort(strings);
		for (String s : strings) { System.out.print(s + " "); }
	}
}

class Test216 {
	public static void test() {
	}
}

class Test217 {
	public static void test() {
	}
}

class Test218 {
	public static void test() {
	}
}

class Test219 {
	public static void test() {
	}
}

class Test220 {
	public enum Dogs {collie, harrier, shepherd};
	
	public static void test() {
		Dogs myDog = Dogs.shepherd;
		switch (myDog) {
			case collie:
				System.out.print("collie ");
			/* case */ default:
				System.out.print("retriever ");
			case harrier:
				System.out.print("harrier ");
		}
	}
}

class Test221 {
	public static void test() {
	}
}

class Test222 {
	public static void test() {
	}
}

class Test223 {
	public static void test() {
		String str = "null";
		if (str == null) {
			System.out.println("null");
		} else if (str.length() == 0) {   // missing if
		System.out.println("zero");
		} else {
		System.out.println("some");
		}
	}
}

class Test224 {
	public static void test() {
	}
}

class Test225 {
	class A {
		public void process() {
			System.out.print("A,");
		}
		public void processE()  throws IOException {
			System.out.print("Aext,");
		}
	}

	class B extends A {
		// not allowed additional exception
//		public void process() throws IOException {
//			super.process();
//			System.out.print("B,");
//			throw new IOException();
//		}
		// allowed without exception or using super class of Exception
		public void processE() /* throws Exception */ {
			System.out.print("Bext,");
		}
	}

	class c extends A {
		// not allowed
//		public void processE() throws Exception {
//			System.out.print("Cext,");
//		}
		// allowed
		public void processE() throws EOFException {
			System.out.print("Cext,");
		}
	}

		public static void test() {
	}
}

class Test226 {
	public static void test() {
	}
}

class Test227 {
	public static void test() {
	}
}

class Test228 {
	public static void test() {
	}
}

class Test229 {
	void doStuff(int x) {
		System.out.print(" doStuff x = " + x++);
	}
	
	public static void test() {
		int x = 6;
		Test229 p = new Test229();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}
}

class Test230 {
	interface DeclareStuff {
		public static final int EASY = 3;
		void doStuff(int t);
	}

	static class TestDeclare implements DeclareStuff {
		public void test() {
			int x = 5;
			new TestDeclare().doStuff(++x);
		}
		public void doStuff(int s) {
			s += EASY + ++s;
			System.out.println("s " + s);
		}
	}
	public static void test() {
		new TestDeclare().test();
	}
}

class Test231 {
	public static void test() {
	}
}

class Test232 {
	public static void test() {
	}
}

class Test233 {
	@FunctionalInterface
	interface DoStuff2 {
		float getRange(int low, int high);
	}

	@FunctionalInterface
	interface DoMore {
		float getAvg(int a, int b, int c);
	}

	abstract class DoAbstract implements DoStuff2, DoMore {
	}

	class DoStuff implements DoStuff2 {
		public float getRange(int x, int y) {
			return 3.14f;
		}
	}

	interface DoAll extends DoMore {
		float getAvg(int a, int b, int c, int d);
	}

	public static void test() {
	}
}

class Test234 {
	public static void test() {
	}
}

class Test235 {
	public static void test() {
	}
}

class Test236 {
	public static void test() {
	}
}

class Test237 {
	public static void test() {
	}
}

class Test238 {
	public static void test() {
	}
}

class Test239 {
	public static void test() {
	}
}

class Test240 {
	public static void test() {
	}
}

public class Testing_200_240 {
	public static void main(String[] args) {
//		Test200.test();  System.out.println();
//		Test201.test();  System.out.println();
//		Test202.test();  System.out.println();
//		Test203.test();  System.out.println();
//		Test204.test();  System.out.println();
//		Test205.test();  System.out.println();
//		Test206.test();  System.out.println();
//		Test207.test();  System.out.println();
//		Test208.test();  System.out.println();
//		Test209.test();  System.out.println();
//		Test210.test();  System.out.println();
//		Test211.test();  System.out.println();
//		Test212.test();  System.out.println();
//		Test213.test();  System.out.println();
//		Test214.test();  System.out.println();
//		Test215.test();  System.out.println();
//		Test216.test();  System.out.println();
//		Test217.test();  System.out.println();
//		Test218.test();  System.out.println();
//		Test219.test();  System.out.println();
//		Test220.test();  System.out.println();
//		Test221.test();  System.out.println();
//		Test222.test();  System.out.println();
//		Test223.test();  System.out.println();
//		Test224.test();  System.out.println();
//		Test225.test();  System.out.println();
//		Test226.test();  System.out.println();
//		Test227.test();  System.out.println();
//		Test228.test();  System.out.println();
//		Test229.test();  System.out.println();
		Test230.test();  System.out.println();
//		Test231.test();  System.out.println();
//		Test232.test();  System.out.println();
//		Test233.test();  System.out.println();
//		Test234.test();  System.out.println();
//		Test235.test();  System.out.println();
//		Test236.test();  System.out.println();
//		Test237.test();  System.out.println();
//		Test238.test();  System.out.println();
//		Test239.test();  System.out.println();
//		Test240.test();  System.out.println();
	}
}
