package aufgaben.thread;

import static org.apache.commons.lang3.StringUtils.*;


public class PrintThreads {
	
	public static void main(String[] args) {
		test1();
		//test2();
		System.out.println();
	}

	public static void test1() {
		class Printer extends Thread {
			final char ch;
			final int linelen;
			final int linenum;

			public Printer(char ch, int linelen, int linenum) {
				this.ch = ch;
				this.linelen = linelen;
				this.linenum = linenum;
			}

			@Override
			public void run() {
				for(int i = 0 ; i < linenum; ++i) 
					synchronized(System.out) {
						for(int j = 0; j < linelen; j++) {
							System.out.print(ch);
						}
						System.out.println();
					}

			}
		}
		Printer p1 = new Printer('a', 10, 20);
		Printer p2 = new Printer('*', 15, 40);
		testStart(p1, p2);
	}
	
	public static void test2() {
		class Printer extends Thread {
			final String line;
			final int linenum;

			public Printer(char ch, int linelen, int linenum) {
				line = repeat(ch, linelen);
				this.linenum = linenum;
			}

			@Override
			public void run() {
				for(int i = 0 ; i < linenum; ++i) 
					synchronized(System.out) {
						System.out.println(line);;
					}

			}
		}
		Printer p1 = new Printer('a', 10, 20);
		Printer p2 = new Printer('*', 15, 40);
		testStart(p1, p2);
	}
	
	
	public static void testStart(Thread p1, Thread p2) {

		p1.start();
		p2.start();
		try {
			p1.join(); // main waiting while t - thread running
			p2.join(); // main waiting while t - thread running
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
