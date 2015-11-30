import java.sql.*;

public class ClosingConnectionTest {

	public void go() {
		
		try (Connection conn = DBInfo.getConnection();
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE
					)) {
			
			String query = "SELECT * from Book";
			ResultSet rs = stmt.executeQuery(query);
			DBUtils.printWarnings(stmt.getWarnings());
			DBUtils.printResultSet(rs);
		} catch (SQLException ex) {
			DBUtils.printExceptions(ex);
			for (Throwable throwable: ex.getSuppressed()) {
				if (throwable instanceof SQLException) {
					DBUtils.printExceptions((SQLException) throwable);
				} else {
					throwable.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ClosingConnectionTest().go();
	}
}
