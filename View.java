import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
public class View extends JFrame
{
	JPanel AdminSearch;
    JLabel idL;
    JLabel nameL;
    JLabel libL;
    JTextField idF;
    JTextField nameF;
    JComboBox libCB;
    JButton submit;
    
//  UserSearch Tab 
    JPanel UserSearch;
    JTable itemTable;
    JScrollPane scrollPane;
    JTextField SearchField;
    JButton resetSearchTable;
    JButton nameSearch;
    JButton pcnSearch;
    JButton dlicenseSearch;
    JPanel topPanel;
    JPanel searchButtonPanel;
    JPanel searchPanel;
    
    JTabbedPane tabbedPane;

// AdminModify Tab 
    JPanel AdminModify;
    JPanel modify;
    JButton insertPerson, updatePerson, deletePerson;
    JButton insertCar, updateCar, deleteCar;
    JButton insertViolation, updateViolation, deleteViolation;
    
    
	JFrame frame;
	public View()
	{
		tabbedPane = new JTabbedPane();
		AdminSearch = new JPanel();
        UserSearch = new JPanel();
        AdminModify = new JPanel();
        
        tabbedPane.addTab("AdminModify", new ImageIcon(), AdminModify, null);
        tabbedPane.addTab("AdminSearch", new ImageIcon(), AdminSearch, null);
        tabbedPane.addTab("User", new ImageIcon(), UserSearch, null);

//		AdminModify Tab
        insertPerson = new JButton("insertPerson");
        updatePerson = new JButton("updatePerson");
        deletePerson = new JButton("deletePerson");
        insertCar = new JButton("insertCar");
        updateCar = new JButton("updateCar");
        deleteCar = new JButton("deleteCar");
        insertViolation = new JButton("insertViolation");
        updateViolation = new JButton("updateViolation");
        deleteViolation = new JButton("deleteViolation");
        
        setButtonFormat(insertPerson);
        setButtonFormat(updatePerson);
        setButtonFormat(deletePerson);
        setButtonFormat(insertCar);
        setButtonFormat(updateCar);
        setButtonFormat(deleteCar);
        setButtonFormat(insertViolation);
        setButtonFormat(updateViolation);
        setButtonFormat(deleteViolation);
        
        modify = new JPanel();
        modify.setLayout(new GridLayout(3,3, 5, 5));

        modify.add(insertPerson);
        modify.add(updatePerson);
        modify.add(deletePerson);
        modify.add(insertCar);
        modify.add(updateCar);
        modify.add(deleteCar);
        modify.add(insertViolation);
        modify.add(updateViolation);
        modify.add(deleteViolation);
        AdminModify.add(modify);
        
        
//      AdminSearch Tab

        AdminSearch.setLayout(new GridLayout(7,1,2,4));
        idL = new JLabel("User ID:");
        idL.setHorizontalAlignment(SwingConstants.LEFT);
        nameL = new JLabel("Name:");
        nameL.setHorizontalAlignment(SwingConstants.LEFT);
        libL = new JLabel("Library");
        libL.setHorizontalAlignment(SwingConstants.LEFT);
        idF = new JTextField("ID",20);
        idF.setEditable(false);
        nameF = new JTextField("name",20);
        libCB = new JComboBox();
        submit = new JButton("Update");
        AdminSearch.add(idL);
        AdminSearch.add(idF);
        AdminSearch.add(nameL);
        AdminSearch.add(nameF);
        AdminSearch.add(libL);
        AdminSearch.add(libCB);
        AdminSearch.add(submit);
        

//      UserSearch Tab
        topPanel = new JPanel();
        searchButtonPanel = new JPanel();
        searchPanel = new JPanel();
        SearchField = new JTextField(20);
        resetSearchTable = new JButton("Reset");
        nameSearch = new JButton("Name UserSearch");
        pcnSearch = new JButton("PCN UserSearch");
        dlicenseSearch = new JButton("DriverLicense UserSearch");
        scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        UserSearch.setLayout(new BorderLayout());
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
        searchButtonPanel.setLayout(new BoxLayout(searchButtonPanel,BoxLayout.X_AXIS));

        topPanel.add(SearchField);
        searchButtonPanel.add(nameSearch);
        searchButtonPanel.add(pcnSearch);
        searchButtonPanel.add(dlicenseSearch);

        topPanel.add(searchButtonPanel);
        searchPanel.add(scrollPane);
        UserSearch.add(topPanel, BorderLayout.NORTH);
        UserSearch.add(searchPanel, BorderLayout.CENTER);
		frame = new JFrame("Parking Violation");

		frame.add(tabbedPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
	}
	public void setTable(DefaultTableModel tableModel)
	{
		searchPanel.removeAll();
		itemTable = new JTable(tableModel);
		itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(itemTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(700,450));
		
		itemTable.invalidate();
		scrollPane.repaint();
		searchPanel.add(scrollPane);
		
	}
	void addNameSearchListener(ActionListener lis){nameSearch.addActionListener(lis);}
	void addPcnSearchListener(ActionListener lis){pcnSearch.addActionListener(lis);}
	void addDLicenseSearchListener(ActionListener lis){dlicenseSearch.addActionListener(lis);}
	void insertPersonListener(ActionListener lis){insertPerson.addActionListener(lis);}
	void deletePersonListener(ActionListener lis){deletePerson.addActionListener(lis);}
	void updatePersonListener(ActionListener lis){updatePerson.addActionListener(lis);}
	void insertViolationListener(ActionListener lis){insertViolation.addActionListener(lis);}
	void insertCarListener(ActionListener lis){insertCar.addActionListener(lis);}
	void updateCarListener(ActionListener lis){updateCar.addActionListener(lis);}
	void deleteCarListener(ActionListener lis){deleteCar.addActionListener(lis);}
	void updateViolationListener(ActionListener lis){updateViolation.addActionListener(lis);}
	//button format
	public static void setButtonFormat(JButton jb)
	{
		jb.setForeground(Color.black);
        jb.setBackground(Color.WHITE);
        jb.setPreferredSize(new Dimension(150, 40));
        jb.setFont(new Font("Serif", Font.BOLD, 20));
	}
	
}
