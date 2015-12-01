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

public class ViolationView extends JFrame{

	JPanel panel;
	JPanel labelPanel;
	JPanel textPanel;
	JPanel radioPanel;
	JButton btn;
	JLabel upcn, uissue, ulocation,ucont, uchargelevel,ufine,upaid,ulplate,ubalance;
	JTextField pcn,issuedate, location, contravention, fine, lplate, balance;
	JRadioButton yes, no, low, high;
	ButtonGroup group1, group2;
	
	public ViolationView(){
		panel = new JPanel();
		labelPanel = new JPanel();
		textPanel = new JPanel();
		radioPanel = new JPanel();
		btn = new JButton("Submit");
		
		upcn = new JLabel("PCN");
		uissue= new JLabel("Issue Date(ex.2015-11-30)");
		ulocation = new JLabel("Location");
		ucont= new JLabel("Contravention"); 
		uchargelevel = new JLabel("Charge Level");
		ufine = new JLabel("Fine Amount");
		upaid = new JLabel("Paid?");
		ulplate = new JLabel("Plate Number");
		ubalance= new JLabel("Balance");
		
		pcn = new JTextField(20);
		issuedate = new JTextField(20);
		location = new JTextField(20);
		contravention = new JTextField(20);
		fine = new JTextField(20);
		lplate = new JTextField(20);
		balance = new JTextField(20);
		
		no = new JRadioButton("No", true);
		yes = new JRadioButton("Yes");
		radioPanel.add(upaid);
		radioPanel.add(no);
		radioPanel.add(yes);
		
		low = new JRadioButton("L", true);
		high = new JRadioButton("H");
		radioPanel.add(uchargelevel);
		radioPanel.add(low);
		radioPanel.add(high);
		
		//not sure
		group1 = new ButtonGroup();
		group1.add(low);
		group1.add(high);
		group2 = new ButtonGroup();
		group2.add(no);
		group2.add(yes);
		
		GroupLayout layout = new GroupLayout(labelPanel);
		labelPanel.setLayout(layout);
		labelPanel.setBorder(new EmptyBorder(20, 10, 20, 20));
		layout.setAutoCreateGaps(true);
		
		
//		JLabel upcn, uissue, ulocation,ucont, uchargelevel,ufine,upaid,ulplate,ubalance;
//		JTextField pcn,issuedate, location, contravention, fine, lplate, balance;
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(upcn)
						.addComponent(uissue)
						.addComponent(ulocation)
						.addComponent(ucont)
						.addComponent(ufine)
						.addComponent(ulplate)
						.addComponent(ubalance)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(pcn)
						.addComponent(issuedate)
						.addComponent(location)
						.addComponent(contravention)
						.addComponent(fine)
						.addComponent(lplate)
						.addComponent(balance)
						)
				);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(upcn)
						.addComponent(pcn)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(uissue)
						.addComponent(issuedate)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ulocation)
						.addComponent(location)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ucont)
						.addComponent(contravention)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ufine)
						.addComponent(fine)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ulplate)
						.addComponent(lplate)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ubalance)
						.addComponent(balance)
						)
				);
		
		panel.setLayout(new BorderLayout());
		panel.add(radioPanel, BorderLayout.NORTH);
		panel.add(labelPanel, BorderLayout.CENTER);
		panel.add(btn, BorderLayout.SOUTH);
		this.add(panel);
		this.setTitle("Insert Violation information");	
		
		
	}
	void addSubmitIVListener(ActionListener lis){btn.addActionListener(lis);}
	
	
	
}
