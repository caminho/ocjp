class MyRunnable implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Run by " + Thread.currentThread()
				.getName() + ", i = " + i);
		}
	}
}

public class MultipleThreads {
	public static void main(String[] args) {
		Runnable myRunnable = new MyRunnable();
		Thread one = new Thread(myRunnable);
		Thread two = new Thread(myRunnable);
		Thread three = new Thread(myRunnable);
		
		one.setName("Fred");
		two.setName("Lucy");
		three.setName("Ricky");
		
		one.start();
		two.start();
		three.start();
	}
}