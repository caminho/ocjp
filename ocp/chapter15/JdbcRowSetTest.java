import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;

public class JdbcRowSetTest {


	static class JdbcRowSetListener implements RowSetListener {
		
		@Override
		public void cursorMoved(RowSetEvent event) {
			// System.out.println("cursor moved");
		}
		
		@Override
		public void rowChanged(RowSetEvent event) {
			System.out.println("row changed");
			if (event.getSource() instanceof RowSet) {
				RowSet rs = (RowSet) event.getSource();
				try {
					rs.execute();
				} catch (SQLException ex) {
					System.out.println("Exception while executing");
					ex.printStackTrace();
				}
			}
		}
		
		@Override
		public void rowSetChanged(RowSetEvent event) {
			System.out.println("row set changed");
		}
	}
	
	private static String leftJustify(String s, int n) {
		if (s.length() <= n) {
			n++;
		}
		return String.format("%1$-" + n + "s", s);
	}
	
	private static void showResults(ResultSet rs) 
			throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		
		for (int i = 1; i <= cols; i++) {
			String col = leftJustify(rsmd.getColumnName(i),
				rsmd.getColumnDisplaySize(i));
				System.out.print(col);
		}
		rs.beforeFirst();
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
	}
	
	public static void main(String[] args) {
	
		RowSetListener myListener = new JdbcRowSetListener();
	
		try (JdbcRowSet jrs = RowSetProvider.newFactory()
				.createJdbcRowSet()) {
			//jrs.addRowSetListener(myListener);
			jrs.setUrl(DBInfo.url);
			jrs.setUsername(DBInfo.user);
			jrs.setPassword(DBInfo.password);
			
			
			jrs.setCommand("SELECT * FROM Author");
			
			jrs.execute();
			System.out.println("--- Before changes");
			showResults(jrs);
			
			if (jrs.last()) {
				System.out.println("--- Removing last row");
				jrs.deleteRow();
				showResults(jrs);
			}
			
			if (jrs.first()) {
				System.out.println("--- Updating first row");
				jrs.updateString("firstname", "Geralt");
				jrs.updateString("lastname", "Z Rivii");
				jrs.updateRow();
				jrs.beforeFirst();
				jrs.execute();			
				showResults(jrs);
			}
			
			System.out.println("--- Adding new row");
			jrs.moveToInsertRow();
			jrs.updateInt(1, 6002);
			jrs.updateString(2, "Angelina");
			jrs.updateString(3, "Jolie");
			jrs.insertRow();
			jrs.moveToCurrentRow();
			
			jrs.execute();			
			showResults(jrs);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}