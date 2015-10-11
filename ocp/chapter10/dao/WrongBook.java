import java.util.*;

/* Niepoprawnie skonstruowana klasa - ma dwie odpowiedzialnosci:
	1) reprezentacja ksiazki
	2) przechowywanie w bazie danych
  które powinny byæ rozdzielone */
class Book {
	private static Map<String, Book> bookstore = 
		new HashMap<String, Book>();
	
	private String isbn;
	private String title;
	private String author;
	
	public Book(String isbn, String author, String title) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Collection<Book> findAllBooks() {
		return bookstore.values();
	}
	
	public Book findBookByIsbn(String isbn) {
		return bookstore.get(isbn);
	}
	
	public void create() {
		bookstore.put(isbn, this);
	}
	
	public void delete() {
		bookstore.remove(isbn);
	}
	
	public void update() {
		// bez operacji - dla bazy danych w pamieci aktualizacja
		// nastepuje w czasie rzeczywistym
	}
}

public class WrongBook {
	
	public static void printBooks(Collection<Book> books) {
		String format = "%10s|%20s|%20s|\n";
		System.out.printf(format, "ISBN", "Autor", "Tytul");
		System.out.printf(format, "----", "-----", "-----");
		for (Book book : books) {
			System.out.printf(format, 
				book.getIsbn(), book.getAuthor(), book.getTitle());
		}
	}
	
	public static void main(String[] args) {
		Book book1 = new Book("123", "Adam Mickiewicz", "Dziady, cz. IV");
		Book book2 = new Book("234", "Franz Kafka", "Proces");
		Book book3 = new Book("456", "Jerzy Grebosz", "Symfonia C++");
		
		book1.create();
		book2.create();
		book3.create();
		
		printBooks(book1.findAllBooks());
	}
}
