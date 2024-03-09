package seleniumBasics;

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
import org.openqa.selenium.firefox.FirefoxDriver;

public class DateExample {
	public static Properties prop ;
	public static WebDriver driver ;

	public static void main (String[] args) throws IOException, InterruptedException {
		propertyFileLoader();
		String url=prop.getProperty("urldateExample");
		String browser=prop.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement sourceInput=driver.findElement(By.id("form-field-travel_from"));
		sourceInput.sendKeys("chennai");
		WebElement dateClick=driver.findElement(By.xpath("//input[@id=\"form-field-travel_comp_date\"]"));
		dateClick.click();
		monthSelection(driver);
		daySelecction(driver);
	}

	public static void monthSelection(WebDriver driver) throws InterruptedException {
	    WebElement CurrentMonth = driver.findElement(By.xpath("//span[@class='cur-month']"));
	    WebElement nextMonthButton = driver.findElement(By.xpath("//span[@class='flatpickr-next-month']"));

	    while (true) {
	        String CurrentMonthText = driver.findElement(By.xpath("//span[@class='cur-month']")).getText();
	        System.out.println("Current Month is: " + CurrentMonthText);
	        
	        if (CurrentMonthText.equalsIgnoreCase("January")) {
	            break; // Exit the loop when December is reached
	        }
	        
	        nextMonthButton.click();
	        Thread.sleep(5000);
	        // It's a good practice to introduce a wait here to ensure the page updates
	        // appropriately before trying to find the nextMonthButton and CurrentMonth elements again.
	    }
	}

	
	public static void daySelecction(WebDriver driver) 
	{
		List<WebElement> allDays=driver.findElements(By.xpath("//span[@class=\"flatpickr-day \"]"));
		for(int i=1; i<allDays.size();i++) 
		{
			String textDay=allDays.get(i).getText();
			System.out.println("Getting the day of the text"+textDay);
			if(textDay.equalsIgnoreCase("21")) 
			{
				System.out.println("The day 12 is clicked");
				allDays.get(i).click();
				break;
			}
		}
	}
	

			public static Properties propertyFileLoader() throws IOException {
				FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\config\\config.properties");
				prop = new Properties();
				prop.load(file);
				return prop;
			}

		}
