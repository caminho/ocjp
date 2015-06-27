
public class VarArgsTest{
   public void test(){
        test1(10, 20);  //1
   }

   public void test1(int i, int... j){ System.out.println("1"); }
   public void test1(int... i ){ System.out.println("2"); }
   public void test1(int i, int j){ System.out.println("3"); }

   public static void main(String[] args){
     new VarArgsTest().test();
   } 
}

