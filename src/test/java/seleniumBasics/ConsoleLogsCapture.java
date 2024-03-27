package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Chrome_V_122\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("D:\\Softwares\\Chrome_V_122\\chrome-win64\\chrome.exe");
		ChromeDriver driver = new ChromeDriver(opt);

		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		WebElement BrowseProductsClick = driver.findElement(By.xpath("(//a[@routerlink=\"/products\"])[2]"));
		BrowseProductsClick.click();
		WebElement SeleniumClick = driver.findElement(By.linkText("Selenium"));
		SeleniumClick.click();
		WebElement AddToCartButton = driver.findElement(By.xpath("//button[text()='Add to Cart']"));
		AddToCartButton.click();
		WebElement ContinueToShop = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
		ContinueToShop.click();
		WebElement CartButton = driver.findElement(By.linkText("Cart"));
		CartButton.click();
		WebElement QuantityInput = driver.findElement(By.id("exampleInputEmail1"));
		QuantityInput.clear();
		QuantityInput.sendKeys("2");

		LogEntries log = driver.manage().logs().get(LogType.BROWSER);
		List<org.openqa.selenium.logging.LogEntry> allLogs = log.getAll();
		for (LogEntry e : allLogs) {
			System.out.println(e.getMessage());
		}
	}
}
