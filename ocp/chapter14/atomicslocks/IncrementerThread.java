import java.text.*;
import java.util.*;
import java.util.concurrent.atomic.*;

class Stoper {
	private long start;
	private long stop;
	private NumberFormat numFormat;
	private String result;
	
	public Stoper() {
		numFormat = NumberFormat.getInstance();
		numFormat.setMaximumFractionDigits(3);
	}
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void stop() {
		stop = System.currentTimeMillis();
		result = numFormat.format((stop - start) / 1000.0) + "s";
	}
	
	public String getTime() {
		return result;
	}
}

class MyAtomicLong {
	private volatile long value = 0;
	
	public MyAtomicLong() {}
	
	public MyAtomicLong(long value) {
		set(value);
	}
	
	public void set(long value) {
		this.value = value;
	}
	public long get() {
		return value;
	}
	
	public long longValue() {
		return value;
	}
	
	public boolean compareAndSet(long expected, long updated) {
		long current = value;
		if (current == expected) {
			value = updated;
			return true;
		}
		return false;
	}
	
	public long getAndIncrement() {
		while (true) {
			long current = value;
			long next = current + 1;
			if (compareAndSet(current, next)) {
				return current;
			}
		}
	}
	
	public long incrementAndGet() {
		while (true) {
			long current = value;
			long next = current + 1;
			if (compareAndSet(current, next)) {
				return next;
			}
		}
	}
}

class Counter {
	private AtomicLong count = new AtomicLong();
	
	public  void increment() {
		count.getAndIncrement();
	}
	
	public long getValue() {
		return count.longValue();
	}
}

public class IncrementerThread extends Thread {
	
	private Counter counter;
	
	public IncrementerThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		for (int i = 0; i < 20000000; i++) {
			counter.increment();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Stoper stoper = new Stoper();
		Counter counter = new Counter();
		IncrementerThread[] threads = new IncrementerThread[4];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new IncrementerThread(counter);
		}
		stoper.start();
		for (Thread t: threads) {
			t.start();
		}
		
		for (Thread t: threads) {
			t.join();
		}
		stoper.stop();
		
		System.out.println(counter.getValue());
		System.out.println("time: " + stoper.getTime());
	}
}