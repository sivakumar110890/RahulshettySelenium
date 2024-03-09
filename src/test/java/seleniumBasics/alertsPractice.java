package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class alertsPractice {

	public static WebDriver driver;
	public static void main(String [] args) throws InterruptedException {
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\drivers\\\\chrome_latest\\\\chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");				
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(url);
		alertAcceptExample(driver);
		alertDismiss(driver);
		alertWithTextVerifyAndAccept(driver);
	}

	public static void alertAcceptExample(WebDriver driver) {
		WebElement alertButton=driver.findElement(By.id("alertbtn"));
		alertButton.click();
		String AlertMessage=driver.switchTo().alert().getText();
		System.out.println("The Alert Message is : "+AlertMessage);
		driver.switchTo().alert().accept();

	}

	public static void alertDismiss(WebDriver driver) throws InterruptedException {
		Thread.sleep(6000);
		WebElement confirmalertButton=driver.findElement(By.id("confirmbtn"));
		confirmalertButton.click();
		driver.switchTo().alert().dismiss();
	}

	public static void alertWithTextVerifyAndAccept(WebDriver driver) 
	{
		WebElement nameInput=driver.findElement(By.id("name"));
		nameInput.sendKeys("sivakumar");
		WebElement confirmalertButton=driver.findElement(By.id("confirmbtn"));
		confirmalertButton.click();
		String alertActualText=driver.switchTo().alert().getText();
		String ExpectedAlertText="Hello sivakumar, Are you sure you want to confirm?";
		Assert.assertEquals(alertActualText, ExpectedAlertText);
		System.out.println("The Alert Message with name is : "+alertActualText);
		driver.switchTo().alert().dismiss();


	}



}

