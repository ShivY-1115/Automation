package Interview.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Wait_till_Download {

    public static WebDriver driver = new ChromeDriver();

    @Test
    public static void test(){

        File file = new File("C:\\Users\\Srikar\\Downloads\\JD-engineer-sdet.pdf");
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10));
        wait.until(x -> file.exists());
    }
}
