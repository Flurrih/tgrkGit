import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Kalendarz extends JPanel implements ItemListener,ActionListener,MouseListener
{
 
	
	JPanel p1, p2;
    JComboBox month;
    JComboBox year;
    JButton goBack;
    Date date1= new Date();
    int actualday=date1.getDay()-3;
    
    int actualyear=1900+date1.getYear();
    static Main main;
    static AddEvent evt;
    ArrayList<JButton> buttons= new ArrayList<JButton>();
    int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String weekdays[] = {"Sun", "Mon", "Wto", "Sro", "Czw", "Fri", "Sat"}; 
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String actualmonth=months[date1.getMonth()];
    
    public Kalendarz(Main main,AddEvent evt)
    
    {	super();
    	this.main=main;
        this.evt=evt;
        
        p1 = new JPanel();
        month = new JComboBox();
        for(int i=0;i< months.length;i++)
        {
            month.addItem(months[i]);
        }
        month.addItemListener(this);
        year = new JComboBox();
        for(int i=1980;i<=2099;i++)
        {
        	
            year.addItem(new Integer(i));
       
        }
        year.addItemListener(this);
        goBack= new JButton("Go Back");
        goBack.addActionListener(this);
        p1.add(month);
        p1.add(year);
        p1.add(goBack);
       
        p2 = new JPanel();
        p2.setLayout(new GridLayout(0,7,10,10));
        Date date = new Date();
        drawCalendar(months[date.getMonth()], new Integer((1900+date.getYear())));
        year.setSelectedItem(new Integer((1900+date.getYear())));
        month.setSelectedItem(months[date.getMonth()]);
  
        add(p1);
        add(p2);
        setVisible(true);
        //addMouseListener(this);
        setSize(500,600);
 
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
    	Kalendarz frame = new Kalendarz(main,evt);
    }

    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
        	p2.removeAll();
        	p2.updateUI();
        	drawCalendar((String)month.getSelectedItem(), (Integer)year.getSelectedItem());
        	//p2.removeAll();
        }
        
 
        
    }
    
    
	public void drawCalendar(String inputMonth, Integer inputYearr)
    {
        p2.removeAll();
        p2.updateUI();
        buttons.clear();
        int inputYear=inputYearr.intValue();
        
        for(int i=0;i< weekdays.length;i++)
        {
            JLabel label = new JLabel(weekdays[i]);
            p2.add(label);
        }
        Date date = new Date("01-"+inputMonth+"-"+inputYear);
        int noOfDaysInMonth = days[date.getMonth()];
        if(date.getYear()%4==0 && date.getMonth()==1)
        {
            noOfDaysInMonth = 29;
        }

       for(int i=0;i<=noOfDaysInMonth+1;i++)
       {
    	   
    	   buttons.add(new JButton(String.valueOf(i+1)));
    	   buttons.get(i).addActionListener(this);
    	   buttons.get(i).addMouseListener(this);
       }
        
        for(int i=1, day=1;day<=noOfDaysInMonth;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(day==1)
                {
                    if(j==date.getDay())
                    {
                       
                        p2.add(buttons.get(day-1));
                        day++;
                    }
                    else
                    {
                        JLabel label = new JLabel("");
                        p2.add(label);
                    }
                }
                else
                {
                	
  
                    p2.add(buttons.get(day-1));
                    day++;
                }
                if(day>noOfDaysInMonth)
                {
                    break;
                }
            }
        }
        
      //System.out.println(actualday);
        
        if(month.getSelectedIndex()==date1.getMonth() && year.getSelectedIndex()==(date1.getYear()-80))buttons.get(actualday).setBackground(Color.RED);
        
        p2.validate();
    }
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==goBack)
		{
		  	p2.removeAll();
        	p2.updateUI();
        	drawCalendar(actualmonth, actualyear);
			month.setSelectedItem(actualmonth);
			year.setSelectedItem(actualyear);
		}
		
		
		for(int i=0;i<buttons.size();i++)
		{
			if(e.getSource()==buttons.get(i))
			{
				main.nr1.setSelectedIndex(1);
				//System.out.println(i);
				Date tmp= new Date(year.getSelectedIndex()+80,month.getSelectedIndex(),i+1);
				evt.chose.setDate(tmp);
			}
			
		}
			
			
	}
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==arg0.BUTTON3)
		{
			System.out.println("dziala :D");
			doPop(arg0);
		}
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void doPop(MouseEvent e){
        PopUpMenuCalendar menu = new PopUpMenuCalendar();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
