package Practice;

import org.testng.annotations.Test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class December_29th {
	
	public static WebDriver driver;
	
  @Test
  public void f() throws InterruptedException, MalformedURLException, IOException, AWTException {
	  
	  WebElement element = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
	  element.sendKeys("Galaxy S24 Ultra");
	  element.sendKeys(Keys.ENTER);
	  List<WebElement> names1 = driver.findElements(By.xpath("//div[@data-cy=\"title-recipe\"]/child::a/descendant::span"));
	  for(WebElement item:names1) {
		  String text = item.getText();
		  System.out.println(text);
	  }
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollTo(0,500)");
	  
	  Thread.sleep(4000);
	  WebElement mobile2 = driver.findElement(By.xpath("//*[contains(text(),'Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Black, 12GB, 256GB Storage)_Without Offer')]"));
	  js.executeScript("arguments[0].scrollIntoView(true);",mobile2);
	  
	  js.executeScript("arguments[0].style.border='2px solid red'",mobile2);
	  js.executeScript("arguments[0].style.backgroundColor='yellow'",mobile2);

	  Thread.sleep(4000);
	  js.executeScript("arguments[0].style.border=''",mobile2);

	  js.executeScript("alert('This is a javaScript alert');");
	  Thread.sleep(4000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  
	  for(WebElement item:links) {
		  String URL1= item.getAttribute("href");
		  if(URL1 != null && !URL1.isEmpty()) {
			  HttpURLConnection huc = (HttpURLConnection) (new URL(URL1).openConnection());
			  huc.setRequestMethod("HEAD");
			  huc.connect();
			  int responsecode = huc.getResponseCode();
			  if(responsecode>=400) {
				  System.out.println(URL1+"This is a broken link");
			  }else {
				  System.out.println(URL1+" is perfect link");
			  }
		  }
	  }
	  
	  File f= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  Date d= new Date();
	  String name = d.toString().replace(":", "_")+".png";
	  File new_f = new File(name);
	  FileUtils.copyFile(f, new_f);
	  
	  
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(null, null);
	  Robot robo = new Robot();
	  robo.keyPress(KeyEvent.VK_CONTROL);
	  
	  element.sendKeys(Keys.F5);
	  
	  
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  driver=new ChromeDriver(options);
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.manage().window().maximize();
	  
	  
	  
	  
	  
	  
  }

}
