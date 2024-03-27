package chromeDevTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.*;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Chrome_V_122\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*
		 * DevTools devtools=driver.getDevTools(); devtools.createSession();
		 * devtools.send(Network.enable(Optional.empty(), null, null));
		 * devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		 */
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.xpath("//button[@class=\"add-to-cart btn btn-default\"]")).click();
		
	}
}
