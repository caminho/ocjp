import java.util.concurrent.*;

public class ExecutorTest {
	
	static class MyJob implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() +
				" running");
		}
	}
	
	static class SameThreadExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}
	
	static class NewThreadExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			new Thread(command).start();
		}
	}
	
	public static void main(String[] args) {
		Runnable job = new MyJob();
		
		Executor sameThreadExecutor = new SameThreadExecutor();
		sameThreadExecutor.execute(job);
		
		Executor newThreadExecutor = new NewThreadExecutor();
		newThreadExecutor.execute(job);
	}
}