package vce.vce;

import static vce.ext.ExtTest045.testExtTest045;
import java.util.*;

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
//test 075
class Test075 implements Runnable {
	public static void test() {
		Thread t = new Thread(new Test075());
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
		waitForSignal();
	}
	
	void waitForSignal() {
		Object obj = new Object();
		synchronized (Thread.currentThread()) {
			try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.notify();
		}
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

	public /*synchronized*/ void foo() {
		//synchronized(this) {             // Solution
			int current = x;
			x = current + 1;
			System.out.print(x + ", ");    // Solution
		//}                                // Solution
	}

	public void go() {
		for(int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					foo();
					//System.out.print(x + ", ");
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
		//public    double getSalesAmount() { return 1230.45; }
		//private   double getSalesAmount() { return 1230.45; }
		protected double getSalesAmount() { return 1230.45; }
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
		//final static public int MY_VALUE = 10;
		int MY_VALUE = 10;
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
		p = new Payload(420);
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

public class Testing_050_099 {
	public static void main(String[] args) {
//		Test050.test();  System.out.println();
//		Test051.test();  System.out.println();
//		Test052.test();  System.out.println();
//		Test053.test();  System.out.println();
//		Test054.test();  System.out.println();
//		Test055.test();  System.out.println();
//		Test056.test();  System.out.println();
//		Test057.test();  System.out.println();
//		Test058.test();  System.out.println();
//		Test059.test();  System.out.println();
//		Test060.test();  System.out.println();
//		Test061.test();  System.out.println();
//		Test062.test();  System.out.println();
//		Test063.test();  System.out.println();
//		Test064.test();  System.out.println();
//		Test065.test();  System.out.println();
//		Test066.test();  System.out.println();
//		Test067.test();  System.out.println();
//		Test068.test();  System.out.println();
//		Test069.test();  System.out.println();
//		Test070.test();  System.out.println();
//		Test071.test();  System.out.println();
//		Test072.test();  System.out.println();
//		Test073.test();  System.out.println();
//		Test074.test();  System.out.println();
//		Test075.test();  System.out.println();
//		Test076.test();  System.out.println();
//		Test077.test();  System.out.println();
//		Test078.test();  System.out.println();
//		Test079.test();  System.out.println();
//		Test080.test();  System.out.println();
		Test081.test();  System.out.println();
//		Test082.test();  System.out.println();
//		Test083.test();  System.out.println();
//		Test084.test();  System.out.println();
//		Test085.test();  System.out.println();
//		Test086.test();  System.out.println();
//		Test087.test();  System.out.println();
//		Test088.test();  System.out.println();
//		Test089.test();  System.out.println();
//		Test090.test();  System.out.println();
//		Test091.test();  System.out.println();
//		Test092.test();  System.out.println();
//		Test093.test();  System.out.println();
//		Test094.test();  System.out.println();
//		Test095.test();  System.out.println();
//		Test096.test();  System.out.println();
//		Test097.test();  System.out.println();
//		Test098.test();  System.out.println();
//		Test099.test();  System.out.println();
	}
}
