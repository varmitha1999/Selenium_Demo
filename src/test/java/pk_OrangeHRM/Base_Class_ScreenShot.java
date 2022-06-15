package pk_OrangeHRM;

import java.text.SimpleDateFormat;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;



import org.apache.commons.io.FileUtils;

public class Base_Class_ScreenShot {
	// String filePath_failure = "D:\\F Drive\\Selenium Training
	// Data\\workspace\\Maven_Selenium_WebDriver_4\\Screenshot_Failure";
	static String filePath = System.getProperty("user.dir");

	static String Relativepath_failure = filePath + "\\Screenshot_Failure";
	static String Relativepath_success = filePath + "\\Screenshot_Success";



	public static String getScreenshotfailure(WebDriver driver, String screenshotName) throws Exception {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	//after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = Relativepath_failure + "//"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
	}



	public static String getScreenshotSuccess(WebDriver driver, String screenshotName) throws Exception {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	//after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = Relativepath_success + "//"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
	}



	}
