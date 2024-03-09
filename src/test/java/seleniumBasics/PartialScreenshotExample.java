package seleniumBasics;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PartialScreenshotExample {
	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		propertyFileLoader();
		String urlMultipleWindowPrimary = prop.getProperty("urlMultipleWindowPrimary");
		String urlMultipleWindowSecondary = prop.getProperty("urlMultipleWindowSecondary");
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.navigate().to(urlMultipleWindowPrimary);
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String primaryTab = it.next();
		String SecondaryTab = it.next();
		driver.switchTo().window(SecondaryTab);
		driver.navigate().to(urlMultipleWindowSecondary);
		String FirsTCourseName = driver.findElement(By.xpath("//div[@title='All-Access Membership']")).getText();
		driver.close();
		driver.switchTo().window(primaryTab);
		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys(FirsTCourseName);
		File source = nameInput.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir") + "//screenshots//Only_WebElement_Screenshot.png");
		FileUtils.copyFile(source, Destination);

		org.openqa.selenium.Rectangle rectangle = nameInput.getRect();
		Point point = nameInput.getLocation();
		System.out.println("Rectanlge : " + rectangle);
		System.out.println("Location : " + point);

	}

	public static Properties propertyFileLoader() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config/config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}

}
