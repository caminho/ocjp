import java.util.concurrent.*;

public class ScheduledThreadPoolTest {

	static class Routine implements Runnable {
		
		private String msg;
		
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
		ScheduledExecutorService scheduledThreadPool = 
				Executors.newScheduledThreadPool(4);
		
		scheduledThreadPool.schedule(
				new Routine("once"), 1, TimeUnit.SECONDS);
		scheduledThreadPool.scheduleAtFixedRate(
				new Routine("every second"), 2, 1, TimeUnit.SECONDS);
		
		
	}
}