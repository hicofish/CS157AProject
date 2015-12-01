import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteCarView extends JFrame
{
	JPanel panel;
	JLabel label;
	JTextField textfield;
	JButton btn;
	
	public DeleteCarView()
	{
		panel = new JPanel();
		textfield = new JTextField(20);
		btn = new JButton("Submit");
		label = new JLabel("Enter a Car's License Plate to Delete: ");
		
		panel.add(label);
		panel.add(textfield);
		panel.add(btn);
		this.pack();
		this.add(panel);
		this.setTitle("Delete Car");
	}
	
	void addDeleteCarListener(ActionListener lis){btn.addActionListener(lis);}
}
