
package listeners;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import drivers.DriverFactory;
import utilities.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
public class TestListener implements ITestListener {
	ExtentReports extent = ExtentManager.getReport();

	ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {

    	System.out.println("START : " + result.getName());

    	test = extent.createTest(result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("PASS : " + result.getName());
        test.info("Browser Launched");

        test.info("URL Opened");

        test.info("Login Successful");
        test.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAIL : " + result.getName());
        
        //only store SS in folder
//        test.fail(result.getThrowable());
//        ScreenshotUtils.captureScreenshot(DriverFactory.getCurrentDriver(),result.getName());
        
//        Failure-> Open Extent Report ->Click failed test -> Screenshot visible immediately
        test.fail(result.getThrowable());
//        String screenshotPath = ScreenshotUtils.captureScreenshot(DriverFactory.getCurrentDriver(),result.getName());
//        test.addScreenCaptureFromPath(screenshotPath);
//        Assert.assertTrue(false);
        
        String screenshotPath =
        		ScreenshotUtils.captureScreenshot(
        		DriverFactory.getCurrentDriver(),
        		result.getName());

        		String reportPath =
        		"Screenshots/" +
        		new java.io.File(screenshotPath).getName();

        		test.addScreenCaptureFromPath(reportPath);
    }
    
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

    }
}