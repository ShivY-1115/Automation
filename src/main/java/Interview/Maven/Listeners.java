package Interview.Maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener, ISuiteListener {
	
	public static  WebDriver driver;
	
	public void OnTestFailure(ITestResult arg0) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath = System.getProperty("user.dir")+File.separator+"\\reports\\Screenshots\\"+"Screenshot.png";
		File Targetpath = new File("destinatop of file");
		FileUtils.copyFile(screenshot, Targetpath);
	}

}
