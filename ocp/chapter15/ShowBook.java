import java.sql.*;

public class ShowBook {
	
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
			String query = "SELECT * from Book";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString("ISBN") + " ");
				System.out.print(rs.getDate("PubDate") + " ");
				System.out.println(rs.getInt("Price"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ShowBook().go();
	}
}
