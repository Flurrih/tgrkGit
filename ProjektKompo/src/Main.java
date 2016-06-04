import java.applet.Applet;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Main extends JApplet{

	public JTabbedPane nr1;
	
	public EventsTable nr2= new EventsTable(new EditTable());
	public AddEvent asd= new AddEvent(nr2);
	
	public void init()
	{
		
		setSize(500,500);
		nr1= new JTabbedPane();
	
		nr1.add("Calendar",new Kalendarz(this,asd));
		nr1.add("Add Event", asd);
		nr1.add("Events", nr2);
		nr1.add("About", new About());
		add(nr1);
		
	}
	
}
