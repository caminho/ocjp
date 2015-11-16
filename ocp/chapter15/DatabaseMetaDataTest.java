import java.sql.*;

public class DatabaseMetaDataTest {
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			DBInfo.url, 
			DBInfo.user, 
			DBInfo.password
		);
	}

	public void go() {
		
		try (Connection conn = getConnection()) {
			DatabaseMetaData dbmd = conn.getMetaData();
			
			if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				System.out.print("Supports TYPE_FORWARD_ONLY");
				if (dbmd.supportsResultSetConcurrency(
						ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_UPDATABLE)) {
					System.out.print(" and CONCUR_UPDATABLE");
				}
				System.out.println();
			}
			
			if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.print("Supports TYPE_SCROLL_INSENSITIVE");
				if (dbmd.supportsResultSetConcurrency(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
					System.out.print(" and CONCUR_UPDATABLE");
				}
				System.out.println();
			}
			
			if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.print("Supports TYPE_SCROLL_SENSITIVE");
				if (dbmd.supportsResultSetConcurrency(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
					System.out.print(" and CONCUR_UPDATABLE");
				}
				System.out.println();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DatabaseMetaDataTest().go();
	}
}
