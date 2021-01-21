import javax.swing.*;
import javax.swing.JTable; 
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
class SeekerData extends JFrame{
JTable table; 
JLabel welcomeNote;
		
	public void showData(){
		setTitle("Seeker Details");
		String[] columnNames = {"Name", "Taken Blood","Quantity","Taken Date","Address","Mobile","BloodGroup","Email"}; 
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);   
		table = new JTable(); 
		table.setModel(model);
        table.setBounds(300,300,200,300);
	   
		try{
			DataAccess da=new DataAccess();
			ResultSet rs =da.getData("select * from seeker"); 
			while(rs.next()) {
				String seekerName = rs.getString("name");
				String seekerTakenBlood= rs.getString("takenBlood");
				String seekerQuantity = rs.getString("quantity");
				String seekerTakenDate = rs.getString("takenDate");
				String seekerAddress = rs.getString("address");
				String seekerMobile = rs.getString("mobile");
				String seekerEmail = rs.getString("email");
				
				
				
				if (seekerName != null) {
					seekerName = seekerName.trim();
				}
				if (seekerTakenBlood != null) {
					seekerTakenBlood = seekerTakenBlood.trim();
				}
				if (seekerQuantity != null) {
					seekerQuantity = seekerQuantity.trim();
				}
				
				if (seekerTakenDate != null) {
					seekerTakenDate = seekerTakenDate.trim();
				}
				
				if (seekerAddress != null) {
					seekerAddress = seekerAddress.trim();
				}
				if (seekerMobile != null) {
					seekerMobile = seekerMobile.trim();
				}
				if (seekerEmail != null) {
					seekerEmail = seekerEmail.trim();
				}
				
				
				
				Object[] row = {seekerName,seekerTakenBlood,seekerQuantity,seekerTakenDate,seekerAddress,seekerMobile,seekerEmail};
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
		
		SeekerData sn= new SeekerData();
		   sn.showData();
		   sn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}