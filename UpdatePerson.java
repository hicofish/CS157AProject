import java.awt.event.ActionListener;

import javax.swing.*;
public class UpdatePerson extends JFrame
{
	JPanel panel;
	JLabel oldName;
	JLabel newName;
	JButton btn;
	JTextField oldNameFd;
	JTextField newNameFd;
	
	public UpdatePerson()
	{
		panel = new JPanel();
		oldName = new JLabel("Enter old name: ");
		newName = new JLabel("Enter new name: ");
		btn = new JButton("Submit");
		oldNameFd = new JTextField(20);
		newNameFd = new JTextField(20);
		panel.add(oldName);
		panel.add(oldNameFd);
		panel.add(newName);
		panel.add(newNameFd);
		panel.add(btn);
		this.setSize(200,400);
		this.add(panel);
		this.setTitle("Update Person Name");
		
	}
	
	void addUpdatePersonListener(ActionListener lis){btn.addActionListener(lis);}
}
