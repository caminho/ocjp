import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintWarnings {

    public void go() {

        try (Connection conn = DBInfo.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE
             )) {

            String query = "SELECT * from Book";

            ResultSet rs = stmt.executeQuery(query);
            DBUtils.printWarnings(stmt.getWarnings());

            DBUtils.printResultSet(rs);
        } catch (SQLException ex) {
            DBUtils.printExceptions(ex);
        }
    }

    public static void main(String[] args) {
        new PrintWarnings().go();
    }
}
