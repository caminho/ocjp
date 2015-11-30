import java.sql.*;

public class RowCountTest {

	public void go() {
		
		try (Connection conn = DBInfo.getConnection();
				Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE
				)) {
					
			String query = "SELECT * from Book";
			ResultSet rs = stmt.executeQuery(query);
			
			int rowsCount = DBUtils.getRowCount(rs);
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
