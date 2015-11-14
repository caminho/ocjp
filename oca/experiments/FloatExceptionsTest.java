class FloatExceptionsTest {
	public float parseFloat( String s ){
	     float f = 0.0f;      // 1
	     label1: {
		     try{
			  f = Float.valueOf( s ).floatValue();    // 2
			  break label1;//return f ;      // 3
		     }
		     catch(NumberFormatException nfe){
			f = Float.NaN ;    // 4
		       return f;     // 5
		     }
		     finally {
			 //return f;     // 6
		     }
		     //return f ;    // 7
		     System.out.println("Koniec bloku");
	     }
	     return f;
	 }
}

