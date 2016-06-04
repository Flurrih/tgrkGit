import java.applet.Applet;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Main extends JApplet{

	JTabbedPane nr1;
	AddEvent asd= new AddEvent();
	
	public void init()
	{
		
		setSize(500,500);
		nr1= new JTabbedPane();
	
		nr1.add("Calendar",new Kalendarz(this));
		nr1.add("Add Event", asd);
		nr1.add("About", new About());
		add(nr1);
		
	}
	

}
