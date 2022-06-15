package pk_Web_Orders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class UpdateOrders_Verify {
 
 
  public class AddOrders_VerifyOrders {
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
     
        @Test
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
  	        String name="VARMITHA";
            String Verifycustomername = driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).getText(); 	
          	        System.out.println(Verifycustomername);
          	        Assert.assertEquals(name, Verifycustomername);
          	        System.out.println("Order Success"); 
          	        Thread.sleep(5000);
          	     driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//following::input[1]")).click(); 
          	     String updatevalue = "THIRUVALLUR";
          	  WebElement edits= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
          	  edits.clear();
          	  edits.sendKeys(updatevalue);
          	 Thread.sleep(5000);
          	     driver.findElement(By.partialLinkText("Update")).click();
          	   String city = driver.findElement(By.xpath("//td[contains(text(),'"+updatevalue+"')]")).getText();
             	        System.out.println(city);
             	        Assert.assertEquals(city, updatevalue);
             	        System.out.println("Update Success"); 
          	   
          	    //td[contains(text(),'90809')] //following::input[1]
            //driver.close();// Close will close only current chrome browser
        }
    }

  }


