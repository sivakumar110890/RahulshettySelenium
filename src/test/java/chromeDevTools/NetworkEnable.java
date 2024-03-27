package chromeDevTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.fetch.Fetch;
import org.openqa.selenium.edge.EdgeDriver;

import com.qeagle.devtools.protocol.commands.Network;

public class NetworkEnable {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\drivers\\edge\\msedgedriver.exe");
		EdgeDriver driver =new EdgeDriver();
		DevTools devtools =  driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtools.addListener(Fetch.requestPaused(), request -> 
		{
			if(request.getRequest().getUrl().contains("=shetty")) {
			String MockedUrl=request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				
			devtools.send(Fetch.continueRequest(request.getRequestId(), 
					Optional.of(MockedUrl), Optional.of(request.getRequest().getMethod()),Optional.empty(),Optional.empty()));
			
			
			}
		}
				);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/library");
		driver.findElement(By.xpath("//button[@routerlink=\"/library\"]")).click();
		
		
		
		
		
		
	}

}
