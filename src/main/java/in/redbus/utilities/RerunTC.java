package in.redbus.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunTC implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 1;//Change the value to the number of times you want to retry
    @Override
    public boolean retry(ITestResult result) {
        while (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
