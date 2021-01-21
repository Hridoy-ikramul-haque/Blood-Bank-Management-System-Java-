import java.awt.*;
import java.awt.event.*;

class UserChoice extends Frame implements WindowListener, ActionListener{

    private Panel panel;
	private Button admin;
	private Button receptionist;
	
	private Register register;
	
	public UserChoice(Register r){
		super("Blood Bank Management System");
		this.register=r;
		setSize(800,600);
		panel=new Panel();
		panel.setLayout(null);
		
		admin= new Button("Admin");
		admin.setBounds(200,240,150,80);
		panel.add(admin);
	
	    receptionist= new Button("Receptionist");
		receptionist.setBounds(450,240,150,80);
		panel.add(receptionist);
		
		
		
		setLocation(100,100);
		
		add(panel);
		admin.addActionListener(this);
		receptionist.addActionListener(this);
		
		addWindowListener(this);
		
		
	}
	
	public void paint(Graphics g){
		g.drawString("User Name:",40,100);
		g.drawString("Password:",40,150);
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		int l=0;
		if(s.equals("Admin")){
			register.userChoice.setVisible(false);
			register.adminloginWindow.setVisible(true);
			
		}
		else if(s.equals("Receptionist")){
			register.userChoice.setVisible(false);
			register.receptionistloginWindow.setVisible(true);
		}
		
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}