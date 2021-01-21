import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddDonor extends Frame implements WindowListener, ActionListener{
	
	private Register register;
	private Label title,name,dob,gender,mobile,address,bg,donationDate,age,email;
	private TextField Tname,Tdob,Tgender,Tmobile,Taddress,Tbg,TdonationDate,Tage,Temail;
	private Button Add,Update,Delete,Back,Show;
	private Panel panel;
	
	
	public  AddDonor(Register r){
		super("BloodBank Management System");
		this.register=r;
		setSize(800,600);
		panel=new Panel();
		panel.setLayout(null);
		
		title=new Label("Enter Donor information.");
		title.setBounds(280,30,500,80);
		panel.add(title);
		
		
		name=new Label("Name");
		name.setBounds(80,170,100,30);
		panel.add(name);
		
		Tname=new TextField(5);
		Tname.setBounds(200,170,150,30);
	   	panel.add(Tname);
		
		dob=new Label("Date of Birth");
		dob.setBounds(80,350,100,30);
		panel.add(dob);
		
		Tdob=new TextField(5);
		Tdob.setBounds(200,350,150,30);
	   	panel.add(Tdob);
		
		gender=new Label("Gender");
		gender.setBounds(80,410,100,30);
		panel.add(gender);
		
		Tgender=new TextField(5);
		Tgender.setBounds(200,410,150,30);
	   	panel.add(Tgender);
		
		mobile=new Label("Mobile No");
		mobile.setBounds(80,230,100,30);
		panel.add(mobile);
		
		Tmobile=new TextField(5);
		Tmobile.setBounds(200,230,150,30);
	   	panel.add(Tmobile);
		
		address=new Label("Address");
		address.setBounds(80,290,100,30);
		panel.add(address);
		
		Taddress=new TextField(5);
		Taddress.setBounds(200,290,150,30);
	   	panel.add(Taddress);
		
		
		bg=new Label("Blood Group");
		bg.setBounds(400,110,100,30);
		panel.add(bg);
		
		Tbg=new TextField(5);
		Tbg.setBounds(520,115,150,30);
		panel.add(Tbg);
		
		/*Choice blood = new Choice();
		blood.add("A+");
		blood.add("A-");
		blood.add("B+");
		blood.add("B-");
		blood.add("AB+");
		blood.add("AB-");
		blood.add("O+");
		blood.add("O-");
		blood.setBounds(520,115,150,30);
		panel.add(blood);*/
			
		donationDate=new Label("Donation Date");
		donationDate.setBounds(400,170,100,30);
		panel.add(donationDate);
		
		TdonationDate=new TextField(5);
		TdonationDate.setBounds(520,170,150,30);
	   	panel.add(TdonationDate);
		
		
		age=new Label("Age");
		age.setBounds(400,290,100,30);
		panel.add(age);
		
		Tage=new TextField(5);
		Tage.setBounds(520,290,150,30);
	   	panel.add(Tage);
		
		email=new Label("Email ");
		email.setBounds(400,230,100,30);
		panel.add(email);
		
		Temail=new TextField(5);
		Temail.setBounds(520,230,150,30);
	   	panel.add(Temail);
		
	
		//Tbg=new TextField(5);
		//Tbg.setBounds(520,410,150,30);
		//panel.add(Tbg);
		
		Add = new Button("Add");
		Add.setBounds(450,470,45,30);
		panel.add(Add);
		
		
		Update = new Button("Update");
		Update.setBounds(500,470,45,30);
		panel.add(Update);
		
		Delete = new Button("Delete");
		Delete.setBounds(550,470,45,30);
		panel.add(Delete);
		
		Back = new Button("Back");
		Back.setBounds(600,470,45,30);
		panel.add(Back);
		
		Show = new Button("Show Details");
		Show.setBounds(200,470,80,30);
		panel.add(Show);
		
		add(panel);
		Add.addActionListener(this);
		Update.addActionListener(this);
		Delete.addActionListener(this);
		Back.addActionListener(this);
	    Show.addActionListener(this);
			
		addWindowListener(this);
		
	}
	
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		//System.out.println(s.getText()+":"+flag);
		return flag;
	}
	private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<atIdx)flag=false;
		return flag;
	}
	
	
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		String text=e.getActionCommand();
	  
			if(text.equals("Add")){
			if(isEmpty(Tname) || isEmpty(Tdob)||isEmpty(Tgender) || isEmpty(Tmobile)||isEmpty(Taddress) || isEmpty(Tbg)||isEmpty(TdonationDate) || isEmpty(Tage)||isEmpty(Temail))
			{
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(Temail.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			else{
				DataAccess da=new DataAccess();
				
				String sql="insert into donor(id,name,dob,gender,mobile,address,bg,donationDate,age,email) values(null,'"+Tname.getText()+"','"+Tdob.getText()+"','"+Tgender.getText()+"','"+Tmobile.getText()+"','"+Taddress.getText()+"','"+Tbg.getText()+"','"+TdonationDate.getText()+"','"+Tage.getText()+"','"+Temail.getText()+"')";
			    da.updateDB(sql);
				
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Registration Complete!");
				}
				else{
					JOptionPane.showMessageDialog(this,"Error!");
				}
				//System.out.println(sql);
			}
		}
		else if(text.equals("Delete"))
		{
			System.out.println("Delete");
	    }
		else if(text.equals("Update")){
			
			System.out.println("Update");
		}
		else if(text.equals("Back")){
			register.adminDashboard.setVisible(true);
			register.addReceptionist.setVisible(false);
		}
		else if(text.equals("Show Details")){
			
			System.out.println("Show Details");
		}
		
	   
		
		
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}