
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
				//uaktualnienie tego rekordu
			//System.out.println(table.rowAtPoint(arg0.getPoint())); ktory wiersz
		}
	}
	}