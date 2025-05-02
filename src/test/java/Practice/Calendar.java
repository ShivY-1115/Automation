package Practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Calendar {
	public WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--incognito");
	   driver = new ChromeDriver(options);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   Thread.sleep(30000);
	   
	   
	   driver.findElement(By.xpath("//*[text()='Time']")).click();
	   driver.findElement(By.xpath("//*[text()='Attendance ']")).click();
	   driver.findElement(By.xpath("//*[text()='Punch In/Out']")).click();
	   driver.findElement(By.xpath("//*[@placeholder=\"yyyy-mm-dd\"]")).click();
	   
	   //driver.get()
	   driver.findElement(By.xpath("(//*[contains(@class,'oxd-calendar-selector')]/i)[2]")).click();
	   
	   
	   
	   LocalDate now = LocalDate.now();
	   int year = now.getYear();
	   driver.findElement(By.xpath("//*[text()='"+year+"']"));
       String fullMonth = now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	   driver.findElement(By.xpath("(//*[contains(@class,'oxd-calendar-selector')]/i)[1]")).click();
	   System.out.println();
	   driver.findElement(By.xpath("//*[text()='"+fullMonth+"']"));
	  // driver.findElement(By.xpath("(//*[contains(@class,'oxd-calendar-selector')]/i)[1]")).click();
       Thread.sleep(1000);
       int day;
       if(now.getDayOfMonth()<=10) {
    	    day = now.getDayOfMonth()+10;
       }else {
	       day = now.getDayOfMonth()-10;
       }
	   driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
	   
	   


       

	  
  }
}
