import java.sql.*;

public class ConnectDB {
	
	public void go() {
		// Dla JDBC 3.0:
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(
				DBInfo.url, 
				DBInfo.user, 
				DBInfo.password)) {
			System.out.println("connected");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ConnectDB().go();
	}
}
