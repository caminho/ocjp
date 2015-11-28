import java.sql.*;
import java.util.*;

public class TransactionTest {

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			DBInfo.url, 
			DBInfo.user, 
			DBInfo.password
		);
	}
	
	private void printExceptions(SQLException ex) {
		while (ex != null) {
			System.out.println("--- SQL EXCEPTION");
			System.out.println("SQL state: " + ex.getSQLState());
			System.out.println("Vendor error code: " + 
				ex.getErrorCode());
			System.out.println("Message: " + ex.getMessage());	
			System.out.println("toString: " + ex.toString());
			ex.printStackTrace();
			ex = ex.getNextException();
		}
	}
	
	private void insertAuthor(CallableStatement stmt, Author author)
			throws SQLException {
		System.out.println("Inserting autor: " + author);
		stmt.setInt(1, author.getAuthorId());
		stmt.setString(2, author.getFirstName());
		stmt.setString(3, author.getLastName());
		stmt.execute();
	}
	
	private void removeAllNewAuthors() {
		try (Connection conn = getConnection()) {
			
			Statement removeStmt = conn.createStatement();
			int removed = removeStmt.executeUpdate(
				"DELETE FROM Author WHERE AuthorID >= 3000");
			System.out.println("Removed: " + removed);
			removeStmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	private void printAuthors() {
		new TableReport().go("Author");
	}
	
	private void go() {
		removeAllNewAuthors();
		printAuthors();
		
		
		try (Connection conn = getConnection()) {
			
			//System.out.println(conn.getTransactionIsolation());
			conn.setTransactionIsolation(
				Connection.TRANSACTION_READ_UNCOMMITTED);
			
			// add new authors
			CallableStatement stmt = conn.prepareCall(
				"{call newAuthor(?, ?, ?)}");
			
			conn.setAutoCommit(false);
			
			insertAuthor(stmt, new Author(3001, "Tomek", "Kaminski"));
			Savepoint sp = conn.setSavepoint("tomek");
			try {
				insertAuthor(stmt, new Author(3002, "Slawek", "Piotrowski"));
				insertAuthor(stmt, new Author(3002, "Slawek", "Piotrowski"));
				
				insertAuthor(stmt, new Author(3003, "Slawek", "Piotrowski"));
			} catch (SQLException s) {
				System.out.println(s);
				conn.rollback("tomek");
			}
			insertAuthor(stmt, new Author(3004, "Piotr", "Kaminski"));
			conn.commit();
			stmt.close();
		} catch (SQLException ex) {
			printExceptions(ex);
		}
		
		printAuthors();
		removeAllNewAuthors();
	}
	
	public static void main(String[] args) {
		new TransactionTest().go();
	}
}

class Author {
    private int authorId;
    private String firstName;
    private String lastName;
	
	public Author() {}
	public Author(int id, String fName, String lName) {
		this.authorId = id;
		this.firstName = fName;
		this.lastName = lName;
	}

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	
	public String toString() {
		return "(" + authorId + ", " + firstName + ", " + lastName + ")";
	}
}
