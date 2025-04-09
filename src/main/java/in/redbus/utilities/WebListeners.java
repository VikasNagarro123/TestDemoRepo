package in.redbus.utilities;


import in.redbus.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class WebListeners implements ITestListener,IAnnotationTransformer  {

@Override
public void onTestFailure(ITestResult result) {
    System.out.println(result.getMethod().getMethodName()+" is failed");
    BaseTest.log.info("Test case failed & taking screenshot");
    File src = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);//taking screenshot in file format
    try {
        String path = System.getProperty("user.dir")+"/CurrentTestResult/Screenshots/"+result.getMethod().getMethodName() + ".png";
        File dest = new File(path);
        FileUtils.copyFile(src, dest);//copying file from src to destinations
    } catch (Exception e) {
        e.printStackTrace();
    }
    BaseTest.log.info("Screenshot taken");
}

@Override
public void onTestSuccess(ITestResult result) {
    System.out.println(result.getMethod().getMethodName()+" is passed");
}

@Override
public void onTestSkipped(ITestResult result) {
    System.out.println(result.getMethod().getMethodName()+" is skipped");
}

@Override
public void transform(
        ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
       annotation.setRetryAnalyzer(RerunTC.class);
}
}


