package seleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class SeleniumRelativeLocatorExample {
	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		propertyFileLoader();
		String url = prop.getProperty("urlRelativeLocator");
		String browser = prop.getProperty("browser");
		System.out.println("browser is : " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.navigate().to(url);
		System.out.println("Url is : " + url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement emailElement = driver.findElement(By.name("email"));
		String Name = driver.findElement(with(By.tagName("label")).above(emailElement)).getText();
		System.out.println("The Text above the email tag is : " + Name);
	}

	public static Properties propertyFileLoader() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;

	}

}
