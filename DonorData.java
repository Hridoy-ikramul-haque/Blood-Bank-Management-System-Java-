import javax.swing.*;
import javax.swing.JTable; 
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
class DonorData extends JFrame{
JTable table; 
JLabel welcomeNote;
		
	public void showData(){
		setTitle("Donor Details");
		String[] columnNames = {"Name", "DOB","Gender","Mobile","Address","BloodGroup","DonationDate","Age","Email"}; 
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);   
		table = new JTable(); 
		table.setModel(model);
        table.setBounds(300,300,200,300);
	   
		try{
			DataAccess da=new DataAccess();
			ResultSet rs =da.getData("select * from donor"); 
			while(rs.next()) {
				String donorName = rs.getString("name");
				String dateOfBirth = rs.getString("dob");
				String donorGender = rs.getString("gender");
				String donorMobile = rs.getString("mobile");
				String donorAddress = rs.getString("address");
				String donorBloodGroup = rs.getString("bg");
				String donorDonationDate = rs.getString("donationDate");
				String donorAge = rs.getString("age");
				String donorEmail = rs.getString("email");
				
				
				if (donorName != null) {
					donorName = donorName.trim();
				}
				if (dateOfBirth != null) {
					dateOfBirth = dateOfBirth.trim();
				}
				if (donorGender != null) {
					donorGender = donorGender.trim();
				}
				
				if (donorMobile != null) {
					donorMobile = donorMobile.trim();
				}
				
				if (donorAddress != null) {
					donorAddress = donorAddress.trim();
				}
				if (donorBloodGroup != null) {
					donorBloodGroup = donorBloodGroup.trim();
				}
				if (donorDonationDate != null) {
					donorDonationDate = donorDonationDate.trim();
				}
				if (donorAge!= null) {
					donorAge = donorAge.trim();
				}
				if (donorEmail  != null) {
					donorEmail  = donorEmail.trim();
				}
				
				
				Object[] row = { donorName,dateOfBirth,donorGender,donorMobile,donorAddress,donorBloodGroup,donorDonationDate,donorAge,donorEmail};
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
		
		DonorData dn= new DonorData();
		   dn.showData();
		   dn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}