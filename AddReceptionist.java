import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddReceptionist extends Frame implements WindowListener, ActionListener{
	
	private Register register;
	private Label title,name,mobile,address,dob,gender,ms,bg,joinDate,email,salary,uName,uPass;
	private TextField Tname,Tmobile,Taddress,Tdob,Tgender,Tms,Tbg,TjoinDate,Temail,Tsalary,TuName,TuPass;
	private Button Add,Update,Delete,Back,Show;
	private Panel panel;
	
	
	public AddReceptionist(Register r){
		super("BloodBank Management System");
		this.register=r;
		setSize(800,600);
		panel=new Panel();
		panel.setLayout(null);
		
		title=new Label("Enter receptionist information.");
		title.setBounds(280,30,500,80);
		panel.add(title);
		
		name=new Label("Name");
		name.setBounds(80,110,100,30);
		panel.add(name);
		
		Tname=new TextField(5);
		Tname.setBounds(200,110,150,30);
	   	panel.add(Tname);
		
		
		gender=new Label("Gender");
		gender.setBounds(80,170,100,30);
		panel.add(gender);
		
		Tgender=new TextField(5);
		Tgender.setBounds(200,170,150,30);
		panel.add(Tgender);
		
		
		dob=new Label("Date of Birth");
		dob.setBounds(80,230,100,30);
		panel.add(dob);
		
		Tdob=new TextField(5);
		Tdob.setBounds(200,230,150,30);
	   	panel.add(Tdob);
		
		
		address=new Label("Address");
		address.setBounds(80,290,100,30);
		panel.add(address);
		
		Taddress=new TextField(5);
		Taddress.setBounds(200,290,150,30);
	   	panel.add(Taddress);
		
		
		ms=new Label("Marital Status");
		ms.setBounds(80,350,100,30);
		panel.add(ms);
		
		Tms=new TextField(5);
		Tms.setBounds(200,350,150,30);
	   	panel.add(Tms);
		
		
		bg=new Label("Blood Group");
		bg.setBounds(80,410,100,30);
		panel.add(bg);
		
		Tbg=new TextField(5);
		Tbg.setBounds(200,415,150,30);
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
		blood.setBounds(200,415,150,30);
		panel.add(blood);*/
		
		
		
		joinDate=new Label("Date of Joining ");
		joinDate.setBounds(400,110,100,30);
		panel.add(joinDate);
		
		TjoinDate=new TextField(5);
		TjoinDate.setBounds(520,110,150,30);
	   	panel.add(TjoinDate);
		
		
		salary=new Label("Salary");
		salary.setBounds(400,170,100,30);
		panel.add(salary);
		
		Tsalary=new TextField(5);
		Tsalary.setBounds(520,170,150,30);
	   	panel.add(Tsalary);
		
		mobile=new Label("Mobile No");
		mobile.setBounds(400,230,100,30);
		panel.add(mobile);
		
		Tmobile=new TextField(5);
		Tmobile.setBounds(520,230,150,30);
	   	panel.add(Tmobile);
		
		email=new Label("Email ");
		email.setBounds(400,290,100,30);
		panel.add(email);
		
		Temail=new TextField(5);
		Temail.setBounds(520,290,150,30);
	   	panel.add(Temail);
		
		
		uName=new Label("User name");
		uName.setBounds(400,350,100,30);
		panel.add(uName);
		
		TuName=new TextField(5);
		TuName.setBounds(520,350,150,30);
	   	panel.add(TuName);
		
		uPass=new Label("Password");
		uPass.setBounds(400,410,100,30);
		panel.add(uPass);
		
		TuPass=new TextField(5);
		TuPass.setBounds(520,410,150,30);
	   	panel.add(TuPass);
		
		
		
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
			//DataAccess da=new DataAccess();
			
			
			if(text.equals("Add")){
			if(isEmpty(Tname) || isEmpty(Tgender)||isEmpty(Tdob) || isEmpty(Taddress)||isEmpty(Tms) || isEmpty(Tbg)||isEmpty(TjoinDate) || isEmpty(Tsalary)||isEmpty(Tmobile) || isEmpty(Temail)||isEmpty(TuName) || isEmpty(TuPass))
			{
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(Temail.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			else{
				DataAccess da=new DataAccess();
				
				String sql="insert into receptionist(id,name,gender,dob,address,ms,bg,join_date,salary,mobile,email,uName,uPass) values(null,'"+Tname.getText()+"','"+Tgender.getText()+"','"+Tdob.getText()+"','"+Taddress.getText()+"','"+Tms.getText()+"','"+Tbg.getText()+"','"+TjoinDate.getText()+"','"+Tsalary.getText()+"','"+Tmobile.getText()+"','"+Temail.getText()+"','"+TuName.getText()+"','"+TuPass.getText()+"')";
			    da.updateDB(sql);
				
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Registration Complete!");
				}
				else{
					JOptionPane.showMessageDialog(this,"Error!");
				}
				System.out.println(sql);
			}
		}
	    
		
		else if(text.equals("Delete")){
				
			
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
			
			//register.receptionistData.setVisible(true);
			register.addReceptionist.setVisible(false);
		}
		
		
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}