import java.util.concurrent.*;

public class CachedThreadPoolTest {
	
	static class Routine implements Runnable {
		private String msg = "";

		public Routine() {}
		
		public Routine(String msg) {
			this.msg = msg;
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()
				+ " running " + msg);
		}
	}
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newCachedThreadPool();
	
		es.execute(new Routine());	// wykona zadanie i usunie watek z puli po 60s
	}
}
