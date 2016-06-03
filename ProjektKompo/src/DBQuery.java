import java.sql.SQLException;
import java.util.Date;

public class DBQuery {

	@SuppressWarnings("unused")
	private DBConnection db;
	
	public DBQuery()
	{
		//new DBConnection(); chwilowo zakomentowane
	}
	
	public static void addEvent(String name, String desc, String place, Date date)
	{
		System.out.println(name + desc + place + date.toString());
	}
}



//Ze starego kodu przyklad
/*
public static void addNewString(String txt)
{
	try {
		stmt.executeUpdate("insert into test (txt) values ('" + txt +"');");
	} catch (SQLException sqlException) {
		sqlException.printStackTrace();
	}
}
public static void  readAll()
{
	try {
	    //stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT id, txt FROM test");
	    while (rs.next()) {
	        int x = rs.getInt("id");
	        String s = rs.getString("txt");
	        
	        System.out.println(x +" "+ s);
	    }
	} catch (SQLException sqlException) {
		sqlException.printStackTrace();
	}
}
*/