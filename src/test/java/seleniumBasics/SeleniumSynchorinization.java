package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSynchorinization {
	public static WebDriver driver;
	public static Properties prop;

	/*
	 * Implicit wait - This will be applied for all the actions used by the driver
	 * globally declared Explicit wait - This will be applied for specific condition
	 * (action) Thread.sleep - It's a java Fluent wait -
	 */

	public static void main(String[] args) throws IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		LoadPropertyFile();
		String url = prop.getProperty("url");
		String cityname = prop.getProperty("cityname");
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ImplicitWaitExample(driver);
	}

	public static Properties LoadPropertyFile() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}

	public static void ImplicitWaitExample(WebDriver driver) throws AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downshift-0-input"))); // Explicit wait

		WebElement cityNameInput = driver.findElement(By.id("downshift-0-input"));
		cityNameInput.sendKeys("Bengaluru");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement Bangalore = driver.findElement(By.xpath("//*[@id=\"downshift-0-item-0\"]/div[2]/span[1]"));
		Bangalore.click();

		WebElement CheckInDateClick = driver.findElement(By.id("check-in-date"));
		CheckInDateClick.click();

		List<WebElement> CheckinDays = driver.findElements(By.xpath("//td[@aria-disabled=\"false\"]"));

		for (WebElement datelist : CheckinDays) // this for loop for selecting the check-in day
		{
			String name = datelist.getAttribute("aria-label");
			if (name.contains("29")) {
				datelist.click();
				break;
			}
		}

		for (WebElement datelist1 : CheckinDays) // this for loop for selecting the check-out day
		{
			String name = datelist1.getAttribute("aria-label");
			if (name.contains("30")) {
				datelist1.click();
				break;
			}
		}

		WebElement SearchButtonClick = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
		SearchButtonClick.click();
	}

}
