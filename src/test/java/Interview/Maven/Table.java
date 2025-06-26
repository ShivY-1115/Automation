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
  @Test
  public void f() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  //options.addArguments("incognito");
	  
	  WebDriver driver = new ChromeDriver(options);
	  driver.get("https://www.kapruka.com/online/samedaydelivery");
	  driver.findElement(By.xpath("//*[text()='Same day delivery']")).click();
	  
	  Thread.sleep(3000);
	  WebElement element1 = driver.findElement(By.xpath("//*[text()='Top Same Day Delivery Products on Kapruka']"));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", element1);
	  Thread.sleep(3000);

	  List<WebElement> count = driver.findElements(By.xpath("//tr"));
	  System.out.println(count.size());
	  int countq1 = count.size();
	  for(int i=1;i<=countq1;i++) {
		  String text1 = driver.findElement(By.xpath("//tr["+i+"]")).getText();
		  System.out.println(text1);
	  }
	  
 
	  
	  
  }
}
