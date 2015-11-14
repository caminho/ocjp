import java.sql.*;

public class ShowCustomers {


	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			DBInfo.url, 
			DBInfo.user, 
			DBInfo.password
		);
	}

	public void go() {
		
		try (Connection conn = getConnection();
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
