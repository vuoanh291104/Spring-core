package springcore;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	public static void testTransaction(JDBCUtil j) {
	    Connection con = null;

	    try {
	        con = j.getConnect();
	        con.setAutoCommit(false);

	        Statement st = con.createStatement();
	        String query = "UPDATE users\n"
	                     + "SET account_balance = CASE\n"
	                     + "    WHEN ID = 1 AND account_balance >= 10000 THEN account_balance - 10000\n"
	                     + "    WHEN ID = 2 THEN account_balance + 10000\n"
	                     + "END\n"
	                     + "WHERE ID IN (1, 2);";
	        st.executeUpdate(query);
	        con.commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	        try {
	            if (con != null) con.rollback();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    } finally {
	        try {
	            if (con != null) con.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}



}
