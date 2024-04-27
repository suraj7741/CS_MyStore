package com.mystore.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//com.mystore.utilities.ExtentListner
public class ExtentListner implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport() {
		htmlReporter=new ExtentSparkReporter("ExtentListnerReport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		ReadConfig readconfig=new ReadConfig();
		
		//add system environment information
		reports.setSystemInfo("Machine","testpc1");
		reports.setSystemInfo("OS","windows 11");
		reports.setSystemInfo("Browser",readconfig.getBrowser());
		reports.setSystemInfo("User Name","Suraj");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		configureReport();
		System.out.println("On Start method invoked..");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On finished method invoked..");
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of test method started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of test method successfully executed: " + result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the pass test case is: "+ result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of test method failed: " + result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the fail test case is: "+ result.getName(), ExtentColor.RED));
		
		String screenshotPath=("C:\\Suraj Automation\\Suraj_Automation_Class\\MavenProjectYoutube\\MyStoreV1\\Screenshots\\"+result.getName()+".png");
		File screenshotFile=new File(screenshotPath);
		if(screenshotFile.exists()) {
			test.fail("Captured Screenshot is below"+ test.addScreenCaptureFromPath(screenshotPath));
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of test method skipped: " + result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: "+ result.getName(), ExtentColor.BLUE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
