package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitExample {
	public static WebDriver driver =null;
	public static Properties prop ;

	public static void main(String[] args) throws IOException {
		loadPropertyfile();		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("CHROME")) 
		{
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "D:\\Selenium\\drivers\\chrome_latest\\new@31-08-23\\chrome-win64\\chrome.exe"
			 * ); ChromeOptions op = new ChromeOptions();
			 * op.addArguments("--remote-allow-origins=*"); //driver =
			 * WebDriver.Chrome(service=Service(ChromeDriverManager().install()),
			 * options=chrome_options)
			 */
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("FIREFOX")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\gecko\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}	
		else if (browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\gecko\\geckodriver.exe");
			driver = new EdgeDriver();
			
		}	
		
		String url=prop.getProperty("urlforimplicitwait");
		String[] itemsNeeded= {"Cucumber","Carrot","Banana"};
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addItemsintoCart(driver, itemsNeeded);
		
	}
	public static Properties loadPropertyfile() throws IOException {
		FileInputStream fileinput= new FileInputStream(System.getProperty("user.dir")+"\\config\\config.properties");
		prop=new Properties();
		prop.load(fileinput);
		return prop;

	}
	public static void addItemsintoCart(WebDriver driver,String[] itemsNeeded) {
		
		List<WebElement> Products=driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		for(int i=0;i>Products.size();i++) {
			String[] name=Products.get(i).getText().split("-");
			String formattedName=name[0].trim();			
			System.out.println("Name : " +name);
			System.out.println("formattedName : " +formattedName);	
			List<String> itemsNeededList=Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName)) {
				WebElement addButtonClick=driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
				addButtonClick.click();
			}
			
			
			//j++;
			
		}
		
		
	}
}
