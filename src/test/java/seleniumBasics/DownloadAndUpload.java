package seleniumBasics;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;

public class DownloadAndUpload {

	WebDriver driver;

	@Test
	public void upload1() throws InterruptedException {
		String FruitName = "Papaya";
		// driver = new FirefoxDriver();

		String DownloadPath=(System.getProperty("user.dir")+"\\Download");
		System.out.println("Download path : "+DownloadPath);
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Chrome_V_122\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("D:\\Softwares\\Chrome_V_122\\chrome-win64\\chrome.exe");
//		opt.setExperimentalOption(FruitName, opt);
		
		HashMap<String, Object> chromepref=new HashMap<String, Object>();
		chromepref.put("profile.default_content_settings.popups", 0);
		chromepref.put("download.default_directory", DownloadPath);
		opt.setExperimentalOption("prefs", chromepref);

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

		By downloadButton = By.id("downloadButton");
		driver.findElement(downloadButton).click();
		Thread.sleep(5000);
		
		File file = new File(DownloadPath+"/download.xlsx");
		if(file.exists()) {
			System.out.println("Download file exists and the test is success");
		}
		else {
			System.out.println("The test is failed. Because the download file is not found in this directory : "+file);
		}

		By UploadButton = By.cssSelector("#fileinput");
		driver.findElement(UploadButton).sendKeys("C:\\Users\\sivakumar.a\\Downloads\\download.xlsx");

		WebElement successfullyUploaded = driver.findElement(By.className("Toastify__toast-icon"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(successfullyUploaded));

		WebElement textElement = driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]"));
		String ActualText = textElement.getText();

		String ExpectedText = "Updated Excel Data Successfully.";
		System.out.println("The Actual text is : " + ActualText);
		Assert.assertEquals(ActualText, ExpectedText);

		wait.until(ExpectedConditions.invisibilityOf(successfullyUploaded));
		String AttributeofPrice = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		WebElement AppleElement = driver.findElement(By.xpath("//div[text()='" + FruitName
				+ "']/parent::div/parent::div/div[@id='cell-" + AttributeofPrice + "-undefined']"));
		String PriceofTheApple = AppleElement.getText();
		System.out.println("Actual price of the" + FruitName + " is " + PriceofTheApple);
		Assert.assertEquals("303", PriceofTheApple);

		driver.close();
	}

}
