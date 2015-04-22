public class ConditionalTest {
	
	public static void main(String[] args) {
		int numOfPets = 3;
		String status = numOfPets < 4 ? "Pet limit not exceeded"
			: "to many pets";
		System.out.println(status);
	}
}
