package Interview;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class NewTest {
	
	public static WebDriver driver;
	 
  @Test
  public void f() throws IOException, AWTException {
	  
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  for(WebElement link:links) {
		  String url = link.getAttribute("href");
		  if(url!=null && !url.isEmpty()) {
			  HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
			  huc.setRequestMethod("HEAD");
			  huc.connect();
			  int responsecode = huc.getResponseCode();
			  if(responsecode<=400){
				  System.out.println("It is a ");
			  }
		  }
	  }
	  
	  String path= " ";
	  StringSelection select = new StringSelection(path);
	  java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
	  
	  Robot robo = new Robot();
	  robo.keyPress(KeyEvent.VK_CONTROL);
	  robo.keyPress(KeyEvent.VK_V);
	  
	  
	  
   
  }
}
