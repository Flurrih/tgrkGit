import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;


public class EventsTable extends JPanel implements ActionListener,MouseListener{
	
	JTable table;
	JButton refreshButton;
	static JButton a1=new JButton("Edit");
	static JButton a2=new JButton("Edit");
	
	JScrollPane js;
	static Object[] columnNames = {"Zdarzenie",
	        "Opis",
	        "Miejsce",
	        "Data",
	       };

	EditTable e1;
	DefaultTableModel model = new DefaultTableModel(data, columnNames);

	
	static Object[][] data= {
		    {"Spotkanie", "O prace",
		        "Lodz", "25 maja",},
		       {"Spotkanie", "O prace",
			        "Lodz", "25 maja",},
		   };
	

	
	EventsTable(EditTable edit)
	{
				super();
				this.e1=edit;
				table = new JTable(model);

				js=new JScrollPane(table);
				js.setSize(new Dimension(550,400));
				add(js);
				
				
				table.addMouseListener(this);
				
				
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

	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==arg0.BUTTON3)
		{
			
				//System.out.println(table.rowAtPoint(arg0.getPoint()));
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
        PopUpEdit menu = new PopUpEdit(this);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

}
