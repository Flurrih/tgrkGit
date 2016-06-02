import java.awt.GridLayout;
import java.awt.TextField;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class AddEvent extends JPanel {

	
	JLabel name1= new JLabel("Name: ");
	JLabel description1=new JLabel("Description");
	JLabel place1=new JLabel("Place: ");
	JLabel date1=new JLabel("Date: ");
	TextField name;
	TextField description;
	TextField place;
	JComboBox day;
	JComboBox month;
	JComboBox year;
	JDateChooser chose;
	
	
	AddEvent(){
			Date date = new Date("01-"+"January"+"-"+1990);
			setLayout(new GridLayout(6,1,2,2));
			name=new TextField();
			description=new TextField();
			place= new TextField();
			chose=new JDateChooser();
			add(name1);
			add(name);
			add(description1);
			add(description);
			add(place1);
			add(place);
			add(date1);
			add(chose);
			chose.setDate(date);
		}
	}