// Please add the code for web orders

package pk_OrangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


  public class WebOrders {
  	ChromeDriver driver;
  	 
      @BeforeTest
      public void LaunchBrowser() {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();
      }
   
      @AfterTest
      public void CloseBrowser() {
          driver.quit();
      }
  }
     /* @Test
      // This is for Sign On Functionality
      public void AddUser_VerifyUser() throws InterruptedException
   
      {
   
          driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
          driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
          driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
          driver.findElement(By.id("ctl00_MainContent_login_button")).click();
          driver.findElement(By.linkText("Order")).click();
         // String Element = driver.findElement(By.linkText("Order")).getText();
          //System.out.println(Element);

          //WebElement orders = driver.findElement(By.id("Order"));
   
         // Actions action = new Actions(driver);
         // action.moveToElement(orders).build().perform();
          Select SelectPass = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
          //SelectPass.selectByValue("1");
          //SelectPass.selectByIndex(0);
          SelectPass.selectByVisibleText("MyMoney");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("12");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("120");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("1.2");
         
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("VARMITHA");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("XYVUOO ST");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("CHENNAI");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("TAMILNADU");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("606024");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("0999775857857");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/23");
          driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
          driver.findElement(By.linkText("View all orders")).click();
          String Customername = driver.findElement(
        			By.xpath("//table/tbody/tr[2]/td[2]")).getText(); 	
        	        System.out.println(Customername);
        	        String name="VARMITHA";
        	        Assert.assertEquals(name, Customername);
        	        System.out.println("Order Success"); 
          driver.close();// Close will close only current chrome browser
      }
  }*/



