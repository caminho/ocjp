import java.util.*;
import java.util.concurrent.*;

class FindMaxRecursiveTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 2;
	
	private int[] data;
	private int start;
	private int end;
	private boolean divideTasks = true;
	
	public FindMaxRecursiveTask(int[] data) {
		this(data, 0, data.length);
	}
	
	public FindMaxRecursiveTask(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		if (end - start <= THRESHOLD) {
			// obliczenia wlasciwe
			int max = data[start];
			for (int i = start + 1; i < end; i++) {
				if (data[i] > max) {
					max = data[i];
				}
			}
			return max;
		} else {
			int halfWay = (end - start) / 2 + start; 
			
			// lewa polowa
			FindMaxRecursiveTask leftJob = new FindMaxRecursiveTask(
				data, start, halfWay);
			leftJob.fork();
			
			// prawa polowa
			FindMaxRecursiveTask rightJob = new FindMaxRecursiveTask(
				data, halfWay, end);
			
			// obliczamy obie
			Integer rightValue = rightJob.compute();
			Integer leftValue = leftJob.join();
			
			if (leftValue >= rightValue) {
				return leftValue;
			} else {
				return rightValue;
			}
		}
	}
	
	public void setDivideTasks(boolean v) {
		this.divideTasks = v;
	}
}

class RandomInitRecursiveAction extends RecursiveAction {
	private static final int THRESHOLD = 2;
	
	private int[] data;
	private int start;
	private int end;
	private boolean divideTasks = true;
	
	public RandomInitRecursiveAction(int[] data) {
		this(data, 0, data.length);
	}
	
	public RandomInitRecursiveAction(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected void compute() {
		if (!divideTasks || (end - start <= THRESHOLD)) {
			// obliczenia wlasciwe
			for (int i = start; i < end; i++) {
				data[i] = ThreadLocalRandom.current().nextInt(1, 101);
			}
		} else {
			int halfWay = ((end - start) / 2) + start;
			
			// lewa polowa
			RandomInitRecursiveAction leftSide = new RandomInitRecursiveAction(
				data, start, halfWay);
			leftSide.fork();
			
			// prawa polowa
			RandomInitRecursiveAction rightSide = new RandomInitRecursiveAction(
				data, halfWay, end);
			rightSide.compute();
			
			// oczekiwanie/przetwarzanie lewej polowy
			leftSide.join();
		}
	}
	
	public void setDivideTasks(boolean v) {
		this.divideTasks = v;
	}
}

public class ForkJoinPoolTest {
	
	public static void main(String[] args) {
		int[] data = new int[10];
		System.out.println("Tworzenie puli");
		ForkJoinPool fjPool = new ForkJoinPool(8);
		
		System.out.println("Inicjalizacja");
		RandomInitRecursiveAction initAction = new RandomInitRecursiveAction(data);
		initAction.setDivideTasks(true);
		fjPool.invoke(initAction);
		System.out.println(Arrays.toString(data));
		
		System.out.println("FindMax");
		FindMaxRecursiveTask findMaxTask = new FindMaxRecursiveTask(data);
		findMaxTask.setDivideTasks(true);
		Integer max = fjPool.invoke(findMaxTask);
		System.out.println(max);
	}
}
