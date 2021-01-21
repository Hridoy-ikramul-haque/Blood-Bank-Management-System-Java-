public class MAIN{
    public static void main(String str[]){
		Register r=new Register();
		r.userChoice=new UserChoice(r);
        r.userChoice.setVisible(true);
		r.adminloginWindow=new AdminLoginWindow(r);
		r.receptionistloginWindow=new ReceptionistLoginWindow(r);
		r.adminDashboard=new AdminDashboard(r);
		r.receptionistDashboard=new ReceptionistDashboard(r);
		r.addReceptionist=new AddReceptionist(r);		
		r.addDonor=new AddDonor(r);
        r.byrepaddDonor=new ByRepAddDonor(r);		
		r.addSeeker=new AddSeeker(r);
		r.byrepaddSeeker=new ByRepAddSeeker(r);
		//r.receptionistData=new ReceptionistData(r);
		//r.receptionistsearchForm=new ReceptionistSearchForm(r);
		
    }
}