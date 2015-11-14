
interface I1 {}
interface I2 {}

class A implements I1,I2 {}

public class MostSpecificType{

   public void method(Object o){
      System.out.println("Object Version");
   }
   public void method(java.io.FileNotFoundException s){
      System.out.println("java.io.FileNotFoundException Version");
   }
   public void method(java.io.IOException s){
      System.out.println("IOException Version");
   }
//   public void method(String s){		// wprowadza niejednoznacznosc przy wywolaniu tc.method(null)
//      System.out.println("String Version");
//   }
   
   
   public void doIStuff(I1 i1) {
      System.out.println("I1 Version");
   }
   public void doIStuff(I2 i2) {
      System.out.println("I2 Version");
   }
   
   public void test1(int i, int... j){ System.out.println("1"); }
   public void test1(int... i ){ System.out.println("2"); }
   public void test1(int i, int j){ System.out.println("3"); }
   
   void probe(int... x) { System.out.println("In ..."); }  //1
    
    void probe(Integer x) { System.out.println("In Integer"); } //2
    
    void probe(long x) { System.out.println("In long"); } //3 
    
   // void probe(Long x) { System.out.println("In LONG"); } //4
   
   
   public static void main(String args[]){
   
      MostSpecificType tc = new MostSpecificType();
      
      
      Integer a = 4; tc.probe(a); //5
      int b = 4; tc.probe(b); //6
      
      
      
      
      
      
      
      
      
      
   //   tc.method(null); // wypisze java.io.FileNotFoundException Version
      
      // tc.doIStuff(new A());  // niejednoznacznosc przy wywolaniu tc.doIStuff(null)
      
      //tc.test1(1); // niejednoznacznosc - drugi argument to pusta lista var-args
     // tc.test1(1, 2); // 3 - parametry scisle pasuja do sygnatury void test1(int i, int j)
      //tc.test1(1, 2, 3); // niejednoznacznosc
   }
}

abstract class CheckAbstractConstructor {

	CheckAbstractConstructor(){}
}

