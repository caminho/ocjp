public class WaitNotifyTest {
	
	static class CountingThread extends Thread {
		public int total;
		
		public void run() {
			System.out.println("CountingTest: run");
			synchronized(this) {
				System.out.println("CountingTest: in critical section");
				for (int i = 0; i < 1000; i++) {
					total += i;
				}
				System.out.println("CountingTest: finished counting");
				notify();
				System.out.println("CountingTest: notify() and sleep");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e){}
			}
			System.out.println("CountingTest: exit critical section");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e){}
		}
	}
	
	public static void main(String[] args) {
		
		CountingThread ct = new CountingThread();
		
		System.out.println("Main: starting CountingThread");
		ct.start();
		System.out.println("Main: waiting for lock");
		synchronized(ct) {
			System.out.println("Main: in critical section");
			try {
				System.out.println("Waiting for Counting Thread to complete");
				ct.wait();
				System.out.println("Main: CountingThread completed!");
			} catch(InterruptedException e) {
			}
			System.out.println("Total is: " + ct.total);
		}
	}
}