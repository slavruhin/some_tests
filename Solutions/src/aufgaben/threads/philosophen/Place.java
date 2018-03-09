package aufgaben.threads.philosophen;



public class Place extends Thread {

	public final int id;
	public final String owner;
	private Status status;
	private Logger logger;

	private Fork leftFork, rigthFork; 

	public Place(int id, String owner) {
		this.id = id;
		this.owner = owner;
		status = Status.THINK;
	}

	public void setForks(Fork leftFork, Fork rigthFork) {
		this.leftFork  = leftFork;
		this.rigthFork = rigthFork;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public final Status getStatus() {
		return status;
	}

	public void changeStatus() {
		synchronized (logger) {
			logger.addMessage("Change status:  " + toString());
		}

		if(status == Status.THINK) {
			status = Status.HUNGRY;
		}
		else if(status == Status.HUNGRY) {
			tryForksUp();
//			synchronized (leftFork) {
//				if(leftFork.isDown()) {
//					leftFork.up();
//					status = Status.LEFT_FORK_UP;
//				} else {
//					try {
//						leftFork.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
		}
//		else if(status == Status.LEFT_FORK_UP) {
//			synchronized (rigthFork) {
//				if(rigthFork.isDown()) {
//					rigthFork.up();
//					status = Status.RIGTH_FORK_UP;
//				}
//				else {
//					try {
//						rigthFork.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
		else if(status == Status.RIGTH_FORK_UP) {
			status = Status.EAT;
			pause(500);
		}
		else if(status == Status.EAT) {
			synchronized (leftFork) {
				leftFork.down();
				status = Status.LEFT_FORK_DOWN;
				leftFork.notifyAll();
			}
		}
		else if(status == Status.LEFT_FORK_DOWN) {
			synchronized (rigthFork) {
				rigthFork.down();
				status = Status.RIGTH_FORK_DOWN;
				rigthFork.notifyAll();
			}
		}
		else {
			status = Status.THINK;
			pause(500);
		}

		synchronized (logger) {
			logger.addMessage("Changed status: " + toString());
		}
	}
	
	private void tryForksUp () {

		synchronized (leftFork) {
			if(leftFork.isDown()) {
				leftFork.up();
				status = Status.LEFT_FORK_UP;
			}
		}
		if(status == Status.LEFT_FORK_UP) {
			synchronized (rigthFork) {
				if(rigthFork.isDown()) {
					rigthFork.up();
					status = Status.RIGTH_FORK_UP;
				}
				else {
					synchronized (leftFork) {
						leftFork.down();
						status = Status.HUNGRY;
					}
				}
			}
		}

		if(status == Status.HUNGRY) {
			synchronized (leftFork) {
				try { 
					leftFork.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 20 ; ++i) {
			System.out.println(toString());
			changeStatus();
		}
	}

	@Override
	public String toString() {
		return String.format( "%-11s (place %d) : %s", owner, id, status.message);
	}
}
