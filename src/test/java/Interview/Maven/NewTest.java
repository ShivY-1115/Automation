package Interview.Maven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import Reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class NewTest {

	public ExtentReports extent;
	public ExtentTest test;


	public WebDriver driver;
  @Test
  public void f() throws MalformedURLException, IOException, InterruptedException {
	  test = extent.createTest("Login Test");
	  ChromeOptions options = new ChromeOptions();
		
		  options.addArguments("--disable-notifications");
		  options.addArguments("incognito");
		 //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikar\\eclipse-workspace\\Maven\\src\\test\\resources\\chromedriver.exe");
	  
	   driver = new ChromeDriver(options);
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  try{
		  driver.findElement(By.xpath("//*[text()='Continue shopping']")).click();
	  } catch (Exception e) {
           System.out.println("Unable to find Continue Shopping");
	  }
      Thread.sleep(5000);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      String state = (String) js.executeScript("return document.readyState");
      if (state.equals("complete")) {
    	  System.out.println("Page is fully loaded");
      }else {
    	  System.out.println("Page is not loaded");
      }


      WebElement element = driver.findElement(By.xpath("//div[@class=\"navFooterColHead\"]"));
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOf(element));

	  driver.findElement(By.xpath("//*[text()='Mobiles']")).click();
      
      /*js.executeScript("arguments[0].style.backgroundColor='red';",element);
      Thread.sleep(5000);*/
      
      
      /*js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",element);
      Thread.sleep(4000);*/
      
      //js.executeScript("window.scrollTo(0,500);");
	  
	 // List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@id,'desktop-grid-')]"));

	  WebElement elem = driver.findElement(By.xpath("(//*[contains(text(),'Mobiles &')])[3]"));

	  Actions act = new Actions(driver);
	  act.moveToElement(elem).perform();

	  WebElement menu = driver.findElement(By.xpath("//*[@class=\"mega-menu\"]"));


	  
 	  //System.out.println("The size of the link is "+links.size());
	  for(int i=1;i<=5;i++)
	  {
		  WebElement ele = driver.findElement(By.xpath("(//*[@class=\"mm-column\"])["+i+"]"));
		  List<WebElement> links = ele.findElements(By.tagName("a"));
		  for(WebElement item:links){
			  String url = item.getAttribute("href");
			  String text = item.getText();
			  System.out.println("The url under the "+i+" is: "+text+url);
		  }
	  }

	  Thread.sleep(2000);

	  test.pass("Login successful");






	 /* for(WebElement item:links) {
		  String url = item.getAttribute("href");
		  if(url != null && !url.isEmpty()) {
			  try {
				  HttpsURLConnection connection = (HttpsURLConnection) (new URL(url).openConnection());
				  connection.setRequestMethod("HEAD");
				  connection.connect();
				  int ResponseCode = connection.getResponseCode();
				  if (ResponseCode >= 200 && ResponseCode < 300) {
					  System.out.println(url+" is a valid link");
				  }else if (ResponseCode >= 300 && ResponseCode < 400) {
					  System.out.println(url+" is fine or redirected");
				  }else {
					  System.out.println(url+" is broken link");
				  }
			  }catch (MalformedURLException e){
				  System.out.println(e);
				  break;
			  }

		  }
		  
	  }*/
	  
	 /* Actions act1 = new Actions(driver);
	  act1.dragAndDrop(element, element);*/
	  
	 /* String url = "";
	  HttpsURLConnection huc = (HttpsURLConnection) (new URL(url).openConnection());
	  huc.setRequestMethod("HEAD");
	  huc.connect();
	  int responsecode = huc.getResponseCode();
	  
	  
	  Set<String> whandles = driver.getWindowHandles();
	  for(String item:whandles) {
		  
			
		}
	  
     
      JavascriptExecutor js1 = (JavascriptExecutor) driver;
      js1.executeScript("arguments[0].style.display='block';",element);
      js1.executeScript("arguments[0].value='username';",element);*/
	  
	  
	  
	  
  
	  
	  
  
  
  }

	@BeforeSuite
	public void setupReport() {
		extent = ExtentManager.getInstance();
	}

	@AfterSuite
	public void flushReport() {
		extent.flush(); // VERY IMPORTANT
	}




}
