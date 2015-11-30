import java.sql.*;

public class TableReport {


	public void go(String table) {
		
		try (Connection conn = DBInfo.getConnection();
				Statement stmt = conn.createStatement()) {
					
			String query = "SELECT * from " + table;
			ResultSet rs = stmt.executeQuery(query);

			DBUtils.printResultSet(rs);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) 
			return;
		new TableReport().go(args[0]);
	}
}
