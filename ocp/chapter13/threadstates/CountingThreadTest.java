class CountingThread extends Thread {
	{
		setName("CountingThread");
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				System.out.println(getName() + ": current counter = "
					+ i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}

public class CountingThreadTest {
	public static void main(String[] args) {
		Thread countingThread = new CountingThread();
		countingThread.start();
	}
}