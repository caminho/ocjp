class MyRunnable implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Run by " + Thread.currentThread()
				.getName() + ", i = " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}

public class SleepingThreads {
	public static void main(String[] args) {
		Runnable myRunnable = new MyRunnable();
		
		Thread one = new Thread(myRunnable, "Fred");
		Thread two = new Thread(myRunnable, "Lucy");
		Thread three = new Thread(myRunnable, "Ricky");
				
		one.start();
		two.start();
		three.start();
	}
}
