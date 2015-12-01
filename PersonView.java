import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//insert view
	class PersonView extends JFrame
	{
		JPanel panel;
		JPanel labelPanel;
		JPanel textPanel;
		JPanel radioPanel;
		JButton btn;
		JLabel udl, uname, udob, ugender;
		JTextField driverLicense, name, dob;
		JRadioButton male, female;
		ButtonGroup group;
		
		public PersonView()
		{
			panel = new JPanel();
			labelPanel = new JPanel();
			textPanel = new JPanel();
			radioPanel = new JPanel();
			btn = new JButton("Submit");
			
			udl = new JLabel("Driver License");
			uname = new JLabel("Name");
			ugender = new JLabel("Gender");			
			udob = new JLabel("Date of Birth");
			
			dob = new JTextField(20);
			driverLicense = new JTextField(20);
			name = new JTextField(20);
			
			male = new JRadioButton("Male", true);
			female = new JRadioButton("Female");
			radioPanel.add(ugender);
			radioPanel.add(male);
			radioPanel.add(female);
			
			group = new ButtonGroup();
			group.add(male);
			group.add(female);
			
			
			GroupLayout layout = new GroupLayout(labelPanel);
			labelPanel.setLayout(layout);
			labelPanel.setBorder(new EmptyBorder(20, 10, 20, 20));
			layout.setAutoCreateGaps(true);
			
			layout.setHorizontalGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(udl)
							.addComponent(uname)
							.addComponent(udob)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(driverLicense)
							.addComponent(name)
							.addComponent(dob))	
					);
			
			layout.setVerticalGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(udl)
							.addComponent(driverLicense)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(uname)
							.addComponent(name)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(udob)
							.addComponent(dob)
							)
					);
			panel.setLayout(new BorderLayout());
			panel.add(radioPanel, BorderLayout.NORTH);
			panel.add(labelPanel, BorderLayout.CENTER);
			panel.add(btn, BorderLayout.SOUTH);
			this.add(panel);
			this.setTitle("Insert Person information");	
			
			
		}
		void addSubmitListener(ActionListener lis){btn.addActionListener(lis);}
		
	}