import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() throws InterruptedException {
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for (int i = 1; i <= count; i++) {
			System.out.println(Thread.currentThread().getName() + " running");
			
			Thread.sleep(200);
		}
		//throw new MyException();
		return count;
	}
}

public class CallableTest {
	public static void main(String[] args) {
		Callable<Integer> task = new MyCallable();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<Integer> future = executor.submit(task);
		
		try {
			Integer result = future.get(); // zablokowany az do zakonczenia zadania
			System.out.println("Counted " + result + " times");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		executor.shutdown();
	}
}