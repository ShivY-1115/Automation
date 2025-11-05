package Interview.Maven;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Selenium_Concepts {
    public ExtentReports extent;
    public ExtentTest test;


    public WebDriver driver;

    @Test
    public void f(){
        test = extent.createTest("Login Test");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("incognito");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikar\\eclipse-workspace\\Maven\\src\\test\\resources\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");

        Set<Cookie> cook = driver.manage().getCookies();

        WebElement element = driver.findElement(null); // Provide appropriate locator


        //Select class, sort all the options
        Select select = new Select(element);
        List<WebElement> option = select.getOptions();
        List<String> option_values = new ArrayList<>();
        for(WebElement item:option){
            option_values.add(item.getText());
        }

        Collections.sort(option_values);

        //Colors in Selenium
        String color = element.getCssValue("color");
        Color colr = Color.fromString(color);
        int red = colr.getColor().getRed();
        int green = colr.getColor().getGreen();
        int blue = colr.getColor().getBlue();
        int alpha = colr.getColor().getAlpha();




    }
}
