package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BrowserUtils;
import utilities.Config;
import utilities.Driver;

public abstract class Hooks {
	protected WebDriver driver;
	protected Actions actions;
	protected ExtentReports report;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentTest extentLogger;
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		
		driver = Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		report = new ExtentReports();
		String filePath = System.getProperty("user.dir") + "/test-output/report.html";
		htmlReporter = new ExtentHtmlReporter(filePath);
		report.attachReporter(htmlReporter);
		report.setSystemInfo("ENV", "staging");
		report.setSystemInfo("browser", Config.getValue("browser"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		htmlReporter.config().setReportName("IIHS Automated Test Reports");


	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
			    if (result.getStatus() == ITestResult.FAILURE) {
	    		    String ssLocation =	BrowserUtils.getScreenshot(result.getName());
	    	      extentLogger.fail(result.getName());
	      extentLogger.addScreenCaptureFromPath(ssLocation);
	      extentLogger.fail(result.getThrowable());

	    } else if (result.getStatus() == ITestResult.SKIP) {
	      extentLogger.skip("Test Case Skipped is " + result.getName());
	    }
		Driver.closeDriver();
	}
	 @AfterTest
	  public void tearDownTest() {
	    report.flush();
	    
	  }

}
