import java.text.DateFormat;
import java.util.Date;

public class Event {
	String name;
	String description;
	String place;
	Date date;
	
	public Event(String name,String desc,String place,Date date)
	{
		this.name = name;
		this.description = desc;
		this.place = place;
		this.date = date;
	}
	
	public String toString()
	{
		return name + " " + description + " " + place + " " + " " + DateFormat.getDateInstance().format(date);
		
	}
}
