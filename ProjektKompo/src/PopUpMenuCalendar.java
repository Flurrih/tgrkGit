import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class PopUpMenuCalendar extends JPopupMenu implements ActionListener {

	 JMenuItem addtask;
	 JMenuItem showtasks;
	    public PopUpMenuCalendar(){
	       	showtasks=new JMenuItem("Show Tasks");
	       	add(showtasks);
	       	
	    }
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==showtasks)
			{
			// nr1. switch
		}
	
}
}