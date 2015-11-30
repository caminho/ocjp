import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DBUtils {
    public static void printExceptions(SQLException ex) {
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

    public static void printWarnings(SQLWarning warn) {
        while (warn != null) {
            System.out.println("--- SQL WARNING");
            System.out.println("SQL state: " + warn.getSQLState());
            System.out.println("Vendor error code: " +
                    warn.getErrorCode());
            System.out.println("Message: " + warn.getMessage());
            warn = warn.getNextWarning();
        }
    }

    public static String leftJustify(String s, int n) {
        if (s.length() <= n) {
            n++;
        }
        return String.format("%1$-" + n + "s", s);
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();

        for (int i = 1; i <= cols; i++) {
            String col = leftJustify(rsmd.getColumnName(i),
                    rsmd.getColumnDisplaySize(i));
            System.out.print(col);
        }
        System.out.println();
        rs.beforeFirst();
        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                String colData = null;
                if (rs.getObject(i) != null) {
                    colData = rs.getObject(i).toString();
                } else {
                    colData = "NULL";
                }
                String col = leftJustify(colData,
                        rsmd.getColumnDisplaySize(i));
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static int getRowCount(ResultSet rs) throws SQLException {
        int rowCount = -1;
        int currRow = 0;

        if (rs != null) {

            currRow = rs.getRow();
            if (rs.isAfterLast()) {
                currRow = -1;
            }

            if (rs.last()) {
                rowCount = rs.getRow();
                if (currRow == -1) {
                    rs.afterLast();
                } else if (currRow == 0) {
                    rs.beforeFirst();
                } else {
                    rs.absolute(currRow);
                }
            }
        }
        return rowCount;
    }
}
