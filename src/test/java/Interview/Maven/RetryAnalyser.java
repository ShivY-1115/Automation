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

        return false;
    }
}
