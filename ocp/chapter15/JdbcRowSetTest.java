import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

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
            DBUtils.printResultSet(jrs);

            if (jrs.last()) {
                System.out.println("--- Removing last row");
                jrs.deleteRow();
                DBUtils.printResultSet(jrs);
            }

            if (jrs.first()) {
                System.out.println("--- Updating first row");
                jrs.updateString("firstname", "Geralt");
                jrs.updateString("lastname", "Z Rivii");
                jrs.updateRow();
                jrs.beforeFirst();
                jrs.execute();
                DBUtils.printResultSet(jrs);
            }

            System.out.println("--- Adding new row");
            jrs.moveToInsertRow();
            jrs.updateInt(1, 6002);
            jrs.updateString(2, "Angelina");
            jrs.updateString(3, "Jolie");
            jrs.insertRow();
            jrs.moveToCurrentRow();

            jrs.execute();
            DBUtils.printResultSet(jrs);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
