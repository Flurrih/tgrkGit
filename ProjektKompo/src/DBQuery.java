import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class DBQuery {

	@SuppressWarnings("unused")
	private static DBConnection db;
	
	public DBQuery()
	{
		new DBConnection();
	}
	
	@SuppressWarnings("static-access")
	public static void addEvent(String name, String desc, String place, Date date)
	{
		System.out.println(name + desc + place + DateFormat.getDateInstance().format(date));
		/*
		try {
			//db.stmt.executeUpdate("insert into events (name,description,place,date) values ('" + txt +"');");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}*/
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