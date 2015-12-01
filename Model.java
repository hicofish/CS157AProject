import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Model 
{
	View view;
	DefaultTableModel TableModel;
	
	public Model(View aview)
	{
		this.view = aview;
		TableModel = getTableModel("person");
		view.setTable(TableModel);
	}

	public DefaultTableModel getTableModel(String selectTable) {
			// TODO Auto-generated method stub
			DefaultTableModel tableModel = null;
			try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
			Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from " + selectTable);
			tableModel = constrTableModel(rs);
			}
			catch (Exception ex) {
	        	System.out.println("errorrrr");

	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
			return tableModel;
			
	}
	public DefaultTableModel constrTableModel(ResultSet rs) throws SQLException
	{
        Vector<String> colNames = new Vector<String>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		//retrieve the column names into vector
        ResultSetMetaData rsmd = rs.getMetaData();
        int totalColumns = rsmd.getColumnCount();
        for(int column = 1; column <= totalColumns; column++)
        	colNames.add(rsmd.getColumnName(column));
        
        //System.out.println(colNames.get(0));
        
        // store the data of the table
        while(rs.next())
        {
        	Vector<Object> v = new Vector<Object>();
        	for(int column = 1; column <= totalColumns; column++)
        		v.add(rs.getObject(column)); //store a column data
        	data.add(v);	//store the entire table
        }
        return new DefaultTableModel(data, colNames);
	}
	
	public DefaultTableModel search(String targetname, String table, String selectColumn,
			String where, DefaultTableModel model)
	{
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
			Statement st = con.createStatement();

			ResultSet rs =
				st.executeQuery("select name, dl, pcn,dob, fine from person "
						+ " inner join car on dl = dlicense"
						+ " inner join violation on lp = lplate "
						+ " where " + where + " =   '"+targetname+"'");


			
			int row = 0;
			if(rs.last())
			{
				row = rs.getRow();
				rs.beforeFirst();
			}
			
			return constrTableModel(rs);
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
		
		return null;
	}
	
	public DefaultTableModel SearchByQuery(String query)
	{
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			return constrTableModel(rs);
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
		return null;
	}
	
	 public void  addUser(String driverLicense, String name, String gender, String dob)
	 {
	        String sqlInsert = "insert into person values('" + 
	                       driverLicense + "','" + name + "','" + gender + "','" + dob + "')";
	        try{
	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
				Statement st = con.createStatement();
				
	            st.executeUpdate(sqlInsert);

	        }
	        catch(SQLException e)
			{
				 e.printStackTrace();
			}
	        
	 }
	 
//	 public void delUser(String name)
//	 {
//		 try{
//	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
//				Statement st = con.createStatement();
//				
//	            st.executeUpdate(name);
//
//	        }
//	        catch(SQLException e)
//			{
//				 e.printStackTrace();
//			}
//	 }
	 
//	 public void updateName(String name)
//	 {
//		 try{
//	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
//				Statement st = con.createStatement();
//				
//	            st.executeUpdate(name);
//
//	        }
//	        catch(SQLException e)
//			{
//				 e.printStackTrace();
//			}
//	 }
	 
	 public void addViolation( String pcn, String issuedate,String location, String contravention,String chargelevel,float fine,int paid,String lplate,float balance)
	 {
		
		  String sqlInsert = "insert into violation values('" + 
                  pcn + "','" + issuedate + "','" + location + "','" + contravention + "','" + chargelevel +"','" + fine + "','" + paid + "','" + lplate + "','" + balance +"')";
		   
		  try{
		   	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
				Statement st = con.createStatement();
				
		       st.executeUpdate(sqlInsert);
		
		   }
		   catch(SQLException e)
			{
				 e.printStackTrace();
			}
		 
		 
	 }
	 
	 public void addCar(String licensePlate, String driverLicense, int year, String make, String model, String color){
		 String sqlInsert1 = "insert into car values('" + licensePlate + "','" + driverLicense + "','" + year + "','" + make + "','" + model + "','" + color + "')";
		 try{
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
			 Statement st = con.createStatement();
			 st.executeUpdate(sqlInsert1);
		 }
		 catch (SQLException e)
		 {
			 e.printStackTrace();
		 }
	 }

	 public void executeQuery(String query)
	 {
		 try{
	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmars", "hicofish", "password");
				Statement st = con.createStatement();
				
	            st.executeUpdate(query);

	        }
	        catch(SQLException e)
			{
				 e.printStackTrace();
			}
	 }
}
