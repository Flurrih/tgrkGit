
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class EditTable extends JFrame implements ActionListener {

	
	JLabel name1= new JLabel("Name: ");
	JLabel description1=new JLabel("Description: ");
	JLabel place1=new JLabel("Place: ");
	JLabel date1=new JLabel("Date: ");
	TextField name;
	TextField description;
	TextField place;
	JComboBox day;
	JComboBox month;
	JComboBox year;
	JDateChooser chose;
	JButton edittask;
	JApplet app;
	EventsTable eventsTable;
	
	Object[] selectedEvent;
	
	EditTable(){
		
			super();
		 	//this.eventsTable = eventsTable;
			edittask=new JButton("Edit");
			
			//Date date = new Date("01-"+"January"+"-"+1990);
			setLayout(new GridLayout(0,1,1,1));
			name=new TextField();
			description=new TextField();
			place= new TextField();
			chose=new JDateChooser();
			edittask.addActionListener(this);
			
				   
			add(name1);
			add(name);
			add(description1);
			add(description);
			add(place1);
			add(place);
			add(date1);
			add(chose);
			add(edittask);
			setSize(400,600);
			setVisible(false);
			//chose.setDate(date);
			
		}
	
	//public void dateChanger(int days,String month, int year)
	//{
	//	Date date= new Date(String.valueOf(days)+month+year );
	//	chose.setDate(date);
	//	
	//}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==edittask)
		{
			selectedEvent[0] = name.getText();
			selectedEvent[1] = description.getText();
			selectedEvent[2] = place.getText();
			selectedEvent[3] = DateFormat.getDateInstance().format(chose.getDate()).toString();
			
				//uaktualnienie tego rekordu
			System.out.println(selectedEvent[0] + " " + selectedEvent[1]);
			DBQuery.editEvent(selectedEvent);
			eventsTable.updateData();
			//this.setVisible(false);
		}
	}
	public void invokeEditTable(Object[] obj)
	{
		if(obj!= null)
		{
			selectedEvent = obj;
			name.setText((String) selectedEvent[0]);
			description.setText((String) selectedEvent[1]);
			place.setText((String) selectedEvent[2]);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				chose.setDate(df.parse((String) selectedEvent[3]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		
	}
	
}

	