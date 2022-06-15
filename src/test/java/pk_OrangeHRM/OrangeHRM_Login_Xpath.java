package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Xpath {
  @Test
  public void Login_Verification() {
		//Launch Chrome
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  //Enter URL
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
		  //Enter User Login Details
		  driver.findElement(By.xpath("//body[1]/form[1]/div[3]/input[1]")).sendKeys("Tester"); //input[id='ctl00_MainContent_username']
		 System.out.println("Working");
		  driver.findElement(By.xpath("//body[1]/form[1]/div[3]/input[2]")).sendKeys("test");
		  System.out.println("Working");
		  //Click Login Btn
		  driver.findElement(By.xpath("//body[1]/form[1]/div[3]/input[3]")).click();
		  //Exp Result : Verify User landed in DashBoard
		  if(driver.findElement(By.xpath("//body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/ul[1]/li[3]/a[1]")).isDisplayed()) {
		  System.out.println("Login Successfully");
		  }
		  else {
		  System.out.println("Login Failed");
		  }

		  //Click Logout
		  driver.findElement(By.xpath("//body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/span[1]/a[1]")).click();

		  if(driver.findElement(By.xpath("//body[1]/form[1]/div[3]/input[3]")).isDisplayed()) {
		  System.out.println("Logout Successfully");
		  }
		  else {
		  System.out.println("Logout Failed");
		  }
		  //Close Browser
		  driver.quit();
	  }
}
