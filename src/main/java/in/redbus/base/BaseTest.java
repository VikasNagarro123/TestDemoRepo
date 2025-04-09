package in.redbus.base;



import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import in.redbus.utilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
	public static WebDriver driver;
	public ExtentReports extentReports;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	public static final Logger log = Logger.getLogger(BaseTest.class);


	@BeforeSuite
	public void initiateReport() {
		extentReports=new ExtentReports();
		String path=System.getProperty("user.dir");
		sparkReporter=new ExtentSparkReporter(path+"/CurrentTestResult/Reports/RedBusAutomationReport.html");
		extentReports.attachReporter(sparkReporter);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("RedBus Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);
		extentReports.setSystemInfo("OS", "Windows");
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Tester", "VikasBurkul");
		extentReports.setSystemInfo("TestType", "Functional");
		log.info("Extent Report is initiated");

	}

	@BeforeMethod
	public void initiateSetup(ITestResult method) {
		test=extentReports.createTest(method.getMethod().getMethodName());
		initiateBrowswe();
		log.info("Browser is initiated");
	}

	@AfterMethod
	public void getReports(ITestResult result) {
		log.info("Getting Reports");
		if(result.getStatus()==ITestResult.SUCCESS) {
			//if test is passed then log the passed test case name
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is Test Passed", ExtentColor.GREEN));
		}else if(result.getStatus()==ITestResult.FAILURE) {
			//if test is failed then log the failed test case name and exception
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" is Test Failed",ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" is Test Failed",ExtentColor.RED));
			//attaching the screenshot to Extent report
			test.info(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/CurrentTestResult/Screenshots/"+result.getMethod().getMethodName() + ".png").build());
		} else if (result.getStatus()==ITestResult.SKIP) {
			//if test is skipped then log the skipped test case name
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" is Test Skipped",ExtentColor.YELLOW));
		}
		driver.quit();
		log.info("Browser is closed");
	}

	@AfterSuite
	public void closeReport() {
		//flush the extent report
		extentReports.flush();
	}


	public void initiateBrowswe(){
		//grabbing the browser name and operating system from the properties file
		String browserName = Utility.getProperties("browser");
		String operatingSystems = Utility.getProperties("os");

		if (operatingSystems.equalsIgnoreCase("windows")) {
				//setting up browser using the WebDriverManager if OS is Windows
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();//setting up browser using the WebDriverManager
				driver = new ChromeDriver();//initializing chrome browser
				log.info("Chrome Browser is initiated");
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();//setting up browser using the WebDriverManager
				driver = new EdgeDriver();//initializing edge browser
				log.info("Edge Browser is initiated");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();//setting up browser using the WebDriverManager
				driver = new FirefoxDriver();//initializing firefox browser
				log.info("Firefox Browser is initiated");
			}
		} else if (operatingSystems.equalsIgnoreCase("mac")) {
			//setting up browser using the WebDriverManager if OS is Mac
			WebDriverManager.safaridriver().setup();//setting up browser using the WebDriverManager
			driver = new SafariDriver();//initializing safari browser
			log.info("Safari Browser is initiated");
		} else {
			log.error("Invalid Operating System");
			throw new RuntimeException("Invalid Operating System");
		}

		driver.manage().window().maximize();//maximize page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Utility.getProperties("implicitWaitTime"))));
		driver.get(Utility.getProperties("url"));//navigate to the URL
		log.info("Navigated to URL"+Utility.getProperties("url"));
	}


}
