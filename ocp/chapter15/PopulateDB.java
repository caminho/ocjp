import java.io.*;
import java.sql.*;
import java.util.*;
import java.nio.file.*;

public class PopulateDB {
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			DBInfo.url, 
			DBInfo.user, 
			DBInfo.password
		);
	}
	
	private void populateDBWith(List<String> sqlStatements) 
			throws SQLException {
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {
			for (String sqlStatement: sqlStatements) {
				System.out.println("Executing: " + sqlStatement);
				int rowsAffected = stmt.executeUpdate(sqlStatement);
				System.out.println("Execution complete, " 
					+ rowsAffected + " rows affected");
			}
		}
	}
	
	private List<String> readStatements(String filePath) 
			throws IOException {
		Path path = Paths.get(filePath);
		List<String> sqlStatements = new ArrayList<>();
		try (Scanner scanner = new Scanner(path)) {
			scanner.useDelimiter(";");
			while (scanner.hasNext()) {
				String statement = scanner.next()
						.replaceAll("\\s+", " ")
						.trim();
				if (statement.length() > 0) {
					sqlStatements.add(statement);
				}
			}			
		}
		return sqlStatements;
	}
	
	private void go(String filePath) {
		try {
			List<String> sqlStatements = readStatements(filePath);
			populateDBWith(sqlStatements);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java PopulateDB definition.sql");
			return;
		}
		new PopulateDB().go(args[0]);
	}
}
