package springcore;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.ClassEditor;



public class JDBCUtil {
	@Value("${mysql.driver}")
	private  String driver;
	@Value("${mysql.url}")
	private  String url;
	@Value("${mysql.username}")
	private  String username;
	@Value("${mysql.password}")
	private String password;
	
	private Connection c;
	
	
	
    public Connection getConnect()throws ClassNotFoundException, SQLException {
        //Connection c = null;
        //DriverManager.registerDriver(d);
        //load driver
        Class.forName(driver);
            
        c = DriverManager.getConnection(url, username, password);
        

        return c;
    }

    public void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void init() throws ClassNotFoundException, SQLException {
		getConnect();
	}

	
	public void destroy() throws SQLException {
		System.out.println("inside destroy method");
		closeConnection(c);
}
    
    public void test1() throws SQLException {
    	Statement st= c.createStatement();
    	ResultSet rs= st.executeQuery("SELECT * FROM users");
    	while(rs.next()) {
    		int id=rs.getInt(1);
    		String name=rs.getString(2);
    		String email=rs.getString(3);
    		System.out.println(id+" "+name+" "+email);
    		
    	}
    }
}
