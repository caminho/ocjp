import java.util.concurrent.*;

public class ThreadPoolTest {
	
	static class MyJob implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() +
				" running");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();
		System.out.println(ex.getClass());
		if (ex instanceof ThreadPoolExecutor) {
			System.out.println("Executors.newCachedThreadPool() zwraca " 
				+ "obiekty ThreadPoolExecutor");
		}
		ex = Executors.newFixedThreadPool(4);
		System.out.println(ex.getClass());
		if (ex instanceof ThreadPoolExecutor) {
			System.out.println("Executors.newFixedThreadPool() zwraca " 
				+ "obiekty ThreadPoolExecutor");
		}
		ex = Executors.newSingleThreadExecutor();
		System.out.println(ex.getClass());
		if (ex instanceof ThreadPoolExecutor) {
			System.out.println("Executors.newSingleThreadExecutor() zwraca " 
				+ "obiekt ThreadPoolExecutor");
		}
		if (ex instanceof AbstractExecutorService) {
			System.out.println("Executors.newSingleThreadExecutor() zwraca " 
				+ "obiekt AbstractExecutorService");
		}
	}
}