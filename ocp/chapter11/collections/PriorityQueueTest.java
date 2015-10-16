import java.util.*;

public class PriorityQueueTest {
	public static void main(String[] args) {
		int[] ia = {1, 5, 3, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		for (int x: ia) {
			pq1.offer(x);
		}
		
		for (int x: ia) {
			System.out.print(pq1.poll() + " ");
		}
		System.out.println();
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, 
			new Comparator<Integer>() {
				public int compare(Integer a, Integer b) {
					return b - a;
				}
			}
		);
		
		for (int x: ia) {
			pq2.offer(x);
		}
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		
		for (int x: ia) {
			System.out.print(pq2.poll() + " ");
		}
	}	
}
