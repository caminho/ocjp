import java.util.*;
import java.util.concurrent.*;

class RandomInitRecursiveAction extends RecursiveAction {
	private static final int THRESHOLD = 1000;
	
	private int[] data;
	private int start;
	private int end;
	
	public RandomInitRecursiveAction(int[] data) {
		this(data, 0, data.length);
	}
	
	private RandomInitRecursiveAction(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) {
			for (int i = start; i < end; i++) {
				data[i] = ThreadLocalRandom.current().nextInt(1, 101);
			}
		} else {
			int halfWay = (start + end) >>> 1;
			invokeAll(
				new RandomInitRecursiveAction(data, start, halfWay),
				new RandomInitRecursiveAction(data, halfWay, end)
			);
		}
	}
}

class SortRecursiveAction extends RecursiveAction {
	private final static int THRESHOLD = 100000;
	
	private final int[] data;
	private final int lo;
	private final int hi;
	
	public SortRecursiveAction(int[] data) {
		this(data, 0, data.length);
	}
	
	private SortRecursiveAction(int[] data, int lo, int hi) {
		this.data = data;
		this.lo = lo;
		this.hi = hi;
	}
	
	@Override
	protected void compute() {
		if (hi - lo <= THRESHOLD ) {
			Arrays.sort(data, lo, hi);
		} else {
			final int mid = (hi + lo) >>> 1;
			invokeAll(new SortRecursiveAction(data, lo, mid),
					  new SortRecursiveAction(data, mid, hi));
			merge(mid);
		}
	}
	
	private void merge(final int mid) {
		if (data[mid-1] <= data[mid]) {
			return;
		}
		int[] tmp = new int[hi - lo];
		int l = lo, h = mid, i = 0;
		while (l < mid && h < hi) {
			if (data[l] < data[h]) {
				tmp[i++] = data[l++];
			} else if (data[l] > data[h]) {
				tmp[i++] = data[h++];
			} else {
				tmp[i++] = data[l++];
				tmp[i++] = data[h++];
			}
		}
		if (l != mid) {
			System.arraycopy(data, l, tmp, i, tmp.length - i);
		} else if (h != hi) {
			System.arraycopy(data, h, tmp, i, tmp.length - i);
		}
		System.arraycopy(tmp, 0, data, lo, tmp.length);
	}
}

public class ForkJoinSortTest {
	public static void main(String[] args) {
		int[] data = new int[90_000_000];
		
		ForkJoinPool fjPool = new ForkJoinPool();
		
		fjPool.invoke(new RandomInitRecursiveAction(data));
		System.out.println("Init");
		
		fjPool.invoke(new SortRecursiveAction(data));
		System.out.println("Sort");
	}
}
