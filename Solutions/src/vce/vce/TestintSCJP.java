package vce.vce;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.*;

//--------------------------------------------------------
//Charter 01-07
class Charter0107 {
	static void test() {
		for(int __x = 0; __x < 3; __x++) ;
		//int #lb = 7;
		//long [] x [5];
		Boolean []ba[];
		//enum Traffic { RED, YELLOW, GREEN };
	}
}

//--------------------------------------------------------
//Charter 01-09
class Charter0109 {
	static class Hobbit {
		int countGold(int x, int y) {
			return x + y;
		}
	}
	static class Frodo extends Hobbit {
	}

	int countGold(int x, int y) {
		return x + y;
	}

	static void test() {
		Short myGold = 7;
		System.out.println(new Frodo().countGold(myGold, 6));
	}
}

//--------------------------------------------------------
//Charter 02-09
class Charter0209 {
	static class Tree { }
	
	static class Redwood extends Tree {
		void go() {
			go2(new Tree(), new Redwood());
			go2((Redwood) new Tree(), new Redwood());
		}

		void go2(Tree t1, Redwood r1) {
			Redwood r2 = (Redwood) t1;    // runtime error :  java.lang.ClassCastException
			Tree t2 = (Tree) r1;
		}
	}
	static void test() {
		new Redwood().go();
	}
}

//--------------------------------------------------------
//Charter 02-11
class Charter0211 {
	static class Alpha {
		static String s = " ";

		protected Alpha() {
			s += "alpha ";
		}
	}
	static class SubAlpha extends Alpha {
		private SubAlpha() {
			s += "sub ";
		}
	}
	static class SubSubAlpha extends Alpha {
		private SubSubAlpha() {
			s += "subsub ";
		}
		static void test() {
			new SubSubAlpha();
			System.out.println(s);
		}
	}
	static void test() {
		SubSubAlpha.test();
	}
}

//--------------------------------------------------------
//Charter 02-15
class Charter0215 {
	static class A {
	}
	static class B extends A {
	}
	static String s = "-";
	static void sifter(A[]... a2) {
		s += "1";
	}
	static void sifter(B[]... b1) {
		s += "2";
	}
	static void sifter(B[] b1) {
		s += "3";
	}
	static void sifter(Object o) {
		s += "4";
	}
	public static void test() {
		// -434
		A[] aa = new A[2];
		B[] ba = new B[2];
		sifter(aa);  // sifter(Object o)
		sifter(ba);  // sifter(B[] b1)
		sifter(7);   // sifter(Object o)
		System.out.println(s);
	}
}

//--------------------------------------------------------
//Charter 03-02
class Charter0302 {
	static class Alien {
		String invade(short ships) {
			return "a few";
		}

		String invade(short... ships) {
			return "many";
		}
	}
	static class Defender {
		public static void test() {
			//System.out.println(new Alien().invade(7));
			System.out.println(new Alien().invade((short)7));
		}
	}
	static void test() {
	}
}

//--------------------------------------------------------
//Charter 03-03
class Charter0303 {
	static void test() {
		int[][] a = {{1,2,}, {3,4}};
		int[] b = (int[]) a[1];
		Object o1 = a;
		int[][] a2 = (int[][]) o1;
		int[] b2 = (int[]) o1;      // runtime error : cannot be cast to
		System.out.println(b[1]);
	}
}

//--------------------------------------------------------
//Charter 03-04
class Charter0304 {
	static class Mixer {
		Mixer m1;
		Mixer() {
		}
		Mixer(Mixer m) {
			m1 = m;
		}
		void go() {
			System.out.print("hi ");
		}
	}
	static void test() {
		Mixer m2 = new Mixer();
		Mixer m3 = new Mixer(m2);
		m3.go();
		Mixer m4 = m3.m1;
		m4.go();
		Mixer m5 = m2.m1;
		m5.go();           // runtime error : java.lang.NullPointerException
	}
}

//--------------------------------------------------------
//Charter 03-07
class Charter0307 {
	static  class Bridge {
		static enum Suits {
			CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30), NOTRUMP(40) { 
				public int getValue(int bid) {
					return ((bid - 1) * 30) + 40;
				}
			};
			Suits(int points) {
				this.points = points;
			}
			private int points;

			public int getValue(int bid) {
				return points * bid;
			}
		}
	}

	static void test() {
		//System.out.println(Bridge.Suits.NOTRUMP.getBidValue(3));
		System.out.println(Bridge.Suits.NOTRUMP.getValue(3));
		System.out.println(Bridge.Suits.SPADES + " " + Bridge.Suits.SPADES.points);
		System.out.println(Bridge.Suits.values());
	}
}

//--------------------------------------------------------
//Charter 03-13
class Charter0313 {
	static class Dark {
		int x = 3;

		void go1() {
			//int x;
			int x = 0;
			go2(++x); // Compile error : local variable is not initialized
		}

		void go2(int y) {
			int x = ++y;
			System.out.println(x);
		}
	}
	static void test() {
		new Dark().go1();
	}
}

//--------------------------------------------------------
//Charter 04-02
class Charter0402 {
	static void test() {
		float f1 = 2.3f;
		float[][] f2 = {{42.0f}, {1.7f, 2.3f}, {2.6f, 2.7f}};
		float[] f3 = {2.7f};
		Long x = 42L;
		// insert code here
		//if(f1 == f2)         // F1. Compile error 
		if(f1 == f2[2][1])   // F2. 
			System.out.println("true");
		if(x == f2[0][0])    // F3. 
			System.out.println("true");
		//if(f1 == f2[1,1])    // F4. Compile error 
		if(f3 == f2[2])      // F5. 
			System.out.println("true");
	}
}

//--------------------------------------------------------
//Charter 04-03
class Charter0403 {
	static void test() {
		String[] args = {"Fork", "live2"};
		if(args.length == 1 | args[1].equals("test")) {
			System.out.println("test case");
			} else {
			System.out.println("production " + args[0]);
			}
		}
}

//--------------------------------------------------------
//Charter 04-09
class Charter0409 {
	static void test() {
		int mask = 0;
		int count = 0;
		if (((5 < 7) || (++count < 10)) | mask++ < 10)  // -> count = 0, mask = 1
			mask = mask + 1;                            // -> count = 0, mask = 2
		if ((6 > 8) ^ false)
			mask = mask + 10;
		if (!(mask > 1) && ++count > 1) 
			mask = mask + 100;
		System.out.println(mask + " " + count);
	}
}

//--------------------------------------------------------
//Charter 05-07
class Charter0507 {
	class SubException extends Exception {}

	class SubSubException extends SubException {}

	public class CC {
		void doStuff() throws SubException {}
	}

	class CC2 extends CC {
		void doStuff() throws SubSubException {}
	}

	class CC3 extends CC {
		//void doStuff() throws Exception {}
		void doStuff() {}
	}

	class CC4 extends CC {
		void doStuff(int x) throws Exception {}
	}

	class CC5 extends CC {
		void doStuff() {}
	}

	static void test() {
	}
}

//--------------------------------------------------------
//Charter 05-09
//9 10 10 d 13 
class Charter0509 {
	static int x = 7;
	static { x++; }
	public static void test() {
		String s = "";
		for (int y = 0; y < 3; y++) {
			x++;
			switch (x) {
				case 8:		s += "8 ";
				case 9:		s += "9 ";
				case 10:	{ s += "10 "; break; }
				default:	s += "d ";
				case 13:	s += "13 ";
			}
		}
		System.out.println(s);
	}
}

//--------------------------------------------------------
//Charter 05-11
class Charter0511 {
	static String s = "";
	static void doStuff() {
		int x = 0;
		int y = 7 / x;
	}

	public static void test() {
		try {
			s += "1";
			throw new Exception();
		} catch (Exception e) {
			s += "2";
		} finally {
			s += "3";
			doStuff();
			s += "4";
		}
		System.out.println(s);
	}
}

//--------------------------------------------------------
//Charter 05-13
class Charter0513 {
	void go() {
		go();
	}
	static void test() {
		// insert code here

		// java.lang.StackOverflowError
		//new Charter0513().go();
		
		// result : ouch
		//try { new Charter0513().go(); } catch (Error e) { System.out.println("ouch"); }
		
		// java.lang.StackOverflowError
		//try { new Charter0513().go(); } catch (Exception e) { System.out.println("ouch"); }
	}
}

//--------------------------------------------------------
//Charter 06-01 :
//m.start=0 m.group=
//m.start=1 m.group=
//m.start=2 m.group=34
//m.start=4 m.group=
//m.start=5 m.group=
//m.start=6 m.group=
class Charter0601 {
	public static void test() {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		boolean b = false;
		while(b = m.find())
			System.out.println("m.start=" + m.start() + " m.group=" + m.group());
	}
}

//--------------------------------------------------------
//Charter 06-03
class Charter0603 {
	static void test() {
		String s = "-";
		Integer x = 343;
		long L343 = 343L;
		if (x.equals(L343))
			s += ".e1 ";
		if (x.equals(343))
			s += ".e2 ";
		Short s1 = (short) ((new Short((short) 343)) / (new Short((short) 49)));
		if (s1 == 7)
			s += "=s ";
		if (s1 < new Integer(7 + 1))
			s += "fly ";
		System.out.println(s);
	}
}

//--------------------------------------------------------
//Charter 06-04
class Charter0604 {
	static class Keyboard {
	}

	static class Computer implements Serializable {
		private Keyboard k = new Keyboard();

		void storeIt(Computer c) {
			try {
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myFile"));
				os.writeObject(c);
				os.close();
				System.out.println("done");
			} catch (Exception x) {
				System.out.println("exc");
			}
		}
	}

	static void test() {
		Computer c = new Computer();
		c.storeIt(c);
	}
}

//--------------------------------------------------------
//Charter 06-05
class Charter0605 {
/*	
	File; 
	FileDescriptor; 
	FileWriter; 
	Directory;
	//try { 
	.createNewDir(); 
	//File dir 
	//File
	//{ } 
	//(Exception x) 
	//("dir3"); 
	//file
	//file 
	//.createNewFile(); 
	//= new File 
	//= new File
	//dir 
	//(dir, "file3"); 
	(dir, file); 
	.createFile();
	//} catch 
	//("dir3", "file3"); 
	//.mkdir(); 
	File file
*/	
	static void test() {
		try { 
			File dir = new File ("dir3");
			dir.mkdir();
			File file = new File(dir, "file3");
			file.createNewFile();
		} catch (Exception x) 
		{ } 
	}
}

//--------------------------------------------------------
//Charter 06-08
class Charter0608 {
	static class SpecialSerial implements Serializable {
		transient int y = 7;
		static int z = 9;
	}
	static void test() {
		SpecialSerial s = new SpecialSerial();
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myFile"));
			os.writeObject(s);
			os.close();
			System.out.print(++s.z + " ");
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("myFile"));
			SpecialSerial s2 = (SpecialSerial) is.readObject();
			is.close();
			System.out.println(s2.y + " " + s2.z);
		} catch (Exception x) {
			System.out.println("exc");
		}
	}
}

//--------------------------------------------------------
//Charter 06-12 :
class Charter0612 {
	static class Vehicle { }
	static class Wheels { }
	static class Car extends Vehicle implements Serializable { }
	static class Ford extends Car { }
	static class Dodge extends Car {
		Wheels w = new Wheels();
	}
	public static void test() {
		Vehicle o1 = new Vehicle();
		Wheels  o2 = new Wheels();
		Car     o3 = new Car();
		Ford    o4 = new Ford();
		Dodge   o5 = new Dodge();
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("charter0612.obj"));
			os.writeObject(o1);
			os.writeObject(o2);
			os.writeObject(o3);
			os.writeObject(o4);
			os.writeObject(o5);
			os.close();
			
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("charter0612.obj"));
			Vehicle oo1 = (Vehicle)is.readObject();
			Wheels  oo2 = (Wheels)is.readObject();
			Car     oo3 = (Car)is.readObject();
			Ford    oo4 = (Ford)is.readObject();
			Dodge   oo5 = (Dodge)is.readObject();
			is.close();
		} catch (Exception e) {
			System.out.print("exc");
		} finally {
			System.out.println();
		}
	}
}

//--------------------------------------------------------
//Charter 06-13 :
class Charter0613 {
	public static void test() {
		String s = "987,123456";
		double d = 987.123456d;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(d) + " ");
		try {
			System.out.println(nf.parse(s));
		} catch (Exception e) {
			System.out.println("got exc");
		}
	}
}

//--------------------------------------------------------
//Charter 06-14 :
class Charter0614 {
	public static void test() {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("ab2c4d67");
		int count = 0;
		while(m.find())
			count++;
		System.out.print(count);
	}
}

//--------------------------------------------------------
//Charter 07-01 :
class Charter0701 {
	public static void test() {
		// Which statements could be inserted here to allow this code to compile and run?
		// List<List<Integer>> table = new List<List<Integer>>();              // A. 
		List<List<Integer>> table = new ArrayList<List<Integer>>();         // B. 
		// List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();    // C. 
		// List<List, Integer> table = new List<List, Integer>();              // D. 
		// List<List, Integer> table = new ArrayList<List, Integer>();         // E. 
		// List<List, Integer> table = new ArrayList<ArrayList, Integer>();    // F. 
		// None of the above                                                   // G. 
		for (int i = 0; i <= 10; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j <= 10; j++)
				row.add(i * j);
			table.add(row);
		}
		for (List<Integer> row : table)
			System.out.println(row);
	}
}

//--------------------------------------------------------
//Charter 07-03 :
class Charter0703 {
	public static void test() {
		@SuppressWarnings("rawtypes")
		Set set = new TreeSet();
		set.add("2");
		set.add(3);              // java.lang.ClassCastException
		set.add("1");
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
	}
}

//--------------------------------------------------------
//Charter 07-04 :
class Charter0704 {
	static class ToDos {
		String day;

		ToDos(String d) {
			day = d;
		}

		public boolean equals(Object o) {
			return ((ToDos) o).day == this.day;
		}
		public int hashCode() { return 9; }
	}
	public static void test() {
		Map<ToDos, String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("Monday");
		ToDos t2 = new ToDos("Monday");
		ToDos t3 = new ToDos("Tuesday");
		m.put(t1, "doLaundry");
		m.put(t2, "payBills");
		m.put(t3, "cleanAttic");
		System.out.println(m.size());
	}
}

//--------------------------------------------------------
//Charter 07-06 :
class Charter0706 {
	interface Hungry<E> {
		void munch(E x);
	}

	interface Carnivore<E extends Animal> extends Hungry<E> {}
	//--- interface Carnivore<E extends Plant> extends Hungry<E> {}
	
	interface Herbivore<E extends Plant> extends Hungry<E> {}
	//interface Herbivore<E extends Animal> extends Hungry<E> {}

	abstract class Plant {
	}

	class Grass extends Plant {
	}

	abstract class Animal {
	}

	//class Sheep extends Animal implements Herbivore<Sheep> {
	//	public void munch(Sheep x) {
	//	}
	//}
	//class Sheep extends Animal implements Herbivore<Plant> {
	//	public void munch(Grass x) {
	//	}
	//}
	class Sheep extends Plant implements Carnivore<Wolf> {
		public void munch(Wolf x) {
		}
	}

	//class Wolf extends Animal implements Carnivore<Sheep> {
	//	public void munch(Sheep x) {
	//	}
	//}
	class Wolf extends Animal implements Herbivore<Grass> {
		public void munch(Grass x) {}
	}
	
	public static void test() {
	}
}

//--------------------------------------------------------
//Charter 07-09 :
class Charter0709 {
	public static void test2() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[] array = {1,2,3,4,5,6,7,8,9,4,5,6,7,8,9};
		for(int i : array) 
			pq.add(i);
		System.out.println("size=" + pq.size());
		for(int i = 0 ; i < 14 ; ++i) 
			System.out.println(pq.peek());
		System.out.println("size=" + pq.size());
		for(int i = 0 ; i < 14 ; ++i) 
			System.out.println(pq.poll());
		System.out.println("size=" + pq.size());
	}
	
	public static void test() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("2");                        // [2]
		pq.add("4");                        // [2, 4]
		System.out.print(pq.peek() + " ");  // -> 2
		pq.offer("1");                      // [1, 4, 2]
		pq.add("3");                        // [1, 3, 2, 4]
		pq.remove("1");                     // [2, 3, 4]
		System.out.print(pq.poll() + " ");  // -> 2
		if (pq.remove("2"))                 // [3, 4]
			System.out.print(pq.poll() + " ");
		System.out.println(pq.poll() + " " + pq.peek()); // -> 3 4
	}
}

//--------------------------------------------------------
//Charter 07-13 :
class Charter0713 {
	public static void test() {
		TreeMap<String, String> myMap = new TreeMap<String, String>();
		myMap.put("a", "apple");
		myMap.put("d", "date");
		myMap.put("f", "fig");
		myMap.put("p", "pear");
		System.out.println("1st after mango: " + myMap.higherKey("f"));
		System.out.println("1st after mango: " + myMap.ceilingKey("f"));
		System.out.println("1st after mango: " + myMap.floorKey("f"));

		SortedMap<String, String> sub = new TreeMap<String, String>();
		sub = myMap.tailMap("f");
		System.out.println("1st after mango: " + sub.firstKey());
	}
}

//--------------------------------------------------------
//Charter 07-15 :
class Charter0715 {
	static class Dog {
		int size;
		Dog(int s) {
			size = s;
		}
		@Override
		public String toString() {
			return Integer.valueOf(size).toString();
		}
	}

	public static void test() {
		TreeSet<Integer> i = new TreeSet<Integer>();
		TreeSet<Dog> d = new TreeSet<Dog>();

		d.add(new Dog(1));
		d.add(new Dog(2));
		d.add(new Dog(1));
		i.add(1);
		i.add(2);
		i.add(1);
		System.out.println(d.size() + " " + i.size());
		System.out.print(i);
		
		System.out.println();
			
	}
}

//--------------------------------------------------------
//Charter 07-16 :
class Charter0716 {
	static class Othello implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}
	public static void test() {
		String[] s = { "map", "pen", "marble", "key" };
		Othello o = new Othello();
		Arrays.sort(s, o);
		for (String s2 : s)
			System.out.print(s2 + " ");
		System.out.println(Arrays.binarySearch(s, "map"));
	}
}

/*
//--------------------------------------------------------
//Charter 07-05 :
class Charter0710 {
	public static void test() {
	}
}
*/

/**
 * 
 * @author slavruhin-ronn
 *
 */
public class TestintSCJP {
	public static void main(String[] args) {
		//new Charter0109().test();
		//new Charter0209().test();
		//new Charter0211().test();
		//new Charter0215().test();
		//new Charter0303().test();
		//new Charter0304().test();
		//new Charter0307().test();
		//new Charter0313().test();
		//new Charter0402().test();
		//new Charter0403().test();
		//new Charter0409().test();
		//new Charter0511().test();
		//new Charter0513().test();
		//new Charter0603().test();
		//new Charter0604().test();
		//new Charter0701().test();
		//new Charter0703().test();
		//new Charter0704().test();
		//new Charter0709().test();
		//new Charter0709().test2();
		new Charter0713().test();
		//new Charter0715().test();
		//new Charter0716().test();
	}

}
