
class MyThread extends Thread {
	@Override
	public void run () {
		System.out.println("Running the extension of thread");
	}
}

class MyJob implements Runnable {
	public void run () {
		System.out.println("Running the implementation of Runnable");
		for (int i = 0 ; i < 10; i++) {
			System.out.println("Running the Runnable " + i);
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		
		MyJob job = new MyJob();
		Thread thread = new Thread(job);
		
		myThread.start();
		thread.start();
		
		System.out.println("All thread started");
	}
}