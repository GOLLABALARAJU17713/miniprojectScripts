package testNG1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class frogotPassword {
	public String url="file:///C:/Users/itctesting19/Desktop/organdonation/login1.html";
	public WebDriver driver;
  @Test
  public void fogotPassword() throws InterruptedException {
	  driver.findElement(By.id("forgot password")).click();
	  Thread.sleep(500);
	  driver.findElement(By.id("username")).sendKeys("Balu1234");
		driver.findElement(By.id("Email")).sendKeys("killer@gmail.com");
		
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Balu1234");
		driver.findElement(By.id("submit")).click();
		
		

		driver.findElement(By.id("username")).sendKeys("Balu1234");
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		

		String expectedTitle = "Home Page";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
  }
  @BeforeTest
  public void beforeTest() {
	  String path6="D:\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", path6);
	  driver= new ChromeDriver();
	  driver.get(url);  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
