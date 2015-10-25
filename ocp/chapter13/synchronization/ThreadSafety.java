import java.util.*;

class NameList {
	private List<String> names = new LinkedList<String>();
		
	public void add(String name) {
		names.add(name);
	}
	
	public synchronized String removeFirst() {
		if (names.size() > 0) {
			return names.remove(0);
		} else {
			return null;
		}
	}
}

public class ThreadSafety {
	
	public static void main(String[] args) throws InterruptedException {
		final NameList list = new NameList();
		class NameDropper extends Thread {
			public void run() {
				try {
				String name = list.removeFirst();
				} catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(name);
			}
		}
		for (int i = 0; i < 1000000; i++) {			
			list.add("Ozymandias");	
			Thread t1 = new NameDropper();
			Thread t2 = new NameDropper();
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		}
	}
}