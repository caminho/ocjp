import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementTest {

    private List<Author> createAuthors() {
        List<Author> result = new ArrayList<>();
        result.add(new Author(2000, "Tomek", "Kaminski"));
        result.add(new Author(2001, "Slawek", "Piotrowski"));
        result.add(new Author(2002, "Piotr", "Kaminski"));
        return result;
    }

    private void go() {
        try (Connection conn = DBInfo.getConnection()) {

            List<Author> newAuthors = createAuthors();

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Author VALUES (?, ?, ?)");

            for (Author author : newAuthors) {
                stmt.setInt(1, author.getAuthorId());
                stmt.setString(2, author.getFirstName());
                stmt.setString(3, author.getLastName());
                int rows = stmt.executeUpdate();
                System.out.println(rows + " row inserted");
            }

            stmt.close();
        } catch (SQLException ex) {
            DBUtils.printExceptions(ex);
        }
    }

    public static void main(String[] args) {
        new PrepareStatementTest().go();
    }
}

