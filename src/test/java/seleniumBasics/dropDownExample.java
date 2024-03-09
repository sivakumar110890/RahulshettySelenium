package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropDownExample {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String url = new String("https://rahulshettyacademy.com/dropdownsPractise/");
		System.setProperty("webdriver.chrome.drive", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		// StaticDropdown(driver);  // in order to execute the static dropdown uncomment this line 
		//updatedDropdown(driver);  // xpath based dropdown 
		twoElementswithSameXpath(driver);
		AutoFillDropDown(driver);
		checkBoxSelection(driver);
		returnDateIsEnabledOrNot(driver);
		ClickSearButton(driver);
		//CloseBrowser(driver);
	}

	public static void StaticDropdown(WebDriver driver) throws InterruptedException {

		WebElement CurrencyDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select currencySelect = new Select(CurrencyDropdown); // when there is tag name in html file with select that means that dropdown is static dropdown
		currencySelect.selectByIndex(3);
		String FirstOutput=currencySelect.getFirstSelectedOption().getText();
		System.out.println("First selected value from the DropDown : "+FirstOutput);
		Thread.sleep(5000);

		currencySelect.selectByValue("AED");
		String secondOutput=currencySelect.getFirstSelectedOption().getText();
		System.out.println("Second Selected value from the DropDown : "+secondOutput);
		Thread.sleep(5000);

		currencySelect.selectByVisibleText("INR");
		String thirdOutput=currencySelect.getFirstSelectedOption().getText();
		System.out.println("Third selected value from the DropDown : "+thirdOutput);
		Thread.sleep(5000);

	}

	public static void updatedDropdown(WebDriver driver) throws InterruptedException {
		int AdultCount=4;
		WebElement PassengersClick=driver.findElement(By.id("divpaxinfo"));
		PassengersClick.click();

		Thread.sleep(5000);
		WebElement AdultIncreementClick=driver.findElement(By.id("hrefIncAdt"));
		WebElement AdultDecreementClick=driver.findElement(By.id("hrefDecAdt"));
		WebElement passengerDoneClick=driver.findElement(By.id("btnclosepaxoption"));
		String TotalAdultSelectedBefore=PassengersClick.getText();
		System.out.println("Total Adults selected before : "+TotalAdultSelectedBefore);
		for(int i=1;i<AdultCount;i++) 
		{
			AdultIncreementClick.click();
		}

		passengerDoneClick.click(); 
		String TotalAdultSelectedAfter=PassengersClick.getText();
		System.out.println("Total Adults selected After : "+TotalAdultSelectedAfter);

		Assert.assertEquals(TotalAdultSelectedAfter, "4 Adult");
	}
	public static void CloseBrowser(WebDriver driver)
	{	
		driver.quit();
	}

	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void twoElementswithSameXpath(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		WebElement SourceButton=driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		WebElement DestinationButton=driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		SourceButton.click();


		WebElement FromBangalore=driver.findElement(By.xpath("//a[@text=\"Bengaluru (BLR)\"]"));

		Thread.sleep(5000);
		FromBangalore.click();

		WebElement KochiDestination=driver.findElement(By.xpath("(//a[@text=\"Kochi (COK)\"])[2]"));
		Thread.sleep(5000);

		KochiDestination.click();
		
		
		// //div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"]  //a[@value="GOI"]   From source GOA
		// //div[@id="glsctl00_mainContent_ddl_originStation1_CTNR"]  //a[@value="GOI"]   in destination GOA

		WebElement DepartDateCurrentDate=driver.findElement(By.xpath("//a[@class='ui-state-public ui-state-highlight ui-state-hover']"));
		DepartDateCurrentDate.click();

	}
	public static void AutoFillDropDown(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		WebElement CountryNameInput=driver.findElement(By.id("autosuggest"));
		CountryNameInput.sendKeys("ind");
		
		List<WebElement> CountryIndialists=driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]"));
		
		for(WebElement india:CountryIndialists) {
			if(india.getText().equalsIgnoreCase("INDIA"))
			{
				india.click();
				break;
			}
		}
	}
	
	public static void checkBoxSelection(WebDriver driver) {
		List<WebElement> TextBoxes=driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		int countOfTheTextboxes=TextBoxes.size();
		System.out.println("Total Text Boxes available : "+countOfTheTextboxes);
		
		WebElement studentCheckBox=driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
		studentCheckBox.click();
		
		
	}
	public static void returnDateIsEnabledOrNot(WebDriver driver) {
		WebElement returnDate=driver.findElement(By.id("Div1"));
		String returnDateAttribute=returnDate.getAttribute("style");
		if(returnDateAttribute.contains("0.5")) {
			System.out.println("The Return Date is disabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(true);
		}
	}
	/*public static void futureDateSelection(WebDriver driver) {
		WebElement CurrentMonth = driver.findElement(By.xpath("//div[@class=\"ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left\"] //span[@class=\"ui-datepicker-month\"]"));
		WebElement CurrentYear	= driver.findElement(By.xpath("//div[@class=\"ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left\"] //span[@class=\"ui-datepicker-year\"]"));
		WebElement NextButton=driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]"));
		
		for(WebElement Augustmonth:CurrentMonth) {
			if(Augustmonth.getText().equalsIgnoreCase("August")) {
				NextButton.click();
				break;
			}*/
			
			
		
	public static void ClickSearButton(WebDriver driver) {
		WebElement SearchButton=driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		SearchButton.click();
		
	}
}
