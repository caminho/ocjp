public class GarbageTruck {
	public static void main(String[] args) {
		// 1)
		StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb);
		// sb nie kwalifikuje siê jeszcze do odœmiecenia
		sb = null;
		// teraz GC mo¿e usun¹æ obiekt z pamiêci
		
		// 2)
		StringBuffer s1 = new StringBuffer("hello");
		StringBuffer s2 = new StringBuffer("goodbye");
		System.out.println(s1);
		// s1 nie kwalifikuje siê jeszcze do odœmiecenia
		s1 = s2;
		// teraz GC mo¿e usun¹æ obiekt z pamiêci
		
		// 3)
		Date d = getDate();
		// rob cos...
		System.out.println("d = " + d);
	}
	
	public static Date getDate() {
		Date d2 = new Date();
		StringBuffer now = new StringBuffer(d2.toString());
		System.out.println(now);
		// obiekt StringBuffer kwalifikuje sie do odœmiecania
		// po wywo³aniu metody
		return d2;
		// obiekt Date nie kwalifikuje siê do odœmiecania
		// - referencja jest zwracana po powrocie
		// i u¿ywana dalej (nie jest zerowana)
	}
}