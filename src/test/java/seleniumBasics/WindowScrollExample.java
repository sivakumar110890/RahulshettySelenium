package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class WindowScrollExample {
	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		propertyLoader();

		String url = prop.getProperty("urlWindowScroll");
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		windowsSCrolBy(driver);
		List<WebElement> table = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr/td[4]"));
		int sum = 0;
		for (int i = 0; i < table.size(); i++) {
			sum = sum + Integer.parseInt(table.get(i).getText());
			System.out.println("Total sum : " + sum);
		}

		WebElement TotalAmountCollected = driver.findElement(By.cssSelector(".totalAmount"));
		String aftersplit = TotalAmountCollected.getText().split(":")[1].trim();
		System.out.println("After split : " +aftersplit);
		int actual=Integer.parseInt(aftersplit);
		Assert.assertEquals(sum, actual);
		System.out.println(" The Actual Sum and Expected SUM Values are matching");

	}

	public static Properties propertyLoader() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}

	public static void windowsSCrolBy(WebDriver driver) throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);

	}

}
