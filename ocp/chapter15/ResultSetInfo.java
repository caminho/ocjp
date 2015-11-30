import java.sql.*;

public class ResultSetInfo {

	public void go() {
		
		try (Connection conn = DBInfo.getConnection();
				Statement stmt = conn.createStatement()) {
			String query = "SELECT AuthorID from Author";
			ResultSet rs = stmt.executeQuery(query);
			//rs.next();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			System.out.println("Column count: " + cols);
			for (int i = 1; i <= cols; i++) {
				System.out.println("Table name: " + rsmd.getTableName(i));
				System.out.println("Column name: " + rsmd.getColumnName(i));
				System.out.println("Column size: "
						+ rsmd.getColumnDisplaySize(i));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ResultSetInfo().go();
	}
}
