import java.util.*;
import java.util.concurrent.*;

public class ExecutorShutdownTest {
	
	static class Routine implements Runnable {
		private String msg = "";

		public Routine() {}
		public Routine(String msg) {
			this.msg = msg;
		}
		
		public void activeRun() {
			for (long i = 0L; i < 10000000000L; i++) {
				if (i % 1000000000L == 0) {
					System.out.println(i + ": " + Thread.currentThread().getName()
						+ " running " + msg);
				}
				if (Thread.currentThread().interrupted()) {
					System.out.println("interrupted while iterating");
					return;
				}
			}
		}

		public void sleepingRun() {
			for (long i = 0L; i < 10L; i++) {
				System.out.println(i + ": " + Thread.currentThread().getName()
						+ " running " + msg);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("interrupted while sleeping");
				}
			}
		}
		
		@Override
		public void run() {
			activeRun();
		}
	}	
	
	static class Immediate implements Runnable {
		private String msg = "";

		public Immediate() {}
		public Immediate(String msg) {
			this.msg = msg;
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()
				+ " ends immediately ");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		ex.execute(new Routine());
		ex.execute(new Immediate());
		
		//Thread.sleep(2000);
		ex.shutdown(); // nie pozwoli na uruchomienie nowych zadan
						// konczy biezace zadania (?)

		// ex.execute(new Routine()); // RejectedExecutionException
		
		try {
			
			System.out.println("start waiting");
			boolean term = ex.awaitTermination(3, TimeUnit.SECONDS);
			// czeka 3 s na zakonczenie wszystkich zadan
			System.out.println("end waiting");
		} catch (InterruptedException e) {
			// przerwany w trakcie czekania
		} finally {
			if (!ex.isTerminated()) {
				System.out.println("NOT all have finished");
				List<Runnable> unfinished = ex.shutdownNow();
				System.out.println(unfinished.size());
				for (Runnable r: unfinished) {
					System.out.println(r.getClass());
				}
			} else {
				System.out.println("all have finished");
			}
		}
	}
}
