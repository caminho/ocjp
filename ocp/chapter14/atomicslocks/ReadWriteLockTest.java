import java.util.*;
import java.util.concurrent.locks.*;

class MaxValueCollection {
	private List<Integer> integers = new ArrayList<>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public void add(Integer value) {
		rwl.writeLock().lock();  // jeden watek naraz
		try {
			integers.add(value);
		} finally {
			rwl.writeLock().unlock();
		}
	}
	public Integer max() {
		rwl.readLock().lock();
		try {
			if (integers.size() > 0)
				return Collections.max(integers);
			return null;
		} finally {
			rwl.readLock().unlock();
		}
	}
}

public class ReadWriteLockTest {
	
	private MaxValueCollection collection = new MaxValueCollection();
	
	class AddingWorker implements Runnable {		
		private int cF = (int) (Math.random() * 100.0);
		public void run() {
			for (int i = 0; i < 10; i++) {
				int value = i*cF;
				System.out.println(Thread.currentThread().getName() 
					+ ": adding " + value);
				collection.add(value);
			}
		}
	}
	
	class SummaryWorker implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				Integer max = collection.max();
				System.out.println(Thread.currentThread().getName() 
					+ ": current max = " + max);
			}
		}
	}
	
	public void go() {
		Thread[] threads = {
			new Thread(new AddingWorker()),
			new Thread(new AddingWorker()),
			new Thread(new AddingWorker()),
		};
		Thread summarizer = new Thread(new SummaryWorker(), "Summarizer");
		
		for (Thread thread: threads) {
			thread.start();
		}
		summarizer.start();
	}
	
	public static void main(String[] args) {
		new ReadWriteLockTest().go();
	}
}
