package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class LinkExample {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;

	public static void main(String[] args) throws IOException, InterruptedException {
		log = Logger.getLogger(LinkExample.class);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\config\\link_log4j.properties");
		propertyFileLoad();
		String url = prop.getProperty("urlLinkExample");
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions fop=new FirefoxOptions();
			fop.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(fop);
		}

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
				
		BrokenLinkFinding(driver);
	}

	public static void LinksAndWindowsHandle(WebDriver driver) throws InterruptedException {
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println(" Total links available in this site : " + count); // Printing the all links available in
																				// whole site
		log.info(" Total links available in this site : " + count);

		WebElement footerPage = driver.findElement(By.id("gf-BIG"));
		List<WebElement> tagsinfooter = footerPage.findElements(By.tagName("a")); // Limiting the scope of the driver to
																					// focus on the footer section
		int countofTheLinksFooter = tagsinfooter.size();
		System.out.println("Total links avaiable in Footer : " + countofTheLinksFooter);

		WebElement firstColumn = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]"));
		List<WebElement> firstcolumntags = firstColumn.findElements(By.tagName("a"));
		int countoftheFirstcolumn = firstcolumntags.size();
		System.out.println("Total links available in first part of the columns is : " + countoftheFirstcolumn);

		for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
			String ClickOnTheLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(ClickOnTheLink);

		}

		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> it = allwindows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String currentUrl = driver.getCurrentUrl();
			Thread.sleep(8000);
			System.out.println("Current URL is :" + currentUrl);
		}

		/*
		 * for(WebElement clickLink:firstcolumntags) { clickLink.click();
		 * driver.navigate().back(); String currentUrl=driver.getCurrentUrl();
		 * System.out.println("Current URL is :"+currentUrl); }
		 */
		// driver.quit();
	}

	public static Properties propertyFileLoad() throws IOException {
		FileInputStream fileinput = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
		prop = new Properties();
		prop.load(fileinput);
		return prop;

	}

	/*public static void brokenLinkTesting(WebDriver driver) throws MalformedURLException, IOException {
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		for (int i = 0; i < allLinks.size(); i++) {
			String Text = allLinks.get(i).getAttribute("href");
			System.out.println("Url : " + Text);
			HttpURLConnection conn = (HttpURLConnection) new URL(Text).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int ResponseCode = conn.getResponseCode();
			//SoftA
			if (ResponseCode >= 200) {
				System.out.println("This URL is valid : " + Text);
			}

			else {
				System.out.println("This URL :" + Text + " is invalid/broken beccasue it's getting " + ResponseCode);
			}*/
		
	public static void BrokenLinkFinding(WebDriver driver) throws MalformedURLException, IOException {
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link:allLinks)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int ResponseCode=conn.getResponseCode();
			SoftAssert sa=new SoftAssert();
			sa.assertTrue(ResponseCode>200, "This url "+url+" is Broken");
		}
		
	}

}


