package Interview.Maven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class NewTest {
	
	public WebDriver driver;
  @Test
  public void f() throws MalformedURLException, IOException, InterruptedException {
	  
	  ChromeOptions options = new ChromeOptions();
		
		  options.addArguments("--disable-notifications");
		  options.addArguments("incognito");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikar\\eclipse-workspace\\Maven\\src\\test\\resources\\chromedriver.exe");
	  
	   driver = new ChromeDriver(options);
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
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
      
      /*js.executeScript("arguments[0].style.backgroundColor='red';",element);
      Thread.sleep(5000);*/
      
      
      /*js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",element);
      Thread.sleep(4000);*/
      
      js.executeScript("window.scrollTo(0,500);");
	  
	  List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@id,'desktop-grid-')]"));
	  
	  for(WebElement item:cards) {
		  String data = item.getText();
		  System.out.println(data);
	  }
	  
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println("The size of the link is "+links.size());
	  for(WebElement item:links) {
		  String url = item.getAttribute("href");
		  if(url != null && !url.isEmpty()) {
			  HttpsURLConnection connection = (HttpsURLConnection) (new URL(url).openConnection());
			  connection.setRequestMethod("HEAD");
			  connection.connect();
			  int ResponseCode = connection.getResponseCode();
			  if (ResponseCode >= 200 && ResponseCode < 300) {
				  System.out.println(url+" is a valid link");
			  }else if (ResponseCode >= 300 && ResponseCode < 400) {
				  System.out.println(url+" is redirected");
			  }else {
				  System.out.println(url+" is broken link");
			  }
		  }
		  
	  }
	  
	  Actions act1 = new Actions(driver);
	  act1.dragAndDrop(element, element);
	  
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
}
