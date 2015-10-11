import java.util.*;

class Book {
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
}

interface BookDao {
	Collection<Book> findAllBooks();
	Book findBookByIsbn(String isbn);
	void create(Book book);
	void delete(Book book);
	void update(Book book);
}

class InMemoryBookDao implements BookDao {
	
	private static Map<String, Book> bookstore = 
		new HashMap<String, Book>();
	
	public Collection<Book> findAllBooks() {
		return bookstore.values();
	}
	
	public Book findBookByIsbn(String isbn) {
		return bookstore.get(isbn);
	}
	
	public void create(Book book) {
		bookstore.put(book.getIsbn(), book);
	}
	
	public void delete(Book book) {
		bookstore.remove(book.getIsbn());
	}
	
	public void update(Book book) {
		// bez operacji - dla bazy danych w pamieci aktualizacja
		// nastepuje w czasie rzeczywistym
	}
}

/* Klasa abstrakcyjna metody fabrycznej */
abstract class Factory {
	public abstract BookDao createDao();
}

/* Konkretna implementacja metody fabrycznej */
class FactoryImpl extends Factory {
	public BookDao createDao() {
		return new InMemoryBookDao();
	}
}

public class BookDaoFactory {
	
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
		Factory factory = new FactoryImpl();
		BookDao dao = factory.createDao();
		
		dao.create(new Book("123", "Adam Mickiewicz", "Dziady, cz. IV"));
		dao.create(new Book("234", "Franz Kafka", "Proces"));
		dao.create(new Book("456", "Jerzy Grebosz", "Symfonia C++"));
		
		printBooks(dao.findAllBooks());
	}
}
