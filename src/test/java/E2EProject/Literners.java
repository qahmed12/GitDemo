package E2EProject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReportNG;
import resources.base;


public class Literners extends base implements ITestListener {
	
	ExtentReports extend=ExtendReportNG.getReportObject();
	ExtentTest test;
	// to run test cases in // mode to get consolidate report without overwriting
	ThreadLocal<ExtentTest> extendTest=new ThreadLocal<>();
	@Override
	public void onTestFailure(ITestResult result) {
		
		extendTest.get().fail(result.getThrowable());
		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();
		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstanceName());
		} catch (Exception e) {
		}

		try {
			//extendTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());
			//getScreenShotPath(testMethodName, driver);
		} catch (Exception e) {
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		 test=extend.createTest(result.getMethod().getMethodName());
		 extendTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extendTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		

	}

	@Override
	public void onFinish(ITestContext context) {
		extend.flush();

	}

}
