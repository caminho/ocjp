import java.sql.*;
import java.util.*;

public class PrepareStatementTest {

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
			ex = ex.getNextException();
		}
	}

	private List<Author> createAuthors() {
		List<Author> result = new ArrayList<>();
		result.add(new Author(2000, "Tomek", "Kaminski"));
		result.add(new Author(2001, "Slawek", "Piotrowski"));
		result.add(new Author(2002, "Piotr", "Kaminski"));
		return result;
	}
	
	private void go() {
		try (Connection conn = getConnection()) {
			
			List<Author> newAuthors = createAuthors();
			
			PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO Author VALUES (?, ?, ?)");
			
			for (Author author: newAuthors) {
				stmt.setInt(1, author.getAuthorId());
				stmt.setString(2, author.getFirstName());
				stmt.setString(3, author.getLastName());
				int rows = stmt.executeUpdate();
				System.out.println(rows + " row inserted");
			}
			
			stmt.close();
		} catch (SQLException ex) {
			printExceptions(ex);
		}
	}
	
	public static void main(String[] args) {
		new PrepareStatementTest().go();
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
