import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class PopUpEdit extends JPopupMenu implements ActionListener,ItemListener {

		EditTable e;
		EventsTable asd;
	 JMenuItem addtask;
	 JMenuItem showtasks;
	 JMenuItem deletetask;
	    public PopUpEdit(EventsTable asd){
	    	this.asd=asd;
	       	showtasks=new JMenuItem("Edit task");
	       	deletetask=new JMenuItem("Delete task");
	       	add(showtasks);
	       	add(deletetask);
	       	showtasks.addActionListener(this);
	       	deletetask.addActionListener(this);
	       	
	    }
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==showtasks)
			{
				//System.out.println("Zlapalo");
			asd.e1.setVisible(true);
			}
			
			if(e.getSource()==deletetask)
			{
				DBQuery.deleteTask(asd.getSelectedEvent());
				asd.updateData();
			}
	
		}
		public void itemStateChanged(ItemEvent arg0) {
			if(arg0.getItemSelectable()==showtasks)
			{
				System.out.println("Zlapalo");
				asd.e1.setVisible(true);
				
			}
			
		}
	
}
