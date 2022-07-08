package automationFramework;


	import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import automationFramework.ExcelUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	//import com.google.common.base.Function;

	public class loginHome {
	    private WebDriver driver;
	    private ExcelUtility utility;
	  //  private Wait<WebDriver> wait;

	    @DataProvider
	    public Object[][] getTestData() throws Exception {
	        utility = new ExcelUtility();

	       
	        int totalRows=utility.getRowCount("D:\\ExcelData\\ExcelData.xlsx", "UsernamePassword");
	        int totalColumns=utility.getColumnCount("D:\\ExcelData\\ExcelData.xlsx", "UsernamePassword");
	        System.out.println("=> Total rows and columns is/are ("+totalRows+", "+totalColumns+")");

	        Object[][] data = new Object[totalRows][totalColumns];
	        for(int i=0;i<totalRows;i++) {
	            for(int j=0;j<totalColumns;j++) {
	                // Give your excel absolute path with the extension
	             
	            data[i][j]=new ExcelUtility().getData("D:\\ExcelData\\ExcelData.xlsx", "UsernamePassword", i, j);            }
	        }
	        return data;
	    }

	   
	    @BeforeMethod(firstTimeOnly = true)
	    public void setup() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	        this.driver = new ChromeDriver();

	        driver.get("file:///C:/Users/itctesting19/Desktop/organdonation/login1.html");
			Thread.sleep(2000);
	       

	     
	    }

	    @Test(dataProvider = "getTestData")
	    public void test(String userName, String password) throws Exception {
	    	
	    	this.driver.findElement(By.id("username")).sendKeys(userName);
			
			this.driver.findElement(By.id("Password")).sendKeys(password);
			Thread.sleep(1000);
			this.driver.findElement(By.id("submit")).click();
			this.driver.switchTo().alert();
			Alert alert1 =driver.switchTo().alert();
			alert1.accept();
	 	    this.driver.findElement(By.id("logout")).click();

	    }
	 
	}
