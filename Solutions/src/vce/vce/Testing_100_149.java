package vce.vce;

import java.util.*;;



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

// --------------------------------------------------------
// test 1XX
class Test117 {
	public static void test() {
	}
}

class Test118 {
	public static void test() {
	}
}

class Test119 {
	public static void test() {
	}
}

class Test120 {
	public static void test() {
	}
}

class Test121 {
	public static void test() {
	}
}

class Test122 {
	public static void test() {
	}
}

class Test123 {
	public static void test() {
	}
}

class Test124 {
	public static void test() {
	}
}

class Test125 {
	public static void test() {
	}
}

class Test126 {
	public static void test() {
	}
}

class Test127 {
	public static void test() {
	}
}

class Test128 {
	public static void test() {
	}
}

class Test129 {
	public static void test() {
	}
}

class Test130 {
	public static void test() {
	}
}

class Test131 {
	public static void test() {
	}
}

class Test132 {
	public static void test() {
	}
}

class Test133 {
	public static void test() {
	}
}

class Test134 {
	public static void test() {
	}
}

class Test135 {
	public static void test() {
	}
}

class Test136 {
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
