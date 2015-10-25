class Reader extends Thread {
	Calculator c;
	
	public Reader(Calculator c) {
		this.c = c;
	}
	
	public void run() {
		synchronized (c) {
			try {
				System.out.println("waiting for calculation");
				c.wait();
			} catch (InterruptedException e) {}
			System.out.println("Total is: " + c.total);
		}
	}
}

class Calculator implements Runnable {
	int total;
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				total += i;
			}
			try { 
				Thread.sleep(2000); 
			} catch (InterruptedException e) {}
			notifyAll();
		}
	}
}

public class NotifyAllTest {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		new Reader(calc).start();
		new Reader(calc).start();
		new Reader(calc).start();
		new Thread(calc).start();
	}
}