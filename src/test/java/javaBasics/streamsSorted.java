package javaBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class streamsSorted {

	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		propertyFileLoading();
		String url = prop.getProperty("urlStreamSort");
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// streamSort();
		getThePrice();
	}

	public static void streamSort() {
		List<WebElement> elementsListBefore = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalListBefore = elementsListBefore.stream().map(s -> s.getText())
				.collect(Collectors.toList());

		System.out.println("Before clicking the sort button : " + originalListBefore);

		WebElement sortButton = driver.findElement(By.xpath("//tr/th[1]"));
		sortButton.click();

		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> SortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("After clicking the sort button : " + SortedList);
		Assert.assertTrue(originalList.equals(SortedList));
		if (originalListBefore != SortedList) {
			System.out.println("Both the values are equal");
		}

	}

	public static void getThePrice() {
		List<WebElement> listOfVeg = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> price = listOfVeg.stream().filter(s -> s.getText().contains("Tomato")).map(s -> getRicePrice(s))
				.collect(Collectors.toList());

		price.forEach(a -> System.out.println("Price of the Potata : " + a));
	}

	public static String getRicePrice(WebElement s) {
		String PriceOfRice = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();

		return PriceOfRice;
	}

	public static Properties propertyFileLoading() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}
}
