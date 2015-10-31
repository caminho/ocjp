import java.util.concurrent.locks.*;

class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull  = lock.newCondition(); 
	final Condition notEmpty = lock.newCondition(); 

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length) 
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length) 
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}

public class ConditionTest {
	
	BoundedBuffer buffer = new BoundedBuffer();
	
	void sleep(double s) {
		try {
			Thread.sleep((long) (1000.0 * s));
		} catch (InterruptedException ex) {}
	}
	
	void handle(Exception e) {
		e.printStackTrace();
	}
	
	class BufferWriter implements Runnable {
		public void run() {
			while (true) {
				int x = (int) (Math.random() * 100.0);
				System.out.println(Thread.currentThread().getName() + 
					": Umieszczam liczbe " + x);
				try {
					buffer.put(x);
				} catch (InterruptedException ex) {
					handle(ex);
				}
				//sleep(0.1);
			}
		}
	}
	
	class BufferReader implements Runnable {
		public void run() {
			while (true) {
				Integer x = null;
				try {
					x = (Integer) buffer.take();
				} catch (InterruptedException ex) {
					handle(ex);
				}
				System.out.println(Thread.currentThread().getName() + 
					": Wyjalem liczbe " + x);
				//sleep(0.2);
			}
		}
	}
	
	public static void main(String[] args) {
		ConditionTest conditionTest = new ConditionTest();
		new Thread(conditionTest.new BufferWriter()).start();
		new Thread(conditionTest.new BufferReader()).start();
	}
}