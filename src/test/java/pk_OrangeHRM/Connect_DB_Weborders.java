package pk_OrangeHRM;

import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Connect_DB_Weborders extends Base_Class{
	public class Loginweborders {
	  	ChromeDriver driver;
	  	 
	      @BeforeTest
	      public void LaunchBrowser() {
	          WebDriverManager.chromedriver().setup();
	          driver = new ChromeDriver();
	          driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	          driver.manage().window().maximize();
	      }
	   
	      @AfterTest
	      public void CloseBrowser() {
	          driver.quit();
	      }
	   
	      @Test
	      public void ConnectSQLDB_With_LoginApp() throws ClassNotFoundException, SQLException, InterruptedException,
	              InstantiationException, IllegalAccessException {
	   
	          ArrayList<String> sqlData = ConnectMySQLDatabase("jdbc:mysql://localhost:3306/weborders", "root", "root","select *from login");
	          System.out.println("SQL Data from DB Example Class : " + sqlData + "\n Array List Size : " + sqlData.size());
	   
	          for (String sqlValues : sqlData) {
	              System.out.println(sqlValues + " split : 0\t" + sqlValues.split("~")[0]);
	              System.out.println(sqlValues + " split : 1\t" + sqlValues.split("~")[1]);
	              String uname=sqlValues.split("~")[0];
	              String upass=sqlValues.split("~")[1];
	              //String expresult=sqlValues.split("~")[1];
	   
	              driver.findElement(By.id("ctl00_MainContent_username")).clear();
	              driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uname);
	              driver.findElement(By.id("ctl00_MainContent_password")).clear();
	              driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(upass);
	              driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	              Thread.sleep(4000);
	              driver.findElement(By.linkText("Logout")).click();

	        	  if(driver.findElement(By.id("ctl00_MainContent_login_button")).isDisplayed()) {
	        	  System.out.println("Logout Successfully");
	        	  }
	        	  else {
	        	  System.out.println("Logout Failed");
	        	  }
	              /*driver.findElementById("welcome").click();
	              Thread.sleep(3000);
	              driver.findElementByLinkText("Logout").click();
	              Thread.sleep(3000);*/
	          }
	      }
}
}
