package bootcampe.expedia;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;

public class expedia1 {
	public static WebDriver driver;
	
	@Parameters({"url"})
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\manic\\eclipse-workspace\\bootcamp\\driver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://www.expedia.com");
  }
  @Parameters({"origin", "destination","departdate", "arrivaldate"})
  @Test
  public void f() throws InterruptedException {
	  WebElement flightTab = driver.findElement(By.xpath("//span[text()='Flights']"));
		flightTab.click();

		WebElement leaveFrom = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
		leaveFrom.click();
		
		WebElement enterLeaveFrom = driver.findElement(By.xpath("//input[@placeholder='Where are you leaving from?']"));
		enterLeaveFrom.sendKeys("iad" + Keys.ENTER);

		WebElement goingTo = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
		goingTo.click();
		
		WebElement enterGoingTo = driver.findElement(By.id("location-field-leg1-destination"));
		enterGoingTo.sendKeys("jfk" + Keys.ENTER);

		WebElement departDate = driver.findElement(By.id("d1-btn"));
		departDate.click();
		driver.findElement(By.xpath("(//*[@data-day='27'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@data-day='29'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='Done'])[2]")).click();

		Thread.sleep(3000);
				
		WebElement search = driver.findElement(By.xpath("//*[@type='submit']"));
		search.click();
		Thread.sleep(9000);
		
	
  }
  
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  
		  Thread.sleep(5000);
		  driver.close();
  }

}
