import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionTest {

    private void insertAuthor(CallableStatement stmt, Author author)
            throws SQLException {
        System.out.println("Inserting autor: " + author);
        stmt.setInt(1, author.getAuthorId());
        stmt.setString(2, author.getFirstName());
        stmt.setString(3, author.getLastName());
        stmt.execute();
    }

    private void removeAllNewAuthors() {
        try (Connection conn = DBInfo.getConnection()) {

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


        try (Connection conn = DBInfo.getConnection()) {

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
                conn.rollback(sp);
            }
            insertAuthor(stmt, new Author(3004, "Piotr", "Kaminski"));
            conn.commit();
            stmt.close();
        } catch (SQLException ex) {
            DBUtils.printExceptions(ex);
        }

        printAuthors();
        removeAllNewAuthors();
    }

    public static void main(String[] args) {
        new TransactionTest().go();
    }
}

