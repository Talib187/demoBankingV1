package com.demoBankingV1.utilities;

// Listener class used to generate extent report:

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testcontext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";
		System.out.println("repName:  " + repName);

		String reportPath = System.getProperty("user.dir") + "/test-output/" + repName;
		System.out.println("Report Path: " + reportPath);

		String configPath = System.getProperty("user.dir") + "/Configuration/extent-config.xml";
		System.out.println("Config Path: " + configPath);

		htmlReporter = new ExtentHtmlReporter(reportPath);
		htmlReporter.loadXMLConfig(configPath);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host-name", "localhost");
		extent.setSystemInfo("Environment: ", "QA");
		extent.setSystemInfo("User: ", "Mohammad Talib");

		htmlReporter.config().setDocumentTitle("Internet Banking Test Project"); // Title of the report:
		htmlReporter.config().setReportName("Functional Test Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {

		logger = extent.createTest(tr.getName()); // Create a new entry in th report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information.

	}

	public void onTestFailure(ITestResult tr) {

		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
	//	System.out.println("screenshotPath:" + screenshotPath);
		File file = new File(screenshotPath);

		if (file.exists()) {

			try {

				logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void onTestSkip(ITestResult tr) {

		logger = extent.createTest(tr.getName()); // Create a new entry in th report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); // send the passed
																								// information.
	}

	public void onFinish(ITestContext testcontext) {

		extent.flush();
	}

}
