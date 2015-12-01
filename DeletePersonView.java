import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DeletePersonView extends JFrame
{
	JPanel panel;
	JLabel label;
	JTextField textfield;
	JButton btn;
	
	public DeletePersonView()
	{
		panel = new JPanel();
		textfield = new JTextField(20);
		btn = new JButton("Submit");
		label = new JLabel("Enter a Person Name to Delete: ");
		
		//panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(label);
		panel.add(textfield);
		panel.add(btn);
		this.setSize(200,400);
		this.add(panel);
		this.setTitle("Delete Person");
	}
	
	void addDeletePersonListener(ActionListener lis){btn.addActionListener(lis);}
}
