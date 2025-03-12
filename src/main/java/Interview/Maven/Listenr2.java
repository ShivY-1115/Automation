package Interview.Maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenr2 implements ITestListener, ISuiteListener{

	
	public static WebDriver driver;
	public WebElement element;
	public void onTestFailure(ITestResult arg0) {
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File TargetPath = new File("path of screenshot");
		try {
			FileUtils.copyFile(Screenshot, TargetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0,500);");
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
		js.executeScript("arguments[0].style.border = '2px red'",element);
		js.executeScript("arguments[0].style.backgroundColor = 'red';", element);
		
		
	}
}
