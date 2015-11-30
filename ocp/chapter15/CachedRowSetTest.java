import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {

    public static final String SELECT_FROM_AUTHOR = "SELECT * FROM AUTHOR";

    private void go() {

        FilteredRowSet rowSet;
        try {
            rowSet = RowSetProvider.newFactory().createFilteredRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        try (Connection conn = DBInfo.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE
             )) {
            ResultSet rs = stmt.executeQuery(SELECT_FROM_AUTHOR);
            //DBUtils.printResultSet(rs);
            rowSet.populate(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {



            rowSet.setCommand(SELECT_FROM_AUTHOR);
            rowSet.setUrl(DBInfo.url);
            rowSet.setUsername(DBInfo.user);
            rowSet.setPassword(DBInfo.password);
//            rowSet.execute();

            rowSet.next();
            rowSet.updateString(2, "CCC");
            rowSet.updateString(3, "DDD");
            rowSet.updateRow();
            rowSet.acceptChanges();

            DBUtils.printResultSet(rowSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection conn = DBInfo.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE
             )) {
            ResultSet rs = stmt.executeQuery(SELECT_FROM_AUTHOR);
            DBUtils.printResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new CachedRowSetTest().go();
    }
}
