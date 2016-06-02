import java.applet.Applet;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Main extends JApplet {

	JTabbedPane nr1;

	
	public void init()
	{
		
		nr1= new JTabbedPane();
		//nr1.setSize(1000,1000);
		nr1.add("Calendar",new Kalendarz());
		nr1.add("Add Event", new AddEvent());
		add(nr1);
		
	}
	

}
