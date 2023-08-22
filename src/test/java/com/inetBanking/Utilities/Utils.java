package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils 
{
	public static void captureScreenshot(WebDriver driver,String test_name)
	{
		Date date=new Date();
		String timestamp=date.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try 
		{
		//	FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\ScreenShots\\" + test_name + "_" + timestamp+".png"));
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\ScreenShots\\" + test_name + ".png"));
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		System.out.println("Screenshot Taken...");
	}
	/*public void generatetimestamp()
	{
		Date date=new Date();
		String timestamp=date.toString().replace(" ", "_").replace(":", "_");
	}*/

}
