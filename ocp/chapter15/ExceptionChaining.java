import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExceptionChaining {

    public void go() {

        try (Connection conn = DBInfo.getConnection();
             Statement stmt = conn.createStatement()) {
            String query = "SELECT * from Book";
            ResultSet rs = stmt.executeQuery(query);
            DBUtils.printResultSet(rs);
        } catch (SQLException ex) {
            DBUtils.printExceptions(ex);
        }
    }

    public static void main(String[] args) {
        new ExceptionChaining().go();
    }
}
