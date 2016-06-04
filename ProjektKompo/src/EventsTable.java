import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class EventsTable extends JTable{
	
	
	static Object[] columnNames = {"Zdarzenie",
	        "Opis",
	        "Miejsce",
	        "Data",
	       };

	static Object[][] data= {
		    {"Spotkanie", "O prace",
		        "Lodz", "25 maja"},
		       {"Spotkanie", "O prace",
			        "Lodz", "25 maja"},
		   };
	
	
	EventsTable()
	{
				super(data,columnNames);
		
	}

}
