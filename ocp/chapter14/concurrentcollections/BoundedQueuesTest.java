import java.util.*;
import java.util.concurrent.*;

public class BoundedQueuesTest {
	
	BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3);
//	BlockingQueue<Integer> bq = new SynchronousQueue<>();
	
	public static void sleep(float s) throws InterruptedException {
		Thread.sleep((long) (s * 1000.0));
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	class Producer implements Runnable {
		@Override
		public void run() {
			try {
				print("Starting producer...");
				sleep(1);
				while (true) {
					Integer nextInt = produce();
					bq.put(nextInt);
					print("Producer: " + nextInt + " put in queue");
				}
			} catch (InterruptedException ex) {
				System.out.println("Producer interrupted");
			}
		}
		
		private Integer produce() {
			Integer nextInt = ThreadLocalRandom.current().nextInt(10, 100);
			print("Producer: next integer = " + nextInt);
			return nextInt;
		}
	}
	
	class Consumer implements Runnable {
		@Override
		public void run() {
			try {
				print("Starting consumer...");
				sleep(2);
				while (true) {
					for (int i = 0; i < 3; i++) {
						Integer nextInt = bq.take();
						consume(nextInt);
					}
					print("Consumer: processing data");
					//sleep(1);
				}
			} catch (InterruptedException ex) {
				System.out.println("Consumer interrupted");
			}
		}
		
		private void consume(Integer nextInt) {
			print("Consumer: consuming integer " + nextInt);
		}
	}
	
	public void run() {
		Thread producer = new Thread(new Producer());
		Thread consumer = new Thread(new Consumer());
		producer.start();
		consumer.start();
	}
	
	public static void main(String[] args) {
		new BoundedQueuesTest().run();
	}
}
