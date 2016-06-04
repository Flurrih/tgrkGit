import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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


public class AddEvent extends JPanel implements ActionListener {

	
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
	JButton addtask;
	JApplet app;
	EventsTable eventsTable;
	AddEvent(EventsTable eventsTable){
		
			
		 	this.eventsTable = eventsTable;
			addtask=new JButton("Add Task");
			
			//Date date = new Date("01-"+"January"+"-"+1990);
			setLayout(new GridLayout(0,1,1,1));
			name=new TextField();
			description=new TextField();
			place= new TextField();
			chose=new JDateChooser();
			addtask.addActionListener(this);
			
				   
			add(name1);
			add(name);
			add(description1);
			add(description);
			add(place1);
			add(place);
			add(date1);
			add(chose);
			add(addtask);
			
			//chose.setDate(date);
			
		}
	
	//public void dateChanger(int days,String month, int year)
	//{
	//	Date date= new Date(String.valueOf(days)+month+year );
	//	chose.setDate(date);
	//	
	//}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addtask)
		{
			Event event = new Event(name.getText(), description.getText(), place.getText(), chose.getDate());
			//Date date = new Date("01-"+inputMonth+"-"+inputYear);
			//Date date = new Date(, Integer.parseInt(month.getSelectedItem().toString()) , Integer.parseInt(year.getSelectedItem().toString()));
			DBQuery.addEvent(event);
			//System.out.println(strDate);
			//name.getText()  // pobieranie nazwy wydarzenia z textfieladu
			// dodanie do bazy danych rekordu, nowego eventu
			eventsTable.addNewEvent(event);
		}
	}
	}