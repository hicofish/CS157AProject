

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class CarView extends JFrame{
	JPanel panel1;
	JPanel labelPanel1;
	JPanel textPanel1;
	JButton btn;
	JLabel udl,  clp, cyear, cmake, cmodel, ccolor;
	JTextField licensePlate, driverLicense, year, make, model, color;
	JRadioButton male, female;
	ButtonGroup group;
	
	public CarView()
	{
		panel1 = new JPanel();
		labelPanel1 = new JPanel();
		textPanel1 = new JPanel();
		btn = new JButton("Submit");
		
		udl = new JLabel("Driver License");
		clp = new JLabel("License Plate");
		cyear = new JLabel("Year");			
		cmake = new JLabel("Make");
		cmodel = new JLabel("Model");
		ccolor = new JLabel("Color");
		licensePlate = new JTextField(20);
		driverLicense = new JTextField(20);
		year = new JTextField(20);
		make = new JTextField(20);
		model = new JTextField(20);
		color = new JTextField(20);
		
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		
		GroupLayout layout = new GroupLayout(labelPanel1);
		labelPanel1.setLayout(layout);
		labelPanel1.setBorder(new EmptyBorder(20, 10, 20, 20));
		layout.setAutoCreateGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(clp)
						.addComponent(udl)
						.addComponent(cyear)
						.addComponent(cmake)
						.addComponent(cmodel)
						.addComponent(ccolor)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(licensePlate)
						.addComponent(driverLicense)
						.addComponent(year)
						.addComponent(make)
						.addComponent(model)
						.addComponent(color))	
				);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(clp)
						.addComponent(licensePlate)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(udl)
						.addComponent(driverLicense)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cyear)
						.addComponent(year)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cmake)
						.addComponent(make)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cmodel)
						.addComponent(model)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ccolor)
						.addComponent(color)
						)
				);
		panel1.setLayout(new BorderLayout());
		
		panel1.add(labelPanel1, BorderLayout.CENTER);
		panel1.add(btn, BorderLayout.SOUTH);
		this.add(panel1);
		this.setTitle("Insert Car Information");	
		
		
	}
	void addSubmitListener(ActionListener lis){btn.addActionListener(lis);}
	
}
