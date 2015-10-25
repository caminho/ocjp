class MyRunnable implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Run by " + Thread.currentThread()
				.getName() + ", i = " + i);
			if (Thread.currentThread().getName().equals("Fred")) {
				Thread.yield();
			}
		}
	}
}

public class YieldTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getPriority());
		Thread.sleep(3*1000);
		Runnable myRunnable = new MyRunnable();
		
		Thread one = new Thread(myRunnable, "Fred");
		one.setPriority(Thread.NORM_PRIORITY);
		Thread two = new Thread(myRunnable, "Lucy");
		one.setPriority(Thread.NORM_PRIORITY);
		Thread three = new Thread(myRunnable, "Ricky");
		one.setPriority(Thread.NORM_PRIORITY);
				
		one.start();
		two.start();
		one.start();
		three.start();
		
		one.join();
		two.join();
		three.join();
		
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
	}
}
