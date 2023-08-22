package com.inetBanking.Utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener
{
	ExtentReports extentReports ;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context)
	{
		extentReports = ExtentReport.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		String test_name=result.getName();
		test=extentReports.createTest(test_name);
		test.log(Status.INFO, test_name+ "started executing......");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		String test_name=result.getName();
		test=extentReports.createTest(test_name);
		test.log(Status.PASS, test_name+ "got executed successfully......");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String test_name=result.getName();
		test=extentReports.createTest(test_name);
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.FAIL, test_name+ "got failed......");
		
		String screenshotpath=System.getProperty("user.dir")+ "\\ScreenShots\\"+result.getName()+ ".png";
		File file=new File(screenshotpath);
		if(file.exists())
		{
			test.fail("Screenshot is below....." + test.addScreenCaptureFromPath(screenshotpath));
			//test.addScreenCaptureFromPath(screenshotpath);
		}	
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		String test_name=result.getName();
		test=extentReports.createTest(test_name);
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.SKIP, test_name+ "got skipped......");
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extentReports.flush();
		System.out.println("FINISH");
	}
	
}
