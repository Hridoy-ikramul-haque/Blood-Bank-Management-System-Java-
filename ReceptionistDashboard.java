import java.awt.*;
import java.awt.event.*;

class ReceptionistDashboard extends Frame implements WindowListener, ActionListener{
	
	
	private Register register;
	
	private Button Donor_Details;
	private Button Seeker_Details;

	private Button logout;
	private Panel panel;
	
	
	public ReceptionistDashboard(Register r){
		super("Receptionist DashBoard window");
		this.register=r;
		setSize(800,600);
		panel=new Panel();
		panel.setLayout(null);
		
		Donor_Details = new Button("Donor Details");
		Donor_Details.setBounds(200,150,150,60);
		panel.add(Donor_Details);
		
		
		Seeker_Details = new Button("Seeker Details");
		Seeker_Details.setBounds(450,150,150,60);
		panel.add(Seeker_Details);

		logout= new Button("Log Out");
		logout.setBounds(600,470,45,30);
		panel.add(logout);
		
		
		add(panel);
		Donor_Details.addActionListener(this);
		Seeker_Details.addActionListener(this);
	
		logout.addActionListener(this);
		
		
		addWindowListener(this);
		
	}
	/*public void paint(Graphics g){
		g.drawString("User Name:",40,100);
		g.drawString("Password:",40,150);
	}*/
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		int l=0;
		
		 if(s.equals("Donor Details")){
			register.receptionistDashboard.setVisible(false);
			register.byrepaddDonor.setVisible(true);
		}
		else if(s.equals("Seeker Details")){
			register.receptionistDashboard.setVisible(false);
			register.byrepaddSeeker.setVisible(true);
		}
		
		else if(s.equals("Log Out")){
			register.adminDashboard.setVisible(false);
			register.adminloginWindow.setVisible(true);
		}
			
		
		
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}
