package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.swing.text.Element;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WindowsHandler {
	public static Logger log;
	public static Properties prop;
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		log=Logger.getLogger(WindowsHandler.class);
		propertyFileLoader();
		String url = prop.getProperty("urlWindowsHandler");
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(); 
		}
		else if (browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		driver.get(url); 
		log.info("Url Opened is : " + url);
		driver.manage().window().maximize();
		log.info("Window is maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement newTabClick=driver.findElement(By.cssSelector(".blinkingText"));
		newTabClick.click();
		log.info("New window is opened");
		
		Set<String> Allwindows=driver.getWindowHandles();
		
		Iterator<String> iteratorS=Allwindows.iterator();
		String ParentWindow=iteratorS.next();
		String ChildWindow=iteratorS.next();
		driver.switchTo().window(ChildWindow);
		
		
		/*// Second method to move into the next window
		 * for(String newWindow:Allwindows) { driver.switchTo().window(newWindow); }
		 */
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"theme-btn register-btn\"]")));
		String TitleofNewWindow=driver.getTitle();
		System.out.println("Control has been moved to the Child window");
		System.out.println("Title of child window is : "+TitleofNewWindow);
		WebElement text=driver.findElement(By.xpath("//p[@class=\"im-para red\"]"));
		String OutputString=text.getText();
		System.out.println("The Text from the child page is : "+OutputString);
		String[] splittedText=OutputString.split(" ");
		String emailId=splittedText[4];
		System.out.println("Email id : "+emailId);
		
		driver.switchTo().window(ParentWindow);
		String TitleofParentWindow=driver.getTitle();
		System.out.println("Control has been moved to the Parent window");
		System.out.println("Title of parent window is : "+TitleofParentWindow);
		String actual ="LoginPage Practise | Rahul Shetty Academy";
		Assert.assertEquals(actual, TitleofParentWindow);
		
		//Allwindows.iterator()
		
	}
	
	public static Properties propertyFileLoader() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\config\\config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	
	}

}
