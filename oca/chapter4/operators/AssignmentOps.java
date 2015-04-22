public class AssignmentOps {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		String status = b >= 4? 
				a > 8 ? "Pet limit on the edge"
					: "too many pets"		
			: "Pet count Ok" 
				 ;
		System.out.println(status);
	}
}