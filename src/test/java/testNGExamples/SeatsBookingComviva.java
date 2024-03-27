package testNGExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeatsBookingComviva {
	@Test
	public static void loginSeatComviva() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		String password ="Twentyfivelakhs@098";
		driver.get("https://sivakumar.a:"+password+"@seats.comviva.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close();
	}
}
