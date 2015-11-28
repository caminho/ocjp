import java.sql.*;

public class TableReport {
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			DBInfo.url, 
			DBInfo.user, 
			DBInfo.password
		);
	}

	private String leftJustify(String s, int n) {
		if (s.length() <= n) {
			n++;
		}
		return String.format("%1$-" + n + "s", s);
	}
	
	public void go(String table) {
		
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {
					
			String query = "SELECT * from " + table;
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			
			for (int i = 1; i <= cols; i++) {
				String col = leftJustify(rsmd.getColumnName(i),
					rsmd.getColumnDisplaySize(i));
					System.out.print(col);
			}
			System.out.println();
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
