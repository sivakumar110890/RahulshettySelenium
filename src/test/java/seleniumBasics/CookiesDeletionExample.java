package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CookiesDeletionExample {
	public static Properties prop;
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		PropertyFileLoading();
		String url=prop.getProperty("urlCookiemanagement");
		driver = new FirefoxDriver();
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public static Properties PropertyFileLoading() throws IOException{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//config/config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
				
		
	}

}
