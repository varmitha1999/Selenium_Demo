package pk_OrangeHRM;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
public class OrangeHRM_Login_Parameters {
	WebDriver driver;
	 
    @Test
    @Parameters({"url","uname","upass"})
    public void Login(String url,String uname,String upass) throws InterruptedException {
        //driver.navigate().to(url);
        driver.get(url);
        driver.findElement(By.name("txtUsername")).sendKeys(uname);
        driver.findElement(By.name("txtPassword")).sendKeys(upass);
        driver.findElement(By.id("btnLogin")).click();
        // Verify that Dashboard page displayed
        String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
        String ExpElement = "Dashboard";
        Assert.assertEquals(ActElement, ExpElement);
        System.out.println(ActElement);
 
        driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.id("logInPanelHeading")).isDisplayed();
 
    }
 
    @BeforeTest
    public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
 
    @AfterTest
    public void CloseBrowser() {
        // driver.close();//Close will close only current chrome browser
        driver.quit();
    }
}
