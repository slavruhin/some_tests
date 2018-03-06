package aufgaben.thread;

//import java.util.*;

class RandomGenerator implements Runnable {
	final int[] array;
	int start = 0, end = 0;

	public RandomGenerator(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	public void run() {
		for(int i = start; i < end ; i++)
			array[i] = (int)(Math.random()*Integer.MAX_VALUE);
		System.out.println("Thread: " + Thread.currentThread().getName() + " : Exit");
    }

//	public void run() {
//		Random random = new Random();
//		for(int i = start; i < end ; i++)
//			array[i] = (int)(random.nextInt(Integer.MAX_VALUE));
//	    System.out.println("Thread: " + Thread.currentThread().getName() + " : Exit");
//  }
};

class Counter implements Runnable {
	@Override
	public void run() {
		for(int i = 0 ; i < 1000000; ++i) 
			synchronized(TestThreads.num) {
				TestThreads.num++;
			}
	}
}

public class TestThreads {
	static volatile Integer num = 0;
	static final int[] array = new int[100];

	public static void main(String[] args) {
		//-----------------------------------------------------------
		// test 1:
		//-----------------------------------------------------------
		Thread t1 = new Thread(new RandomGenerator(array,  0,  20));
		Thread t2 = new Thread(new RandomGenerator(array, 20,  50));
		Thread t3 = new Thread(new RandomGenerator(array, 50,  75));
		Thread t4 = new Thread(new RandomGenerator(array, 75, 100));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join(); // main waiting while t - thread running
			t2.join(); // main waiting while t - thread running
			t3.join(); // main waiting while t - thread running
			t4.join(); // main waiting while t - thread running
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0 ; i < array.length ; ++i)
			System.out.printf("%2d : %d %n", i, array[i]);
		System.out.println("Main: Exit");

		//-----------------------------------------------------------
		// Test 2:
		//-----------------------------------------------------------
		Thread t5 = new Thread(new Counter());
		Thread t6 = new Thread(new Counter());
		t5.start();
		t6.start();
		try {
			t5.join(); // main waiting while t - thread running
			t6.join(); // main waiting while t - thread running
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);

		//-----------------------------------------------------------
		// Test 2:
		//-----------------------------------------------------------
		class Threads4 {

			public void start () {
				new Threads4().go();
			}
			
			public void go() {
				Runnable r = new Runnable() {
					public void run() {
						System.out.print("foo");
					}
				};

				Thread t = new Thread(r);
				t.start();
				t.start();
			}
		}
		
		new Threads4().start();
	}
	
//	static void waitForSignal() {
//		Object obj = new Object();
//		synchronized (Thread.currentThread()) {
//				obj.wait();
//				obj.notify();
//		}
//	}
	
}
