public class Book {
	private String title;
	
	public String getTitle() {
		return title;
	}
	
	public static void main(String[] args) {
		Book b = new Book();
		System.out.println("The title is " + b.getTitle());
	}
}
