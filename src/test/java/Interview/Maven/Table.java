package Interview.Maven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Table {

	  public static WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  //options.addArguments("incognito");
	  
	  WebDriver driver = new ChromeDriver(options);
	  JavascriptExecutor js = (JavascriptExecutor) driver;

	  driver.get("https://www.kapruka.com/online/samedaydelivery");

	  waitForPageLoadWithRetries(driver, 3, 2000);

	  WebElement element = driver.findElement(By.xpath("//*[text()='Top Same Day Delivery Products on Kapruka']"));
	  js.executeScript("arguments[0].scrollIntoView(true);", element);

	  Thread.sleep(3000);


	  List<WebElement> rows = driver.findElements(By.xpath("//tr"));
	  System.out.println(rows.size());
	  for(WebElement row: rows){
		  List<WebElement> valus = row.findElements(By.tagName("td"));
		  for(WebElement item: valus){
			  System.out.print(item.getText() + " | ");
		  }
		  System.out.println();

	  }
 
	  
	  
  }

	// java
	public static boolean waitForPageLoadWithRetries(WebDriver driver, int maxRetries, long pauseMillis) throws InterruptedException {
		if (driver == null) return false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int attempts = 0;
		while (attempts < maxRetries) {
			Object state = js.executeScript("return document.readyState");
			if ("complete".equals(state)) {
				return true;
			}
			attempts++;
			Thread.sleep(pauseMillis);
		}
		return false;
	}

}
