
package testNG1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginToAboutUsPage {
	public String url="file:///C:/Users/itctesting19/Desktop/organdonation/login1.html";
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	    driver.findElement(By.id("username")).sendKeys("Balu1234");
	    Thread.sleep(500);
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		Thread.sleep(500);
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("about")).click();
		
		String expectedTitle = "About Us";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
  }
  @BeforeMethod
  public void beforeMethod() {
	  String path6="D:\\chromedriver.exe";
	   System.setProperty("webdriver.chrome.driver", path6);
	   driver= new ChromeDriver();
	   driver.get(url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
