package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCertificatAcceptance {
	public static Properties prop;
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		propertyFileLoad();
		String url=prop.getProperty("urlSSLAcceptance");
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("firefox")) 
		{
			FirefoxOptions fop= new FirefoxOptions();
			//fop.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions cop=new ChromeOptions();
			cop.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(cop);
		}
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.quit();
	}
	
	public static Properties propertyFileLoad() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}
	
	public static void chromeOptions() {
		
	}

}
