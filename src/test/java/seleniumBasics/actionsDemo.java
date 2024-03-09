package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;

	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\config\\log4j.properties");
		log=Logger.getLogger(actionsDemo.class);
		propertyFileLoader();
		String url = prop.getProperty("actionDemoUrl");
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();

		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mouseHoverToHelloSignIn(driver);
		Thread.sleep(5000);
		mouseOverToSearchBox(driver);
		Thread.sleep(5000);
		//driver.quit();
	}

	public static void mouseHoverToHelloSignIn(WebDriver driver) { // this actions moves the mouse to target area
		WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
		Actions actions = new Actions(driver);
		actions.moveToElement(signIn).build().perform();
		log.info("Cursor moved to Sign-In option");
	}
	
	public static void mouseOverToSearchBox(WebDriver driver) {
		WebElement searchInput=driver.findElement(By.id("twotabsearchtextbox"));
		Actions actionsSearch = new Actions(driver);
		actionsSearch.moveToElement(searchInput);
		log.info("Cursor moved to Searbox");
		actionsSearch.keyDown(Keys.SHIFT).sendKeys("mobiles").doubleClick().build().perform();
		log.info("Double click operation has been performed");
		
	}

	public static Properties propertyFileLoader() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config/config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}

}
