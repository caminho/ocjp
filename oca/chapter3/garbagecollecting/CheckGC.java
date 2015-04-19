import java.util.Date;

public class CheckGC {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		System.out.println("Total JVM memory: " + 
			rt.totalMemory());
		System.out.println("Before memory: " + 
			rt.freeMemory());	
		
		Date d = null;
		for (int i = 0; i < 100000000; i++) {
			d = new Date();
			d = null;
		}
		
		System.out.println("After memory: " + 
			rt.freeMemory());
		for (int i =0; i < 4; i++) {
			rt.gc();
			System.out.println("After garbage collecting memory: " + 
			rt.freeMemory());
		}
		
	}
}