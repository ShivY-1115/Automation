package Interview.Maven;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

    int count = 0;
    int max_count = 3;


    @Override
    public boolean retry(ITestResult result) {

        if(count<max_count){
            count++;
            return true;
        }
        int a = 0;
        int b = 1;
        Math.abs(a-b);

        return false;
    }
}
