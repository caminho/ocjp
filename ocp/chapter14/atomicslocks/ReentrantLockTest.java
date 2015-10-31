import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class ReentrantLockTest {
	
	private Lock lock = new ReentrantLock();
	
	class LockingWorker extends Thread {
		@Override
		public void run() {
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println(getName() + 
						" working (" + (i + 1) + ")");
				}	
			} finally {
				lock.unlock();
			}
		}
	}
	
	class BackgroundWorker extends Thread {
		
		protected void runJob(int i) {
			if (lock.tryLock()) {
				try {					
					System.out.println(getName() + 
						" working in background (" + (i + 1) + ")");	
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println(getName() + " attempt to work: " 
					+ "other threads hold lock");
			}
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				runJob(i);				
			}	
		}
	}
	
	class WaitingWorker extends BackgroundWorker {
		
		protected void runJob(int i) {
			try {
				if (lock.tryLock(10, TimeUnit.MILLISECONDS )) {
					try {					
						System.out.println(getName() + 
							" working in background (" + (i + 1) + ")");	
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(getName() + " attempt to work: " 
						+ "other threads hold lock");
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public void go() {
		LockingWorker worker1 = new LockingWorker();
		LockingWorker worker2 = new LockingWorker();
		LockingWorker worker3 = new LockingWorker();
		BackgroundWorker bgworker = new WaitingWorker();
		
		worker1.start();
		worker2.start();
		bgworker.start();
		worker3.start();
	}
	
	public static void main(String[] args) {
		new ReentrantLockTest().go();
	}
}