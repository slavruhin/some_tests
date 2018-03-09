package vce.eA.item19;

import java.util.*;

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


// C.57.
//class SuperCalc {
//	protected static int multiply(int a, int b) { return a * b;}
//}
//class SubCalc extends SuperCalc{
//	public static int multiply(int a, int b) {
//		int c = super.multiply(a, b);
//		return c;
//	}
//}

// 98
class PayloadExt {
	 private int weight;
	 public PayloadExt (int w) { weight = w; }
	 public void setWeight(int w) { weight = w; }
	 public String toString() { return Integer.toString(weight); }
}


public class Test {
	static public void go() {
		String o = "";
		z:
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 2; y++) {
				if(x==1) 
					break;
				if(x==2 && y==1) 
					break z;
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

	// 98
	static void changePayload(PayloadExt p) {
		/* insert code */ 
		//p.setWeight(420);
		p = new PayloadExt(420);
	}
	
	
	// 106.
	static void test106() throws Error {
		if (true) 
			throw new AssertionError();
		System.out.print("test ");
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
		try { new Boxer1(new Integer(4)); } catch ( NullPointerException e) {}
		//-------------------
		// 57
		
		//-------------------
		// 64
		class WrappedString {
			private String s;
			public WrappedString(String s) { 
				this.s = s; 
			}
		}
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
		System.out.println("hs.size() = " + hs.size() + " hash code : " + hs1 + " , " + hs2);
		
		// 66.
		class G1 {
			 public void takeList(List<? extends String> list) {
				 // insert code here
				 
				 // *** The method add(capture#1-of ? extends String) 
				 //            in the type List<capture#1-of ? extends String> 
				 //            is not applicable for the arguments (String)
				 //list.add("foo");
				 // not work : list.add(new String("foo"));
				 // works    : ((ArrayList<String>)list).add("foo");
				 
				 Object o = list;
				 String s = list.get(0);
				 list = new ArrayList<String>();
				 // Type mismatch: cannot convert from ArrayList<Object> to List<? extends String>
				 //list = new ArrayList<Object>();
			 }
		 }
		 
		 // 98
		 class Payload {
			 private int weight;
			 public Payload (int w) { weight = w; }
			 public void setWeight(int w) { weight = w; }
			 public String toString() { return Integer.toString(weight); }
		 }
		 class TestPayload {
			void changePayload(Payload p) {
				/* insert code */ 
				p.setWeight(420);
				//p = new Payload(420);
			}
			void test() {
				Payload p = new Payload(200);
				p.setWeight(1024);
				changePayload(p);
				System.out.println("p is " + p);
			}
		 }
		 new TestPayload().test();
		
		PayloadExt p = new PayloadExt(200);
		p.setWeight(1024);
		changePayload(p);
		System.out.println("p is " + p);

		// 102
		
		// 106 : Dead code : Exception in thread "main" java.lang.AssertionError
		try { test106(); }
		catch (Exception ex) { System.out.print("exception "); }
		System.out.print("end ");
	}
}
