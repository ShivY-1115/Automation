package Interview.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class pageactions {
	
	public WebDriver driver;
	public locators locator;
	public pageactions() {
		this.locator = new locators();
		PageFactory.initElements(driver, locator);
	}
	
	public void ClikconLogin() {
		click(locator.loginpage,"");
	}

	private void click(WebElement loginpage,String message) {
		// TODO Auto-generated method stub
		
	}

}
