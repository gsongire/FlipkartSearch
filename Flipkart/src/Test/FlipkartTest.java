package Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataReader.ExcelReader;
import DriverManageFactory.DriverFactory;
import DriverManageFactory.DriverManager;
import Enum.Drivers;
import pages.FlipKartPage;

public class FlipkartTest {
	
	DriverManager manager;
	WebDriver driver;
	
	@BeforeSuite
	
	public void setupBrowser() {
		
		Properties prop = new Properties();
		
		InputStream input = null;
		
		try {
			
			FileInputStream input1 = new FileInputStream("C:\\Users\\eddie\\eclipse-workspace\\Flipkart\\src\\Property\\Config.properties");
			
			prop.load(input1);
			
			String URL = prop.getProperty("URL");
			String driverType = prop.getProperty("Driver");
			manager = DriverFactory.getDriverManager(Drivers.valueOf(driverType));
			this.driver=manager.getWebDriver();
			driver.get(URL);
		}
		catch(Exception ex)
		{
	}
	}
		@AfterSuite
		
		public void closeBrowser() {
			
			manager.quitWebDriver();
		}
		
		
	
	
	@DataProvider
	public String[][] SearchData() {
		
		ExcelReader objExcelFile = new ExcelReader();
		String filePath = System.getProperty("user.dir")+"\\src\\TestData";
		String[][] dataSet = objExcelFile.readExcel(filePath, "FlipkartSearchData.xlsx", "sheet");
		return dataSet;
		
	}
	
	@Test(dataProvider="SearchData")
	
	public void FlipKartTest(String searchString) throws InterruptedException {
		
		FlipKartPage flipKart = new FlipKartPage(driver);
		flipKart.searchTheItem().clear();
		flipKart.searchTheItem().sendKeys(searchString);
		performAction(flipKart.driver);
		Thread.sleep(3000);
		flipKart.clickNthProductFromList(2);
		Thread.sleep(5000);
		flipKart.SwitchToParentWindow();
	}

	public static void performAction(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	}
