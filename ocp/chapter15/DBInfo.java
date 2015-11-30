import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInfo {
    public static String url = "jdbc:hsqldb:file:db/booksellerdb";
    public static String user = "SA";
    public static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DBInfo.url,
                DBInfo.user,
                DBInfo.password
        );
    }
}