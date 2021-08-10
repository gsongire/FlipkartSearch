package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FlipKartPage {

	private By searchBox = By.name("q");
	
	
	public WebDriver driver;
	
	public FlipKartPage(WebDriver driver) {
		
		this.driver=driver;
		closeLoginPopUp();
	}	
	
	public WebElement searchTheItem() {
		
		return driver.findElement(searchBox);
	}
	
	
	public void closeLoginPopUp() {
		
		Actions actions = new Actions(driver);
		Action action = actions.sendKeys(Keys.ESCAPE).build();
		action.perform();
	}
	
	public void SwitchToParentWindow() {
		
		driver.switchTo().defaultContent();
	}
	
	public void clickNthProductFromList(int nElement) {
		
		driver.findElement(By.xpath("//div[starts-with(@class,'_1AtVbE')]//div[@data-id])["+nElement+"]")).click();
		
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
	}
	
}
