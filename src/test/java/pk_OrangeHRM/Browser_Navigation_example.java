package pk_OrangeHRM;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
 
import junit.framework.Assert;

public class Browser_Navigation_example {
	ChromeDriver driver;
	//WebDriver driver;
	@Test
	public void ForgetPassword() throws InterruptedException
	{
	driver.findElement(By.xpath("//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Women']")).click();
	Thread.sleep(3000);
	String ExpURL="https://demo.spreecommerce.org/t/categories/women";
	String ActURL=driver.getCurrentUrl();
	Assert.assertEquals(ExpURL, ActURL);
	String ExpTitle="Women - Spree Demo Site";
	String ActTitle=driver.getTitle();
	Assert.assertEquals(ExpTitle, ActTitle);
	String Acttxt = driver.findElement(By.linkText("Women")).getText();
	String ExpText = "Women";
	Assert.assertEquals(Acttxt, ExpText);
	System.out.println(ActURL);
	System.out.println(ActTitle);
	System.out.println(Acttxt);

	driver.navigate().back();
	Thread.sleep(3000);
	String ExpURLHOME="https://demo.spreecommerce.org/";
	String ActURLHOME=driver.getCurrentUrl();
	Assert.assertEquals(ExpURLHOME, ActURLHOME);
	String ExpTitleHOME="Homepage (English) - Spree Demo Site";
	String ActTitleHOME=driver.getTitle();
	Assert.assertEquals(ExpTitleHOME, ActTitleHOME);
	String ExpTxtHome= driver.findElement(By.xpath("//span[normalize-space()='Create your own Spree project']")).getText();
	String ActTxtHome="Create your own Spree project";
	Assert.assertEquals(ExpTxtHome, ActTxtHome);
	System.out.println(ActURLHOME);
	System.out.println(ActTitleHOME);
	System.out.println(ActTxtHome);

	driver.navigate().forward();
	Thread.sleep(3000);
	String ExpURLFor="https://demo.spreecommerce.org/t/categories/women";
	String ActURLFor=driver.getCurrentUrl();
	Assert.assertEquals(ExpURLFor, ActURLFor);
	String ExpTitleFor="Women - Spree Demo Site";
	String ActTitleFor=driver.getTitle();
	Assert.assertEquals(ExpTitleFor, ActTitleFor);
	String ActtxtFor = driver.findElement(By.linkText("Women")).getText();
	String ExpTextFor = "Women";
	Assert.assertEquals(ActtxtFor, ExpTextFor);
	System.out.println(ActURLFor);
	System.out.println(ActTitleFor);
	System.out.println(ActtxtFor);
	driver.navigate().refresh();
	}
	//Pre-Condition
	@BeforeTest
	public void LaunchBrowser(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://demo.spreecommerce.org/");
	}
	//Post Condition
	@AfterTest
	public void CloseBrowser(){
	//driver.quit();
	}
	}