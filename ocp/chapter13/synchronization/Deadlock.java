class Resource {
	public int value;
}

public class Deadlock {
	
	private Resource a = new Resource();
	private Resource b = new Resource();
	
	public int read() {
		synchronized (a) {
			synchronized (b) {
				return a.value + b.value;
			}
		}
	}
	
	public void write(int a, int b) {
		synchronized (this.b) {
			synchronized (this.a) {
				this.a.value = a;
				this.b.value = b;
			}
		}
	}
	
	static class Worker extends Thread {
		private Deadlock manager;
		
		public Worker(Deadlock manager) {
			this.manager = manager;
		}
		
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				System.out.println(getName() + " pisze: " + (i+i));
				manager.write(i, i);
				int res = manager.read();
				System.out.println(getName() + " czyta: " + res);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Deadlock manager = new Deadlock();
		Thread t1 = new Worker(manager);
		Thread t2 = new Worker(manager);
		t1.start();
		t2.start();
		System.out.println("watki: start!");
		t1.join();
		t2.join();
		System.out.println("szczesliwy koniec:)");
	}
}