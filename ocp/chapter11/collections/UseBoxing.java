import java.util.*;

public class UseBoxing {
	
	public static void main(String[] args) {
		UseBoxing ub = new UseBoxing();
		System.out.println(ub.go(5));
	}
	
	boolean go(Integer i) {
		Boolean ifSo = true;
		Short s = 300;
		if (ifSo) {
			System.out.println(++s);
		}
		return !ifSo;
	}
}
