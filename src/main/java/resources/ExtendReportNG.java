package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {

	static ExtentReports extend;

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.xml";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");// to set report name
		reporter.config().setDocumentTitle("Test Results");// to set title

		extend = new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("Tester", "Qasim Ahmed");

		return extend;

	}

}
