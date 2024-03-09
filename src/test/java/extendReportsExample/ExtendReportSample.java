package extendReportsExample;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportSample {

	WebDriver driver;
	ExtentSparkReporter reporter;
	ExtentReports extent;

	@BeforeTest
	public void BeforeTestMethod() {

		driver = new ChromeDriver();

		String path = (System.getProperty("user.dir") + "\\reports\\index.html");
		reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Extent Rahulshetty");
		reporter.config().setReportName("Selenium test with ExtentReport");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Author", "Sivakumar A");
		// extent.createTest("Launch Browser");
	}

	@Test
	public void LaunchBrowser() {
		extent.createTest("LaunchBrowser");
		driver.get("https://rahulshettyacademy.com/");
		String TitleOfThePage = driver.getTitle();
		System.out.println("The Page Title of Test 2  : " + TitleOfThePage);

	}

	@Test
	public void LaunchBrowser1() {
		ExtentTest test = extent.createTest("LaunchBrowser fail");
		test.assignAuthor("Test Author is : \"Sivakumar A\" ");
		test.assignCategory("Test Category is : \"Web Automation\" ");
		test.fail("This test is failed");
		driver.get("https://rahulshettyacademy.com/practice-project");
		String TitleOfThePage = driver.getTitle();
		System.out.println("The Page Title of Test 2 : " + TitleOfThePage);
		extent.flush();
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}

}
