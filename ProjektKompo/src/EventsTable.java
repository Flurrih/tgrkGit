import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class EventsTable extends JPanel implements ActionListener{
	
	JTable table;
	JButton refreshButton;
	JScrollPane js;
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
				super();
				
				table = new JTable(DBQuery.getAllEvents(),columnNames);
				js=new JScrollPane(table);
				js.setSize(new Dimension(550,400));
				add(js);
				
				
				
				
				
				refreshButton= new JButton("Refresh");
				refreshButton.addActionListener(this);
				
				add(refreshButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == refreshButton) 
		{
			updateData();
		}
	}

	public void updateData() {
	    
	}

	public void addNewEvent(Event event) {

		TableModel d;
		System.out.println("dd");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{event.name,event.description,event.place,event.date.toString()});
	}

}
