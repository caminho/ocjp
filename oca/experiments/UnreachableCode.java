public class UnreachableCode{
   public static void main(String[] args)  {     calculate(2);    }
   public static void calculate(int x){
      String val;
      switch(x){
         case 2:
         	// break; // powoduje error: variable val might not have been initialized
         default:
         val = "def";
      }
      System.out.println(val);
   }
}

