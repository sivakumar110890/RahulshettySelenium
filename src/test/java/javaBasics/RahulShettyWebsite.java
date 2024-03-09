package javaBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class RahulShettyWebsite {
	
	public static void main(String[] args) throws InterruptedException {
		
		String url= new String("https://rahulshettyacademy.com/locatorspractice/");
		String username= new String("sivakumar");
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(opt);
		String password=getPassword(driver, url);
		login(driver,username,password);
		PostLoginVerification(driver,username);
		
	}
	
	public static String getPassword(WebDriver driver, String url) throws InterruptedException {
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String ExtractedText=driver.findElement(By.xpath("//form[@action='#']/p")).getText();
		String[] splittedText=ExtractedText.split("'");
		String ExtractedPassword=splittedText[1].trim();
		System.out.println(splittedText[1].trim());
		return ExtractedPassword;
	}
	
	public static void login(WebDriver driver,String username,String ExtractedPassword) {
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(ExtractedPassword);
		driver.findElement(By.xpath("//button[@class=\"submit signInBtn\"]")).click();
		
	}
	
	public static void PostLoginVerification(WebDriver driver,String username) {
		String loggedInUsername=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/h2")).getText();
		Assert.assertEquals(loggedInUsername, "Hello "+username+",");
		System.out.println("Login Verification is successful");
	}

}
