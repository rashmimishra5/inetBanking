package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
//public class Reporting extends TestListenerAdapter
public class Reporting implements ITestListener
{
	public static ExtentReports extent;
	public static ExtentTest tests;
	public static ExtentSparkReporter spark;
	//public static ExtentHtmlReporter eh;
	@Override
	public void onStart(ITestContext context)
	{
		
		
		extent=ExtentReport.generateExtentReport();
		
		/*File file=new File(System.getProperty("user.dir") + "\\test-output\\extentReport\\myreport.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("functional Report");
		spark.config().setDocumentTitle("Banking automation Report");
		
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("envt", "test/QA");
		extent.setSystemInfo("Tester Name", "Rashmi");
		
		extent.attachReporter(spark);
		//return extent;
		*/
		
	}
	@Override
	public void onTestStart(ITestResult result)
	{
		/*String timestamp=new SimpleDateFormat("YYYYMMDDHHMMSS").format(new Date());
		String report_name="Test-Report" + timestamp+ ".html";
		System.out.println(report_name);
		
		spark=new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\" + report_name);
		System.out.println((System.getProperty("user.dir") + "/test-output./" + report_name));
		spark.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		System.out.println((System.getProperty("user.dir") + "/extent-config.xml"));
		
		
		System.out.println("attaching");
		extent.attachReporter(spark);
		System.out.println("attached");
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("envt", "test/QA");
		extent.setSystemInfo("Tester Name", "Rashmi");
		
		//spark.config().setDocumentTitle("EXTENT Report");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Banking Report");
		spark.config().setDocumentTitle("TEST Document");
		//spark.config().*/
		
		String test_name=result.getName();
		tests=extent.createTest(test_name);
		tests.log(Status.INFO, test_name+ "started executing......");
		
	}
/*	@Test
	public void verifyTitle1()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		//WebDriverWait wait= new WebDriverWait(driver,10);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//WebDriver ele=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Form_submitForm")));
		//driver.findElement(By.id("//input[@name=\"EmailHomePage\"]")).sendKeys("rashmi@gmail.com");
		
		//driver.findElement(By.id("")).sendKeys("");
		//driver.findElement(By.id("")).click();
		
		//Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
		Assert.assertTrue(true);
		
		
	}*/
	
	@Override
public void onTestSuccess(ITestResult result)
	{
		/*System.out.println(" on testsuccess");
		tests=extent.createTest("tt");
		//tests=extent.createTest(result.getName());//create new entry in report 
		tests.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test Case success" ,ExtentColor.GREEN));
		System.out.println(" on testsuccess end");*/
	
		String test_name=result.getName();
		//test=extentReports.createTest(test_name);
		tests.log(Status.PASS, test_name+ "  got executed successfully......");
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		/*System.out.println(" on testskipped");
		tests=extent.createTest("re");//create new entry in report 
		tests.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "-Test Case Skipped" ,ExtentColor.ORANGE));
		System.out.println(" on testskipped endd");*/
		String test_name=result.getName();
		tests.log(Status.INFO, result.getThrowable());
		tests.log(Status.SKIP, test_name+ "  got skipped.....");
		
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println(" on testfailure");
		tests=extent.createTest("test1");//create new entry in report 
		System.out.println(" tests"+tests);
		tests.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test Case failed" ,ExtentColor.RED));
		//String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
	//	File f=new File(screenshotpath);
		/*if(f.exists())
		{
			try {
			tests.fail("screenshot is below:"+tests.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/
		System.out.println(" on testfailure endd");
	}//end of onTestFailure(ITestResult result)  
		/*@AfterMethod
		public void getResult(ITestResult result)
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				tests=extent.createTest(result.getName());
				tests.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test Case failed" ,ExtentColor.RED));
				tests.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ "-Test Case failed" ,ExtentColor.RED));
			}
			
			if(result.getStatus()==ITestResult.SKIP)
			{
				tests=extent.createTest(result.getName());
				tests.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test Case skipped" ,ExtentColor.ORANGE));
				
			}
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				tests=extent.createTest(result.getName());
				tests.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test Case success" ,ExtentColor.GREEN));
				
			}
		}*/
	@Override
		public void onFinish(ITestContext context)
		{
			extent.flush();
		}

}
