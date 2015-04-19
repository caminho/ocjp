public class Island {
	Island i;
	
	public static void main(String[] args) {
		Island i1 = new Island();
		Island i2 = new Island();
		Island i3 = new Island();
		
		i1.i = i2;
		i2.i = i3;
		i3.i = i1;
		
		i1 = null;
		i2 = null;
		i3 = null;
		
		// obiekt pierwotnie wskazywane przez i1, i2, i3
		// nie s¹ dostêpne przez ¿aden w¹tek -
		// kwalifikuj¹ siê do odœmiecenia
	}
}