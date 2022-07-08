package testNG1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class createAccountToHomePage {
	public String url="file:///C:/Users/itctesting19/Desktop/organdonation/login1.html";
	public WebDriver driver;
  @Test
  public void createAccount() throws InterruptedException {
	  driver.findElement(By.id("create")).click();
	  
	  Thread.sleep(500);
	  driver.findElement(By.id("name")).sendKeys("Balaraju");
	  driver.findElement(By.id("username")).sendKeys("Balaraju12");
	  driver.findElement(By.id("Email")).sendKeys("killer@gmail.com");
	  driver.findElement(By.id("number")).sendKeys("9645273645");
	  driver.findElement(By.id("Password")).sendKeys("vicky123");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("vicky123");
      WebElement radio1 = driver.findElement(By.id("male"));
	  radio1.click();
	  driver.findElement(By.id("submit")).click();
	  driver.switchTo().alert();
   	  Alert alert =driver.switchTo().alert();
	  alert.accept();
		    
	  driver.findElement(By.id("username")).sendKeys("Balaraju12");
	  driver.findElement(By.id("Password")).sendKeys("vicky123");
	  driver.findElement(By.id("submit")).click();
	  driver.switchTo().alert();
	  Alert alert1 =driver.switchTo().alert();
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
	  driver.close();
  }

}
