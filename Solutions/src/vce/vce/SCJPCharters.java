package vce.vce;
import java.io.*;
import java.text.NumberFormat;
import java.util.regex.*;


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
class Charter0603 {
	public static void test() {
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
	
	public static void test() {
		Computer c = new Computer();
		c.storeIt(c);
	}
}

//--------------------------------------------------------
class Charter0605 {
	public static void test() {
		try {
			File dir = new File("dir3");
			dir.mkdir();
			File file = new File(dir, "file3");
			file.createNewFile();
		} catch (Exception x) {
		}
	}
}	

//--------------------------------------------------------
//Charter 06-08 :
class Charter0608 {
	public static void test() {
		SpecialSerial s = new SpecialSerial();
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("charter0608.obj"));
			os.writeObject(s);
			os.close();
			System.out.print(++s.z + " ");
			
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("charter0608.obj"));
			SpecialSerial s2 = (SpecialSerial)is.readObject();
			is.close();
			System.out.print(s2.y + " " + s2.z);
		} catch (Exception e) {
			System.out.print("exc");
		} finally {
			System.out.println();
		}
	}
	static class SpecialSerial implements Serializable {
		transient int y = 7;
		static int z = 9;
	}
}

//--------------------------------------------------------
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



public class SCJPCharters {
	public static void main(String[] args) {
		//Charter0509.test();
		//Charter0601.test();
		//Charter0603.test();
		//Charter0604.test();
		//Charter0605.test();
		//Charter0608.test();
		//Charter0612.test();
		Charter0613.test();
		//Charter0614.test();
	}
}
