import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddSeeker extends Frame implements WindowListener,ActionListener{
	
	private Register register;
	private Label title,name,takenBlood,quantity,takenDate,address,mobile,email;
	private TextField Tname,TtakenBlood,Tquantity,TtakenDate,Taddress,Tmobile,Temail;
	private Button Add,Update,Delete,Back,Show;
	private Panel panel;
	
	
	public AddSeeker(Register r){
		super("Blood Bank Management System.");
		this.register=r;
		setSize(800,600);
		panel=new Panel();
		panel.setLayout(null);
		
		title=new Label("Enter Seeker Information.");
		title.setBounds(280,30,500,80);
		panel.add(title);
		
		name=new Label("Name");
		name.setBounds(80,170,100,30);
		panel.add(name);
		
		Tname=new TextField(5);
		Tname.setBounds(200,170,150,30);
	   	panel.add(Tname);
		
		takenBlood= new Label("Taken Blood");
		takenBlood.setBounds(80,230,100,30);
		panel.add(takenBlood);
		
		TtakenBlood=new TextField(5);
		TtakenBlood.setBounds(200,230,150,30);
		panel.add(TtakenBlood);
		
		/*Choice blood = new Choice();
		blood.add("A+");
		blood.add("A-");
		blood.add("B+");
		blood.add("B-");
		blood.add("AB+");
		blood.add("AB-");
		blood.add("O+");
		blood.add("O-");
		blood.setBounds(200,230,150,30);
		panel.add(blood);*/
		
		quantity=new Label("Quantity");
		quantity.setBounds(80,290,100,30);
		panel.add(quantity);
		
		Tquantity=new TextField(5);
		Tquantity.setBounds(200,290,150,30);
		panel.add(Tquantity);
		
		takenDate=new Label("Taken Date");
		takenDate=new Label("Taken Date");
		takenDate.setBounds(80,350,100,30);
		panel.add(takenDate);
		
		TtakenDate=new TextField(5);
		TtakenDate.setBounds(200,350,150,30);
		panel.add(TtakenDate);
		
		address=new Label("Address");
		address.setBounds(80,410,100,30);
		panel.add(address);
		
		Taddress=new TextField(5);
		Taddress.setBounds(200,410,150,30);
	   	panel.add(Taddress);
		
		mobile=new Label("Mobile No");
		mobile.setBounds(400,170,100,30);
		panel.add(mobile);
		
		Tmobile=new TextField(5);
		Tmobile.setBounds(520,170,150,30);
	   	panel.add(Tmobile);
		
		email=new Label("Email ");
		email.setBounds(400,230,100,30);
		panel.add(email);
		
		Temail=new TextField(5);
		Temail.setBounds(520,230,150,30);
	   	panel.add(Temail);
		
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
			if(isEmpty(Tname) || isEmpty(TtakenBlood)||isEmpty(Tquantity) || isEmpty(TtakenDate)||isEmpty(Taddress) || isEmpty(Tmobile)||isEmpty(Temail))
			{
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(Temail.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			else{
				DataAccess da=new DataAccess();
				
				String sql="insert into seeker (id,name,takenBlood,quantity,takenDate,address,mobile,email) values(null,'"+Tname.getText()+"','"+TtakenBlood.getText()+"','"+Tquantity.getText()+"','"+TtakenDate.getText()+"','"+Taddress.getText()+"','"+Tmobile.getText()+"','"+Temail.getText()+"')";
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
			register.addSeeker.setVisible(false);
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