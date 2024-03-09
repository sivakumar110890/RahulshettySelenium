package seleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotExample {
	public static Properties prop;
	public static WebDriver driver;
	public static void main(String[] args) throws IOException{
		propertyfileLoader();
		String url=prop.getProperty("utlTakeAScreenshot");
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		takingScreenshot();
		driver.close();
	}
	
	public static Properties propertyfileLoader() throws IOException{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
		
	}
	
	public static void takingScreenshot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File(System.getProperty("user.dir")+"//screenshots//"+DateTimeFormat()+".png");
		FileUtils.copyFile(src, Destination);
		
	}
	
	public static String DateTimeFormat() {
		LocalDateTime currentTimeStamp=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYYMMDD_HHMMSS");
		String FinalTime=currentTimeStamp.format(formatter);
		System.out.println("currentTimeStamp: "+currentTimeStamp);
		System.out.println("formatter: "+formatter);
		System.out.println("Current Time is : "+FinalTime);
		return FinalTime;
		
	}

}
