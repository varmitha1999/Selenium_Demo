package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQA_Login {
	  @Test
	  public void Login_Verification() {
		//Launch Chrome
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  //Enter URL
		  driver.get("https://demoqa.com");
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,250)", "");
		  driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		  driver.findElement(By.cssSelector("#item-0")).click();
		  
		  //for text box
		  driver.findElement(By.id("userName")).sendKeys("Varmitha");
		  driver.findElement(By.id("userEmail")).sendKeys("varmitha.a@gmail.com");
		  driver.findElement(By.id("currentAddress")).sendKeys("Thiruvallur");
		  driver.findElement(By.id("permanentAddress")).sendKeys("Thiruvallur");
		  driver.findElement(By.xpath("//button[@id='submit']")).click();
		  //driver.findElement(By.id("userName")).sendKeys("Varmitha");
		  //driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
		  driver.close();
	  }
}