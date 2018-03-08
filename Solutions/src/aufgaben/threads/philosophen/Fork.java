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
	private boolean blocked = false;
	
	public void    lock()     { blocked = true;  }
	public void    unlock()   { blocked = false; }
	public boolean isLocked() { return blocked;  }
}
