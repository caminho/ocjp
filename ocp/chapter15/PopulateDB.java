import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PopulateDB {

    private void populateDBWith(List<String> sqlStatements)
            throws SQLException {
        try (Connection conn = DBInfo.getConnection();
             Statement stmt = conn.createStatement()) {
            for (String sqlStatement : sqlStatements) {
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
            scanner.useDelimiter(";;");
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
