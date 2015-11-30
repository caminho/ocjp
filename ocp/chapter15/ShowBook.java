import java.sql.*;

public class ShowBook {

	public void go() {
		
		try (Connection conn = DBInfo.getConnection();
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
