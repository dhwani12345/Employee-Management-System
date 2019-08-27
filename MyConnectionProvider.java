package employee.registration.details;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider implements MyProvider {
	
	static Connection con = null;
		
		public static Connection getConn() {
			try {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return con;
		}
}
