public class FinalizeTest {
	
	/*
	static int counter = 0;
	{
		if (counter++ < 1000) {
			ref = new FinalizeTest();
		}
	}
	*/
	
	static int counter = 0;
	int id;
	FinalizeTest ref = null;
	
	public FinalizeTest() {
		id = counter;
		counter++;
	}
	
	@Override
	public void finalize() {
		System.out.println("usuwanie obiektu " + id);
		if (id == 0) {
			System.out.println("JVM USUNAL PIERWSZY ELEMENT!!!!!!!!!");
		}
	}
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		System.out.println("Total JVM memory: " + 
			rt.totalMemory());
		System.out.println("Before memory: " + 
			rt.freeMemory());	
		
		/*
		FinalizeTest ft = new FinalizeTest();
		ft = null;
		*/
		
		
		FinalizeTest head = new FinalizeTest();
		FinalizeTest tail = head;
		for (int i = 0; i < 10000000; i++) {
			tail.ref = new FinalizeTest();
			tail = tail.ref;
		}
		tail.ref = new FinalizeTest();
		
		System.out.println("After memory: " + 
			rt.freeMemory());
		for (int i = 0; i < 10; i++) {
			rt.gc();
			System.out.println("After garbage collecting memory: " + 
				rt.freeMemory());		
		}
		
		/*
		FinalizeTest x = head;
		do {
			System.out.println("Obiekt numer " + x.id + " zwarty i gotowy!");
			x = x.ref;
		} while (x != null);
		*/
	}
}
