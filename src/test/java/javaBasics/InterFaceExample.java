package javaBasics;

public class InterFaceExample implements CentralTrafficRules,ContinentalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub

		CentralTrafficRules c = new InterFaceExample(); // here we need to create an object using the interface name
		c.RedStop();
		//c.GreenGo();
		c.YellowWait();
		
		ContinentalInterface ct = new InterFaceExample();
		ct.ContinentInterface();
	}

	@Override
	public void GreenGo() {
		// TODO Auto-generated method stub
		System.out.println("Now signal is green so Go ahead and proceed");

	}

	@Override
	public void RedStop() {
		// TODO Auto-generated method stub
		System.out.println("Now signal is Red So Wait");
	}

	@Override
	public void YellowWait() {
		// TODO Auto-generated method stub
		System.out.println("Now signal is Yellow. So be cautious");
	}

	@Override
	public void ContinentInterface() {
		// TODO Auto-generated method stub
		System.out.println("This is continental interface ");
		
	}

}
