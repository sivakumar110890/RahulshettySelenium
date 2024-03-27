package seleniumBasics;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WindowsPopup {
	
	@Test
	public static void WindowsPopUpMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Chrome_V_122\\chromedriver-win64\\chromedriver.exe");
		File file = new File("D:\\Softwares\\Chrome_V_122\\chrome-win64\\chrome.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary(file);
		
		WebDriver driver = new ChromeDriver(opt);
		String username="sivakumar.a";
		String password="Twentyfivelakhs@098";
		driver.navigate().to("https://"+username+":"+password+"@seats.comviva.com/");
	}
}
