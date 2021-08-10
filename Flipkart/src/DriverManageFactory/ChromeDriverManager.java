package DriverManageFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
	
	@Override
	
	public void CreateWebDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eddie\\eclipse-workspace\\Flipkart\\src\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---started --maximized");
		this.driver = new ChromeDriver(options);
	}
	
	
	
	

}
