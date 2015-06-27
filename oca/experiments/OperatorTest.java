public class OperatorTest {
	public static void main(String[] args) {
		int k = 1;
		k = k + (k*=k++);
		System.out.println(k); // 2
	}
}

