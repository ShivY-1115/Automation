package Interview.Maven;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "USERS")
    public static Object[][] data(){
        return new Object[][]{
                {"Vamsi","Srikar"},
                {"Srikar","Jogi"},
                {"Jogi","Vamsi"}
        };
    }

    @Test(dataProvider = "USERS")
    public static void login(String firstname, String lastName){
        System.out.println(firstname+" , "+lastName);
    }




}
