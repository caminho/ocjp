class A1{
  static int i = 10;
  static { System.out.println("A1 Loaded "); }
}
public class A{
  static { System.out.println("A Loaded "); }
  public static void main(String[] args){
    System.out.println(" A should have been loaded");
    A1 a1 = null;
    System.out.println(" A1 should not have been loaded");
    System.out.println(a1.i);
  }
}


