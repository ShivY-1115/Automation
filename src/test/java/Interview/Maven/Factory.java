package Interview.Maven;

public class Factory {

    @org.testng.annotations.Factory
    public static Object[] fidd_browser(){
         return new Object[] {
                 new BrowserTest("chrome"),
                 new BrowserTest("Edge"),
                 new BrowserTest("firefox")
         };
    }
}
