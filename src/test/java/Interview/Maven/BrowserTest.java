package Interview.Maven;

import org.testng.annotations.Test;

public class BrowserTest {

    private static String browser;

    public BrowserTest(String browser){
        this.browser = browser;
    }

    @Test
    public static void OpenBrowserTest(){
        System.out.println("Running Test on: "+ browser);
    }

}
