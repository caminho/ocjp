import java.sql.*;
import java.util.*;

public class CallableStatementTest {

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

	private List<Author> createAuthors() {
		System.out.println("Adding new authors");
		List<Author> result = new ArrayList<>();
		result.add(new Author(3000, "Tomek", "Kaminski"));
		result.add(new Author(3001, "Slawek", "Piotrowski"));
		result.add(new Author(3002, "Piotr", "Kaminski"));
		return result;
	}
	
	private void go() {
		try (Connection conn = getConnection()) {
			
			Statement removeStmt = conn.createStatement();
			int removed = removeStmt.executeUpdate(
				"DELETE FROM Author WHERE AuthorID IN (3000, 3001, 3002)");
			System.out.println("Removed: " + removed);
			removeStmt.close();
			
			// add new authors
			CallableStatement stmt = conn.prepareCall(
				"{call newAuthor(?, ?, ?)}");
			
			for (Author author: createAuthors()) {
				stmt.setInt(1, author.getAuthorId());
				stmt.setString(2, author.getFirstName());
				stmt.setString(3, author.getLastName());
				boolean result = stmt.execute();
				System.out.println(result + " returned");
			}
			
			// get max price of books by given author
			stmt = conn.prepareCall(
				//"{? = call maxBookPriceOfAuthor(?)}",
				"{call maxBookPriceOfAuthor(?)}",
				ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY
			);
			
			int authorId = 1000;
			//stmt.registerOutParameter(1, java.sql.Types.DOUBLE);
			//stmt.setInt(2, authorId);
			stmt.setInt(1, authorId);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			rs.next();
			
			System.out.println("Max book price for author with id = " + authorId + 
					": " + rs.getDouble(1));
			
			stmt.close();
		} catch (SQLException ex) {
			printExceptions(ex);
		}
	}
	
	public static void main(String[] args) {
		new CallableStatementTest().go();
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
}
