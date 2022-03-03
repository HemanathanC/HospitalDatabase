package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sql {
	public static Connection getcon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","");
		}
		catch(Exception e) {e.printStackTrace();}
		return con;
	}
}
