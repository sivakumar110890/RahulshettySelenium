package seleniumBasics;

import java.io.File;
import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicAuthenticationUsingPredicate {

	public static void main(String[] agrs) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Chrome_V_122\\chromedriver-win64\\chromedriver.exe");
		File file = new File("D:\\Softwares\\Chrome_V_122\\chrome-win64\\chrome.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary(file);
		ChromeDriver driver = new ChromeDriver(opt);

		Predicate<URI> uripredicate = uri -> uri.getHost().contains("httpbin.org");
		((HasAuthentication) driver).register(uripredicate,
				UsernameAndPassword.of("sivakumar.a", "Twentyfivelakhs@098"));

		driver.get("https://seats.comviva.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Next 7 days>>']")).click();
		
		WebElement Tuesday=driver.findElement(By.xpath("//td[@class=\"small td-cursor\"][2]"));
		WebElement Wednesday=driver.findElement(By.xpath("//td[@class=\"small td-cursor\"][3]"));
		WebElement Thursday=driver.findElement(By.xpath("//td[@class=\"small td-cursor\"][4]"));
	}

}
