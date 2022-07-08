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

	public class organForm {
	    private WebDriver driver;
	    private ExcelUtility utility;
	  //  private Wait<WebDriver> wait;

	    @DataProvider
	    public Object[][] getTestData() throws Exception {
	        utility = new ExcelUtility();

	       
	        int totalRows=utility.getRowCount("D:\\ExcelData\\ExcelData.xlsx", "Sheet3");
	        int totalColumns=utility.getColumnCount("D:\\ExcelData\\ExcelData.xlsx", "Sheet3");
	        System.out.println("=> Total rows and columns is/are ("+totalRows+", "+totalColumns+")");

	        Object[][] data = new Object[totalRows][totalColumns];
	        for(int i=2;i<totalRows;i++) {
	            for(int j=0;j<totalColumns;j++) {
	                // Give your excel absolute path with the extension
	             
	            data[i][j]=new ExcelUtility().getData("D:\\ExcelData\\ExcelData.xlsx", "Sheet3", i, j);            }
	        }
	        return data;
	    }

	   
	    @BeforeMethod(firstTimeOnly = true)
	    public void setup() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	        this.driver = new ChromeDriver();

	        driver.get("file:///C:/Users/itctesting19/Desktop/organdonation/Organ.html");
			//Thread.sleep(2000);
	       

	     
	    }

	    @Test(dataProvider = "getTestData")
	    public void test(String Fname,String Lname, String dob,String email,String phoneno, String gender,String address,String city,String pincode,String state,String Bgroup,String Otype,String adhaar) throws Exception {
	    	this.driver.findElement(By.id("fname")).sendKeys(Fname);
	 	    this.driver.findElement(By.id("Last_Name")).sendKeys(Lname);
	 	    this.driver.findElement(By.id("date")).sendKeys(dob);
	 	    this.driver.findElement(By.id("Email_Id")).sendKeys(email);
	 	    this.driver.findElement(By.id("Mobile_Number")).sendKeys(phoneno);
	 		WebElement radio1 = driver.findElement(By.id(gender));
	 		radio1.click();
	 		this.driver.findElement(By.id("Address")).sendKeys(address);
	 		this.driver.findElement(By.id("City")).sendKeys(city);
	 		this.driver.findElement(By.id("Pincode")).sendKeys(pincode);
	 		WebElement drop1 = driver.findElement(By.id(state));
	 		drop1.click();
	 		WebElement radio2 = driver.findElement(By.id(Bgroup));
	 		radio2.click();
	 		WebElement checkBoxSelect = driver.findElement(By.id(Otype));
	 		checkBoxSelect.click();
	 		this.driver.findElement(By.id("adhaar")).sendKeys(adhaar);
	 		this.driver.findElement(By.id("submit")).click();
	      Thread.sleep(500);
	      this.driver.findElement(By.id("button")).click();
	      this.driver.findElement(By.id("blood & orgran")).click();
	  
	  
	    }
	 
	}

