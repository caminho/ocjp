import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowCustomers {

    public void go() {
        try (Connection conn = DBInfo.getConnection();
             Statement stmt = conn.createStatement()) {
            String query = "SELECT * from Customer";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("CustomerID") + " ");
                System.out.print(rs.getString("FirstName") + " ");
                System.out.print(rs.getString("LastName") + " ");
                System.out.print(rs.getString("EMail") + " ");
                System.out.println(rs.getString("phone"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ShowCustomers().go();
    }
}
