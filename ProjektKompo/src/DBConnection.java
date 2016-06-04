import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	

	
	public static void connectToDatabase() throws SQLException {

	    con = DriverManager.getConnection("jdbc:mysql://localhost/KompoDB","root", "haslo123");


	    stmt = con.createStatement();
	    
	}
	
}
