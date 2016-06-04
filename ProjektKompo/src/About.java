import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class About extends JPanel {

	JLabel tomek=new JLabel("Tomasz Gabryelewicz");
	JLabel rafal=new JLabel("Rafal Koper");
	JLabel opis=new JLabel("Organizer");
	
	About()
	{
		
		super();
		setLayout(new GridLayout(0,1));
		add(opis);
		add(tomek);
		add(rafal);
	}
	
}
