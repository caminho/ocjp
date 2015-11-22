import java.sql.*;

public class RowCountTest {
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			DBInfo.url, 
			DBInfo.user, 
			DBInfo.password
		);
	}

	private int getRowCount(ResultSet rs) throws SQLException {
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
	
	public void go() {
		
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE
				)) {
					
			String query = "SELECT * from Book";
			ResultSet rs = stmt.executeQuery(query);
			
			int rowsCount = getRowCount(rs);
			System.out.println(query);
			System.out.println("rows count: " + rowsCount);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RowCountTest().go();
	}
}
