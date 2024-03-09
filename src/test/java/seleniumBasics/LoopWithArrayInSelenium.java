package seleniumBasics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoopWithArrayInSelenium {
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loopIterationtoClickOptions(driver);

	}

	public static void loopIterationtoClickOptions(WebDriver driver) {
		List<WebElement> AllCheckBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

		String[] arrayListVariable= {"option1","option2"};


		for (int i = 0; i < AllCheckBoxes.size(); i++) 
		{
			String CheckBoxname = AllCheckBoxes.get(i).getAttribute("value");


			for (String[] values:CheckBoxname)

			{
				driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(i).click();
				break;
			}
		}
	}
}


}
