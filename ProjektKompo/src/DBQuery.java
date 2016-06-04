import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
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
	public static Object[][] getAllEvents()
	{

		ArrayList<Event> events = new ArrayList<Event>();
		try {
			db.connectToDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
		    db.rs = db.stmt.executeQuery("SELECT * FROM events");
		    while (db.rs.next()) {
		        String n = db.rs.getString("name");
		        String d = db.rs.getString("description");
		        String p = db.rs.getString("place");
		        Date dat = db.rs.getDate("date");
		        
		        Event event = new Event(n,d,p,dat);
		        events.add(event);
		        System.out.println(event.toString());
		    }
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		Object[][] ret = new Object[events.size()][][];

		ret[0][0] = "Fsdsfsd";
		//ret[0][0] = events.get(0).name;
		
		System.out.println((String)ret[0][0]);
	/*	for(int i = 0; i < events.size(); i++)
		{
			ret[i][0] = events.get(i).name;
			ret[i][1] = events.get(i).description;
			ret[i][2] = events.get(i).place;
			ret[i][3] = events.get(i).date;
			
			System.out.println(ret[i][0]);
		}
*/
		
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