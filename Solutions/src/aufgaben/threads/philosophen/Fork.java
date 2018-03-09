package aufgaben.threads.philosophen;



//class Philosoph implements Runnable {
//
//	int state = 0;
//	@Override
//	public void run() {
//	}
//	
//}

/**
 * Shared resource
 * @author S.Lavruhin-Ronn
 *
 */
public class Fork {
	private boolean up = false;
	
	public void    up()     { up = true;  }
	public void    down()   { up = false; }
	public boolean isUp()   { return up;  }
	public boolean isDown() { return !up; }
}
