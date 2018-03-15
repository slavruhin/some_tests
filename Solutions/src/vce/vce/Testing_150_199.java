package vce.vce;
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
	public static void test() {
	}
}

class Test163 {
	public static void test() {
	}
}

class Test164 {
	public static void test() {
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
	public static void test() {
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
	}
}

class Test175 {
	public static void test() {
	}
}

class Test176 {
	public static void test() {
	}
}

class Test177 {
	public static void test() {
	}
}

class Test178 {
	public static void test() {
	}
}

class Test179 {
	public static void test() {
	}
}

class Test180 {
	public static void test() {
	}
}

class Test181 {
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
	public static void test() {
	}
}

class Test188 {
	public static void test() {
	}
}

class Test189 {
	public static void test() {
	}
}

class Test190 {
	public static void test() {
	}
}

class Test191 {
	public static void test() {
	}
}

class Test192 {
	public static void test() {
	}
}

class Test193 {
	public static void test() {
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
		Test150.test();  System.out.println();
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
//		Test193.test();  System.out.println();
//		Test194.test();  System.out.println();
//		Test195.test();  System.out.println();
//		Test196.test();  System.out.println();
//		Test197.test();  System.out.println();
//		Test198.test();  System.out.println();
//		Test199.test();  System.out.println();
	}
}
