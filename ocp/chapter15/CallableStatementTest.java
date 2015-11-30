import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CallableStatementTest {

    private List<Author> createAuthors() {
        System.out.println("Adding new authors");
        List<Author> result = new ArrayList<>();
        result.add(new Author(3000, "Tomek", "Kaminski"));
        result.add(new Author(3001, "Slawek", "Piotrowski"));
        result.add(new Author(3002, "Piotr", "Kaminski"));
        return result;
    }

    private void go() {
        try (Connection conn = DBInfo.getConnection()) {

            Statement removeStmt = conn.createStatement();
            int removed = removeStmt.executeUpdate(
                    "DELETE FROM Author WHERE AuthorID IN (3000, 3001, 3002)");
            System.out.println("Removed: " + removed);
            removeStmt.close();

            // add new authors
            CallableStatement stmt = conn.prepareCall(
                    "{call newAuthor(?, ?, ?)}");

            for (Author author : createAuthors()) {
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
            DBUtils.printExceptions(ex);
        }
    }

    public static void main(String[] args) {
        new CallableStatementTest().go();
    }
}


