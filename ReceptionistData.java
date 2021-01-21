import javax.swing.*;
import javax.swing.JTable; 
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
class ReceptionistData extends JFrame{
JTable table; 
JLabel welcomeNote;
		
	public void showData(){
		setTitle("Receptionist Datatable");
		String[] columnNames = {"Name","Gender", "DOB","Address","MaritalStatues","BloodGroup","Joined Date","Salary","Mobile","Email"}; 
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);   
		table = new JTable(); 
		table.setModel(model);
        table.setBounds(300,300,200,300);
	   
		try{
			DataAccess da=new DataAccess();
			ResultSet rs =da.getData("select * from receptionist"); 
			while(rs.next()) {
				String receptionistName = rs.getString("name");
				String receptionistGender = rs.getString("gender");
				String dateOfBirth = rs.getString("dob");
				String receptionistAddress = rs.getString("address");
				String receptionistMs = rs.getString("ms");
				String receptionistBloodGroup = rs.getString("bg");
				String receptionistJoinDate = rs.getString("join_date");
				String receptionistSalary = rs.getString("salary");
				String receptionistMobile = rs.getString("mobile");
				String receptionistEmail = rs.getString("email");
				
				if (receptionistName != null) {
					receptionistName = receptionistName.trim();
				}
				if (receptionistGender != null) {
					receptionistGender = receptionistGender.trim();
				}
				if (dateOfBirth != null) {
					dateOfBirth = dateOfBirth.trim();
				}
				
				if (receptionistAddress != null) {
					receptionistAddress = receptionistAddress.trim();
				}
				
				if (receptionistMs != null) {
					receptionistMs = receptionistMs.trim();
				}
				if (receptionistBloodGroup != null) {
					receptionistBloodGroup = receptionistBloodGroup.trim();
				}
				if (receptionistJoinDate != null) {
					receptionistJoinDate = receptionistJoinDate.trim();
				}
				if (receptionistSalary!= null) {
					receptionistSalary = receptionistSalary.trim();
				}
				if (receptionistMobile  != null) {
					receptionistMobile  = receptionistMobile .trim();
				}
				if (receptionistEmail != null) {
					receptionistEmail = receptionistEmail.trim();
				}
				
				Object[] row = { receptionistName,receptionistGender,dateOfBirth,receptionistAddress,receptionistMs,receptionistBloodGroup,receptionistJoinDate,receptionistSalary,receptionistMobile,receptionistEmail};
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				model1.addRow(row);
			} 
			rs.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	    JScrollPane sp = new JScrollPane(table); 
		 sp.setBounds(300,300,200,300);	
        add(sp);
       	
        // Frame Size 
        setSize(700,700); 
        // Frame Visible = true 
        setVisible(true); 
		
		
		
	}

	public static void main(String []args){
		
		ReceptionistData rd= new ReceptionistData();
		   rd.showData();
		   rd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}