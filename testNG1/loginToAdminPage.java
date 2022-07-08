package testNG1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginToAdminPage {
	public String url="file:///C:/Users/itctesting19/Desktop/organdonation/login1.html";
	public WebDriver driver;
  @Test
  public void f() {
	    driver.findElement(By.id("username")).sendKeys("Balu1234");
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		driver.switchTo().alert();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		driver.switchTo().alert();
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		
		driver.findElement(By.id("btn")).click();
		
		String expectedTitle = "Admin";
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
