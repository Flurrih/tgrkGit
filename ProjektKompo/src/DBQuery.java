import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class DBQuery {

	@SuppressWarnings("unused")
	private static DBConnection db;
	
	@SuppressWarnings("static-access")
	public DBQuery()
	{
		new DBConnection();
		
	}
	
	@SuppressWarnings("static-access")
	public static void addEvent(Event ev)
	{
		try {
			db.connectToDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			db.stmt.executeUpdate("insert into events (name,description,place,date) values ('" + ev.name +"','" + ev.description + "','" + ev.place + "','" + DateFormat.getDateInstance().format(ev.date) +"');");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		getAllEvents(); // to delete
	}
	
	@SuppressWarnings("static-access")
	public static List<Event> getAllEvents()
	{

		try {
		    db.rs = db.stmt.executeQuery("SELECT * FROM events");
		    while (db.rs.next()) {
		        String n = db.rs.getString("name");
		        String d = db.rs.getString("description");
		        String p = db.rs.getString("place");
		        Date dat = db.rs.getDate("date");
		        
		        Event event = new Event(n,d,p,dat);
		        System.out.println(event.toString());
		    }
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return null;
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