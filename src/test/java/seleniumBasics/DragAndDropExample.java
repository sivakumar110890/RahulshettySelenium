package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;

	public static void main(String[] args) throws IOException {
		propertyLoading();
		log = Logger.getLogger(DragAndDropExample.class);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\config\\frame_log4j.properties");
		String url = prop.getProperty("urlDragAndDrop");

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
			log.info("Selected Browser is : " + browser);
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
			log.info("Selected Browser is : " + browser);
		}

		driver.navigate().to(url);
		log.info("Entered url is : "+url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		driver.switchTo().frame(frameElement);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Destination = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(Source, Destination).build().perform();
	}

	public static Properties propertyLoading() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}

}
