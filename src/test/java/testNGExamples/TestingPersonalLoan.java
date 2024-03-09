package testNGExamples;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class TestingPersonalLoan {
	@Parameters({"url","MaximumLoanAmount"})
	@Test
	public void MobileLoginPersonalLoan(String url,String MaximumLoanAmount) {
		System.out.println("Mobile Login Personal Loan");
		System.out.println("Mobile Login Personal Loan url is : "+url +" and then Maximum Loan Amount is : "+MaximumLoanAmount );
	}
	

	@Test(dataProvider="TestData")
	public void MobileNagivatetoDashboardPersonalLoan(String username,String Password) {
		System.out.println("Mobile Navigate to Dashboard Personal Loan USERNAME : "+username);
		System.out.println("Mobile Navigate to Dashboard Personal Loan PASSWORD : "+Password);
	}
	
	@Test
	public void WebLoginPersonalLoan() {
		System.out.println("Web Login Personal Loan");
	}
	
	@Test
	public void WebNagivatetoDashboardPersonalLoan() {
		System.out.println("Web Navigate to Dashboard Personal Loan");
	}
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("This is the Before Suite");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("This is the After Suite");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("This method is executed only for Personal loan test before calling the actual methods");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("This method is executed only for Personal loan test After calling the actual methods");
	}
	
	@DataProvider
	public Object[][] TestData() {
		Object[][] data=new Object[3][2];
		data[0][0]="firstSetofUsername";
		data[0][1]="firstSetofpassword";
		data[1][0]="SecondSetofUsername";
		data[1][1]="SecondSetofPassword";
		data[2][0]="ThirdSetofUsername";
		data[2][1]="ThirdSetofPassword";
		return data;
	}
	
	
}
