package com.inetBanking.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport 
{
	public static ExtentReports generateExtentReport()
	{
		String timestamp=new SimpleDateFormat("YYYYMMDDHHMMSS").format(new Date());
		String report_name="Test-Report" + timestamp+ ".html";
		System.out.println(report_name);
		
		ExtentReports extent=new ExtentReports();
		File file=new File(System.getProperty("user.dir") + "\\test-output\\extentReport\\" + report_name);
		
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("inetBanking Report");
		spark.config().setDocumentTitle("Banking automation Report");
		
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("envt", "test/QA");
		extent.setSystemInfo("Tester Name", "Rashmi");
		
		extent.attachReporter(spark);
		return extent;
		
	}

}
