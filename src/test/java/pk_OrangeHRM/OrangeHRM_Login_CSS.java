package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_CSS {
  @Test
  public void Login_Verification() {
		//Launch Chrome
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  //Enter URL
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
		  //Enter User Login Details
		  driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester"); //input[@id='ctl00_MainContent_username']
		 System.out.println("Working");
		  driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
		  System.out.println("Working");
		  //Click Login Btn
		  driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();
		  //Exp Result : Verify User landed in DashBoard
		  if(driver.findElement(By.cssSelector("tr:nth-child(1) td:nth-child(1) ul.menu:nth-child(2) li:nth-child(3) > a:nth-child(1)")).isDisplayed()) {
		  System.out.println("Login Successfully");
		  }
		  else {
		  System.out.println("Login Failed");
		  }

		  //Click Logout
		  driver.findElement(By.cssSelector("#ctl00_logout")).click();

		  if(driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).isDisplayed()) {
		  System.out.println("Logout Successfully");
		  }
		  else {
		  System.out.println("Logout Failed");
		  }
		  //Close Browser
		  driver.quit();
	  }
}
