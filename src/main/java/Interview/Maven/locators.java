package Interview.Maven;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class locators {

	@FindBy(xpath="some xpath")
	public WebElement loginpage;
	
	@FindBy(xpath="soemli")
	public WebElement enterpassword;
	
	
}
