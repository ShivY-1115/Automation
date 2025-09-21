package Interview.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton_DriverManager {

    private static WebDriver driver;

    private Singleton_DriverManager(){
    }

    public static WebDriver get_Driver(){
        if(driver==null){
            driver = new ChromeDriver();

        }
        return driver;
    }

}
