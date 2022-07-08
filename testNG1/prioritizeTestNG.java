package testNG1;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class prioritizeTestNG {
	public String url="file:///C:/Users/itctesting19/Desktop/organdonation/login1.html";
	public WebDriver driver;
  @Test(priority=1)
  public void createAccount() throws Exception  {
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
  @Test(priority=2)
  public void loginTOHomePage() throws Exception   {
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
  @Test(priority=3)
  public void forgotPassword() throws Exception   {
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
  @Test(priority=4)
  public void aboutUs() throws Exception   {
	  driver.findElement(By.id("username")).sendKeys("Balu1234");
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		
		driver.findElement(By.id("about")).click();
		
		String expectedTitle = "About Us";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  @Test(priority=5)
  public void admin() throws Exception   {
	  driver.findElement(By.id("username")).sendKeys("Balu1234");
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		
		
		driver.findElement(By.id("btn")).click();
		
		String expectedTitle = "Admin";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  @Test(priority=6)
  public void organForm() throws Exception   {
	  driver.findElement(By.id("username")).sendKeys("Balu1234");
		driver.findElement(By.id("Password")).sendKeys("Balu1234");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		driver.findElement(By.id("blood & orgran")).click();
	    driver.findElement(By.id("fname")).sendKeys("Balaraju");
		driver.findElement(By.id("Last_Name")).sendKeys("GOLLA");
		driver.findElement(By.id("date")).sendKeys("09-03-2001");
		driver.findElement(By.id("Email_Id")).sendKeys("killer@gmail.com");
		driver.findElement(By.id("Mobile_Number")).sendKeys("9645273645");
		WebElement radio1 = driver.findElement(By.id("male"));
		radio1.click();
		driver.findElement(By.id("Address")).sendKeys("5-18, Narasapuram, Ananthapur");
		driver.findElement(By.id("City")).sendKeys("Ananthapuram");
		driver.findElement(By.id("Pincode")).sendKeys("515763");
		WebElement drop1 = driver.findElement(By.id("text"));
		Select select1 = new Select(drop1);
		select1.selectByIndex(11);
		WebElement radio2 = driver.findElement(By.id("AB+"));
		radio2.click();
		WebElement checkBoxSelect = driver.findElement(By.id("Heart"));
		Boolean isSelect = checkBoxSelect.isSelected();
		if (isSelect == false) {
			checkBoxSelect.click();
		}
		driver.findElement(By.id("adhaar")).sendKeys("669802947397");
		driver.findElement(By.id("submit")).click();
		
		
		
		String expectedTitle = "Message";
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
      driver.close();
  }

}
