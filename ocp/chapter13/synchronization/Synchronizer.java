public class Synchronizer extends Thread {
	
	private StringBuffer buffer;
	private Thread waitForMe;

	public Synchronizer(StringBuffer sb, Thread waitForMe) {
		this.buffer = sb;
		this.waitForMe = waitForMe;
	}
	
	public void run() {
		try {
			waitForMe.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (buffer) {
			for (int i = 0; i < 100; i++) {
				System.out.print(buffer.charAt(0));
			}
			System.out.println();
			buffer.setCharAt(0, (char) (buffer.charAt(0) + 1));
		}
	}
	
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		StringBuffer buffer = new StringBuffer("A");
		Synchronizer[] threads = {
			new Synchronizer(buffer, mainThread),
			new Synchronizer(buffer, mainThread),
			new Synchronizer(buffer, mainThread),
		};
		for (Thread t: threads) {
			t.start();
		}
		System.out.println("All threads started");
	}
	
}