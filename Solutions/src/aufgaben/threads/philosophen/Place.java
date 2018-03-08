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
			pause(500);
			status = Status.HUNGRY;
		}
		else if(status == Status.HUNGRY) {
			synchronized (leftFork) {
				if(! leftFork.isLocked()) {
					leftFork.lock();
					status = Status.LEFT_FORK_UP;
				}
			}
		}
		else if(status == Status.LEFT_FORK_UP) {
			synchronized (rigthFork) {
				if(! rigthFork.isLocked()) {
					rigthFork.lock();
					status = Status.RIGTH_FORK_UP;
				}
			}
		}
		else if(status == Status.RIGTH_FORK_UP) {
			synchronized (rigthFork) {
				if(! rigthFork.isLocked()) {
					rigthFork.lock();
					status = Status.EAT;
				}
			}
		}
		else if(status == Status.EAT) {
			pause(500);
			synchronized (leftFork) {
				leftFork.unlock();
				status = Status.LEFT_FORK_DOWN;
			}
		}
		else if(status == Status.LEFT_FORK_DOWN) {
			synchronized (rigthFork) {
				rigthFork.unlock();
				status = Status.RIGTH_FORK_DOWN;
			}
		}
		else
			status = Status.THINK;

		synchronized (logger) {
			logger.addMessage("Changed status: " + toString());
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
		for(int i = 0 ; i < 30 ; ++i) {
			System.out.println(toString());
			changeStatus();
		}
	}

	@Override
	public String toString() {
		return String.format( "%-11s (place %d) : %s", owner, id, status.message);
	}
}
