package pk_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class OrangeHRM_Implicitwait {
	ChromeDriver driver;
	 
    @BeforeTest
    public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
 
    @Test
    public void Explicit_Wait() throws InterruptedException
 
    {
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        // -----------------ImplicitWait Example-------------

         driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click(); 
         //Thread.sleep(5000);
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         driver.findElement(By.linkText("Logout")).click();
         driver.findElement(By.id("logInPanelHeading")).isDisplayed();
 

        // ----------------ExplicitWait Example--------------
    /*    @SuppressWarnings("deprecation")
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.findElement(By.id("welcome")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
        System.out.println(element.getText());
        element.click();*/
 
    }
 
    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }
}
