import java.sql.*;

public class PrintWarnings {
	
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
	
	private void printExceptions(SQLException ex) {
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
	
	private void printWarnings(SQLWarning warn) {
		while (warn != null) {
			System.out.println("--- SQL WARNING");
			System.out.println("SQL state: " + warn.getSQLState());
			System.out.println("Vendor error code: " + 
				warn.getErrorCode());
			System.out.println("Message: " + warn.getMessage());
			warn = warn.getNextWarning();
		}
	}
	
	public void go() {
		
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE
					)) {
			
			String query = "SELECT * from Book";
			
			ResultSet rs = stmt.executeQuery(query);
			printWarnings(stmt.getWarnings());
			
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
			printExceptions(ex);
		}
	}
	
	public static void main(String[] args) {
		new PrintWarnings().go();
	}
}
