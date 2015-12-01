import java.awt.event.ActionListener;

import javax.swing.*;

public class UpdateCarView extends JFrame
{
	JPanel panel;
	JLabel oldLicensePlate;
	JLabel newLicensePlate;
	JTextField oldPlate;
	JTextField newPlate;
	JButton btn;
	
	public UpdateCarView()
	{
		panel = new JPanel();
		oldLicensePlate = new JLabel("Enter old License Plate Number: ");
		newLicensePlate = new JLabel("Enter new License Plate Number: ");
		oldPlate = new JTextField(20);
		newPlate = new JTextField(20);
		btn = new JButton("Submit");
		
		panel.add(oldLicensePlate);
		panel.add(oldPlate);
		panel.add(newLicensePlate);
		panel.add(newPlate);
		panel.add(btn);
		this.add(panel);
		this.setTitle("Update License Plate");
	}
	
	void addUpdateCarListener(ActionListener lis){btn.addActionListener(lis);}
}
