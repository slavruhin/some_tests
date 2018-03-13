package vce.vce;

import static vce.ext.ExtTest045.testExtTest045;

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
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}
}

//--------------------------------------------------------
//test 003
class Test003 {

	void waitForSignal() {
		Object obj = new Object();
		synchronized (Thread.currentThread()) {
//			obj.wait();  // need try/catch : This code can throw an IllegalMonitorStateException.
			obj.notify();
		}
	}
}

//--------------------------------------------------------
//test 038
class Test038 {
	public static void test() {
		Float pi = new Float(3.14f);
		if (pi > 3) {
			System.out.print("pi is bigger than 3. ");
		}
		else {
			System.out.print("pi is not bigger than 3. ");
		}
//		finally {
//			System.out.println("Have a nice day.");
//		}
	}
}

// ......

//--------------------------------------------------------
//test 039
class Test039 {
	Integer i;
	int x;

	public Test039(int y) {
		x = i + y;                  // A NullPointerException occurs at runtime. (Integer i = null)
		System.out.println(x);
	}
	
	public static void test() {
		new Test039(new Integer(4));
	}
}

//--------------------------------------------------------
//test 040
class Person {
	private String name;
	public Person(String name) { this.name = name; }

	// !!!! overload : will be not used in sort methods 
	public boolean equals(Person p) {
		return p.name.equals(this.name);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}


//--------------------------------------------------------
//test 042
class Score implements Comparable<Score> {
	private int wins, losses;
	public Score(int w, int l) { wins = w; losses = l; }
	public int getWins()       { return wins; }
	public int getLosses()     { return losses; }

	public String toString() {
		return "<" + wins + "," + losses + ">";
	}
	// insert code here : because generic implementation Comparable<Score> -> typ is explicit defined 
	public int compareTo(Score other) {/*more code here*/ return 0; }
}

//--------------------------------------------------------
//test 043
//test 068 
class Test043 {
	//public static int sum(List list) {
	public static int sum(List<Integer> intList) {
		int sum = 0;
		//for ( Iterator iter = list.iterator(); iter.hasNext(); ) {
		for (int i : intList) {
			//int i = ((Integer)iter.next()).intValue();
			sum += i;
		}
		return sum;
	}
	//What three changes allow the class to be used with generics and avoid an unchecked warning? (Choose three.)
	//	Replace the method declaration with "sum(List<Integer> intList)"
	//	Replace line 13 with "for (int i : intList) {"
	//	Remove line 14.
}

//--------------------------------------------------------
//test 044
class Test044 {
	//public static int sum(List list) {
	public static void test() {
		Object [] myObjects = { new Integer(12),
								new String("foo"),
								new Integer(5),
								new Boolean(true)
		};

		Arrays.sort(myObjects);
		// Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		// 		at java.lang.String.compareTo(Unknown Source)
		// 		at java.util.ComparableTimSort.countRunAndMakeAscending(Unknown Source)
		// 		at java.util.ComparableTimSort.sort(Unknown Source)
		// 		at java.util.Arrays.sort(Unknown Source)                                 // static void sort(Object[] a)
		// 		at vce.Test044.test(Testing.java:131)
		// 		at vce.Testing.main(Testing.java:196)
		
		for(int i = 0; i < myObjects.length; i++) {
			System.out.print(myObjects[i].toString());
			System.out.print(" ");
		}
	}
}

//--------------------------------------------------------
//test 045
class Test045 {
	public static void test() {
		System.out.println(testExtTest045());
	}
}

//--------------------------------------------------------
//test 050
class Test050 {
	int squares = 81;
	
	public static void test() {
		new Test050().go();
	}
	
	void go() {
		incr(++squares);
		System.out.println(squares);
	}
	void incr(int squares) { 
		squares += 10;
	}
}


//--------------------------------------------------------
//test 052
class Test052 {
	public static void test() {
		int x = 5;
		Test052 p = new Test052();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.print(" doStuff x = " + x++);
	}
}


//--------------------------------------------------------
//test 053
class Test053 {
	interface Animal { 
		void makeNoise();
	}

	static class Horse implements Animal {
		Long weight = 1200L;
		public void makeNoise() { 
			System.out.println("whinny");
		}
	}

	static class Icelandic extends Horse {
		public void makeNoise() { 
			System.out.println("vinny");
		}
	}

	public static void test() {
		Icelandic i1 = new Icelandic();
		Icelandic i2 = new Icelandic();
		Icelandic i3 = new Icelandic();
		i3 = i1;    // i3 = i1 = object_1
		i1 = i2;    // i1 = object_2
		i2 = null;  // i2 = null, but object_2 linked to i1
		i3 = i1;    // i3 = objelt_2
		
		// result -> i1 = i3 = object_2, object_1=null, object_3=null
	}
}

//--------------------------------------------------------
//test 055
class Test055 {
	public static void test() {
		String[] elements = { "for", "tea", "too" };
		String first = (elements.length > 0) ? elements[0] : null;
	}
}


//--------------------------------------------------------
//test 057
class Test057 {
	static class SuperCalc {
		protected static int multiply(int a, int b) { return a * b;}
	}

	static class SubCalc extends SuperCalc {
		public static int multiply(int a, int b) {
			//int c = super.multiply(a, b);
			int c = SuperCalc.multiply(a, b);
			return c;
		}
	}

	public static void test() {
		SubCalc sc = new SubCalc ();
		System.out.println(sc.multiply(3,4));
		System.out.println(SubCalc.multiply(2,2));
	}
}


//--------------------------------------------------------
//test 058
class Test058 {
	static class Foo {
		public int a = 3;
		public void addFive() { 
			a += 5; System.out.print("f ");
		}
	}
	
	static class Bar extends Foo {
		public int a = 8;
		public void addFive() { 
			this.a += 5; System.out.print("b " ); 
		}
	}

	public static void test() {
		Foo f = new Bar();
		f.addFive();              // Polymorphism : OK for methods
		System.out.println(f.a);  // Polymorphism : no for property
	}
}



//--------------------------------------------------------
//test 060
class Test060 {
	static class ClassA {
		public int numberOfInstances;
		protected ClassA(int numberOfInstances) {
			this.numberOfInstances = numberOfInstances;
		}
	}

	static class ExtendedA extends ClassA {
		private ExtendedA(int numberOfInstances) {
			super(numberOfInstances);
		}
	}

	public static void test() {
		ExtendedA ext = new ExtendedA(420);
		System.out.print(ext.numberOfInstances);
	}
}

//--------------------------------------------------------
//test 061
class Test061 {
	static class ClassA                {}
	static class ClassB extends ClassA {}
	static class ClassC extends ClassA {}

	public static void test() {
		ClassA p0 = new ClassA();
		ClassB p1 = new ClassB();
		ClassC p2 = new ClassC();
		ClassA p3 = new ClassB();
		ClassA p4 = new ClassC();
		
		p0 = p1;
		//p1 = p2;
		//p2 = p4;
		//p2 = (ClassC)p1;
		p1 = (ClassB)p3;
		p2 = (ClassC)p4;
	}
}

//--------------------------------------------------------
//test 062
class Test062 {
	static class Component { 
		void go() { 
			System.out.print("c");
		}
	}
	static class Meter extends Component { 
		void go() { 
			System.out.print("m");
		}
	} 

	static class Thingy { 
		Meter m = new Meter();
	}

	

	static class DeluxeThingy extends Thingy {
		public static void test() {
			DeluxeThingy dt = new DeluxeThingy();
			dt.m.go();
			Thingy t = new DeluxeThingy();
			t.m.go();
		}
	}

	public static void test() {
		DeluxeThingy.test();
	}
}

//--------------------------------------------------------
//test 064
class Test064 {
	static class WrappedString {
		private String s;
		public WrappedString(String s) { 
			this.s = s; 
		}
	}
	public static void test() {
		HashSet<Object> hs = new HashSet<Object>();
		WrappedString ws1 = new WrappedString("aardvark");
		WrappedString ws2 = new WrappedString("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		hs.add(ws1); 
		hs.add(ws2); 
		hs.add(s1); 
		hs.add(s2);
		int hs1 = s1.hashCode();
		int hs2 = s2.hashCode();
		System.out.println("hs.size() = " + hs.size() + "\n\thash code(ws1)=" + ws1.hashCode() + ", hash code(ws2)=" + ws2.hashCode() + ", hash code(hs1)=" +  hs1 + ", hash code(hs2)=" + hs2);
	}
}

//--------------------------------------------------------
//test 066
class Test066 {
	public void takeList(List<? extends String> list) {
		// insert code here
		 
		// *** The method add(capture#1-of ? extends String) 
		//            in the type List<capture#1-of ? extends String> 
		//            is not applicable for the arguments (String)
		// problem if <? extends String> for 'add' weil type problem 
		//list.add("foo");
		// not work : list.add(new String("foo"));
		// works    : ((ArrayList<String>)list).add("foo");
 
		Object o = list;
		String s = list.get(0);
		list = new ArrayList<String>();
		// Type mismatch: cannot convert from ArrayList<Object> to List<? extends String>
		//list = new ArrayList<Object>();
	}

	public static void test() {
	}
}



//--------------------------------------------------------
//test 067
class Test067 {
	public static void test() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("banana");
		pq.add("pear");
		pq.add("apple");
		
		// Тип операции 		Генерирует исключение 	Возвращает специальное значение
		// Добавление 			add(e)					offer(e)
		// Удаление 			remove() 				poll()
		// Получение верхушки 	element() 				peek()
		System.out.println(pq.poll() + " " + pq.peek());
	}
}


//--------------------------------------------------------
//test 070
class Test070 {
	public static void test() {
		Set<Integer> set = new HashSet<Integer>();
		Integer i1 = 45;
		Integer i2 = 46;
		set.add(i1);                                            // 1 element in set
		set.add(i1);    // System.out.print(set.size() + " ");  // 1 element in set
		set.add(i2);    System.out.print(set.size() + " ");     // 2 elementa in set
		set.remove(i1); System.out.print(set.size() + " ");     // 1 element in set
		i2 = 47;
		set.remove(i2); System.out.print(set.size() + " ");     // 1 element in set
	}
}


//--------------------------------------------------------
//test 071
class Test071 {
	public static void test() {
		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for(int i = 606; i < 613; i++) 
		if(i%2 == 0) s.add(i);
		subs = (TreeSet)s.subSet(608, true, 611, true);
		s.add(609);
		System.out.println(s + " " + subs);
	}
}

//--------------------------------------------------------
//test 072
class Test072 {
	public static void test() {
		String[] colors = {"blue", "red", "green", "yellow", "orange"};
		Arrays.sort(colors);
		int s2 = Arrays.binarySearch(colors, "orange");
		int s3 = Arrays.binarySearch(colors, "violet");
		System.out.println(s2 + " " + s3);
	}
}

//--------------------------------------------------------
//test 073
class Test073 {
	public static void test() {
		 HashMap props = new HashMap();  //HashMap<String,String> props = new HashMap<String,String>();
		 props.put("key45", "some value");
		 props.put("key12", "some other value");
		 props.put("key39", "yet another value");
		 Set s = props.keySet();
		 // insert code here
		 //Arrays.sort(s);       // will be work if Arrays.sort(s.toArray());
		 //s = new TreeSet(s);   // navigableSet, SortedSet and TreeSet in Java?
		 //Collection.sort(s);   // collection hasen't function sort : only iterable - interface
		 //s = new SortedSet();  // SortedSet s = (SortedSet)props.keySet();
	}
}

//--------------------------------------------------------
//test 076
class Test076 implements Runnable {
	public static void test() {
		Thread t = new Thread(new Test076());
		t.start();
		System.out.print("Started");
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  System.out.println();
		System.out.print("Complete");
	}
	
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.print(i);
		}
	}
}
	
//--------------------------------------------------------
//test 077
class Test077 {
	//private final synchronized Object o = new Object();
	//private synchronized Object o;
	//void go1() { synchronized() { /* code here */ }
	//public synchronized void go() { /* code here */ }
	//private synchronized(this) void go() { /* code here */ }
	//void go2() { synchronized(Object.class) { /* code here */ } }
	//void go3() { Object o = new Object(); synchronized(o) { /* code here */ } }

	public static void test() { }
}

//--------------------------------------------------------
//test 078
class Test078 {
	private int x;

	public void foo() {
		//synchronized(this) {             // Solution
			int current = x;
			x = current + 1;
		//	System.out.print(x + ", ");    // Solution
		//}                                // Solution
	}

	public void go() {
		for(int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					foo();
					System.out.print(x + ", ");
				}
			}.start();
		}
	}
	public static void test() {
		new Test078().go();
	}
}



//--------------------------------------------------------
//test 080
class Test080 {
	public static void test() {
		Runnable r = new Runnable() {
			public void run() {
				System.out.print("Cat");
			}
		};
		
		Thread t = new Thread(r) {
			public void run() {
				System.out.print("Dog");
			}
		};
		t.start();
	}
}


//--------------------------------------------------------
//test 081
class Test081 {
	public static void test() {
		new Thread(new Runnable() {
			public void run() {
				System.out.print("bar");
			}
		}).start();
	}
}

//--------------------------------------------------------
//test 082
class Test082 {
	static class One {
		void foo() {}
	}
	static class Two extends One {
		//insert method here :
		//           int foo() { /* more code here */ }
		//          void foo() { /* more code here */ }
		//public    void foo() { /* more code here */ }
		//private   void foo() { /* more code here */ }
		//protected void foo() { /* more code here */ }
	}

	public static void test() {
	}
}

//--------------------------------------------------------
//test 083
class Test083 {
	abstract class Employee {
		protected abstract double getSalesAmount();
		public double getCommision() {
			return getSalesAmount() * 0.15;
		}
	}
	class Sales extends Employee {
		// insert method here:
		//          double getSalesAmount() { return 1230.45; }
		public    double getSalesAmount() { return 1230.45; }
		//private   double getSalesAmount() { return 1230.45; }
		//protected double getSalesAmount() { return 1230.45; }
	}
	public static void test() {
	}
}


//--------------------------------------------------------
//test 084
class Test084 {
	static class X {
		X() { 
			System.out.print(1);
		}
		X(int x) {
			this(); System.out.print(2);
		}
	}
	static class Y extends X {
		Y() { 
			super(6); System.out.print(3); 
		}
		Y(int y) {
			this(); System.out.println(4);
		}
	}
	public static void test() {
		new Y(5);
	}
}

//--------------------------------------------------------
//test 088
class Test088 {
	interface Foo { int bar(); }
	
	static class Sprite {
		public int fubar( Foo foo ) { return foo.bar(); }
		public void testFoo() {
			fubar(
					// insert code here:
					//Foo { public int bar() { return 1; } }
					//new Foo { public int bar() { return 1; } } 
					new Foo() { public int bar() { return 1; } }
					//new class Foo { public int bar() { return 1; } }
				);
		}
	}

	public static void test() {
	}
}



//--------------------------------------------------------
//test 089
class Test089 {
	static enum Title {
		MR("Mr."), MRS("Mrs."), MS("Ms.");
		private final String title;
		private Title(String t) { title = t; }
		
		public String format(String last, String first) {
			return title + " " + first + " " + last;
		}
	}
	public static void test() {
		System.out.println(Title.MR.format("Doe", "John"));
	}
}

//--------------------------------------------------------
//test 091
class Test091 {
	static class Line {
		public static class Point {}
	}
	static class Triangle {
		// insert code here :
		// Point p = new Point();
		Line.Point p = new Line.Point();
		// The Point class cannot be instatiated at line 15.
		// Line l = new Line() ; l.Point p = new l.Point();
	}
	public static void test() {
	}
}


//--------------------------------------------------------
//test 092
class Test092 {
	public interface Status {
		// /* insert code here */ int MY_VALUE = 10;
		// Illegal modifier for the interface field Test092.Status.MY_VALUE; 
		// only public, static & final are permitted
		final static public int MY_VALUE = 10;
	}
	public static void test() {
	}
}

//--------------------------------------------------------
//test 096
class Test096 {
	static class Snoochy {
		Boochy booch;
		public Snoochy() { booch = new Boochy(this); }
	}

	static class Boochy {
		Snoochy snooch;
		public Boochy(Snoochy s) { snooch = s; }
	}

	public static void test() {
		Snoochy snoog = new Snoochy();
		snoog = null;
		// more code here
	}
}

//--------------------------------------------------------
//test 097
class Test097 {
	interface Animal { 
		void makeNoise();
	}

	static class Horse implements Animal {
		Long weight = 1200L;
		public void makeNoise() { 
			System.out.println("whinny");
		}
	}

	static class Icelandic extends Horse {
		public void makeNoise() { 
			System.out.println("vinny");
		}
	}

	public static void test() {
		Icelandic i1 = new Icelandic();
		Icelandic i2 = new Icelandic();
		Icelandic i3 = new Icelandic();
		i3 = i1;    // i3 = i1 = object_1
		i1 = i2;    // i1 = object_2
		i2 = null;  // i2 = null, but object_2 linked to i1
		i3 = i1;    // i3 = objelt_2
		
		// result -> i1 = i3 = object_2, object_1=null, object_3=null
	}
}

//--------------------------------------------------------
//test 098
class Test098 {
	static class Payload {
		private int weight;
		public Payload (int w) { 
			weight = w;
		}
		public void setWeight(int w) { 
			weight = w;
		}
		public String toString() { 
			return Integer.toString(weight);
		}
	}

	static void changePayload(Payload p) { 
		/* insert code */ 
		// p.setWeight(420);
		// p.changePayload(420);
		// p = new Payload(420);
		// Payload.setWeight(420);
		// p = Payload.setWeight(420);
	}
	public static void test() {
		Payload p = new Payload(200);
		p.setWeight(1024);
		changePayload(p);
		System.out.println("p is " + p);
	}
}

//--------------------------------------------------------
//test 099
class Test099 {
	public static void test99(String str) {
		int check = 4;
//		if (check = str.length()) {
//			System.out.print(str.charAt(check -= 1) +", ");
//		} else {
//			System.out.print(str.charAt(0) + ", ");
//		}
	}
	
	public static void test() {
		test99("four");
		test99("tee");
		test99("to");
	}
}

//--------------------------------------------------------
//test 102
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

////--------------------------------------------------------
////test 1XX
//class Test1XX {
//public static void test() {
//}
//}



public class Testing {
	public static void main(String[] args) {
		//Test001.test();  System.out.println();
		//Test044.test();  System.out.println();
		//Test045.test();  System.out.println();
		//Test050.test();  System.out.println();
		//Test052.test();  System.out.println();
		//Test057.test();  System.out.println();
		//Test058.test();  System.out.println();
		//Test060.test();  System.out.println();
		//Test064.test();  System.out.println();
		//Test066.test();  System.out.println();
		//Test067.test();  System.out.println();
		//Test070.test();  System.out.println();
		//Test071.test();  System.out.println();
		//Test073.test();  System.out.println();
		//Test076.test();  System.out.println();
		//Test078.test();  System.out.println();
		//Test080.test();  System.out.println();
		//Test084.test();  System.out.println();
		//Test102.test();  System.out.println();
		//Test106.test();  System.out.println();
		//Test108.test();  System.out.println();
		//Test110.test();  System.out.println();
		//new Test110();  System.out.println();
		Test113.test();  System.out.println();
	}
}
