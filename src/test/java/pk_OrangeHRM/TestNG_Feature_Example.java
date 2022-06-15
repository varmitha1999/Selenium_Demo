package pk_OrangeHRM;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Feature_Example {
  ChromeDriver driver;
  @BeforeTest
  public void LaunchBrowser()
  {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  }
  //@Test(priority=1, description = "OrangeHRM SignOn Functionality")
  @Test(priority=1, timeOut =4000)
  
  // This is for Sign On Functionality
  public void Sign_On() throws InterruptedException

  {
      driver.findElement(By.name("txtUsername")).sendKeys("Admin");
      driver.findElement(By.name("txtPassword")).sendKeys("admin123");
      driver.findElement(By.id("btnLogin")).click();
      String Element = driver.findElement(By.linkText("Dashboard")).getText();
      System.out.println(Element);

  }

  @Test(priority=2,expectedExceptions={NoSuchElementException.class},description = "OrangeHRM Add user Functionality")
  //@Test(priority=2)
  public void AddUsers_Page()
  {
      WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
      Actions action = new Actions(driver);
      action.moveToElement(admin).build().perform();
      WebElement usermanagement = driver.findElement(By.linkText("User Management"));
      action.moveToElement(usermanagement).build().perform();
      driver.findElement(By.linkText("Users")).click();
      //User Click on Add Button to add users
      driver.findElement(By.id("searchBtn")).click();
      driver.findElement(By.id("btnAddd")).isDisplayed();

  }
  @Test(priority=3,enabled=false)
  public void VerifyAddedUser() throws InterruptedException
  {
      driver.findElement(By.id("btnAdd")).click();

      //Enter all the mandatory Fields
      Select SelectPass = new Select(driver.findElement(By.id("systemUser_userType")));
      //SelectPass.selectByValue("1");
      SelectPass.selectByVisibleText("Admin");
      //SelectPass.selectByIndex(0);
      driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
      Random randomGenerator = new Random();  
      int randomInt = randomGenerator.nextInt(100); 
      driver.findElement(By.id("systemUser_userName")).sendKeys("abhidixit"+randomInt);
      driver.findElement(By.id("systemUser_password")).sendKeys("Pass@2212");
      driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Pass@2212");
      Thread.sleep(5000);
      driver.findElement(By.id("btnSave")).click();
      Thread.sleep(5000);
      String ExpUserName="abhidixit"+randomInt;
      System.out.println(ExpUserName);
      //WebElement cellIneed = driver.findElementByXPath("//*[@id='resultTable']/tbody/tr[1]/td[2]/a");
      WebElement cellIneed = driver.findElement(By.xpath("//a[contains(text(),'abhidixit"+randomInt+"')]"));
      //a[contains(text(),'abhidixit699')]
      //---//a[text()='"+ExpUserName+"']
      String valueIneed = cellIneed.getText();
      System.out.println("Cell value is : " + valueIneed); 
      Assert.assertEquals(ExpUserName, valueIneed);
  }
  @AfterTest
  public void CloseBrowser()
  {
      driver.quit();
  }
}
