import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UpdateViolationView extends JFrame
{
	JPanel panel, subPanel;
	JLabel pcnNum;
	JLabel balance;
	JTextField pcn;
	JTextField amount;
	JButton btn, submit;
	
	JTextArea textarea;
	
	public UpdateViolationView()
	{
		panel = new JPanel();
		subPanel = new JPanel();
		textarea = new JTextArea(5, 15);
		textarea.setEditable(false);
		pcnNum = new JLabel("Enter PCN Number: ");
		balance = new JLabel("Enter Paid Amount: ");
		pcn = new JTextField(15);
		amount = new JTextField(15);
		btn = new JButton("Search");
		submit = new JButton("Submit");
		
		panel.add(pcnNum);
		panel.add(pcn);
		panel.add(btn);
		panel.add(textarea);
		
		subPanel.add(balance);
		subPanel.add(amount);
		subPanel.add(submit);
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(subPanel, BorderLayout.CENTER);
		this.setTitle("Paid Fine");
	}
	
	void addSearchViolationAmountListener(ActionListener lis){btn.addActionListener(lis);}
	void addUpdateViolationAmountListener(ActionListener lis){submit.addActionListener(lis);}
}
