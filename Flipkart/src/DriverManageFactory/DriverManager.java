package DriverManageFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	
	protected abstract void CreateWebDriver();
	
	public WebDriver currentDriver = this.getWebDriver();
	
	public void quitWebDriver()
	{
		
		if(null!= driver)
		{
			driver.quit();
			driver=null;
		}
	}
		
	public WebDriver getWebDriver() {
		
		if(null == driver) {
			
			CreateWebDriver();
		}
		
		return driver;
	}
	
}
