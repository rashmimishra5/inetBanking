package com.inetBanking.TestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	ReadConfig rc=new ReadConfig();
	Utils u=new Utils();
	
	@Parameters("Browser")
	@BeforeMethod
	
	public void setUp(String browser_Name)
	{
		switch(browser_Name)
		{
		case "chrome":
			System.out.println("driver  "+ browser_Name);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;
		
		case "firefox":
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Browsername is invalid");
			break;
		}
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		//driver.get("https://demo.guru99.com/v3/index.php");
		driver.get(rc.getAppUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize(); 
		System.out.println("Successfully window launched and maximixed");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		System.out.println("Successfully window closed");
	}
	
	//closing popups and other windows opened
		@Test
		public void blockingPopupsAndOtherWindow() throws InterruptedException
		{
			String parent_window=driver.getWindowHandle();
			//get all windows opened
			
			Set<String> all_window=driver.getWindowHandles();
			int total_window=all_window.size();
			System.out.println("Total Window = "+ total_window);
			
			//extracting all window and blocking other than parent window
			for(String ele:all_window)
			{
				if(!parent_window.equalsIgnoreCase(ele))
				{
					driver.switchTo().window(ele);
					Thread.sleep(2000);
					driver.close();
				}
			}
			driver.switchTo().window(parent_window);
			System.out.println("Parent Window Title " +driver.getTitle());		
		}

}
