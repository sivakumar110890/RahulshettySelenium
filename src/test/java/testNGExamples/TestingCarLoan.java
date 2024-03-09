package testNGExamples;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class TestingCarLoan {
	@Parameters({"url"})
	@Test
	public void MobileLoginCarLoan(String url) {
		System.out.println("Mobile Login Car Loan :"+url);
	}
	
	@Test
	public void MobileNagivatetoDashboardCarLoan() {
		System.out.println("Mobile Navigate to Dashboard Car Loan");
	}
	
	@Test
	public void WebLoginCarLoan() {
		System.out.println("Web Login Car Loan");
	}
	
	@Test
	public void WebNagivatetoDashboardCarLoan() {
		System.out.println("Web Navigate to Dashboard Car Loan");
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("================= START ==========================");
		System.out.println("This test should be executed Before all the test");
		
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("This test should be executed After all the test");
		System.out.println("================= END ==========================");
	}

}
